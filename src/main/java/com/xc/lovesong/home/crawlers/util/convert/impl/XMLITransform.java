/**   
 * @title: XMLITransform.java 
 * @package com.xc.taosku.kernel.util.converts.impl 
 * @description: TODO 描述该文件作用 
 * @author chenyibin 
 * @date 2012-10-4 下午10:29:03 
 * @version V1.0   
 */
package com.xc.lovesong.home.crawlers.util.convert.impl;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

import com.xc.lovesong.home.crawlers.util.convert.ITransform;
import com.xc.lovesong.kernel.util.Constant;

/** 
 * @copyright: 	www.xc.com
 * @author:		DanielChen@xc.com
 * @created:		2012-10-4 下午10:29:03
 * @vesion:		1.0
 * @updateLogs:
 * User		 	Date					Description
 * ------------------------------------------------------
 * DanielChen	2012-10-4-下午10:29:03  	添加类
 * 项目名称：		taosku
 * 说明:	 TODO 添加类描述				
 */
public class XMLITransform implements ITransform {

	private Logger logger = Logger.getLogger(this.getClass().getName());

	/**
	 * 将bean生成对应的xml文件
	 * 
	 * @param filePath
	 * @param encoding
	 */
	public void toFile(String filePath, String encoding, Class clazz, Object obj) {
		OutputStream outputStream = null;
		try {

			File file = new File(filePath);
			if (!file.exists()) {

				if (!file.getParentFile().exists()) {
					file.getParentFile().mkdirs();
				}
				file.createNewFile();
			}

			outputStream = new FileOutputStream(filePath);
			JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);

			marshaller.marshal(obj, outputStream);
		} catch (FileNotFoundException e) {
			logger.error("this file not exist:" + filePath);
		} catch (IOException e) {
			logger.error("this file not exist:" + filePath);
		} catch (JAXBException e) {
			e.printStackTrace();
			logger.error("fail to transform bean to xml:" + filePath);
		} finally {
			try {
				if (outputStream != null) {
					outputStream.close();
				}
			} catch (IOException e) {
				logger.error("fail to close outputStream");
			}
		}
	}

	/**
	 * @title: loadFile
	 * @description: 将xml文件生成bean对象 
	 * @author: chenyibin 2012-10-5
	 * @param filePath 文件路径
	 * @param clazz 对象
	 * @return
	 */
	public Object loadFile(String filePath, Class clazz) {
		return loadFile(filePath,Constant.XML_DEFAUL_ENCODING,clazz);
	}
	/**
	 * @title: loadFile
	 * @category: 将xml文件生成bean对象
	 * @author: chenyibin 2012-10-5
	 * @param filePath 文件路径
	 * @param encode 编码
	 * @param clazz 对象
	 * @return
	 */
	public Object loadFile(String filePath, String encode, Class clazz) {
		InputStream inputStream = null;
		try {
			// 是否是压缩过的文件
			if (filePath.endsWith(".zip") || filePath.endsWith(".ZIP")) {
				ZipFile zipFile = new ZipFile(filePath);
				Enumeration<ZipEntry> entries = zipFile.getEntries();
				while (entries.hasMoreElements()) {
					ZipEntry zipEntry = entries.nextElement();
					if (!zipEntry.isDirectory()) {
						inputStream = zipFile.getInputStream(zipEntry);
					}
				}
			} else {
				inputStream = new FileInputStream(filePath);
			}

			JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			
			//在此用GBK编码，以解决“珺”等乱码问题
			InputStreamReader reader=new InputStreamReader(inputStream,encode);
			return unmarshaller.unmarshal(reader);
		} catch (FileNotFoundException e) {
			logger.error("this file not exist:" + filePath);
		} catch (JAXBException e) {
			logger.error("fail to transform xml to bean:" + filePath);
		} catch (IOException e) {
			logger.error("解压zip包的xml文件失败:" + filePath);
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				logger.error("fail to close inputStream");
			}
		}

		return null;
	}
}