/**   
 * @title: ResourceBean.java 
 * @package com.xc.taosku.home.app.resource.domain 
 * @description: TODO 描述该文件作用 
 * @author chenyibin 
 * @date 2012-8-12 上午10:50:19 
 * @version V1.0   
 */
package com.xc.lovesong.home.app.resource.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

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
@Entity(name="RESOURCES")
@Table(name="XC_RESOURCES")
public class ResourceBean {
	@Id
	@Column(name="RESOURCE_ID")
	@GeneratedValue
	private Integer resourceId	;
	
	@Column(name="RESOURCE_CODE")
	private String resourceCode ;
	
	@Column(name="RESOURCE_NAME")
	private String resourceName ;
	
	@Column(name="RESOURCE_URL")
	private String resourceURL ;
	
	@Column(name="RESOURCE_TYPE")
	private Integer resourceType ;
	
	@Column(name="TARGET")
	private String target ;
	
	@Column(name="LEVEL_NUM")
	private Integer levelNum ;
	
	@Column(name="ORDER_NUM")
	private Integer orderNum ;
	
	@Column(name="ALIASES")
	private String aliases ;
	
	@Column(name="STYLE")
	private String style ;
	
	@Column(name="UNI_ID")
	private String uniId ;
	
	@Column(name="COMMENTS")
	private String comments ;
	
	@Column(name="PARENT_RES_ID")
	private Integer parentResId ;
	@Transient 
	private String parentResName ;	
	
	@Column(name="ACTIVE")
	private Integer active ;
	
	
	public Integer getResourceId() {
		return resourceId;
	}
	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}
	public String getResourceCode() {
		return resourceCode;
	}
	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getResourceURL() {
		return resourceURL;
	}
	public void setResourceURL(String resourceURL) {
		this.resourceURL = resourceURL;
	}
	public Integer getResourceType() {
		return resourceType;
	}
	public void setResourceType(Integer resourceType) {
		this.resourceType = resourceType;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public Integer getLevelNum() {
		return levelNum;
	}
	public void setLevelNum(Integer levelNum) {
		this.levelNum = levelNum;
	}
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	public String getAliases() {
		return aliases;
	}
	public void setAliases(String aliases) {
		this.aliases = aliases;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getUniId() {
		return uniId;
	}
	public void setUniId(String uniId) {
		this.uniId = uniId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Integer getParentResId() {
		return parentResId;
	}
	public void setParentResId(Integer parentResId) {
		this.parentResId = parentResId;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	public String getParentResName() {
		return parentResName;
	}
	public void setParentResName(String parentResName) {
		this.parentResName = parentResName;
	}
	
}
