package com.xc.lovesong.kernel.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * Author:	  daniel
 * Created:	  Jul 25, 2010 12:19:00 AM
 * Vesion:	  1.0
 * Last EditTime: Jul 25, 2010 12:19:00 AM
 * Update Logs:
 *				daniel@Jul 25, 2010 12:19:00 AM 添加
 * 项目名称：		shoppingCart
 * 说明: 国际化字符的工具类
 */
public class UnicodeFormatter {

	public static char HEX_DIGIT[] = {
		'0', '1', '2', '3', '4', '5', '6', '7',
		'8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
	};

	public static String byteToHex(byte b) {
		char[] array = {HEX_DIGIT[(b >> 4) & 0x0f], HEX_DIGIT[b & 0x0f]};

		return new String(array);
	}

	public static String charToHex(char c) {
		byte hi = (byte)(c >>> 8);
		byte lo = (byte)(c & 0xff);

		return byteToHex(hi) + byteToHex(lo);
	}
	
	/** 
	 * 方法说明: 将Unicode编码转换成普通的字符串
	 * @param hexString
	 * @return
	 */
	public static String parseString(String hexString) {
		StringBuffer sm = new StringBuffer();

		char[] array = hexString.toCharArray();

		if ((array.length % 6) != 0) {
			_log.error("String is not in hex format");

			return hexString;
		}

		for (int i = 2; i < hexString.length(); i = i + 6) {
			String s = hexString.substring(i, i + 4);

			try {
				char c = (char)Integer.parseInt(s, 16);

				sm.append(c);
			}
			catch (Exception e) {
				_log.error(e, e);

				return hexString;
			}
		}

		return sm.toString();
	}
	
	/** 
	 * 方法说明: 将字符数组格式化成Unicode编码输出
	 * @param array
	 * @return
	 */
	public static String toString(char[] array) {
		StringBuffer sm = new StringBuffer();

		for (int i = 0; i < array.length; i++) {
			sm.append("\\u");
			sm.append(charToHex(array[i]));
		}

		return sm.toString();
	}
	
	/** 
	 * 方法说明: 将字符串格式化成Unicode编码输出
	 * @param s
	 * @return
	 */
	public static String toString(String s) {
		if (s == null) {
			return null;
		}

		return toString(s.toCharArray());
	}

	private static Log _log = LogFactory.getLog(UnicodeFormatter.class);

}