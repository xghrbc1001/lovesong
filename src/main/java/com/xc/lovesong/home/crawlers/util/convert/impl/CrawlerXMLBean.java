/**   
 * @title: CrawlerXMLBean.java 
 * @package com.xc.taosku.kernel.util.converts.impl 
 * @description: TODO 描述该文件作用 
 * @author chenyibin 
 * @date 2012-10-4 下午10:51:31 
 * @version V1.0   
 */
package com.xc.lovesong.home.crawlers.util.convert.impl;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.xc.lovesong.home.crawlers.util.convert.BaseXMLBean;
import com.xc.lovesong.home.crawlers.util.convert.CrawlerDetail;

/** 
 * @copyright: 	www.xc.com
 * @author:		DanielChen@xc.com
 * @created:		2012-10-4 下午10:51:31
 * @vesion:		1.0
 * @updateLogs:
 * User		 	Date					Description
 * ------------------------------------------------------
 * DanielChen	2012-10-4-下午10:51:31  	添加类
 * 项目名称：		taosku
 * 说明:	 TODO 添加类描述				
 */
@XmlRootElement(name = "products")
@XmlType(propOrder = {"crawlerDetail" })
public class  CrawlerXMLBean extends BaseXMLBean{
	
	private List<CrawlerDetail> crawlerDetail; //爬虫XML明细
	
	@XmlElement(name = "product", required = true)
	public List<CrawlerDetail> getCrawlerDetail() {
		return crawlerDetail;
	}

	public void setCrawlerDetail(List<CrawlerDetail> crawlerDetail) {
		this.crawlerDetail = crawlerDetail;
	}
	public static void main(String[] args) {
		CrawlerXMLBean crawlerXMLBean = new CrawlerXMLBean();
		
		crawlerXMLBean = (CrawlerXMLBean) crawlerXMLBean.loadFile("D:/tmp/eladies.sina.com/sina.eladies.xml");
		List<CrawlerDetail> crawlerDetail= crawlerXMLBean.getCrawlerDetail();
		for(CrawlerDetail crawler : crawlerDetail){
			System.out.println(crawler.getTitle());
		}
		
	}
	
}
