package com.yuanpeng.domain;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.yuanpeng.BuilderJava.ToolUtils;

import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author yuanpeng
 * @since 2019-11-19
 * Model AR一种领域模型 作用,一个实体类对应关系型数库里的一张表
 * Model 里有个抽象方法要实现叫pkVal()  必须指定当前类的主键属性
 * 他可以自己插入自己        sysUser.insert();
 */
@TableName("yp_sys_user")
public class SysUser extends utilDomain implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "id", type = IdType.INPUT)
    private String id;
    /**
     * 用户编码
     */
    private String usercode;
    /**
     * 用户登录名
     */
    private String username;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 盐值
     */
    private String salt;
    /**
     * 状态(0:正常 1:锁定)
     */
    private Integer status;
    /**
     * 逻辑删除标记(0 未删除 1 已删除)
     */
    private Integer delFlag;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 修改时间
     */
    private String updateTime;
    /**
     * 头像链接
     */
    private String avatar;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 性别
     */
    private String sex;
    /**
     * 注册ip
     */
    private String ip;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = ToolUtils.getUserCode(usercode);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    /*@Override
    protected Serializable pkVal() {
        return this.id;
    }*/

    @Override
    public String toString() {
        return "SysUser{" +
                ", id=" + id +
                ", usercode=" + usercode +
                ", username=" + username +
                ", nickname=" + nickname +
                ", password=" + password +
                ", mobile=" + mobile +
                ", salt=" + salt +
                ", status=" + status +
                ", delFlag=" + delFlag +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", avatar=" + avatar +
                ", email=" + email +
                ", sex=" + sex +
                ", ip=" + ip +
                "}";
    }
}
