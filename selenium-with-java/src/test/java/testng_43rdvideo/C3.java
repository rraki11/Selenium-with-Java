package testng_43rdvideo;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class C3 {
	
	@BeforeSuite	//it runs before the test method 
	void beforesuite() {
		System.out.println("befor suite");
	}
	
	@Test
	void test1() {
		System.out.println("test one of class C3");
	}
	
	@AfterSuite	//it runs after the test method
	void aftersuite() {
		System.out.println("after suite");
	}
	
	@Test	//this test method will run first
	void test2() {
		System.out.println("test two of class C3");
	}

}
