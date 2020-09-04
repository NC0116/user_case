package com.neusoft.dao.Impl;

import com.neusoft.dao.UserDao;
import com.neusoft.domin.User;
import com.neusoft.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {
    // query():查询结果，将结果封装为JavaBean对象 * query的参数：RowMapper
    // * 一般我们使用BeanPropertyRowMapper实现类。可以完成数据到JavaBean的自动封装  new BeanPropertyRowMapper<类型>(类型.class)
//        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
//        return users;
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findAll() {
      String sql="select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public int saveUser(User user) {
        String sql="insert  into user values(null,?,?,?,?,?,?,null,null)";
        int count = template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
        return count;
    }

    @Override
    public void updateUser(User user) {
        String sql="update user set name=?,gender=?,age=?,address=?,qq=?,email=? where id=?";
        template.update(sql,user.getName(),user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(),user.getId());
    }

    @Override
    public User findById(int id) {
        String sql="select * from user where id=?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
    }

    @Override
    public void deleteUser(int id) {
        String sql="delete from user where id=?";
        template.update(sql,id);
    }

    @Override
    public User loginUser(User user) {
        try{
            String sql="select * from user where username=? and password=?";
            User user1 = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),user.getUsername(),user.getPassword());
            return user1;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public  List<User> findUser(User user) {
        String sql="select * from user where name=? or address=? or email=?";
        List<User> find = template.query(sql, new BeanPropertyRowMapper<User>(User.class), user.getName(), user.getAddress(), user.getEmail());
        return find;
    }

    @Override
    public int findTotalCount( Map<String,String[]> condition) {
        String sql="select count(*) from user where 1=1";
        StringBuilder sb = new StringBuilder(sql);

        List<Object> params = new ArrayList<>();

        //遍历
        Set<String> keySet = condition.keySet();
        for (String key:keySet) {
            //排除condition中的分页条件,如果是发生if判断的条件，就跳过这次循环，
            // 取不到currentPage，rows这两个参数，实现模糊查询的条数
            if ("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取condition中的value值
            String value= condition.get(key)[0];
            //判断value是否为空
            if (value !=null && !"".equals(value)){
                sb.append("  and "+ key +" like ?  ");
                params.add("%" + value + "%");
            }

        }
        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from user where 1= 1  ";
//        String sql = "select * from user  limit ?,?";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
//
        List<Object> params = new ArrayList<>();

        for (String key :keySet){
            // 排除 分页的条件参数
            if ("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
//            SELECT count(*) FROM user WHERE 1=1 AND name LIKE '%李%'
            // 获取value值
            String value = condition.get(key)[0];
            // 判断value是否有值
            if (value !=null && !"".equals(value)){
                sb.append("  and "+ key +" like ?  ");
                params.add("%" + value + "%");
            }
        }
        //添加分页
        sb.append("limit ?,? ");
        params.add(start);
        params.add(rows);
        sql =sb.toString();


        return template.query(sql, new BeanPropertyRowMapper<User>(User.class), params.toArray());
    }
}

