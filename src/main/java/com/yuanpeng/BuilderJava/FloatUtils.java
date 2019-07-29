package com.yuanpeng.BuilderJava;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * double的运算
 */
public class FloatUtils
{
	/**
	 * 加
	 */
	public static double add(double a, double b) {
		BigDecimal a1 = new BigDecimal(Double.toString(a));
		BigDecimal b1 = new BigDecimal(Double.toString(b));
		double c = a1.add(b1).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return c;
	}

	/**
	 * 加
	 */
	public static double add(double a, double b, int weishu) {
		BigDecimal a1 = new BigDecimal(Double.toString(a));
		BigDecimal b1 = new BigDecimal(Double.toString(b));
		double c = a1.add(b1).setScale(weishu, BigDecimal.ROUND_HALF_UP).doubleValue();
		return c;
	}

	/**
	 * 减
	 */
	public static double sub(double a, double b) {
		BigDecimal a1 = new BigDecimal(Double.toString(a));
		BigDecimal b1 = new BigDecimal(Double.toString(b));
		double c = a1.subtract(b1).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return c;
	}

	public static double multiply(double a, double b) {
		BigDecimal a1 = new BigDecimal(Double.toString(a));
		BigDecimal b1 = new BigDecimal(Double.toString(b));
		double c = a1.multiply(b1).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return c;
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @param weishu 保留小数点位数
	 * @return
	 */
	public static double multiply(double a, double b, int weishu) {
		BigDecimal a1 = new BigDecimal(Double.toString(a));
		BigDecimal b1 = new BigDecimal(Double.toString(b));
		double c = a1.multiply(b1).setScale(weishu, BigDecimal.ROUND_HALF_UP).doubleValue();
		return c;
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @param weishu 保留小数点位数
	 * @return
	 */
	public static double multiplyfloor(double a, double b, int weishu) {
		DecimalFormat df = new DecimalFormat("0.00");
		BigDecimal a1 = new BigDecimal(Double.toString(a));
		BigDecimal b1 = new BigDecimal(Double.toString(b));
		double c = a1.multiply(b1).setScale(weishu, BigDecimal.ROUND_UNNECESSARY).doubleValue();
		return c;
	}

	public static double divide(double a, double b) {
		BigDecimal a1 = new BigDecimal(Double.toString(a));
		BigDecimal b1 = new BigDecimal(Double.toString(b));
		BigDecimal c = a1.divide(b1, 2, BigDecimal.ROUND_HALF_UP);
		//double c = a1.divide(b1).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		return c.doubleValue();
	}

	public static void main(String[] args) {
		double fmoney = 0;
		float money = 540;
		double psettlementrate = 0.0024;
		fmoney = FloatUtils.multiply(money, psettlementrate, 2);
		System.out.println("FloatUtils.main()" + fmoney);
	}

}
