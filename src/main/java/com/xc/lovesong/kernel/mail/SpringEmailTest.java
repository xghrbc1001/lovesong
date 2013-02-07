/**   
 * @title: SpringEmailTest.java 
 * @package com.xc.lovesong.kernel.mail 
 * @description: TODO 描述该文件作用 
 * @author chenyibin 
 * @date 2013-2-3 下午12:42:06 
 * @version V1.0   
 */
package com.xc.lovesong.kernel.mail;

import java.util.HashMap;
import java.util.Map;

import com.xc.lovesong.kernel.mail.dao.MailEntity;
import com.xc.lovesong.kernel.mail.domain.SendMailType;
import com.xc.lovesong.kernel.mail.service.MailMessageFactory;
import com.xc.lovesong.kernel.util.VelocityUtil;

/** 
 * @copyright: 	www.xc.com
 * @author:		DanielChen@xc.com
 * @created:		2013-2-3 下午12:42:06
 * @vesion:		1.0
 * @updateLogs:
 * User		 	Date					Description
 * ------------------------------------------------------
 * DanielChen	2013-2-3-下午12:42:06  	添加类
 * 项目名称：		lovesong
 * 说明:	 TODO 添加类描述				
 */
public class SpringEmailTest {

	/**
	 * @title: main
	 * @category: TODO 添加方法描述 
	 * @author: chenyibin 2013-2-3
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sendConfirm();
//		SimpleMailSender smsend = new SimpleMailSender();
//		MailSenderInfo info = new MailSenderInfo();
//		info.setFromAddress("nucchenyibin@gmail.com");
//		info.setToAddress("nucchenyibin@126.com");
//		info.setSubject("test");
//		info.setContent("textContent");
//		smsend.sendTextMail(info);

	}
	public static void sendText(){
		//默认空构造为发送文本类型  
		    MailMessageFactory mms = new MailMessageFactory(SendMailType.TEXT);  
		    mms.setSubject("使用spring email 测试发送文本消息")  
		    .setText("正文消息了。。。。")  
		    .send();  
	}
	
	public static void sendHtml(){
		MailMessageFactory mms = new MailMessageFactory(SendMailType.HTML);  
        mms.setSubject("使用spring email 测试发送Html中文邮件")  
        .setText("<html>" +
        		"<head><meta http-equiv='content-type' content='text/html; charset=GBK'></head>" +
        		"<body>" +
        		"<h1>这里是情歌网发送的邮件</h1>" +
        		"</body></html>").send();
	}
	public static void sendConfirm(){
		String activeURL = "http://localhost:8080/web/register/action/"+"uuid";
		VelocityUtil vutil = VelocityUtil.Instatnce();
		Map<String, Object> map = new HashMap<String, Object>();
		MailEntity entity = new MailEntity() ;
		entity.setUserName("userName");
		entity.setEmail("nucchenyibin@126.com");
		entity.setActiveURL(activeURL);
		map.put("mailEntity", entity);
		String text = vutil.getTemplateValue("confirmMail.vm", "UTF-8",map);
		
		
		MailMessageFactory mms = new MailMessageFactory(SendMailType.HTML);  
        mms.setSubject("情歌-注册确认邮件").setTo("nucchenyibin@126.com")  
        .setText("<html>" +
        		"<head><meta http-equiv='content-type' content='text/html; charset=GBK'></head>" +
        		"<body>" +
        		"<h1>这里是情歌网发送的邮件</h1>" +
        		"<p>"+text+"</p>" +
        		"</body></html>").send();
	}
	
}
