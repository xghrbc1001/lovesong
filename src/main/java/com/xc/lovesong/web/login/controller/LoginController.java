package com.xc.lovesong.web.login.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xc.lovesong.home.user.domain.UserBean;
import com.xc.lovesong.home.user.service.UserService;
import com.xc.lovesong.web.login.domain.LoginContext;
import com.xc.lovesong.web.util.Constants;



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
@RequestMapping("/web")
public class LoginController {
	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "loginIndex", method = RequestMethod.GET)
	public String loginIndex(@RequestParam(value = "locale", required = false) Locale locale,
            HttpServletRequest request,
            HttpServletResponse response){
		System.out.println("-----------loginIndex----------->");
		return "web/login/login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam(value = "locale", required = false) Locale locale,
            HttpServletRequest request,
            HttpServletResponse response,Model view){
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		StringBuffer message = new StringBuffer();
		//1:验证用户是否存在
		UserBean user = userService.findUserByUserName(userName);
		if(user != null ){
			String confirPassword = user.getPassword();
			//2:验证密码是否正确
			if(password.equals(confirPassword)){
				//2:验证用户是否激活
				Integer active = user.getActive() ;	
				if(active.intValue() == Constants.ACTIVE_VALID ){
					LoginContext loginContext = new LoginContext(userName,password);
					request.getSession().setAttribute(userName, loginContext);
					message.append("用户："+userName+"登录成功!");
				}else{
					message.append("用户："+userName+"还未激活,请您激活!");
				}
			}else{
				message.append("用户密码不正确,请您确认!");
			}
		}else{
			message.append("用户："+userName+"不存在,请您确认!");
		}
		view.addAttribute("message", message);
		view.addAttribute("userName", userName);
		
    	return "index";
	}
	
	@RequestMapping(value = "/{userName}/logou", method = RequestMethod.GET)
	public String logout(@PathVariable("userName") String userName,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException{
//		String userName = request.getParameter("userName");
		System.out.println("---request.getContextPath()-->"+request.getContextPath());
		request.getSession().removeAttribute(userName);
        response.sendRedirect("http://localhost:8080/web/loginIndex");
        //跳转到首页
        return null;
	}
	
	
	public boolean isValid(LoginContext loginContext) {
		
		String password = loginContext.getPassword();
		UserBean user = userService.findUserByUserName(loginContext.getUserName());
		if(user != null){
			String confirPassword = user.getPassword().trim() ;
			if(password.equals(confirPassword)){
				
			}
		}
		
		return true;
    }
	
}
