package com.yuanpeng.like;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 网络蜘蛛类
 * https://www.cnblogs.com/snoopylovefiona/p/4593725.html
 * @author SNOOPY
 */
public class Spider {
	/**
	 *
	 * @param srcLink  要获取网页源码的路径
	 * @param encoding    编码格式
	 * @return
	 */
	public static String getPageHtmlSource(String srcLink){
		//List<String> list = new ArrayList<String>();
		InputStream inputStream = null;
		InputStreamReader inputStreamReader =null;
		BufferedReader bufferedReader = null;
		StringBuilder strBuilder = null;
		String htmlcode = null;
		try {
			//1、建立与网页服务器连接
			URL url = new URL(srcLink);
			URLConnection urlconnection =url.openConnection();//打开链接
			//urlconnection.setRequestProperty("User-Agent", "java");

			String encoding = getHtmlEncoding(srcLink,url);
			System.out.println("encoding====="+encoding);
			//2、通过该连接，读取数据(获取输入流)
			inputStream = urlconnection.getInputStream();//得到字节输入流
			inputStreamReader = new InputStreamReader(inputStream,encoding);//转为字符流

			bufferedReader = new BufferedReader(inputStreamReader);//构建缓冲输入流
			strBuilder = new StringBuilder();//非线程安全，多线程同时访问时会有问题    但效率高  StringBuffer 线程安全

			String line = null;//存储一行数据
			while((line=bufferedReader.readLine())!=null){
				strBuilder.append(line+"\r\n");//回车换行区别 回车： 回到同一行的起始位置，换行：换到下一行
			}
			htmlcode = strBuilder.toString();
			System.out.println(htmlcode);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				bufferedReader.close();
				inputStreamReader.close();
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return htmlcode;
	}
	public static String getHtmlEncoding(String url,URL Url){
		/**
		 * 根据头部获取encoding
		 *
		 */

		//编码情况https://www.cnblogs.com/blog5277/p/6704168.html
		String encoding = null;
		//1,根据responseHeaders获取Content-Type里的charset
		try {
			HttpURLConnection huc = (HttpURLConnection)Url.openConnection();
			huc.connect();
			Map<String,List<String>> map = huc.getHeaderFields();
			Set<String> keys = map.keySet();
			Iterator<String> it = keys.iterator();
			String key = null;
			String tmp = null;
			while (it.hasNext()) {
				key = it.next();
				tmp = map.get(key).toString().toLowerCase();
				// 获取content-type charset
				if (key != null && key.equals("Content-Type")) {
					int m = tmp.indexOf("charset=");//返回指定子字符串在此字符串中第一次出现处的索引。
					if (m != -1) {
						encoding = tmp.substring(m + 8).replace("]", "");
						return encoding;
					}
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//2.根据html标签里的meta取
		if(encoding == null){

		}
		return encoding = "gb2312";
	}
	public static void main(String[] args) {
		/**
		 * 测试方法
		 * 最好用浏览器进行测试，控制台测试也可以，但是可能因为网页字符集和控制台字符集不匹配造成不能显示汉子
		 */
		String srcURL ="http://www.qq.com";
		String html = getPageHtmlSource(srcURL);
		System.out.println(html);
	}
}
