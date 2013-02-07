/**   
 * @title: ICrawler.java 
 * @package com.xc.taosku.kernel.util.crawlers 
 * @description: TODO 描述该文件作用 
 * @author chenyibin 
 * @date 2012-10-5 上午10:17:35 
 * @version V1.0   
 */
package com.xc.lovesong.home.crawlers.util.crawler;

/** 
 * @copyright: 	www.xc.com
 * @author:		DanielChen@xc.com
 * @created:		2012-10-5 上午10:17:35
 * @vesion:		1.0
 * @updateLogs:
 * User		 	Date					Description
 * ------------------------------------------------------
 * DanielChen	2012-10-5-上午10:17:35  	添加类
 * 项目名称：		taosku
 * 说明:	 TODO 添加类描述				
 */
public interface ICrawler {
	/**
	 * @title: execute
	 * @category: 执行爬虫任务,抓取网页
	 * @author: chenyibin 2012-10-5
	 * @param webURL 要抓取的网址
	 */
	public void executeCrawler(String webURL);
	
	/**
	 * @title: converts
	 * @category: 转换中间数据为正式数据
	 * @author: chenyibin 2012-10-5
	 */
	public void convertData();
}
