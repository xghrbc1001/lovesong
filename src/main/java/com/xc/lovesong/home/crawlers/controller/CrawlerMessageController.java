/**   
 * @title: CrawlerMessageController.java 
 * @package com.xc.taosku.home.crawlers.controller 
 * @description: TODO 描述该文件作用 
 * @author chenyibin 
 * @date 2012-10-6 下午08:07:27 
 * @version V1.0   
 */
package com.xc.lovesong.home.crawlers.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xc.lovesong.home.crawlers.domain.CrawlerMessage;
import com.xc.lovesong.home.crawlers.service.CrawlerMessageService;
import com.xc.lovesong.kernel.bean.ResultBean;

/** 
 * @copyright: 	www.xc.com
 * @author:		DanielChen@xc.com
 * @created:		2012-10-6 下午08:07:27
 * @vesion:		1.0
 * @updateLogs:
 * User		 	Date					Description
 * ------------------------------------------------------
 * DanielChen	2012-10-6-下午08:07:27  	添加类
 * 项目名称：		taosku
 * 说明:	 TODO 添加类描述				
 */
@Controller
@RequestMapping("/home/crawler")
public class CrawlerMessageController {
	private static final Logger logger = Logger.getLogger(CrawlerMessageController.class);
	@Autowired
	CrawlerMessageService crawlerMessageService ;
	
	   @RequestMapping(value = "executeCrawler", method = RequestMethod.GET)
	   @ResponseBody 
	   public ResultBean executeCrawler(@ModelAttribute("message")
			   CrawlerMessage message, BindingResult result){
		   
		   
	       crawlerMessageService.addCrawlerMessage(message);
	       ResultBean bean = new ResultBean();
	       bean.setSuccess(true);
	       return bean;
	   }
}
