package com.rakesh.selenium.selenium_with_java;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TypesOf_Assertions_3 {
	
	@Test
	void types_of_assertions() {
		
//		String one = "hi";
//		String two = "hlo";
		
//		Assert.assertEquals(one,two);		//failed
//		Assert.assertEquals("hi", "hi"); 	//passed
//		Assert.assertEquals("hlo", 19);		//failed
//		Assert.assertEquals("123", "123");	//passed
//		Assert.assertEquals("123", 123); 	//failed
		
//		Assert.assertNotEquals("hi", "hi"); //failed
//		Assert.assertNotEquals("hi", "ho"); //passed
		
//		Assert.assertTrue(true); 			//passed
//		Assert.assertTrue(false); 			//failed
//		Assert.assertTrue(1==2); 			//failed
		Assert.assertTrue(1==1); 			//passed
		
	}

}
