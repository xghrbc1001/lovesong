package com.xc.lovesong.kernel.mail.service;

import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.xc.lovesong.kernel.mail.domain.EmailEntity;

/**
 * @copyright: 	www.xc.com
 * @author:		DanielChen@xc.com
 * @created:		2013-2-3 下午12:39:12
 * @vesion:		1.0
 * @updateLogs:
 * User		 	Date					Description
 * ------------------------------------------------------
 * DanielChen	2013-2-3-下午12:39:12  	添加类
 * 项目名称：		lovesong
 * 说明:	 邮件发送服务器
 */
public class JavaMailFactory {
	
	/***
	 * 此处也可修改为
	 * private JavaMailSenderImpl javaMailSenderImpl;
	 * ... 省略set,get,方便使用spring注入
	 * */
	
	private static JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
	
	static{
		senderImpl.setHost(EmailEntity.EMAIL_HOST);
		senderImpl.setUsername(EmailEntity.EMAIL_USERNAME); 
		senderImpl.setPassword(EmailEntity.EMAIL_PASSWORD); 		
		senderImpl.setJavaMailProperties(EmailEntity.safetyProperties);
	}
	
	public static JavaMailSenderImpl getJavaMail(){	
		System.out.println("***********"+senderImpl.getHost());
		return senderImpl;
	}


}
