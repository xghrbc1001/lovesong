/**   
 * @title: ResourceDaoImpl.java 
 * @package com.xc.taosku.home.app.resource.dao 
 * @description: TODO 描述该文件作用 
 * @author chenyibin 
 * @date 2012-9-4 下午10:47:23 
 * @version V1.0   
 */
package com.xc.lovesong.home.user.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xc.lovesong.home.account.domain.AccountBean;
import com.xc.lovesong.home.app.resource.domain.ResourceBean;
import com.xc.lovesong.home.user.domain.UserBean;

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
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<UserBean> queryUserList() {
		List<UserBean>  beanList = sessionFactory.getCurrentSession().createQuery("from USERS").list();
		return beanList;
	}


	public UserBean queryUserById(Integer userId) {
		UserBean bean = (UserBean) sessionFactory.getCurrentSession().get(
				UserBean.class, userId);
		return bean;
	}


	/**
	 * @title: insertResource
	 * @description: TODO 添加描述 
	 * @author: DanielChen 2012-9-4
	 * @param bean
	 */
	public void insertUser(UserBean bean){
		sessionFactory.getCurrentSession().save(bean);
	}
	
	public void updateUserActive(Integer userId){
		UserBean user = queryUserById(userId);
		user.setActive(new Integer(1));
		sessionFactory.getCurrentSession().update(user);
	}
	
	public UserBean queryUserByUserName(String userName) {
		String HQL = "from USERS as u where u.userName=:userName";
		Query query = sessionFactory.getCurrentSession().createQuery(HQL);
		query.setString("userName", userName);
		List result = query.list();  
		UserBean bean = (UserBean) result.get(0);
		return bean;
	}
	
}
