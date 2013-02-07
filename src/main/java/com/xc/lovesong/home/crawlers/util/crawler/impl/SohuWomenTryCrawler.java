///**   
// * @title: SinaLadiesCrawler.java 
// * @package com.xc.taosku.kernel.util.crawlers.impl 
// * @description: TODO 描述该文件作用 
// * @author chenyibin 
// * @date 2012-10-5 上午10:19:14 
// * @version V1.0   
// */
//package com.xc.taosku.home.crawlers.util.crawler.impl;
//
//import java.io.FileNotFoundException;
//import java.lang.reflect.InvocationTargetException;
//import java.util.List;
//
//import org.apache.commons.beanutils.BeanUtils;
//import org.apache.log4j.Logger;
//
//import org.webharvest.definition.ScraperConfiguration;
//import org.webharvest.runtime.Scraper;
//
//import com.xc.taosku.home.crawlers.domain.CrawlerMessage;
//import com.xc.taosku.home.crawlers.util.CrawlerUtil;
//import com.xc.taosku.home.crawlers.util.convert.CrawlerDetail;
//import com.xc.taosku.home.crawlers.util.convert.impl.CrawlerXMLBean;
//import com.xc.taosku.home.crawlers.util.crawler.ICrawler;
//import com.xc.taosku.kernel.util.StringPool;
//
///** 
// * @copyright: 	www.xc.com
// * @author:		DanielChen@xc.com
// * @created:		2012-10-5 上午10:19:14
// * @vesion:		1.0
// * @updateLogs:
// * User		 	Date					Description
// * ------------------------------------------------------
// * DanielChen	2012-10-5-上午10:19:14  	添加类
// * 项目名称：		taosku
// * 说明:	 TODO 添加类描述				
// */
//public class SohuWomenTryCrawler implements ICrawler {
//	private Logger log = Logger.getLogger(this.getClass().getName());
//	
//	public void executeCrawler(String webURL) {
//        ScraperConfiguration config;  
//        long startTime = 0L;  
//        try {  
//        	startTime = System.currentTimeMillis();    
//            config = new ScraperConfiguration("E:/try.woment.sohu.com.xml");//xml目录  
//            Scraper scraper = new Scraper(config, "d:/tmp/");//指定工作目录，爬去后的xml会保存到这里  
//            scraper.setDebug(true);  
//            scraper.execute();  
//        } catch (FileNotFoundException e) {  
//           log.error("webURL["+webURL+"] executeCrawler error ："+e);   
//        }  
//        System.out.println("time elapsed: "   + (System.currentTimeMillis() - startTime));  
//		
//	}
//
//	public void convertData() {
//		CrawlerXMLBean crawlerXMLBean = new CrawlerXMLBean();
//		crawlerXMLBean = (CrawlerXMLBean) crawlerXMLBean.loadFile("D:/tmp/sohu/women/try/try.wement.sohu.xml");
//		List<CrawlerDetail> crawlerDetail= crawlerXMLBean.getCrawlerDetail();
//		//转化逻辑
//		for(CrawlerDetail crawler : crawlerDetail){
//			crawler.setQuantity(CrawlerUtil.extractNumFromStr(getUsefulValue(crawler.getQuantity()), 0));
//			crawler.setPrice(CrawlerUtil.extractNumFromStr(getUsefulValue(crawler.getPrice()),0));
//			crawler.setStandard(getUsefulValue(crawler.getStandard()));
//			crawler.setEfficacy(getUsefulValue(crawler.getEfficacy()));
//			crawler.setSuitable(getUsefulValue(crawler.getSuitable()));
//			crawler.setTryNum(CrawlerUtil.extractNumFromStr(getUsefulValue(crawler.getTryNum()),0));
//			crawler.setStartTime("2012-12-09");
//			crawler.setEndTime("2012-12-09");
//			CrawlerMessage message = new CrawlerMessage();
//			try {
//				BeanUtils.copyProperties(message, crawler);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			System.out.println("---------------");
//		}
//		crawlerXMLBean.toFile("D:/tmp/test.xml", "UTF-8");
//		System.out.println("------------ convert end --->");
//		
//		
//	}
//	//提取有用的信息
//	public static String getUsefulValue(String val){
//		String value = "";
//		if( (val==null) || ("".equals(val)) || ("null".equals(val)) ){
//			return value;
//		}else{
//			String args[] = val.split(StringPool.COLON_SBC);
//			if(args!=null && args.length >1){
//				value = args[1].trim();
//			
//			}
//			return value;
//		}
//	}
//}
