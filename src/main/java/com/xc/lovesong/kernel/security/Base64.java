package com.xc.lovesong.kernel.security;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.log4j.Logger;

/**
 * @copyright: 	www.xc.com
 * @author:		DanielChen@xc.com
 * @created:		2013-2-3 下午02:12:21
 * @vesion:		1.0
 * @updateLogs:
 * User		 	Date					Description
 * ------------------------------------------------------
 * DanielChen	2013-2-3-下午02:12:21  	添加类
 * 项目名称：		lovesong
 * 说明:	 TODO 添加类描述
 */
public class Base64 {

	protected static char getChar(int sixbit) {
		if (sixbit >= 0 && sixbit <= 25) {
			return (char)(65 + sixbit);
		}

		if (sixbit >= 26 && sixbit <= 51) {
			return (char)(97 + (sixbit - 26));
		}

		if (sixbit >= 52 && sixbit <= 61) {
			return (char)(48 + (sixbit - 52));
		}

		if (sixbit == 62) {
			return '+';
		}

		return sixbit != 63 ? '?' : '/';
	}

	protected static int getValue(char c) {
		if (c >= 'A' && c <= 'Z') {
			return c - 65;
		}

		if (c >= 'a' && c <= 'z') {
			return (c - 97) + 26;
		}

		if (c >= '0' && c <= '9') {
			return (c - 48) + 52;
		}

		if (c == '+') {
			return 62;
		}

		if (c == '/') {
			return 63;
		}

		return c != '=' ? -1 : 0;
	}
	
    /** 
     * 编码 
     * @param byte  需要编码的字符数组
     * @return String 编码后的字符串
     */  
	public static String encode(byte raw[]) {
		StringBuffer encoded = new StringBuffer();

		for (int i = 0; i < raw.length; i += 3) {
			encoded.append(encodeBlock(raw, i));
		}

		return encoded.toString();
	}

	protected static char[] encodeBlock(byte raw[], int offset) {
		int block = 0;
		int slack = raw.length - offset - 1;
		int end = slack < 2 ? slack : 2;

		for (int i = 0; i <= end; i++) {
			byte b = raw[offset + i];

			int neuter = b >= 0 ? ((int) (b)) : b + 256;
			block += neuter << 8 * (2 - i);
		}

		char base64[] = new char[4];

		for (int i = 0; i < 4; i++) {
			int sixbit = block >>> 6 * (3 - i) & 0x3f;
			base64[i] = getChar(sixbit);
		}

		if (slack < 1) {
			base64[2] = '=';
		}

		if (slack < 2) {
			base64[3] = '=';
		}

		return base64;
	}
    /** 
     * 解码 
     * @param base64  编码后的64位字符
     * @return  byte[]  解码后的字符数组
     */
	public static byte[] decode(String base64) {
		int pad = 0;

		for (int i = base64.length() - 1; base64.charAt(i) == '='; i--) {
			pad++;
		}

		int length = (base64.length() * 6) / 8 - pad;
		byte raw[] = new byte[length];
		int rawindex = 0;

		for (int i = 0; i < base64.length(); i += 4) {
			int block = (getValue(base64.charAt(i)) << 18) +
						(getValue(base64.charAt(i + 1)) << 12) +
						(getValue(base64.charAt(i + 2)) << 6) +
						getValue(base64.charAt(i + 3));

			for (int j = 0; j < 3 && rawindex + j < raw.length; j++) {
				raw[rawindex + j] = (byte)(block >> 8 * (2 - j) & 0xff);
			}

			rawindex += 3;
		}

		return raw;
	}

	public static String objectToString(Object o) {
		if (o == null) {
			return null;
		}

		ByteArrayOutputStream bam = new ByteArrayOutputStream(32000);

		try {
			ObjectOutputStream os = new ObjectOutputStream(
				new BufferedOutputStream(bam));

			os.flush();
			os.writeObject(o);
			os.flush();
		}
		catch (IOException e) {
			_log.error(e.getMessage());
		}

		return encode(bam.toByteArray());
	}

	public static Object stringToObject(String s) {
		if (s == null) {
			return null;
		}

		byte byteArray[] = decode(s);

		ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);

		try {
			ObjectInputStream is =
				new ObjectInputStream(new BufferedInputStream(bais));

			return is.readObject();
		}
		catch (Exception e) {
			_log.error(e.getMessage());
		}

		return null;
	}
	private static final Logger _log = Logger.getLogger(Base64.class);
	
    public static void main(String[] args) {  
        String aa = "d9c5dc9b13124cc3951447df7b067304";  
        aa = Base64.encode(aa.getBytes());  
        System.out.println("----编码:"+aa);  
        String str = aa;  
        String str2 = new String(Base64.decode(str));  
        System.out.println("-----解码:"+str2);  
    }  
}