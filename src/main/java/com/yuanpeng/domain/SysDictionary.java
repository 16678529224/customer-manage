package com.yuanpeng.domain;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 系统字典表
 * </p>
 *
 * @author yuanpeng
 * @since 2019-11-22
 */
@TableName("yp_sys_dictionary")
public class SysDictionary extends utilDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.INPUT)
    private String id;
    /**
     * 父ID 分类下再分类
     */
    private String pid;
    /**
     * 数据类别
     */
    private String dictionaryType;
    /**
     * 数据名称
     */
    private String dictionaryValue;
    /**
     * 数据库存值
     */
    private String dictionaryCode;
    /**
     * 数据描述
     */
    private String dictionaryDesc;
    /**
     * 顺序 
     */
    private Integer orderNum;
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


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getDictionaryType() {
        return dictionaryType;
    }

    public void setDictionaryType(String dictionaryType) {
        this.dictionaryType = dictionaryType;
    }

    public String getDictionaryValue() {
        return dictionaryValue;
    }

    public void setDictionaryValue(String dictionaryValue) {
        this.dictionaryValue = dictionaryValue;
    }

    public String getDictionaryCode() {
        return dictionaryCode;
    }

    public void setDictionaryCode(String dictionaryCode) {
        this.dictionaryCode = dictionaryCode;
    }

    public String getDictionaryDesc() {
        return dictionaryDesc;
    }

    public void setDictionaryDesc(String dictionaryDesc) {
        this.dictionaryDesc = dictionaryDesc;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
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



    @Override
    public String toString() {
        return "SysDictionary{" +
        ", id=" + id +
        ", pid=" + pid +
        ", dictionaryType=" + dictionaryType +
        ", dictionaryValue=" + dictionaryValue +
        ", dictionaryCode=" + dictionaryCode +
        ", dictionaryDesc=" + dictionaryDesc +
        ", orderNum=" + orderNum +
        ", status=" + status +
        ", delFlag=" + delFlag +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
