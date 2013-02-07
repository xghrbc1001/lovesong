package com.xc.lovesong.home.app.resource.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

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

import com.xc.lovesong.home.app.resource.domain.ResourceBean;
import com.xc.lovesong.home.app.resource.service.ResourceService;
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
@RequestMapping("/home/app/resources")
public class ResourceController {
	private static final Logger logger = Logger.getLogger(ResourceController.class);
	
	@Autowired
	ResourceService resourceService ;
	
	@RequestMapping(value = "resourceIndex", method = RequestMethod.GET)
    public String index(
            @RequestParam(value = "locale", required = false) Locale locale,
            HttpServletRequest request,
            HttpServletResponse response) {
		System.out.println("---------------------->");
        return "home/app/resource-index";
    }
	@RequestMapping(value = "resourceTree", method = RequestMethod.POST)
    public void resourceTree (
            @RequestParam(value = "locale", required = false) Locale locale,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
		
	       List<String> resourceTree = new ArrayList<String>();
	       List<ResourceBean> beanList = resourceService.findResourceList();
	       if( (beanList != null) && (beanList.size() > 0) ){
	    	   for(ResourceBean bean : beanList){
	    		   String node = "{id:"+bean.getResourceId()+", pId:"+bean.getParentResId()+", name:\""+bean.getResourceName()+"\",open:true}";
	    		   resourceTree.add(node);
	    	   }
	       };
	       
	       
	       //ResourceDtoPage resourceDtoPage  = RESTFulClient.get("resourceRest/findAllResource", ResourceDtoPage.class) ;
	       //List<ResourceDto> resourceDtoList = resourceDtoPage.getResourceDtoList();
//	       List<Resource>  resourceList = new ArrayList<Resource>();
//	       if(resourceDtoList!=null && resourceDtoList.size()>0){
//	           for(ResourceDto resourceDto : resourceDtoList){
//	             Resource resource  = new Resource();
//	             if(resourceDto!=null){
//	                BeanUtils.copyProperties(resourceDto, resource);
//	             }
//	              resourceList.add(resource) ;
//	           }
//	       }
	      // for(Resource resource :resourceList){
//	       for(int i = 0;i<10;i++){
//
//	           //String temp =  "{id:"+resource.getResId()+", pId:"+resource.getParentResId()+", name:\""+resource.getResName()+"\",open:true}";
//	    	   String temp =  "{id:"+i+", pId:"+i+10+", name:\""+"Name"+i+"\",open:true}";
//	    	   System.out.println("--------: "+temp);
//	    	   resourceTreeInfo.add(temp);
//	       }
//	       String t1 = "{id:1, pId:0, name:\""+"父节点1"+"\",open:true}";
//	      System.out.println(t1); 
//	      resourceTree.add(t1);
//	       String t2 = "{id:11, pId:1, name:\""+"子节点1"+"\",open:true}";
//	       System.out.println(t2); 
//	       resourceTreeInfo.add(t2);
//	       String t3 = "{id:12, pId:1, name:\""+"子节点2"+"\",open:true}";
//	       resourceTreeInfo.add(t3);
//	       System.out.println(t3); 
	        response.setContentType("text/html;charset=UTF-8");
	        response.getWriter().print(JSONArray.fromObject(resourceTree).toString());
		System.out.println("----------resourceTree------------>");
		
    }
	@RequestMapping(value = "/toAddResourceTree/{resId}", method = RequestMethod.GET)
	 public String toAddResourceTree(@PathVariable("resId") Integer resourceId, Model view){
		System.out.println("--------->"+resourceId);
		
//	       String resId = resource.getResId();
//	       ResourceDto resourceDto = RESTFulClient.get("resourceRest/findResourceByResId/"+resId, ResourceDto.class) ;
//	       if(resourceDto!=null){
//	            BeanUtils.copyProperties(resourceDto, resource);
//	       }
//	       resource.setLevel(String.valueOf(Integer.parseInt(resourceDto.getLevel()) + 1));
//	       resource.setUuid(UUID.randomUUID().toString());
//	       Result result  = new  Result();
//	       result.addDefaultModel("resource",resource);
//	       toVm(result);
//	       return "addResourceTree";
		ResourceBean bean = resourceService.findResourceById(resourceId);
		ResourceBean resource = new ResourceBean();
		resource.setParentResId(bean.getResourceId());
		resource.setParentResName(bean.getResourceName());
		resource.setLevelNum(2);
		view.addAttribute("resource", resource);
		
		return "home/app/resource-add";
	}
	   @RequestMapping(value = "addResourceTree", method = RequestMethod.POST)
	   @ResponseBody 
	   public ResultBean addResourceTree(@ModelAttribute("resource")
			   ResourceBean resource, BindingResult result){
		   
		   
	       Integer resId = resource.getResourceId();
	       String resCode = resource.getResourceCode();
	       System.out.println("-------resCode------"+resCode);
	       
	       resourceService.addResource(resource);
	       
//	       ResourceDto resourceDto = RESTFulClient.get("resourceRest/findResourceByResId/"+resId, ResourceDto.class) ;
//	       if(resourceDto!=null){
//	            BeanUtils.copyProperties(resourceDto, resource);
//	       }
//	       resource.setLevel(String.valueOf(Integer.parseInt(resourceDto.getLevel()) + 1));
//	       resource.setUuid(UUID.randomUUID().toString());
//	       Result result  = new  Result();
//	       result.addDefaultModel("resource",resource);
//	       toVm(result);
	       ResultBean bean = new ResultBean();
	       
	       bean.setSuccess(true);
	       
	       return bean;
	   }
	
}
