/**   
 * @title: ResourceServiceImpl.java 
 * @package com.xc.taosku.home.app.resource.service 
 * @description: TODO 描述该文件作用 
 * @author chenyibin 
 * @date 2012-9-4 下午10:46:37 
 * @version V1.0   
 */
package com.xc.lovesong.home.app.resource.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xc.lovesong.home.app.resource.dao.ResourceDao;
import com.xc.lovesong.home.app.resource.domain.ResourceBean;

/** 
 * @copyright: 	www.xc.com
 * @author:		DanielChen@xc.com
 * @created:		2012-9-4 下午10:46:37
 * @vesion:		1.0
 * @updateLogs:
 * User		 	Date					Description
 * ------------------------------------------------------
 * DanielChen	2012-9-4-下午10:46:37  	添加类
 * 项目名称：		taosku
 * 说明:	 TODO 添加类描述				
 */

@Service
public class ResourceServiceImpl implements ResourceService {
	
	@Autowired
	ResourceDao resourceDao ;
	
	@Transactional
	public List<ResourceBean> findResourceList() {
		List<ResourceBean> beanList = new ArrayList<ResourceBean>();
		beanList = resourceDao.queryResourceList();
		return beanList;
	}

	@Transactional
	public ResourceBean findResourceById(Integer resourceId) {
		return resourceDao.queryResourceById(resourceId);
	}


	@Transactional
	public void addResource(ResourceBean bean) {
		resourceDao.insertResource(bean);
		
	}
	
}
