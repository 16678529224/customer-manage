package com.yuanpeng.like;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class DownLoadFromUrl {

	public static void main(String[] args) throws UnsupportedEncodingException {
		/*
				http://177l.tt56w.com:8000/玄幻小说/异常生物见闻录/199.mp3
		*/
		//String urlStr ="http://177l.tt56w.com:8000/玄幻小说/异常生物见闻录/199.mp3";

		/*String urlStr ="http://177l.tt56w.com:8000/%E7%8E%84%E5%B9%BB%E5%B0%8F%E8%AF%B4/%E5%BC%82%E5%B8%B8%E7%94%9F%E7%89%A9%E8%A7%81%E9%97%BB%E5%BD%95/199.mp3";
		String savePath ="D:\\小说";
		String fileName= "异常01.mp3";*/
		for(int a = 500;a<500;a++){
			String urlStr ="http://177l.tt56w.com:8000/%E7%8E%84%E5%B9%BB%E5%B0%8F%E8%AF%B4/%E5%BC%82%E5%B8%B8%E7%94%9F%E7%89%A9%E8%A7%81%E9%97%BB%E5%BD%95/"+a+".mp3";
			String savePath ="D:\\小说";
			String fileName= "异常生物见闻录"+a+".mp3";
			DownLoadFromUrl DownLoadFromUrl = new DownLoadFromUrl();
			DownLoadFromUrl.downLoadFromUrl( urlStr,  fileName,  savePath);
			System.out.println(a);
		}
	}

	public List<String> downLoadFromUrl(String urlStr, String fileName, String savePath){
		List<String> list= new ArrayList<String>();
		try {
			boolean aa = false;
			URL url = new URL(urlStr);
			//URL url = new URL(URLEncoder.encode(urlStr,"UTF-8"));编码问题,/和/之间有中文不能全用
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			//设置超时间为3秒
			conn.setConnectTimeout(3*1000);
			//防止屏蔽程序抓取而返回403错误
			conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			int responseCode = conn.getResponseCode();
			if (responseCode != 200) {
				//log.info(urlStr+","+savePath+"文件不存在");
				list.add("40001");
				list.add("未找到此路径下文件");
				return list;
			}
			//得到输入流
			InputStream inputStream = conn.getInputStream();
			//获取自己数组
			byte[] getData = readInputStream(inputStream);
			int i = getData.length;
			int b = i/1024;

			//文件保存位置
			File saveDir = new File(savePath);
			if(!saveDir.exists()){
				saveDir.mkdir();
			}
			File file = new File(saveDir+ File.separator+fileName);
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(getData);
			if(fos!=null){
				fos.close();
			}
			if(inputStream!=null){
				inputStream.close();
			}
			//log.info("info:"+url+" download success");
			list.add("0");
			list.add(b+"");

			return list;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			list.add("40002");
			list.add("文件下载出现错误"+e.toString());
			e.printStackTrace();
			return list;
		}

	}
	/**
	 * 从输入流中获取字节数组
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	public static  byte[] readInputStream(InputStream inputStream) throws IOException {
		byte[] buffer = new byte[1024];
		int len = 0;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while((len = inputStream.read(buffer)) != -1) {
			bos.write(buffer, 0, len);
		}
		bos.close();
		return bos.toByteArray();
	}
}
