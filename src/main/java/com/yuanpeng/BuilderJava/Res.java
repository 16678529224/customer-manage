package com.yuanpeng.BuilderJava;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * Ajax请求返回实体类
 * <h2>code : @See ResultCode 状态码</h2>
 * <h2>msg : String 简要信息</h2>
 * <h2>result : Object 返回结果</h2>
 */

public class Res extends JSONObject implements Serializable
{
	private static final long serialVersionUID = 3466826361259294779L;

	/**
	 * 默认状态码为 {@link ResultCode#SUCCESS}
	 */
	public Res() {
		this.setCode(ResultCode.SUCCESS);
	}

	public Res(ResultCode code) {
		super();
		this.put("code", code.toString());
		this.put("msg", code.getComment());
	}

	/**
	 * 默认msg为空,状态码为 {@link ResultCode#SUCCESS}
	 */
	public Res(Object result) {
		this.setCode(ResultCode.SUCCESS);
		this.put("result", result);
	}

	public Res(ResultCode code, String msg) {
		super();
		this.put("code", code.toString());
		this.put("msg", msg);
	}

	public Res success() {
		this.setCode(ResultCode.SUCCESS);
		return this;
	}

	public Res failed() {
		this.setCode(ResultCode.FAILED);
		return this;
	}

	public Res failedMsg(ResultCode code) {
		this.put("code", code.getCode());
		this.put("msg", code.getComment());
		return this;
	}

	public String getCode() {
		return this.getString("code");
	}

	public Res setCode(ResultCode code) {
		this.put("code", code.toString());
		this.put("msg", code.getComment());
		return this;
	}

	public String getMsg() {
		return this.getString("msg");
	}

	public Res setMsg(String msg) {
		this.put("msg", msg);
		return this;
	}

	public Object getResult() {
		return this.get("result");
	}

	public Res setResult(Object result) {
		this.put("result", result);
		this.put("msg", "");
		return this;
	}

}
