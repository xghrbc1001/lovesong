/**   
 * @title: CrawlerMessage.java 
 * @package com.xc.taosku.home.crawlers.domain 
 * @description: TODO 描述该文件作用 
 * @author chenyibin 
 * @date 2012-10-6 下午07:41:31 
 * @version V1.0   
 */
package com.xc.lovesong.home.crawlers.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
 * @copyright: 	www.xc.com
 * @author:		DanielChen@xc.com
 * @created:		2012-10-6 下午07:41:31
 * @vesion:		1.0
 * @updateLogs:
 * User		 	Date					Description
 * ------------------------------------------------------
 * DanielChen	2012-10-6-下午07:41:31  	添加类
 * 项目名称：		taosku
 * 说明:	 TODO 添加类描述				
 */
@Entity(name="CRAWLERMESSAGE")
@Table(name="XC_CRAWLER_MESSAGES")
public class CrawlerMessage {
	
	@Id
	@Column(name="ID")
	@GeneratedValue
	private Integer ID ;			//主键
	@Column(name="TITLE")
	private String title ;			//商品标题
	@Column(name="SITEURL")
	private String siteurl ;		//商品链接
	@Column(name="IMAGE")
	private String image ;			//商品图片
	@Column(name="QUANTITY")
	private Integer quantity ;		//商品数量
	@Column(name="PRICE")
	private Double price ;			//定价
	@Column(name="BARGINPRICE")
	private Double barginPrice ;	//促销价
	@Column(name="STANDARD")
	private String standard ;		//规格
	@Column(name="EFFICACY")
	private String efficacy ;		//功效
	@Column(name="SUITABLE")
	private String suitable ;		//适用人群
	@Column(name="STARTTIME")
	private Date startTime ;		//开始时间
	@Column(name="ENDTIME")
	private Date endTime ;		//结束时间
	@Column(name="TRYNUM")
	private Integer tryNum ;			//申请人数
	@Column(name="DESCRIPTION")
	private String description ;	//描述
	@Column(name="REMARK")
	private String remark ;			//备注
	@Column(name="MERCHANT")
	private String merchant ;		//商家
	@Column(name="WEBSITE")
	private String website ;		//来源网站
	@Column(name="CITY")
	private String city ;			//城市
	@Column(name="PRIORITY")
	private Integer priority ;		//优先级
	@Column(name="TAGS")
	private String tags ;			//商品标签
	@Column(name="AUTO")
	private Integer auto ;			//是否自动抓取(0:否;1:是)
	@Column(name="EFFECTIVE")
	private Integer effective ;		//是否有效(0:无效;1:有效)
	
	@Column(name="ACTIVE")
	private Integer active ;		//是否删除
	@Column(name="CREATED_BY")
	private Integer createdBy ;		//创建人
	@Column(name="CREATE_DATE")
	private Date createDate ;		//创建时间
	@Column(name="LAST_UPDATE_BY")
	private Integer lastUpdateBy ;	//最后修改人
	@Column(name="LAST_UPDATE_DATE")
	private Date lastUpdateDate ;	//最后修改时间
	
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSiteurl() {
		return siteurl;
	}
	public void setSiteurl(String siteurl) {
		this.siteurl = siteurl;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getBarginPrice() {
		return barginPrice;
	}
	public void setBarginPrice(Double barginPrice) {
		this.barginPrice = barginPrice;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getEfficacy() {
		return efficacy;
	}
	public void setEfficacy(String efficacy) {
		this.efficacy = efficacy;
	}
	public String getSuitable() {
		return suitable;
	}
	public void setSuitable(String suitable) {
		this.suitable = suitable;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Integer getTryNum() {
		return tryNum;
	}
	public void setTryNum(Integer tryNum) {
		this.tryNum = tryNum;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getMerchant() {
		return merchant;
	}
	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public Integer getAuto() {
		return auto;
	}
	public void setAuto(Integer auto) {
		this.auto = auto;
	}
	public Integer getEffective() {
		return effective;
	}
	public void setEffective(Integer effective) {
		this.effective = effective;
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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
