/**   
 * @title: ImportExcelUtil.java 
 * @package com.xc.taosku.kernel.util.excel.imports 
 * @description: TODO 描述该文件作用 
 * @author chenyibin 
 * @date 2012-10-3 上午09:33:41 
 * @version V1.0   
 */
package com.xc.lovesong.kernel.util.excel.imports;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/** 
 * @copyright: 	www.xc.com
 * @author:		DanielChen@xc.com
 * @created:		2012-10-3 上午09:33:41
 * @vesion:		1.0
 * @updateLogs:
 * User		 	Date					Description
 * ------------------------------------------------------
 * DanielChen	2012-10-3-上午09:33:41  	添加类
 * 项目名称：		taosku
 * 说明:	 TODO 添加类描述				
 */
public class ImportExcelUtil {

	public static void mian(String[] args){
		String fileURL = "d:/优质导购.xls";
		List<Map<String,String>>  result = excelReader(fileURL);
		for(int i =0 ; i< result.size(); i++){
			System.out.println("--------");
		}
		
		
	}

	public static List<Map<String,String>>  excelReader(String fileURL){
		FileInputStream input = null;
		List<Map<String,String>> result = null;
		try{
			input = new FileInputStream(new File(fileURL));  
			HSSFWorkbook wb=new HSSFWorkbook(input);  
			HSSFSheet sheet = wb.getSheetAt(0); 
			//获取标题
			String[] excelTitle = readExcelTitle(sheet);
			//获取内容 结构入List<Map<标题,内容>> 
			result = readExcelContent(sheet,excelTitle);
			
			
		}catch (Exception e) {  
			e.printStackTrace();  
		}finally{
			try {  
                if (input != null) {  
                    input.close();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
		}
        return result ;
	}
	
    public static String[] readExcelTitle(HSSFSheet sheet) {// 读取Excel表格表头的内容      	           
		HSSFRow titleRow = sheet.getRow(0);// 得到标题的内容对象。  
	    int colNum = titleRow.getPhysicalNumberOfCells(); // 得到标题总列数  
	    String[] excleTitle = new String[colNum];  
	    for (int i = 0; i < colNum; i++) {  
	        excleTitle[i] = getStringCellValue(titleRow.getCell((short) i)).trim();  
	    }  
        return excleTitle;  
    }  
	
    public static List<Map<String,String>> readExcelContent(HSSFSheet sheet,String[] excleTitle) {// 读取Excel数据内容  

        List<Map<String,String>> result = new ArrayList<Map<String,String>>();
        Map<String,String> contents = new HashMap<String,String>();
        try {   
            int rowNum = sheet.getLastRowNum(); 	// 得到总行数    
            HSSFRow titleRow = sheet.getRow(0);		// 得到标题的内容对象
            int colNum = titleRow.getPhysicalNumberOfCells();// 得到每行的列数
            
            HSSFRow row = null;
            for (int i = 1; i < rowNum; i++) { // 正文内容应该从第二行开始,第一行为表头的标题  
                row = sheet.getRow(i);  
                int j = 0;  
                while (j < colNum) {  
                	String cellTitle = excleTitle[j]; //标题
                	String cellValue = getStringCellValue(row.getCell((short) j)).trim();	//CELL内容
                	contents.put(cellTitle, cellValue);
                    j++;  
                }  
                result.add(contents);
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        return result;  
    }  
	
	
	
	/**
	 * 
	 * @title: getStringCellValue
	 * @category: 获取单元格数据内容为字符串类型的数据
	 * @author: chenyibin 2012-10-3
	 * @param cell
	 * @return
	 */
    private static String getStringCellValue(HSSFCell cell) {  
        String strCell = "";  
        switch (cell.getCellType()) {  
        case HSSFCell.CELL_TYPE_STRING:  
            strCell = cell.getStringCellValue();  
            break;  
        case HSSFCell.CELL_TYPE_NUMERIC:  
            strCell = String.valueOf(cell.getNumericCellValue());  
            break;  
        case HSSFCell.CELL_TYPE_BOOLEAN:  
            strCell = String.valueOf(cell.getBooleanCellValue());  
            break;  
        case HSSFCell.CELL_TYPE_BLANK:  
            strCell = "";  
            break;  
        default:  
            strCell = "";  
            break;  
        }  
        if (strCell.equals("") || strCell == null) {  
            return "";  
        }  
        if (cell == null) {  
            return "";  
        }  
        return strCell;  
    }  
	

}
