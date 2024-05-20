package com.gsxy.guide.domain;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户实体类
 */
public class User implements Serializable {
    private static final long serialVersionUID = -16000919610921848L;

    private Long id;
    /**
     *  用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     *  创建时间
     */
    private Date createTime;

    /**
     *  更新人
     */
    private Long updateBy;

    /**
     *  更新时间
     */
    private Date updateTime;

    private Integer status;

    /**
     *  逻辑删除（0：正常，1：删除）
     */
    private Integer delFlag;

    public User() {
    }
    public User( String username, String password,  Date createTime,  Date updateTime, Integer status, Integer delFlag) {
        this.username = username;
        this.password = password;

        this.createTime = createTime;

        this.updateTime = updateTime;
        this.status = status;
        this.delFlag = delFlag;
    }

    public User(Long id, String username, String password, Long createBy, Date createTime, Long updateBy, Date updateTime, Integer delFlag) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.delFlag = delFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                ", updateBy=" + updateBy +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", delFlag=" + delFlag +
                '}';
    }
}

