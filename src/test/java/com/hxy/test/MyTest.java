package com.hxy.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Date;

import org.junit.Test;

import com.hxy.common.utils.DateUtil;
import com.hxy.common.utils.FileUtil;
import com.hxy.common.utils.StreamUtil;

public class MyTest {

	@Test
	public void test1() throws ParseException {
		String sql = "select * from t_order where create_time>='{1}' and create_time<='{2}' ";
		sql = sql.replace("{1}", DateUtil.getDateByInitMonth(new Date("2019/5/20")));
		sql = sql.replace("{2}", DateUtil.getDateByFullMonth(new Date("2019/5/20")));
		System.out.println(sql);
	}
	
	@Test
	public void test2(){
		System.out.println(FileUtil.getTempDirectory());
		System.out.println(FileUtil.getUserDirectory());
	}
	
	@Test
	public void test3() throws FileNotFoundException{
		System.out.println(StreamUtil.readTextFile(new File("C:\\aaa\\a.txt")));
	}

}
