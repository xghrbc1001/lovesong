/**   
 * @title: ITransform.java 
 * @package com.xc.taosku.kernel.util.converts 
 * @description: TODO 描述该文件作用 
 * @author chenyibin 
 * @date 2012-10-4 下午10:26:13 
 * @version V1.0   
 */
package com.xc.lovesong.home.crawlers.util.convert;

/** 
 * @copyright: 	www.xc.com
 * @author:		DanielChen@xc.com
 * @created:		2012-10-4 下午10:26:13
 * @vesion:		1.0
 * @updateLogs:
 * User		 	Date					Description
 * ------------------------------------------------------
 * DanielChen	2012-10-4-下午10:26:13  	添加类
 * 项目名称：		taosku
 * 说明:	 从java对象转为文件，或从文件转为java对象			
 */
public interface ITransform {
	/**
	 * 对象 --> 文件
	 * @param filePath 文件路径
	 * @param encoding 文件编码
	 * @param clazz 对象的类类
	 * @param obj
	 *            对象
	 */
	public void toFile(String filePath, String encoding, Class clazz, Object obj);

	/**
	 * 文件 --> 对象
	 * @param filePath 文件路径
	 * @param clazz 类类
	 * @return 生成的对象
	 */
	public Object loadFile(String filePath, Class clazz);
}
