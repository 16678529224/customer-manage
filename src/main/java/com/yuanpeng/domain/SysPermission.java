package com.yuanpeng.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author yuanpeng
 * @since 2019-11-28
 */
@TableName("yp_sys_permission")
public class SysPermission extends utilDomain {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 权限描述
     */
    private String description;
    /**
     * 权限访问路径
     */
    private String url;
    /**
     * 权限标识
     */
    private String perms;
    /**
     * 父级权限id
     */
    private String parentId;
    /**
     * 类型   0：页面   1：按钮  
     */
    private Integer type;
    /**
     * 排序
     */
    private Integer orderNum;
    /**
     * 图标
     */
    private String icon;
    /**
     * 创建时间yyyy-MM-dd HH:mm:ss
     */
    @TableField(fill = FieldFill.INSERT)
    private String createTime;
    /**
     * 创建用户ID
     */

    //@TableField("create_userId")
    @TableField(fill = FieldFill.INSERT)
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

	@TableField(exist = false)
    private boolean haveChild = true;

	public boolean isHaveChild() {
		return haveChild;
	}

	public void setHaveChild(boolean haveChild) {
		this.haveChild = haveChild;
	}

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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
        return "SysPermission{" +
        ", id=" + id +
        ", name=" + name +
        ", description=" + description +
        ", url=" + url +
        ", perms=" + perms +
        ", parentId=" + parentId +
        ", type=" + type +
        ", orderNum=" + orderNum +
        ", icon=" + icon +
        ", createTime=" + createTime +
        ", createUserid=" + createUserid +
        ", updateTime=" + updateTime +
        ", updateUserid=" + updateUserid +
        ", status=" + status +
        ", delFlag=" + delFlag +
        "}";
    }
}
