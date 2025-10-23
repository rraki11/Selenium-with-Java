package testng_43rdvideo;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class C1 {
	
	@AfterTest	//it runs after the test method
	void aftertest() {
		System.out.println("after test");
	}
	
	@Test	//this test method will run first
	void test1() {
		System.out.println("test one of class C1");
	}

}
