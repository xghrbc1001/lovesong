/**   
 * @title: ResourceDao.java 
 * @package com.xc.taosku.home.app.resource.dao 
 * @description: TODO 描述该文件作用 
 * @author chenyibin 
 * @date 2012-9-4 下午10:46:57 
 * @version V1.0   
 */
package com.xc.lovesong.home.account.dao;

import java.util.List;

import com.xc.lovesong.home.account.domain.AccountBean;

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
public interface AccountDao {
	
	public List<AccountBean> queryAccountList();
	
	public AccountBean queryAccountById(Integer accountId);
	public AccountBean queryAccountByUUID(String UUID);
	public void insertAccount(AccountBean bean);
	public void updateAccountActive(Integer accountId);
	
}
