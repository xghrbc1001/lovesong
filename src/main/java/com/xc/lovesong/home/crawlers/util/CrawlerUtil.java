/**   
 * @title: CrawlerUtil.java 
 * @package com.xc.taosku.kernel.util.crawlers 
 * @description: TODO 描述该文件作用 
 * @author chenyibin 
 * @date 2012-10-6 下午03:24:13 
 * @version V1.0   
 */
package com.xc.lovesong.home.crawlers.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.xc.lovesong.kernel.util.StringPool;

/** 
 * @copyright: 	www.xc.com
 * @author:		DanielChen@xc.com
 * @created:		2012-10-6 下午03:24:13
 * @vesion:		1.0
 * @updateLogs:
 * User		 	Date					Description
 * ------------------------------------------------------
 * DanielChen	2012-10-6-下午03:24:13  	添加类
 * 项目名称：		taosku
 * 说明:	 TODO 添加类描述				
 */
public class CrawlerUtil {
	
	public static void main(String[] args){
//		CrawlerXMLBean crawlerXMLBean = new CrawlerXMLBean();
//		crawlerXMLBean = (CrawlerXMLBean) crawlerXMLBean.loadFile("D:/tmp/sohu/women/try/try.wement.sohu.xml");
//		List<CrawlerDetail> crawlerDetail= crawlerXMLBean.getCrawlerDetail();
		//转化逻辑
//		for(CrawlerDetail crawler : crawlerDetail){
//			System.out.println(crawler.getQuantity());
//			CrawlerMessage message = new CrawlerMessage();
//			BeanUtils.copyProperties(crawler, message);
//			
//			
//		}
//		String   s= "今天是11月5日 "; 
//		String[]   arr=s.split( "\\D+ "); 
//		for(int i=0;i<arr.length;i++){
//			System.out.println(arr[i]);
//		}
//		int   month=Integer.parseInt(arr[1]); 
//		int   day=Integer.parseInt(arr[2]); 
		
	       String  str="20 份";  
	       String nums = extractNumFromStr(str,0);
//	       for(String strval : nums ){
	    	   System.out.println(nums);
//	       }
//        String  str="10 份";  
//        String s = "\\d+.\\d+|\\d+";
//        Pattern  pattern=Pattern.compile(s);  
//        Matcher  ma=pattern.matcher(str);  
//   
//        while(ma.find()){  
//            System.out.println(ma.group());  
//        }  
		
	}
	
	/**
	 * @title: extractNumFromStr
	 * @category: 抽取字符串中的数字
	 * @author: chenyibin 2012-10-6
	 * @param str 字符串
	 * @return 包含数字的数组
	 */
	public static String[]  extractNumFromStr(String str){
		String[] nums = null;
		if(str==null || StringPool.BLANK.equals(str)){
			return nums;
		}else{
			//数字或是小数 的正则表达式
			String regexp = "\\d+.\\d+|\\d+"; 
	        Pattern  pattern=Pattern.compile(regexp);  
	        Matcher  ma=pattern.matcher(str);  

	        StringBuffer sb = new StringBuffer("");
	        while(ma.find()){  
	        	String strval = ma.group();
	        	sb.append(strval+"&");
	        } 
	        String strbuff = sb.toString();
	        if(!StringPool.BLANK.equals(strbuff)){
	        	nums = strbuff.split("&");
	        }
	        return nums;
		}
	}
	/**
	 * @title: extractNumFromStr
	 * @category: 获取指定字符串中位置的数字(以0为起始位置)
	 * @author: chenyibin 2012-10-6
	 * @param str 字符串
	 * @param index 指定位置
	 * @return 指定位置的数字(没有默认为0)
	 */
	public static String  extractNumFromStr(String str,int index){
		String[] nums = extractNumFromStr(str);
		String num = "0";
//		System.out.println(nums.length+"extractNumFromStr"+index);
		if(null!=nums){
			if(index < nums.length){
				num = nums[index];
			}else{
				num = nums[nums.length-1];
			}
		}
		return num;
	}
	
}
