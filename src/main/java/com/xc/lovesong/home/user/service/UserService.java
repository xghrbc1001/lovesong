/**   
 * @title: ResourceService.java 
 * @package com.xc.taosku.home.app.resource.service 
 * @description: TODO 描述该文件作用 
 * @author chenyibin 
 * @date 2012-9-4 下午10:45:49 
 * @version V1.0   
 */
package com.xc.lovesong.home.user.service;

import java.util.List;

import com.xc.lovesong.home.user.domain.UserBean;

/** 
 * @copyright: 	www.xc.com
 * @author:		DanielChen@xc.com
 * @created:		2012-9-4 下午10:45:49
 * @vesion:		1.0
 * @updateLogs:
 * User		 	Date					Description
 * ------------------------------------------------------
 * DanielChen	2012-9-4-下午10:45:49  	添加类
 * 项目名称：		taosku
 * 说明:	 TODO 添加类描述				
 */
public interface UserService {
	
	public List<UserBean> findUserList();
	public UserBean findUserById(Integer userId);
	
	public void addUserAndAccount(UserBean bean,String uuid);
	public boolean registerAction(Integer userId, Integer accountId);
	
	public UserBean findUserByUserName(String userName);
	
	public boolean sendRegisterConfirmEmail(String userName ,String email, String uuid);
}
