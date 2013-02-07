/**   
 * @title: ResultBean.java 
 * @package com.xc.taosku.kernel.bean 
 * @description: TODO 描述该文件作用 
 * @author chenyibin 
 * @date 2012-9-4 下午05:39:39 
 * @version V1.0   
 */
package com.xc.lovesong.kernel.bean;

import java.io.Serializable;
import java.util.Date;

/** 
 * @copyright: 	www.xc.com
 * @author:		DanielChen@xc.com
 * @created:		2012-9-4 下午05:39:39
 * @vesion:		1.0
 * @updateLogs:
 * User		 	Date					Description
 * ------------------------------------------------------
 * DanielChen	2012-9-4-下午05:39:39  	添加类
 * 项目名称：		taosku
 * 说明:	 TODO 添加类描述				
 */
public class ResultBean implements Serializable {
	/**
	 * @daniel 
	 */
	private static final long serialVersionUID = 4495840911980139979L;
	/**
	 * 成功标识
	 */
	private Boolean success;
	/**
	 * 错误标识编号
	 */
	private String errorCode;
	/**
	 * 错误信息
	 */
	private String errorMsg;
	
	
	/**
	 * 操作时间
	 */
	private Date operaterTime;
	/**
	 * 操作者 
	 */
	private String operater;
	

	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getOperater() {
		return operater;
	}
	public void setOperater(String operater) {
		this.operater = operater;
	}
	public Date getOperaterTime() {
		return operaterTime;
	}
	public void setOperaterTime(Date operaterTime) {
		this.operaterTime = operaterTime;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
}
