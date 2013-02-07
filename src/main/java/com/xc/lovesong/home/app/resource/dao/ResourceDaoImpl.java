/**   
 * @title: ResourceDaoImpl.java 
 * @package com.xc.taosku.home.app.resource.dao 
 * @description: TODO 描述该文件作用 
 * @author chenyibin 
 * @date 2012-9-4 下午10:47:23 
 * @version V1.0   
 */
package com.xc.lovesong.home.app.resource.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xc.lovesong.home.app.resource.domain.ResourceBean;

/** 
 * @copyright: 	www.xc.com
 * @author:		DanielChen@xc.com
 * @created:		2012-9-4 下午10:47:23
 * @vesion:		1.0
 * @updateLogs:
 * User		 	Date					Description
 * ------------------------------------------------------
 * DanielChen	2012-9-4-下午10:47:23  	添加类
 * 项目名称：		taosku
 * 说明:	 TODO 添加类描述				
 */

@Repository
public class ResourceDaoImpl implements ResourceDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public List<ResourceBean> queryResourceList() {
		List<ResourceBean>  beanList = sessionFactory.getCurrentSession().createQuery("from RESOURCES").list();
		return beanList;
	}


	public ResourceBean queryResourceById(Integer resourceId) {
		ResourceBean bean = (ResourceBean) sessionFactory.getCurrentSession().get(
				ResourceBean.class, resourceId);
		return bean;
	}


	/**
	 * @title: insertResource
	 * @description: TODO 添加描述 
	 * @author: DanielChen 2012-9-4
	 * @param bean
	 */
	public void insertResource(ResourceBean bean) {
		sessionFactory.getCurrentSession().save(bean);
	}
	
	
	
}
