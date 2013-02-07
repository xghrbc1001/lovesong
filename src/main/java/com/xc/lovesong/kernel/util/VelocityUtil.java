package com.xc.lovesong.kernel.util;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.xc.lovesong.kernel.mail.dao.MailEntity;


public class VelocityUtil {
	
	private VelocityEngine ve;
	private static final VelocityUtil vm = new VelocityUtil();

	private VelocityUtil() {
		ve = new VelocityEngine();
	}  
	public static VelocityUtil Instatnce(){
		return vm;
	}
	/**
	 * @title: getTemplateValue
	 * @category: TODO 添加方法描述 
	 * @author: chenyibin 2013-2-6
	 * @param templateName
	 * @param encoding
	 * @param params
	 * @return
	 */
	public String getTemplateValue(String templateName,String encoding,Map<String,Object> params) {
		VelocityContext context = new VelocityContext();
		Template t;
		StringWriter writer = null;
		String resule = null;
		try {
			String loaderPathKey = PropertiesUtil.get("FILE_RESOURCE_LOADER_PATH_KEY");
			String loaderPath = PropertiesUtil.get("FILE_RESOURCE_LOADER_PATH");
			//设置velocity从classpath中获取模板文件
			ve.setProperty(loaderPathKey, loaderPath);
			t = ve.getTemplate(templateName, encoding);
			if( (params != null) && (!params.isEmpty()) ){
				Iterator<Entry<String, Object>> iter = params.entrySet().iterator();  
				while(iter.hasNext()){
					Map.Entry<String,Object> entry=(Map.Entry<String,Object>)iter.next();
					context.put(entry.getKey(),entry.getValue());
				}
			}
			writer = new StringWriter();
			t.merge(context, writer);
			resule = writer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(writer!=null){try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}}
		}
		return resule;
	}
	
	public static void main(String[] args){
		VelocityUtil vutil = VelocityUtil.Instatnce();
		Map<String, Object> map = new HashMap<String, Object>();
		MailEntity entity = new MailEntity() ;
		entity.setUserName("DanielChen");
		entity.setEmail("nucchenyibin@126.com");
		entity.setActiveURL("http://localhost:8080/register/active/uu42432423432800234204");
		map.put("mailEntity", entity);
		String text = vutil.getTemplateValue("confirmMail.vm", "UTF-8",map);
		System.out.println(text);
		
	}
	
}
