package com.rakesh.selenium.selenium_with_java;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Hard_Assertion_4 {
	
	@Test
	void hard_assertion() {
		
		System.out.println("testing..");
		System.out.println("testing..");
		
		Assert.assertEquals(1,11); //hard assertion
		//the test fails here and restricts the reamining code to run
		
		System.out.println("testing..");
		System.out.println("testing..");
		
	}

}
