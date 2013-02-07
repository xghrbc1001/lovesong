package com.xc.lovesong.kernel.mail.domain;

import java.util.Properties;

import com.xc.lovesong.kernel.util.PropertiesUtil;

public class EmailEntity {
	
	/**邮件服务器*/
	private static final String EMAIL_HOST_KEY = "mail.host";
	public static final String EMAIL_HOST = PropertiesUtil.get(EMAIL_HOST_KEY);
	
	/**用户名*/
	private static final String EMAIL_USERNAME_KEY = "mail.username";
	public static final String EMAIL_USERNAME = PropertiesUtil.get(EMAIL_USERNAME_KEY);
	
	/**用户密码*/
	private static final String EMAIL_PASSWORD_KEY = "mail.password";
	public static final String EMAIL_PASSWORD = PropertiesUtil.get(EMAIL_PASSWORD_KEY);	
	
	/**接收人*/
	private static final String EMAIL_TO_KEY = "mail.to";
	public static final String EMAIL_TO = PropertiesUtil.get(EMAIL_TO_KEY);
	
	/**发送人*/
	private static final String EMAIL_FROM_KEY = "mail.from";
	public static final String EMAIL_FROM = PropertiesUtil.get(EMAIL_FROM_KEY);	
	
	/**服务器进行认证,认证用户名和密码是否正确*/
	private static final String EMAIL_SMTP_AUTH_KEY = "mail.smtp.auth";
	public static final String EMAIL_SMTP_AUTH = PropertiesUtil.get(EMAIL_SMTP_AUTH_KEY);
	
	/**超时时间设定*/
	private static final String EMAIL_SMTP_TIMEOUT_KEY = "mail.smtp.timeout";
	public static final String EMAIL_SMTP_TIMEOUT = PropertiesUtil.get(EMAIL_SMTP_TIMEOUT_KEY);
	
	
	/**编码设置*/
	private static final String EMAIL_ENCODING_KEY = "mail.encoding";
	public static final String EMAIL_ENCODING = PropertiesUtil.get(EMAIL_ENCODING_KEY);
	
	private static final String EMAIL_SMTP_STARTTLS_KEY = "mail.smtp.starttls.enable";
	public static final String EMAIL_SMTP_STARTTLS = PropertiesUtil.get(EMAIL_SMTP_STARTTLS_KEY);
	
	//private static final String EMAIL_SMTP_SOCKETFACTORY_CLASS_KEY = "mail.smtp.socketFactory.class";
	//public static final String EMAIL_SMTP_SOCKETFACTORY_CLASS = PropertiesUtil.get(EMAIL_SMTP_SOCKETFACTORY_CLASS_KEY);
	
	
	/**安全认证设置*/
	public static Properties safetyProperties = new Properties();
	
	static{
		//调试信息,可以取消
		//System.setProperty( "javax.net.debug", "ssl");		
		/**
		 * #配置JavaMail的Properties时，不要指定“mail.smtp.socketFactory.class”，
		   #因为TLS使用的是普通的Socket。然后指定属性“mail.smtp.starttls.enable”为“true”。
		 * */		
		safetyProperties.put(EMAIL_SMTP_AUTH_KEY, EMAIL_SMTP_AUTH); 
		//safetyProperties.put(EMAIL_SMTP_STARTTLS_KEY, EMAIL_SMTP_STARTTLS); 
		safetyProperties.put("mail.smtp.starttls.enable","true");
		//safetyProperties.put(EMAIL_SMTP_SOCKETFACTORY_CLASS_KEY, EMAIL_SMTP_SOCKETFACTORY_CLASS);
		//safetyProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
		
		safetyProperties.put("mail.smtp.socketFactory.fallback", "false"); 
	    safetyProperties.put("mail.smtp.port", "465"); 
	    safetyProperties.put("mail.smtp.socketFactory.port", "465"); 
	}	
}