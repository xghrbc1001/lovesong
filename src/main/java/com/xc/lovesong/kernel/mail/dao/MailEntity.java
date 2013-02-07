/**   
 * @title: MailEntity.java 
 * @package com.xc.lovesong.kernel.mail.dao 
 * @description: TODO 描述该文件作用 
 * @author chenyibin 
 * @date 2013-2-6 下午02:10:22 
 * @version V1.0   
 */
package com.xc.lovesong.kernel.mail.dao;

/** 
 * @copyright: 	www.xc.com
 * @author:		DanielChen@xc.com
 * @created:		2013-2-6 下午02:10:22
 * @vesion:		1.0
 * @updateLogs:
 * User		 	Date					Description
 * ------------------------------------------------------
 * DanielChen	2013-2-6-下午02:10:22  	添加类
 * 项目名称：		lovesong
 * 说明:	 邮件模板实体类		
 */
public class MailEntity {
	private String userName ;
	private String screenName ;
	private String email ;
	private String sex ;
	private String activeURL ;
	private String context ;
	
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getActiveURL() {
		return activeURL;
	}
	public void setActiveURL(String activeURL) {
		this.activeURL = activeURL;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
