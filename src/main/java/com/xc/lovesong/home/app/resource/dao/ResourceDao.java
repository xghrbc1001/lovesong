/**   
 * @title: ResourceDao.java 
 * @package com.xc.taosku.home.app.resource.dao 
 * @description: TODO 描述该文件作用 
 * @author chenyibin 
 * @date 2012-9-4 下午10:46:57 
 * @version V1.0   
 */
package com.xc.lovesong.home.app.resource.dao;

import java.util.List;

import com.xc.lovesong.home.app.resource.domain.ResourceBean;

/** 
 * @copyright: 	www.xc.com
 * @author:		DanielChen@xc.com
 * @created:		2012-9-4 下午10:46:57
 * @vesion:		1.0
 * @updateLogs:
 * User		 	Date					Description
 * ------------------------------------------------------
 * DanielChen	2012-9-4-下午10:46:57  	添加类
 * 项目名称：		taosku
 * 说明:	 TODO 添加类描述				
 */
public interface ResourceDao {
	
	public List<ResourceBean> queryResourceList();
	
	public ResourceBean queryResourceById(Integer resourceId);
	
	public void insertResource(ResourceBean bean);
	
}
