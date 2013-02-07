/**   
 * @title: CrawlerDetail.java 
 * @package com.xc.taosku.kernel.util.converts.impl 
 * @description: TODO 描述该文件作用 
 * @author chenyibin 
 * @date 2012-10-4 下午10:52:45 
 * @version V1.0   
 */
package com.xc.lovesong.home.crawlers.util.convert;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/** 
 * @copyright: 	www.xc.com
 * @author:		DanielChen@xc.com
 * @created:		2012-10-4 下午10:52:45
 * @vesion:		1.0
 * @updateLogs:
 * User		 	Date					Description
 * ------------------------------------------------------
 * DanielChen	2012-10-4-下午10:52:45  	添加类
 * 项目名称：		taosku
 * 说明:	 TODO 添加类描述				
 */
@XmlType(propOrder = { 
		"title", "siteurl", "image", "quantity", "price", 
		"barginPrice", "standard", "efficacy", "suitable", "startTime", 
		"endTime", "tryNum", "description", "remark", "merchant", 
		"website","city","priority", "tags", "auto", 
		"effective"
	})
public class CrawlerDetail {
	
	private String title ;			//商品标题
	private String siteurl ;		//商品链接
	private String image ;			//商品图片
	private String quantity ;		//商品数量
	private String price ;			//定价
	private String barginPrice ;	//促销价
	private String standard ;		//规格
	private String efficacy ;		//功效
	private String suitable ;		//适用人群
	private String startTime ;		//开始时间
	private String endTime ;		//结束时间
	private String tryNum ;			//申请人数
	private String description ;	//描述
	private String remark ;			//备注
	private String merchant ;		//商家
	private String website ;		//来源网站
	private String city ;			//城市
	private String priority ;		//优先级
	private String tags ;			//商品标签
	private String auto ;			//是否自动抓取(0:否;1:是)
	private String effective ;		//是否有效(0:无效;1:有效)
	

	@XmlElement(name = "title", required = true)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@XmlElement(name = "siteurl", required = true)
	public String getSiteurl() {
		return siteurl;
	}

	public void setSiteurl(String siteurl) {
		this.siteurl = siteurl;
	}
	@XmlElement(name = "image", required = true)
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@XmlElement(name = "quantity", required = true)
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	@XmlElement(name = "price", required = true)
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	@XmlElement(name = "barginPrice", required = true)
	public String getBarginPrice() {
		return barginPrice;
	}

	public void setBarginPrice(String barginPrice) {
		this.barginPrice = barginPrice;
	}
	@XmlElement(name = "standard", required = true)
	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}
	@XmlElement(name = "efficacy", required = true)
	public String getEfficacy() {
		return efficacy;
	}

	public void setEfficacy(String efficacy) {
		this.efficacy = efficacy;
	}
	@XmlElement(name = "suitable", required = true)
	public String getSuitable() {
		return suitable;
	}

	public void setSuitable(String suitable) {
		this.suitable = suitable;
	}
	@XmlElement(name = "startTime", required = true)
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	@XmlElement(name = "endTime", required = true)
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	@XmlElement(name = "tryNum", required = true)
	public String getTryNum() {
		return tryNum;
	}

	public void setTryNum(String tryNum) {
		this.tryNum = tryNum;
	}
	@XmlElement(name = "description", required = true)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@XmlElement(name = "remark", required = true)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	@XmlElement(name = "merchant", required = true)
	public String getMerchant() {
		return merchant;
	}

	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}
	@XmlElement(name = "website", required = true)
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	@XmlElement(name = "city", required = true)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@XmlElement(name = "priority", required = true)
	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	@XmlElement(name = "tags", required = true)
	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
	@XmlElement(name = "auto", required = true)
	public String getAuto() {
		return auto;
	}

	public void setAuto(String auto) {
		this.auto = auto;
	}
	@XmlElement(name = "effective", required = true)
	public String getEffective() {
		return effective;
	}

	public void setEffective(String effective) {
		this.effective = effective;
	}

}
