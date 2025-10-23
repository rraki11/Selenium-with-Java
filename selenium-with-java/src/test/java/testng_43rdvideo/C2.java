package testng_43rdvideo;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C2 {
	
	@BeforeTest	//it runs before the test method 
	void beforetest() {
		System.out.println("befor test");
	}
	
	@Test
	void test1() {
		System.out.println("test one of class C2");
	}

}
