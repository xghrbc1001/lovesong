package com.xc.lovesong.kernel.util;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;


/**
 * 
 * Author:	  daniel
 * Created:	  Jul 25, 2010 12:19:00 AM
 * Vesion:	  1.0
 * Last EditTime: Jul 25, 2010 12:19:00 AM
 * Update Logs:
 *				daniel@Jul 25, 2010 12:19:00 AM 添加
 * 项目名称：		shoppingCart
 * 说明: properties的工具类
 */

public class PropertiesUtil {
	private static final  Properties prop = new Properties();
	
	 static { 
        InputStream in = PropertiesUtil.class.getResourceAsStream("/conf/params.properties"); 
        try {
            prop.load(in);  
        } catch (IOException e) { 
            e.printStackTrace(); 
        } 
	 } 
	 
	 public static void main(String[] args){
//		 String param = get("edi.purview.flag");
//		 System.out.println("----->"+param+"===="+(param==null));
//		 Timestamp time = new Timestamp(new Date().getTime());
//		 String str = DateFormatUtils.format(time, "yyyy-MM-dd");
//		 System.out.println(str);
//		 Long size = new Long(17452);
//		 
//		 System.out.println(size/1024.00);
		 System.out.println(prop.containsKey("sina.ladies.webURL"));
	 }
	 public static String get(String key){
		Object returnObj = prop.getProperty(key);

		if (returnObj != null) {
			return (String)returnObj;
		}
		else { 
			return null;
		}
	 }
	 /**
	  * 方法说明: (key=value)根据指定值value获取properties 文件中的 key集合
	  * @param context 指定值(value)
	  * @return 返回Map<context,key集合>
	  */
	 public static Map getKeysByContext(String context){
		 Map result = new HashMap();
		 if(!prop.isEmpty()){
			 if(prop.containsValue(context)){
				 List list = new ArrayList();
				 Enumeration enums = prop.keys();
				 while (enums.hasMoreElements()) {
					 Object key = enums.nextElement();
					 String value = (String) prop.get(key);
					 if(value!=null && context.equals(value)){
						 list.add(key);
					 }
				 }
				 result.put(context, list);
			 }
		 }
		 return result;
	 }
	 
		/**
		 * 方法说明: 将一个properties中的内容拷贝到另一个properties中
		 * @param from 源文件
		 * @param to 目标文件
		 */
		public static void copyProperties(Properties from, Properties to) {
			Iterator itr = from.entrySet().iterator();

			while (itr.hasNext()) {
				Map.Entry entry = (Map.Entry)itr.next();
				to.setProperty((String)entry.getKey(), (String)entry.getValue());
			}
		}
		/**
		 * 方法说明: 将Map 中的内容存入properties中
		 * @param map 
		 * @return
		 */
		public static Properties fromMap(Map map) {
			if (map instanceof Properties) {
				return (Properties)map;
			}
			Properties p = new Properties();
			Iterator itr = map.entrySet().iterator();

			while (itr.hasNext()) {
				Map.Entry entry = (Map.Entry)itr.next();

				String key = (String)entry.getKey();
				String value = (String)entry.getValue();

				if (value != null) {
					p.setProperty(key, value);
				}
			}

			return p;
		}
		/**
		 * 方法说明: 将propertis中的内容存入Map中
		 * @param p 源文件
		 * @param map 目标
		 */
		public static void fromProperties(Properties p, Map map) {
			map.clear();
			Iterator itr = p.entrySet().iterator();

			while (itr.hasNext()) {
				Map.Entry entry = (Map.Entry)itr.next();

				map.put(entry.getKey(), entry.getValue());
			}
		}
		/**
		 * 方法说明: 将指定路径的properties文件中的内容加载
		 * @param s 要加载的properties路径
		 * @return  加载内容后的properties
		 * @throws IOException
		 */
		public static Properties load(String s) throws IOException {
			Properties p = new Properties();
			load(p, s);

			return p;
		}
		/**
		 * 方法说明: 将字符串存入properties中
		 * @param p 目标properties
		 * @param s 要存入的字符串
		 * @throws IOException
		 */
		public static void load(Properties p, String s) throws IOException {
			if (Validator.isNotNull(s)) {
				s = UnicodeFormatter.toString(s);

				s = StringUtil.replace(s, "\\u003d", "=");
				s = StringUtil.replace(s, "\\u000a", "\n");
				s = StringUtil.replace(s, "\\u0021", "!");
				s = StringUtil.replace(s, "\\u0023", "#");
				s = StringUtil.replace(s, "\\u0020", " ");
				s = StringUtil.replace(s, "\\u005c", "\\");

				p.load(new ByteArrayInputStream(s.getBytes()));

				List propertyNames = Collections.list(p.propertyNames());
				//因为存入时候会覆盖,所以先存入字符串,再把原先的存入
				for (int i = 0; i < propertyNames.size(); i++) {
					String key = (String)propertyNames.get(i);

					String value = p.getProperty(key);

					if (value != null) {
						value = value.trim();

						p.setProperty(key, value);
					}
				}
			}
		}

		public static void merge(Properties p1, Properties p2) {
			Enumeration enu = p2.propertyNames();

			while (enu.hasMoreElements()) {
				String key = (String)enu.nextElement();
				String value = p2.getProperty(key);

				p1.setProperty(key, value);
			}
		}

		public static String list(Map map) {
			Properties props = fromMap(map);

			ByteArrayOutputStream bam = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(bam);

			props.list(ps);

			return bam.toString();
		}

		public static void list(Map map, PrintStream out) {
			Properties props = fromMap(map);

			props.list(out);
		}

		public static void list(Map map, PrintWriter out) {
			Properties props = fromMap(map);

			props.list(out);
		}
		/**
		 * 方法说明: 将properties文件中的内容序列化到字符串中
		 * @param p
		 * @return
		 */
		public static String toString(Properties p) {
			StringBuffer sm = new StringBuffer();
			Enumeration enu = p.propertyNames();

			while (enu.hasMoreElements()) {
				String key = (String)enu.nextElement();

				sm.append(key);
				sm.append(StringPool.EQUAL);
				sm.append(p.getProperty(key));
				sm.append("\n");
			}

			return sm.toString();
		}
		/**
		 * 方法说明: 将properties中的key包含的空格去掉（如果有则去掉,重新存入去空格后的key=value）
		 * @param p
		 */
		public static void trimKeys(Properties p) {
			Enumeration enu = p.propertyNames();

			while (enu.hasMoreElements()) {
				String key = (String)enu.nextElement();
				String value = p.getProperty(key);

				String trimmedKey = key.trim();

				if (!key.equals(trimmedKey)) {
					p.remove(key);
					p.setProperty(trimmedKey, value);
				}
			}
		}
}
