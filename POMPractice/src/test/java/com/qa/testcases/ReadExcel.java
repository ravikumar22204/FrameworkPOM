package com.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.testdata.TestDatafromExcel;

public class ReadExcel {

	static Logger log=Logger.getLogger(ReadExcel.class);
	
	
	@Test
	public static void add(){
		log.info("launch method");
		int a=10, b=20;
		log.info("input passed");
		int c=a+b;
		log.info("sum of 2");
		Assert.assertEquals(30,c);
		log.warn("assertion is enabled");
		
	}
	
	@Test
	public static void sub(){
		int a=10, b=20;
		int c=b-a;
		Assert.assertEquals(10,c);
		
	}
	
	@Test
	public void readExcel(){
		TestDatafromExcel testdata= new TestDatafromExcel();
		System.out.println(testdata.getData(5, 4, 0));
	}
}