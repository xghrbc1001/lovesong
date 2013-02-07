/**   
 * @title: ResourceDaoImpl.java 
 * @package com.xc.taosku.home.app.resource.dao 
 * @description: TODO 描述该文件作用 
 * @author chenyibin 
 * @date 2012-9-4 下午10:47:23 
 * @version V1.0   
 */
package com.xc.lovesong.home.account.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xc.lovesong.home.account.domain.AccountBean;


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
public class AccountDaoImpl implements AccountDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<AccountBean> queryAccountList() {
		List<AccountBean>  beanList = sessionFactory.getCurrentSession().createQuery("from USERS").list();
		return beanList;
	}


	public AccountBean queryAccountById(Integer accountId) {
		AccountBean bean = (AccountBean) sessionFactory.getCurrentSession().get(
				AccountBean.class, accountId);
		return bean;
	}
	public AccountBean queryAccountByUUID(String UUID){
		String HQL = "from ACCOUNTS as c where c.UUID=:UUID";
		Query query = sessionFactory.getCurrentSession().createQuery(HQL);
		query.setString("UUID", UUID);
		List result = query.list();  
		AccountBean bean = (AccountBean) result.get(0);
		return bean;
	}

	/**
	 * @title: insertResource
	 * @description: TODO 添加描述 
	 * @author: DanielChen 2012-9-4
	 * @param bean
	 */
	public void insertAccount(AccountBean bean){
		sessionFactory.getCurrentSession().save(bean);
	}
	public void updateAccountActive(Integer accountId){
		AccountBean account = queryAccountById(accountId);
		account.setActive(new Integer(1));
		sessionFactory.getCurrentSession().update(account);
	}
	
	
}
