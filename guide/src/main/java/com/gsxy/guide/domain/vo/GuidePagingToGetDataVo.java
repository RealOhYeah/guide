package com.gsxy.guide.domain.vo;

import java.util.List;

public class GuidePagingToGetDataVo {

    private List<GuidePagingToData> list;
    private Integer count;

    public GuidePagingToGetDataVo() {
    }

    public GuidePagingToGetDataVo(List<GuidePagingToData> list, Integer count) {
        this.list = list;
        this.count = count;
    }

    public List<GuidePagingToData> getList() {
        return list;
    }

    public void setList(List<GuidePagingToData> list) {
        this.list = list;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "GuidePagingToGetDataVo{" +
                "list=" + list +
                ", count=" + count +
                '}';
    }
}
