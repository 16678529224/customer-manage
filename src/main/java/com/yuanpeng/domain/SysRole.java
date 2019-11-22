package com.yuanpeng.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author yuanpeng
 * @since 2019-11-21
 */
@TableName("yp_sys_role")
public class SysRole extends utilDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色描述
     */
    private String description;
    /**
     * 创建时间yyyy-MM-dd HH:mm:ss
     */
    private String createTime;
    /**
     * 创建用户ID
     */
    @TableField("create_userId")
    private String createUserid;
    /**
     * 更新时间yyyy-MM-dd HH:mm:ss
     */
    private String updateTime;
    /**
     * 更新用户ID
     */
    @TableField("update_userId")
    private String updateUserid;
    /**
     * 状态(0:正常 1:锁定)
     */
    private Integer status;
    /**
     * 逻辑删除标记(0 未删除 1 已删除)
     */
    private Integer delFlag;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(String createUserid) {
        this.createUserid = createUserid;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUserid() {
        return updateUserid;
    }

    public void setUpdateUserid(String updateUserid) {
        this.updateUserid = updateUserid;
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
        return "SysRole{" +
        ", id=" + id +
        ", name=" + name +
        ", description=" + description +
        ", createTime=" + createTime +
        ", createUserid=" + createUserid +
        ", updateTime=" + updateTime +
        ", updateUserid=" + updateUserid +
        ", status=" + status +
        ", delFlag=" + delFlag +
        "}";
    }
}
