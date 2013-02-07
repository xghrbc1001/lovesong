/**   
 * @title: MessageDaoImpl.java 
 * @package com.xc.taosku.home.crawlers.dao 
 * @description: TODO 描述该文件作用 
 * @author chenyibin 
 * @date 2012-10-6 下午07:37:27 
 * @version V1.0   
 */
package com.xc.lovesong.home.crawlers.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xc.lovesong.home.crawlers.domain.CrawlerMessage;


/** 
 * @copyright: 	www.xc.com
 * @author:		DanielChen@xc.com
 * @created:		2012-10-6 下午07:37:27
 * @vesion:		1.0
 * @updateLogs:
 * User		 	Date					Description
 * ------------------------------------------------------
 * DanielChen	2012-10-6-下午07:37:27  	添加类
 * 项目名称：		taosku
 * 说明:	 TODO 添加类描述				
 */
@Repository
public class CrawlerMessageDaoImpl implements CrawlerMessageDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * @title: insertResource
	 * @description: TODO 添加描述 
	 * @author: DanielChen 2012-9-4
	 * @param bean
	 */
	public void insertMessage(CrawlerMessage bean) {
		sessionFactory.getCurrentSession().save(bean);
		
	}
	
}
