/**   
 * @title: ResourceServiceImpl.java 
 * @package com.xc.taosku.home.app.resource.service 
 * @description: TODO 描述该文件作用 
 * @author chenyibin 
 * @date 2012-9-4 下午10:46:37 
 * @version V1.0   
 */
package com.xc.lovesong.home.user.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xc.lovesong.home.account.dao.AccountDao;
import com.xc.lovesong.home.account.domain.AccountBean;
import com.xc.lovesong.home.user.controller.UserController;
import com.xc.lovesong.home.user.dao.UserDao;
import com.xc.lovesong.home.user.domain.UserBean;
import com.xc.lovesong.kernel.mail.dao.MailEntity;
import com.xc.lovesong.kernel.mail.domain.SendMailType;
import com.xc.lovesong.kernel.mail.service.MailMessageFactory;
import com.xc.lovesong.kernel.util.UUIDGenerator;
import com.xc.lovesong.kernel.util.VelocityUtil;

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
public class UserServiceImpl implements UserService {
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserDao userDao ;
	@Autowired
	AccountDao accountDao ;
	
	@Transactional
	public List<UserBean> findUserList() {
		List<UserBean> beanList = new ArrayList<UserBean>();
		beanList = userDao.queryUserList();
		return beanList;
	}

	@Transactional
	public UserBean findUserById(Integer userId){
		return userDao.queryUserById(userId);
	}

	@Transactional
	public void addUserAndAccount(UserBean bean,String uuid){
		Date newTime = new Date();
		//1:增加用户表记录
		bean.setActive(0);
		bean.setCreatedBy(0);
		bean.setCreatedDate(newTime);
		bean.setLastUpdateBy(0);
		bean.setLastUpdateDate(newTime);
		
		userDao.insertUser(bean);
		//2:增加账户表记录(与用户关联)
		AccountBean account = new AccountBean();
		account.setUserId(bean.getUserId());
		account.setUserName(bean.getUserName());
		account.setLegalType("邮件类型");
		account.setLegalName("QQ邮箱");
		account.setLegalCode(bean.getEmail());
		account.setConsumeNum(3);
		account.setDefaultFlag(1);
		account.setActive(0);
		account.setCreatedBy(0);
		account.setCreatedDate(newTime);
		account.setLastUpdateBy(0);
		account.setLastUpdateDate(newTime);
		account.setUUID(uuid);
		accountDao.insertAccount(account);
		
		//3:发送邮件确认信息
		sendRegisterConfirmEmail(bean.getUserName(),bean.getEmail(),uuid);
		
	}
	public boolean sendRegisterConfirmEmail(String userName ,String email, String uuid){
		boolean flag = false ;
		try{
			String activeURL = "http://localhost:8080/web/register/action/"+uuid;
			VelocityUtil vutil = VelocityUtil.Instatnce();
			Map<String, Object> map = new HashMap<String, Object>();
			MailEntity entity = new MailEntity() ;
			entity.setUserName(userName);
			entity.setEmail(email);
			entity.setActiveURL(activeURL);
			map.put("mailEntity", entity);
			String text = vutil.getTemplateValue("confirmMail.vm", "UTF-8",map);
			
			
			MailMessageFactory mms = new MailMessageFactory(SendMailType.HTML);  
	        mms.setSubject("情歌-注册确认邮件")  
	        .setText("<html>" +
	        		"<head><meta http-equiv='content-type' content='text/html; charset=GBK'></head>" +
	        		"<body>" +
	        		"<h1>这里是情歌网发送的邮件</h1>" +
	        		"<p>"+text+"</p>" +
	        		"</body></html>").send();
	       flag = true;
		}catch(Exception ex){
			logger.error(ex.getMessage(),ex);
		}

		return flag;
		
	}
	@Transactional
	public boolean registerAction(Integer userId, Integer accountId){
		userDao.updateUserActive(userId);
		accountDao.updateAccountActive(accountId);
		return true;
		
	}
	@Transactional
	public UserBean findUserByUserName(String userName){
		return userDao.queryUserByUserName(userName);
	}
}
