/**   
 * @title: BaseXMLBean.java 
 * @package com.xc.taosku.kernel.util.converts 
 * @description: TODO 描述该文件作用 
 * @author chenyibin 
 * @date 2012-10-4 下午10:38:58 
 * @version V1.0   
 */
package com.xc.lovesong.home.crawlers.util.convert;

import java.io.Serializable;

import com.xc.lovesong.home.crawlers.util.convert.impl.XMLITransform;

/** 
 * @copyright: 	www.xc.com
 * @author:		DanielChen@xc.com
 * @created:		2012-10-4 下午10:38:58
 * @vesion:		1.0
 * @updateLogs:
 * User		 	Date					Description
 * ------------------------------------------------------
 * DanielChen	2012-10-4-下午10:38:58  	添加类
 * 项目名称：		taosku
 * 说明:	 TODO 添加类描述				
 */
public abstract class BaseXMLBean  implements Serializable {

	private static final long serialVersionUID = 5195492506915947322L;

	private ITransform iTransform;
	public BaseXMLBean(){
		//以后通过Spring注入
		iTransform = new XMLITransform();
		
	}
	
	public void toFile(String filePath, String encoding) {
		iTransform.toFile(filePath, encoding,this.getClass(),this);
	}

	public Object loadFile(String filePath) {
		return iTransform.loadFile(filePath,this.getClass());
	}
	
}