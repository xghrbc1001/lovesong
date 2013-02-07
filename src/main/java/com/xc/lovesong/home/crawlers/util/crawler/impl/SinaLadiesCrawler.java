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
//import java.util.List;
//
//import org.apache.log4j.Logger;
//import org.webharvest.definition.ScraperConfiguration;
//import org.webharvest.runtime.Scraper;
//
//import com.xc.taosku.home.crawlers.util.convert.CrawlerDetail;
//import com.xc.taosku.home.crawlers.util.convert.impl.CrawlerXMLBean;
//import com.xc.taosku.home.crawlers.util.crawler.ICrawler;
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
//public class SinaLadiesCrawler implements ICrawler {
//	private Logger log = Logger.getLogger(this.getClass().getName());
//	
//	public void executeCrawler(String webURL) {
//        ScraperConfiguration config;  
//        long startTime = 0L;  
//        try {  
//        	startTime = System.currentTimeMillis();    
//            config = new ScraperConfiguration("E:/eladies.sina.com.xml");//xml目录  
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
//		crawlerXMLBean = (CrawlerXMLBean) crawlerXMLBean.loadFile("D:/eladies.xml");
//		List<CrawlerDetail> crawlerDetail= crawlerXMLBean.getCrawlerDetail();
//		//转化逻		
//		//for(CrawlerDetail crawler : crawlerDetail){
//		CrawlerDetail crawler = crawlerDetail.get(1);
//			String remark = crawler.getRemark();
//			String[] nodes = remark.split("<br />");
//			String[] vals = remark.split("　");
//			System.out.println(nodes.length+" = "+vals.length);
//			System.out.println(crawler.getRemark());
//			for(int i =0;i<vals.length;i++){
//				System.out.println("--->"+vals[i]);
//			}
//		//}
//		
//		
//		
//	}
//
//}
