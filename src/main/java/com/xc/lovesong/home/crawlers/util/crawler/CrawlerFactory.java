///**   
// * @title: CrawlerFactory.java 
// * @package com.xc.taosku.kernel.util.crawlers 
// * @description: TODO 描述该文件作用 
// * @author chenyibin 
// * @date 2012-10-5 上午10:28:42 
// * @version V1.0   
// */
//package com.xc.taosku.home.crawlers.util.crawler;
//
//import com.xc.taosku.home.crawlers.util.crawler.impl.SohuWomenTryCrawler;
//
///** 
// * @copyright: 	www.xc.com
// * @author:		DanielChen@xc.com
// * @created:		2012-10-5 上午10:28:42
// * @vesion:		1.0
// * @updateLogs:
// * User		 	Date					Description
// * ------------------------------------------------------
// * DanielChen	2012-10-5-上午10:28:42  	添加类
// * 项目名称：		taosku
// * 说明:	 TODO 添加类描述				
// */
//public class CrawlerFactory {
//	private ICrawler iCrawler ;
//	
//	public CrawlerFactory(){}
//	public CrawlerFactory(ICrawler iCrawler){
//		this.iCrawler = iCrawler ;
//	}
//	
//	public void execute(String webURL){
//		this.iCrawler.executeCrawler(webURL);
//		this.iCrawler.convertData();
//	}
//	
//	public static void main(String[] args) {
//		CrawlerFactory factory = new CrawlerFactory(new SohuWomenTryCrawler());
//		factory.execute("webURL");
////		scripts();
//	}
//}
