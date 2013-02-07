///**   
// * @title: XQueryFetchStrategyTest.java 
// * @package com.xc.taosku.harvest 
// * @description: TODO 描述该文件作用 
// * @author chenyibin 
// * @date 2012-10-4 下午03:28:15 
// * @version V1.0   
// */
//package com.xc.taosku.harvest;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import org.junit.Ignore;
//import org.junit.Test;
//import org.webharvest.definition.ScraperConfiguration;
//import org.webharvest.runtime.Scraper;
//
///** 
// * @copyright: 	www.xc.com
// * @author:		DanielChen@xc.com
// * @created:		2012-10-4 下午03:28:15
// * @vesion:		1.0
// * @updateLogs:
// * User		 	Date					Description
// * ------------------------------------------------------
// * DanielChen	2012-10-4-下午03:28:15  	添加类
// * 项目名称：		taosku
// * 说明:	 TODO 添加类描述				
// */
//public class XQueryFetchStrategyTest {
//
////	private XQueryFetchStrategy xQueryFetchStrategy = new XQueryFetchStrategy();
//
//	
//	
//	public void write(){
//		//E:/user/baidu/
//	      String filename = "E:/user/baidu/aaa.txt";  
//	        File file = new File(filename);  
//	  
//	        try {  
//	  
//	            FileWriter fw = new FileWriter(file);  
//	  
//	            BufferedWriter bw=new BufferedWriter(fw);  
//	            PrintWriter out = new PrintWriter(fw);  
//	              
//	            out.append("ssss");  
//	            out.append("/r/n");  
//	            out.append("ddddd");  
////	          out.flush();   
//	  
//	            out.close();  
//	            fw.close();  
//	  
//	        } catch (IOException e) {  
//	            System.out.println("Uh oh, got an IOException error!");  
//	            e.printStackTrace();  
//	        }  
//	}
//	
//	@Test
//	/**
//	 * 百度空间内容
//	 */
//	public void testShareBaidu() throws FileNotFoundException {
//
////		String s"tr = "D:\\yuanWorkspace\\yuan\\yuan-web\\src\\main\\resources\\xquery\\apps.hi.baidu.com.xml";
//		String str = "E:\\dev\\googleTrunk\\trunk\\yuan\\yuan-web\\src\\main\\resources\\xquery\\apps.hi.baidu.com.xml";
////		FileOutputStream f = new FileOutputStream(new File(str));
//		ScraperConfiguration config = new ScraperConfiguration(str);
//		Scraper scraper = new Scraper(config, "E:/user/");
//		scraper.addVariableToContext("baiduURL","http://apps.hi.baidu.com/share/detail/61652094");
//		
////		scraper.setDebug(true);
//		scraper.execute();
//
//		// xQueryFetchStrategy.run("apps.hi.baidu.com");
//	}
//
//	
//	/**
//	 * F团
//	 */
////	@Ignore
////	public void testFtuan() {
////		xQueryFetchStrategy.run("ftuan.com");
////	}
////
////	/**
////	 * QQ团
////	 */
////	@Ignore
////	public void testQQtuan() {
////		xQueryFetchStrategy.run("tuan.qq.com");
////	}
////
////	/**
////	 * 滴答团
////	 */
////	@Ignore
////	public void testDiDatuan() {
////		xQueryFetchStrategy.run("didatuan.com");
////	}
////
////	@Ignore
////	/**
////	 * 糯米
////	 */
////	public void testnuomi() {
////		xQueryFetchStrategy.run("nuomi.com");
////	}
////
////	@Ignore
////	/**
////	 * 拉手
////	 */
////	public void testlashou() {
////		xQueryFetchStrategy.run("lashou.com");
////	}
////
////	@Ignore
////	/**
////	 * 大众点评
////	 */
////	public void testDianPing() {
////		xQueryFetchStrategy.run("dianping.com");
////	}
////
////	@Ignore
////	/**
////	 * 京东
////	 */
////	public void test360buy() {
////		xQueryFetchStrategy.run("tuan.360buy.com");
////	}
////
////	@Ignore
////	/**
////	 * 美团
////	 */
////	public void testMeituan() {
////		xQueryFetchStrategy.run("meituan.com");
////	}
////
////	@Ignore
////	/**
////	 * 凡客
////	 */
////	public void testVancl() {
////		xQueryFetchStrategy.run("tuan.vancl.com");
////	}
//}
