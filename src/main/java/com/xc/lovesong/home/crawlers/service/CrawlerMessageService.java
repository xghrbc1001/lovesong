/**   
 * @title: CrawlerMessageService.java 
 * @package com.xc.taosku.home.crawlers.service 
 * @description: TODO 描述该文件作用 
 * @author chenyibin 
 * @date 2012-10-6 下午07:58:08 
 * @version V1.0   
 */
package com.xc.lovesong.home.crawlers.service;

import com.xc.lovesong.home.crawlers.domain.CrawlerMessage;

/** 
 * @copyright: 	www.xc.com
 * @author:		DanielChen@xc.com
 * @created:		2012-10-6 下午07:58:08
 * @vesion:		1.0
 * @updateLogs:
 * User		 	Date					Description
 * ------------------------------------------------------
 * DanielChen	2012-10-6-下午07:58:08  	添加类
 * 项目名称：		taosku
 * 说明:	 TODO 添加类描述				
 */
public interface CrawlerMessageService {
	public void addCrawlerMessage(CrawlerMessage bean);
}
