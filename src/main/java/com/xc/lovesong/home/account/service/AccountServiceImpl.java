/**   
 * @title: ResourceServiceImpl.java 
 * @package com.xc.taosku.home.app.resource.service 
 * @description: TODO 描述该文件作用 
 * @author chenyibin 
 * @date 2012-9-4 下午10:46:37 
 * @version V1.0   
 */
package com.xc.lovesong.home.account.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xc.lovesong.home.account.dao.AccountDao;
import com.xc.lovesong.home.account.domain.AccountBean;
import com.xc.lovesong.home.user.controller.UserController;
import com.xc.lovesong.home.user.dao.UserDao;
import com.xc.lovesong.home.user.domain.UserBean;
import com.xc.lovesong.kernel.mail.domain.SendMailType;
import com.xc.lovesong.kernel.mail.service.MailMessageFactory;
import com.xc.lovesong.kernel.util.UUIDGenerator;

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
public class AccountServiceImpl implements AccountService {
	private static final Logger logger = Logger.getLogger(AccountServiceImpl.class);
	
	@Autowired
	AccountDao accountDao ;
	

	@Transactional
	public AccountBean findAccountByUUID(String UUID) {
		return accountDao.queryAccountByUUID(UUID);
	}


}
