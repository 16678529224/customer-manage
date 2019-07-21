package com.yuanpeng.congfig;

public enum ResultCode
{
	/**
	 * 请求处理
	 */
	SUCCESS(100, "成功"), FAILED(10000, "系统异常"),
	/**
	 * 登陆、认证
	 */
	FAILED_LOGIN(11000, "未登录或已过期,请重新登陆.."),
	FAILED_LOGIN_INCORRECTCREDENTIALS(11010, "用户名或密码错误"),
	FAILED_AUTHORIZED(11011, "无操作权限,请联系管理员进行授权."),
	FAILED_LOGIN_CAPTCHA(11012, "验证码错误"),
	FAILED_LOGIN_INVALID_ACCOUNT(11013, "账号不存在或已被锁定"),
	FAILED_LOGIN_HAD_NO_SHOP (11014,"当前用户名下无商铺信息") ,
	/**
	 * token异常
	 */
	TOKEN_EXPIRED(11020, "token过期"), TOKEN_ERROR(11021, "token验证失败"),

	/**
	 * 操作失败
	 */
	NORMAL_ERROR(-100,"操作失败"),

	/**
	 * 此会员等级下还有会员
	 */
	MEMBER_DELETERANK(1200, "此会员等级下还有会员"),
	/**
	 * 会员注册手机号验证
	 */
	MEMBER_TEL(12001, "此手机号已注册会员"),

	/**
	 * 查询是否有会员
	 */
	MEMBER_NO(12002, "没有此会员"),
	/**
	 * 会员充值金额与实际充值金额不符
	 */
	MEMBER_MONEY(12003, "会员充值金额与实际充值金额不符"),
	/**
	 * 会员注册卡号验证
	 */
	MEMBER_CARD(12004, "此卡号已注册会员"),
	/**
	 * 此会员等级下还有会员,无法删除
	 */
	MEMBER_CHARGEUNEQUAL(12005, "此会员等级下还有会员,无法删除"),

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
