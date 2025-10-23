package com.rakesh.selenium.selenium_with_java;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Soft_Assertion_5 {
	
	@Test
	void soft_assertion() {
		
		System.out.println("testing..");
		System.out.println("testing..");
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(1,11); //soft assertion
		//the test fails here but still runs the reamining code
		
		System.out.println("testing..");
		System.out.println("testing..");
		
//		sa.assertAll(); //mandatory	//using this will again work correctly like hard assertion
	}
}
