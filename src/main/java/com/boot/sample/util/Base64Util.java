package com.boot.sample.util;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * base64加解码
 * 
 * @author xu.yong
 *
 */
public class Base64Util {

	/**
	 * base64加码
	 * 
	 * @param bytes
	 * @return
	 */
	public static String encoderByBase64(byte[] bytes) {
		return new BASE64Encoder().encode(bytes);
	}

	/**
	 * base64解码
	 * @param str
	 * @return
	 */
	public static byte[] decoderByBase64(String str) {
		byte[] decoderBytes = null;
		try {
			decoderBytes = new BASE64Decoder().decodeBuffer(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return decoderBytes;
	}
}
