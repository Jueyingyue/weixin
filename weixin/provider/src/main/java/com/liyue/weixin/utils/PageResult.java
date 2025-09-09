package com.liyue.weixin.utils;

import java.util.List;

/**
 * 通用的分页查询结果封装类
 *
 * @param <T> 当前页的数据类型
 */
public class PageResult<T> {

    private Integer total=1;      // 总记录数
    private Integer pageNum=1;    // 当前页码
    private Integer pageSize=1;   // 每页条数
    private List<T> records;    // 当前页数据列表

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public PageResult(Integer total, Integer pageNum, Integer pageSize, List<T> records) {
        this.total = total;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.records = records;
    }
}
