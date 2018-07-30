package com.jiameng.jingxuan.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * md5加密类
 * 
 * @Title： 
 * @Author： alvin.wyh
 * @Date： 2017年3月10日 上午8:13:05
 * @Description：
 */
public class MD5 {
	
	private static Log log = LogFactory.getLog(MD5.class);
	
	public static String md5(String text) {
		String str = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(text.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			str = buf.toString();
		} catch (NoSuchAlgorithmException e) {
			log.error("MD5加密-NoSuchAlgorithm异常", e);
		} catch (Exception e) {
			log.error("MD5加密异常", e);
		}
		return str.toUpperCase();
	}
	
	public static void main(String agrs[]) {
		log.info("md5('admin')=="+md5("admin"));// 加密
	}

}