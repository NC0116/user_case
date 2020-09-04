package com.neusoft.domin;


import java.util.List;

//分页对象
public class PageBean<T> {
    //总记录条数
    private int totalCount;
    //    总页数
    private int totalPage;
    //    每页显示的记录数
    private int rows;
    //    每页数据
    private  List<User> list;
    //    当前页码
    private int currentPage;

    public PageBean() {
    }

    public PageBean(int totalCount, int totalPage, int rows, List<User> list, int currentPage) {
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.rows = rows;
        this.list = list;
        this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", rows=" + rows +
                ", list=" + list +
                ", currentPage=" + currentPage +
                '}';
    }
}
