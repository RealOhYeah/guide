package com.gsxy.guide.domain;

import cn.hutool.core.date.DateTime;

import java.time.LocalDateTime;
import java.util.Date;
import java.io.Serializable;

/**
 * 向导实体类
 *
 * @author Oh...Yeah!!!
 * @since 2024-03-13 17:35:36
 */
public class Guide implements Serializable {
    private static final long serialVersionUID = -10400830850493243L;

    private Long id;
/**
     * 网址名
     */
    private String name;
/**
     * 网址链接
     */
    private String toLink;
/**
     * 创建时间
     */
    private LocalDateTime createTime;
/**
     * 创建人
     */
    private Long createBy;
/**
     * 修改时间
     */
    private LocalDateTime updateTime;
/**
     * 修改人
     */
    private Long updateBy;
/**
     * 状态（0：普通，1：管理）
     */
    private Integer status;
/**
     * 逻辑删除（0：未删除，1：已删除）
     */
    private Integer delFlag;

    public Guide() {
    }

    public Guide(Long id, String name, String toLink, LocalDateTime createTime, Long createBy, LocalDateTime updateTime, Long updateBy, Integer status, Integer delFlag) {
        this.id = id;
        this.name = name;
        this.toLink = toLink;
        this.createTime = createTime;
        this.createBy = createBy;
        this.updateTime = updateTime;
        this.updateBy = updateBy;
        this.status = status;
        this.delFlag = delFlag;
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

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "Guide{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", toLink='" + toLink + '\'' +
                ", createTime=" + createTime +
                ", createBy=" + createBy +
                ", updateTime=" + updateTime +
                ", updateBy=" + updateBy +
                ", status=" + status +
                ", delFlag=" + delFlag +
                '}';
    }
}

