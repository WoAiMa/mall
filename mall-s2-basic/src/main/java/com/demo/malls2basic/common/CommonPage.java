package com.demo.malls2basic.common;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 分页数据封装类
 * @param <T>
 */
public class CommonPage<T> {
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalSize;
    private Long total;
    private List<T> list;

    /**
     * 将pagehelper分页后的list转为分页信息
     * @param list
     * @param <T>
     * @return
     */
    public static <T> CommonPage<T> restPage(List<T> list){
        CommonPage<T> result = new CommonPage<T>();
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotalSize(pageInfo.getPages());
        result.setTotal(pageInfo.getTotal());
        result.setList(list);
        return result;
    }

    /**
     * 将springdata分页后的list转为分页信息
     * @param page
     * @param <T>
     * @return
     */
//    public static <T> CommonPage<T> restPage(Page<T> page){
//        CommonPage<T> result = new CommonPage<T>();
//        result.setPageNum(page.getPageSize());
//        result.setPageNum(page.getPageNum());
//        result.setTotalSize(page.getPages());
//        result.setTotal(page.getTotal());
//        result.setList(page.getCpm);
//        return result;
//    }

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

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
