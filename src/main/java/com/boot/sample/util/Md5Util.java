package com.boot.sample.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * md5算法
 * @author xu.yong
 *
 */
public class Md5Util {

	/**
	 * 
	 * @param index
	 *            加密位置
	 * @param secretKey
	 *            密钥
	 * @param md5Str
	 *            MD5加密目标字符串
	 * @return
	 */
	public static byte[] md5(int index, String md5Str, String secretKey) {
		if (md5Str == null)
			throw new NullPointerException("md5Str {} can't be null!");

		if (secretKey == null)
			secretKey = "";

		byte[] secretBytes = null;
		if (index < 0 || index > md5Str.length())
			index = md5Str.length();
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append(md5Str.substring(0, index));
		stringBuilder.append(secretKey);
		stringBuilder.append(md5Str.substring(index, md5Str.length()));

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			secretBytes = md.digest(stringBuilder.toString().getBytes("utf-8"));
		} catch (NoSuchAlgorithmException var1) {
			var1.printStackTrace();
		} catch (UnsupportedEncodingException var2) {
			var2.printStackTrace();
		}
		return secretBytes;
	}
	
	/**
	 * md5加密且通过base64加码解析成字符串
	 * @param index
	 * @param md5Str
	 * @param secretKey
	 * @return
	 */
	public static String md5ByBase64ToString(int index, String md5Str, String secretKey) {
		byte[] md5Bytes = md5(index, md5Str, secretKey);
		String targetStr = null;
		if (md5Bytes != null)
			targetStr = Base64Util.encoderByBase64(md5Bytes);
		return targetStr;
	}
	
	/**
	 * md5加密，base64加码，密钥前置
	 * @param md5Str
	 * @param secretKey
	 * @return
	 */
	public static String md5BeforeByBase64ToString(String md5Str, String secretKey) {
		return md5ByBase64ToString(0, md5Str, secretKey);
	}
	
	/**
	 * md5加密，base64加码，密钥后置
	 * @param md5Str
	 * @param secretKey
	 * @return
	 */
	public static String md5AfterByBase64ToString(String md5Str, String secretKey) {
		return md5ByBase64ToString(-1, md5Str, secretKey);
	}

	public static void main(String[] args) {
		System.out.println("md5 Before : " + md5BeforeByBase64ToString("md5", "11111")); 
		System.out.println("md5 After : " + md5AfterByBase64ToString("md5", "11111")); 
	}
}
