package com.hxy.common.utils;
/**
 * 文件工具类
*/
public class FileUtil {

	/*
	* 方法1：给定一个文件名，返回该文件名的扩展名，例如“aaa.jpg”，返回“.jpg”(3分)
	*/
	public static String getExtendName(String fileName){
		String[] strs = fileName.split(fileName);
		String endOfName = "."+strs[strs.length-1];
		return endOfName;
	}
	/*
	* 方法2：返回操作系统临时目录(5分)
	*/
	public static String getTempDirectory(){
		return System.getProperty("java.io.tmpdir");
	}
	/*
	* 方法3：返回操作系统用户目录(5分)
	* 例如Linux系统是在/home/{用户账号名}，Windows系统是在C:\Users\{用户账号名}> 
	*/
	public static String getUserDirectory(){
		return System.getProperty("user.home");
	}
	
}
