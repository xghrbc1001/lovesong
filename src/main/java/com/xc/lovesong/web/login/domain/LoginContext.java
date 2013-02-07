/**   
 * @title: LoginContext.java 
 * @package com.xc.lovesong.web.login.domain 
 * @description: TODO 描述该文件作用 
 * @author chenyibin 
 * @date 2013-2-4 下午04:31:30 
 * @version V1.0   
 */
package com.xc.lovesong.web.login.domain;

/** 
 * @copyright: 	www.xc.com
 * @author:		DanielChen@xc.com
 * @created:		2013-2-4 下午04:31:30
 * @vesion:		1.0
 * @updateLogs:
 * User		 	Date					Description
 * ------------------------------------------------------
 * DanielChen	2013-2-4-下午04:31:30  	添加类
 * 项目名称：		lovesong
 * 说明:	 TODO 添加类描述				
 */
public class LoginContext {
	 private String userName;
	 private String password;
	 private String email ;
	 private String sex ;
	 private String confirmPassword ;
	 
	 public LoginContext(){}
	 public LoginContext(String userName ,String password){
		 this.userName = userName ;
		 this.password = password ;
	 }
	 
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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
	 
}
