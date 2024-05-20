package com.gsxy.guide.domain.bo;

import com.gsxy.guide.domain.Guide;

import java.io.Serializable;

public class GuidePagingToGetDataBo implements Serializable {

    private Long start;//开始坐标
    private Integer size;//每页显示长度
    private Guide guide;

    public GuidePagingToGetDataBo() {
    }

    public GuidePagingToGetDataBo(Long start, Integer size, Guide guide) {
        this.start = start;
        this.size = size;
        this.guide = guide;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    @Override
    public String toString() {
        return "GuidePagingToGetDataBo{" +
                "start=" + start +
                ", size=" + size +
                ", guide=" + guide +
                '}';
    }
}
