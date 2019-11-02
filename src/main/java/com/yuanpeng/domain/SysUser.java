package com.yuanpeng.domain;

import com.yuanpeng.BuilderJava.BaseEntity;

//@TableName("lmt_sys_user")
public class SysUser extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	//@TableId(value = "id", type = IdType.AUTO)
	private String id;
	private String username;//用户名
	private String password;//密码
	private String mobile;//手机号
	private String salt;//盐值
    private String nickname;//昵称
    //@TableField("dept_id")
	private Integer deptId;//所属部门
	private Integer status;//状态(0:正常 1:锁定)
	//@TableField(value = "created_at", fill = FieldFill.INSERT) //创建时间
	private String createdAt;
	//@TableField(value = "updated_at", fill = FieldFill.UPDATE) //最后更新时间
	private String updatedAt;
	//@TableLogic //逻辑删除标记(0 未删除 1 已删除)
	//@TableField("del_flag")
	private Integer delFlag;

	//@TableField(exist = false)
	//private List<SysRole> roles;

	//@TableField(exist = false)
	//private List<SysResource> resources;

	//@TableField(exist = false)
	//private String deptName;
	//@TableField(exist = false)
	//private String num;

	/**
	 * 用户状态
	 */
	public interface SysUserStatus
	{
		/**
		 * 锁定
		 */
		Integer LOCKED = 0;
		/**
		 * 正常
		 */
		Integer NORMAL = 1;
	}

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}