package com.yuanpeng.BuilderJava;

public enum ResultCode
{
	/**
	 * 请求处理
	 */
	SUCCESS(100, "成功"),
	FAILED(10000, "系统异常"),
    NORMAL_ERROR(-100,"操作失败"),
    /**
     * 创建用户
     */
    LOGIN_REG_USERNAME(12000,"昵称重复哦!"),
    LOGIN_REG_MOBILE(12001,"此手机号以注册!"),
    LOGIN_REG_ERROR(12002,"注册异常请稍后重试!"),

	/**
	 * 登陆、认证
	 */
	FAILED_LOGIN(11000, "未登录或已过期,请重新登陆.."),
	FAILED_LOGIN_INCORRECTCREDENTIALS(11010, "密码错误"),
	FAILED_AUTHORIZED(11011, "无操作权限,请联系管理员进行授权."),
	FAILED_LOGIN_CAPTCHA(11012, "验证码错误"),
	FAILED_LOGIN_INVALID_ACCOUNT(11013, "账号不存在或已被锁定"),
	FAILED_LOGIN_HAD_NO_SHOP (11014,"当前用户名下无商铺信息") ,
	FAILED_LOGIN_NO_USERNAME(11015, "没有此用户,请先注册后登陆."),
    FAILED_LOGIN_SUODING(11016, "用户被锁定."),
	/**
	 * token异常
	 */
	TOKEN_EXPIRED(11020, "token过期"), TOKEN_ERROR(11021, "token验证失败"),


	/*
	/**
	 * 订单创建没有桌号
	 */
	MEAL_TABLENO(13001, "请选择桌和号"),
	/**
	 * 没有该职位或者该职位已被禁用
	 */
	SHOP_NOPOST(14001, "没有该职位或者该职位已被禁用"),
	/**
	 * 没有该员工
	 */
	SHOP_NOSTAFF(14002, "没有该员工"),
	/**
	 * 已有该员工无法再次添加
	 */
	SHOP_YESSTAFF(14002, "已有该员工无法再次添加"),
	/**
	 * 此职务下有员工无法禁用或删除
	 */
	SHOP_CANNOTBEBANNED(14003, "此职务下还有员工无法禁用或删除"),
	/**
	 * 没有接班信息请先接班
	 */
	SHOP_NOSHIFTS(15001, "没有接班信息请先接班");
	private int code;
	private String comment;

	ResultCode(int code, String comment) {
		this.code = code;
		this.comment = comment;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return Integer.toString(this.getCode());
	}

}
