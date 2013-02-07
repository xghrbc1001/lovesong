/**   
 * @title: CrawlerServiceImpl.java 
 * @package com.xc.taosku.home.crawlers.service 
 * @description: TODO 描述该文件作用 
 * @author chenyibin 
 * @date 2012-10-6 下午07:58:30 
 * @version V1.0   
 */
package com.xc.lovesong.home.crawlers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xc.lovesong.home.crawlers.dao.CrawlerMessageDao;
import com.xc.lovesong.home.crawlers.domain.CrawlerMessage;

/** 
 * @copyright: 	www.xc.com
 * @author:		DanielChen@xc.com
 * @created:		2012-10-6 下午07:58:30
 * @vesion:		1.0
 * @updateLogs:
 * User		 	Date					Description
 * ------------------------------------------------------
 * DanielChen	2012-10-6-下午07:58:30  	添加类
 * 项目名称：		taosku
 * 说明:	 TODO 添加类描述				
 */
@RequestMapping("/home/crawler/service")
@Service
public class CrawlerMessageServiceImpl implements CrawlerMessageService {
	@Autowired
	private CrawlerMessageDao crawlerMessageDao ;
	
	@RequestMapping(value = "addCrawlerMessage", method = RequestMethod.POST)
	public void addCrawlerMessage(CrawlerMessage bean) {
		crawlerMessageDao.insertMessage(bean);
	}

}
