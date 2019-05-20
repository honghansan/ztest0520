package com.hxy.common.utils;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 流处理工具类
*/
public class StreamUtil {

	/*
	* 方法1：批量关闭流，参数能传无限个。(3分)
	* 例如传入FileInputStream对象、JDBC中Connection对象都可以关闭。
	*/
	public static void closeAll(Object stm){
		try {
			if (stm instanceof BufferedReader) {
				((BufferedReader) stm).close();
			}
			if (stm instanceof InputStream) {
				((InputStream) stm).close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	* 方法2：传入一个文本文件对象，默认为UTF-8编码，返回该文件内容(3分)，要求方法内部调用上面第1个方法关闭流(3分)
	*/
	private static String readTextFile(InputStream src){
		BufferedReader br = new BufferedReader(new InputStreamReader(src));
		String fstr = "";
		String x = null;
		try {
			while((x = br.readLine()) != null) {
				fstr += ","+x;
			}
			fstr.substring(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(br);
			closeAll(src);
		}
		return fstr;
	}
	/*
	* 方法3：传入文本文件对象，返回该文件内容(3分)，并且要求内部调用上面第2个方法(5分)。
	*/
	public static String readTextFile(File txtFile) throws FileNotFoundException{
		if(!txtFile.exists()) {
			throw new IllegalArgumentException("文件"+txtFile.getName()+"不存在");
		}
		if(!txtFile.isFile()) {
			throw new IllegalArgumentException("这个不是文件");
		}
		InputStream in = new FileInputStream(txtFile);
		return readTextFile(in);
		
	}
}
