/**   
 * @title: HomeIndexController.java 
 * @package com.xc.taosku.home 
 * @description: TODO 描述该文件作用 
 * @author chenyibin 
 * @date 2012-8-9 上午10:05:15 
 * @version V1.0   
 */
package com.xc.lovesong.web;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/** 
 * @copyright: 	www.xc.com
 * @author:		DanielChen@xc.com
 * @created:		2012-8-9 上午10:05:15
 * @vesion:		1.0
 * @updateLogs:
 * User		 	Date					Description
 * ------------------------------------------------------
 * DanielChen	2012-8-9-上午10:05:15  	添加类
 * 项目名称：		taosku
 * 说明:	 TODO 添加类描述				
 */
@Controller
@RequestMapping("/web")
public class WebIndexController {
	private static final Logger logger = Logger.getLogger(WebIndexController.class);
	
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(
            @RequestParam(value = "locale", required = false) Locale locale,
            HttpServletRequest request,
            HttpServletResponse response) {
		System.out.println("----------mailIndex------------>");
        return "web/index";
    }
	
}
