package com.xc.lovesong.web.register.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.xc.lovesong.kernel.util.UUIDGenerator;
import com.xc.lovesong.web.login.domain.LoginContext;



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
@RequestMapping("/web/register")
public class RegisterController {
	private static final Logger logger = Logger.getLogger(RegisterController.class);
	
	@Autowired
	UserService userService;
	@Autowired
	AccountService accountService;	

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(@RequestParam(value = "locale", required = false) Locale locale, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("-----------registerIndex----------->");
		return "web/register/register-index";
	}

	@RequestMapping(value = "action", method = RequestMethod.POST)
	@ResponseBody
	public String action(@ModelAttribute("loginContext") LoginContext loginContext, BindingResult result,
			HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		//1:获取值
		String email = loginContext.getEmail();
		String password = loginContext.getPassword();
		String confirmPassword = loginContext.getConfirmPassword();
		System.out.println(email + "-------" + password);
		//2:校验注册合法性
		//XXX
		//3:注册用户
		UserBean user = new UserBean();
		user.setEmail(email);
		user.setPassword(password);
		user.setUserName(email);
		String uuid = UUIDGenerator.getUUID() ;
		userService.addUserAndAccount(user,uuid);
		//4：跳转到邮件确认
		String realPath = request.getSession().getServletContext().getRealPath(request.getRequestURI());
		System.out.println(realPath+"==============");
		String URL = "http://localhost:8080/web/register/confirm?email="+email+"&aid="+uuid;
		response.sendRedirect(URL);


		return null;
	}
	@RequestMapping(value = "confirm", method = RequestMethod.GET)
	public String confirm(@RequestParam(value = "locale", required = false) Locale locale, 
			HttpServletRequest request, 
			HttpServletResponse response,Model view) {
		//1:获取值
		String email = request.getParameter("email");
		String uuid = request.getParameter("aid");
		//2:往会话设置值
		view.addAttribute("email", email);
		view.addAttribute("uuid", uuid);
		
		System.out.println("-----------registerConfirm----------->");
		return "web/register/register-confirm";
	}

	@RequestMapping(value = "active/{uuid}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView  active(@PathVariable("uuid") String uuid, 
			HttpServletRequest request, HttpServletResponse response) {
		
		AccountBean account = accountService.findAccountByUUID(uuid);
		if(account != null){
			Integer userId = account.getUserId() ;
			Integer accountId = account.getAccountId();
			//激活状态
			userService.registerAction(userId, accountId);
			//保存会话
			UserBean user = userService.findUserById(userId);
			String userName = user.getUserName();
			LoginContext loginContext = new LoginContext(userName, user.getPassword());
			request.getSession().setAttribute(userName, loginContext);
			
		}else{
			//"用户账户不存在!"
		}
//		ModelAndView view = new ModelAndView("redirect:/home/app/user/registerIndex");
//		view.setViewName("redirect:/home/app/user/registerIndex");
		try {
			response.sendRedirect("http://localhost:8080/web/register/success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	@RequestMapping(value = "success", method = RequestMethod.GET)
	public String registerSuccess(@RequestParam(value = "locale", required = false) Locale locale, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("-----------registerConfirm----------->");
		return "web/register/register-success";
	}
	@RequestMapping(value = "/resendActive/{uuid}", method = RequestMethod.GET)
	public String resendActive(@PathVariable("uuid") String uuid,
			HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		AccountBean account = accountService.findAccountByUUID(uuid);
		String legalCode = account.getLegalCode();
		String userName = account.getUserName() ;
		userService.sendRegisterConfirmEmail(userName, legalCode, uuid);
		String URL = "http://localhost:8080/web/register/confirm?email="+legalCode+"&aid="+uuid;
		System.out.println("-----------resendActive----------->");
		response.sendRedirect(URL);
		return null;
	}
	
}
