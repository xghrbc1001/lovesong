package com.xc.lovesong.base.form;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;

/**
 * 
 * @copyright: 	www.taosku.com
 * @author:		Beni
 * @created:		2012-6-30 上午11:56:07
 * @vesion:		1.0
 * @updateLogs:
 * User		 	Date					Description
 * ------------------------------------------------------
 * Beni	2012-6-30-上午11:56:07  	添加类
 * 项目名称：		taosku
 * 说明:	 Domain基类
 */
public class BaseForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CREATE_TIME")
	private Timestamp createTime;

	@Column(name = "UPDATE_TIME")
	private Timestamp updateTime;

	@Column(name = "CREATE_USER")
	private String createUser;

	@Column(name = "UPDATE_USER")
	private String updateUser;

	@Column(name = "DELETED")
	private Boolean deleted;

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

}
