package com.xc.lovesong.home.user.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xc.lovesong.home.account.domain.AccountBean;
import com.xc.lovesong.home.account.service.AccountService;
import com.xc.lovesong.home.user.domain.UserBean;
import com.xc.lovesong.home.user.service.UserService;
import com.xc.lovesong.kernel.bean.ResultBean;

/** 
 * @copyright: 	www.xc.com
 * @author:		DanielChen@xc.com
 * @created:		2012-7-31 下午01:58:32
 * @vesion:		1.0
 * @updateLogs:
 * User		 	Date					Description
 * ------------------------------------------------------
 * DanielChen	2012-7-31-下午01:58:32  	添加类
 * 项目名称：		taosku
 * 说明:	 TODO 添加类描述				
 */

@Controller
@RequestMapping("/home/app/user")
public class UserController {
	private static final Logger logger = Logger.getLogger(UserController.class);


	
}
