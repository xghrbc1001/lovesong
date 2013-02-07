/**   
 * @title: ResourceBean.java 
 * @package com.xc.taosku.home.app.resource.domain 
 * @description: TODO 描述该文件作用 
 * @author chenyibin 
 * @date 2012-8-12 上午10:50:19 
 * @version V1.0   
 */
package com.xc.lovesong.home.user.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
 * @copyright: 	www.xc.com
 * @author:		DanielChen@xc.com
 * @created:		2012-8-12 上午10:50:19
 * @vesion:		1.0
 * @updateLogs:
 * User		 	Date					Description
 * ------------------------------------------------------
 * DanielChen	2012-8-12-上午10:50:19  	添加类
 * 项目名称：		taosku
 * 说明:	 TODO 添加类描述				
 */
@Entity(name="USERS")
@Table(name="XC_USERS")
public class UserBean implements Serializable{
	@Id
	@Column(name="USER_ID")
	@GeneratedValue
	private Integer userId	;
	
	@Column(name="USER_NAME")
	private String userName ;
	
	@Column(name="SCREEN_NAME")
	private String screenName ;
	
	@Column(name="PASSWORD")
	private String password ;
	
	@Column(name="PASSWORD_ENCRYPTED")
	private Integer passwordEncrypted ;
	
	@Column(name="PASSWORD_RESET")
	private Integer passwordReset ;
	
	@Column(name="PASSWORD_MODIFIED_DATE")
	private Date passwordModifiedDate ;
	
	@Column(name="SEX")
	private Integer sex ;
	
	@Column(name="PHONE")
	private String phone ;
	
	@Column(name="FIXED_PHONE")
	private String fixedPhone ;
	
	@Column(name="BIRTHDAY")
	private Date birthday ;
	
	@Column(name="EMAIL")
	private String email ;
	
	@Column(name="ADDRESS")
	private String address ;	
	
	@Column(name="COMPANY_ID")
	private Integer companyId ;
	
	@Column(name="COMMENTS")
	private String comments ;	
	
	@Column(name="PORTRAIT_URL")
	private String portraitURL ;	
	@Column(name="GREET_WORD")
	private String greetWord ;	
	
		
	
	@Column(name="LOGIN_COUNT")
	private Integer loginCount ;
	
	@Column(name="LOGIN_DATE")
	private Date loginDate ;
	
	@Column(name="LOGIN_IP")
	private String loginIP ;
	
	@Column(name="LAST_LOGIN_DATE")
	private Date lastLoginDate ;
	
	@Column(name="LAST_LOGIN_IP")
	private String lastLoginIP ;
	
	@Column(name="ACTIVE")
	private Integer active ;
	
	@Column(name="CREATED_BY")
	private Integer createdBy ;
	
	@Column(name="CREATED_DATE")
	private Date createdDate ;
	
	@Column(name="LAST_UPDATE_BY")
	private Integer lastUpdateBy ;
	
	@Column(name="LAST_UPDATE_DATE")
	private Date lastUpdateDate ;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPasswordEncrypted() {
		return passwordEncrypted;
	}

	public void setPasswordEncrypted(Integer passwordEncrypted) {
		this.passwordEncrypted = passwordEncrypted;
	}

	public Integer getPasswordReset() {
		return passwordReset;
	}

	public void setPasswordReset(Integer passwordReset) {
		this.passwordReset = passwordReset;
	}

	public Date getPasswordModifiedDate() {
		return passwordModifiedDate;
	}

	public void setPasswordModifiedDate(Date passwordModifiedDate) {
		this.passwordModifiedDate = passwordModifiedDate;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFixedPhone() {
		return fixedPhone;
	}

	public void setFixedPhone(String fixedPhone) {
		this.fixedPhone = fixedPhone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getPortraitURL() {
		return portraitURL;
	}

	public void setPortraitURL(String portraitURL) {
		this.portraitURL = portraitURL;
	}

	public String getGreetWord() {
		return greetWord;
	}

	public void setGreetWord(String greetWord) {
		this.greetWord = greetWord;
	}

	public Integer getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getLoginIP() {
		return loginIP;
	}

	public void setLoginIP(String loginIP) {
		this.loginIP = loginIP;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getLastLoginIP() {
		return lastLoginIP;
	}

	public void setLastLoginIP(String lastLoginIP) {
		this.lastLoginIP = lastLoginIP;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(Integer lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
	
}
