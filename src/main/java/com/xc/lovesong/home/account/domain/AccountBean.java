/**   
 * @title: ResourceBean.java 
 * @package com.xc.taosku.home.app.resource.domain 
 * @description: TODO 描述该文件作用 
 * @author chenyibin 
 * @date 2012-8-12 上午10:50:19 
 * @version V1.0   
 */
package com.xc.lovesong.home.account.domain;

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
@Entity(name="ACCOUNTS")
@Table(name="XC_ACCOUNTS")
public class AccountBean {
	@Id
	@Column(name="ACCOUNT_ID")
	@GeneratedValue
	private Integer accountId	;
	
	@Column(name="ACCOUNT_NAME")
	private String accountName ;
	
	@Column(name="ACCOUNT_TYPE")
	private String accountType ;
	
	@Column(name="PARENT_ACCOUNT_ID")
	private Integer parentAccountId ;
	
	@Column(name="COMPANY_ID")
	private Integer companyId ;
	
	@Column(name="USER_NAME")
	private String userName ;
	
	@Column(name="USER_ID")
	private Integer userId ;
	
	@Column(name="LEGAL_NAME")
	private String legalName ;
	
	@Column(name="LEGAL_CODE")
	private String legalCode ;
	
	@Column(name="LEGAL_TYPE")
	private String legalType ;
	
	@Column(name="BALANCE")
	private Double balance ;
	
	@Column(name="INTEGRAL")
	private Integer integral ;
	@Column(name="CONSUME_NUM")
	private Integer consumeNum ;
	
	@Column(name="DEFAULT_FLAG")
	private Integer defaultFlag ;	
	
	@Column(name="COMMENTS")
	private String comments ;		
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
	@Column(name="UUID")
	private String UUID ;
	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Integer getParentAccountId() {
		return parentAccountId;
	}

	public void setParentAccountId(Integer parentAccountId) {
		this.parentAccountId = parentAccountId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public String getLegalCode() {
		return legalCode;
	}

	public void setLegalCode(String legalCode) {
		this.legalCode = legalCode;
	}

	public String getLegalType() {
		return legalType;
	}

	public void setLegalType(String legalType) {
		this.legalType = legalType;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public Integer getDefaultFlag() {
		return defaultFlag;
	}

	public void setDefaultFlag(Integer defaultFlag) {
		this.defaultFlag = defaultFlag;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

	public Integer getConsumeNum() {
		return consumeNum;
	}

	public void setConsumeNum(Integer consumeNum) {
		this.consumeNum = consumeNum;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}


	
}
