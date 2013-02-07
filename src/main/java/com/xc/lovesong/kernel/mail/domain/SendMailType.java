package com.xc.lovesong.kernel.mail.domain;
/**
 * 
 * @copyright: 	www.xc.com
 * @author:		DanielChen@xc.com
 * @created:		2013-2-2 下午02:31:07
 * @vesion:		1.0
 * @updateLogs:
 * User		 	Date					Description
 * ------------------------------------------------------
 * DanielChen	2013-2-2-下午02:31:07  	添加类
 * 项目名称：		lovesong
 * 说明:	 TODO 添加类描述
 */
public enum SendMailType {
	/**
	 * 文本类型
	 * */
	TEXT,
	/**
	 * HTML类型,包含图片与附件内容
	 * **/
	HTML;
	
	@Override
	public String toString() {
		String message = null;
		switch (this) {
		case TEXT:
			message = "发送文本消息";
			break;
		case HTML :
			message = "发送html消息";	
			break;
		}
		return message;
	}
	
	

}