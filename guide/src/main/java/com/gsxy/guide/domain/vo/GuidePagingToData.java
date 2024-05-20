package com.gsxy.guide.domain.vo;

import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

public class GuidePagingToData {

    /**
     *
     */
    @TableId
    private Long id;

    /**
     * 网站名称
     */
    private String name;
    /**
     * 网站链接
     */
    private String toLink;

    /**
     * 修改时间
     */
    private Date updateTime;


    public GuidePagingToData() {
    }

    public GuidePagingToData(Long id, String name, String toLink, Date updateTime) {
        this.id = id;
        this.name = name;
        this.toLink = toLink;
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToLink() {
        return toLink;
    }

    public void setToLink(String toLink) {
        this.toLink = toLink;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "GuidePagingToData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", toLink='" + toLink + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
