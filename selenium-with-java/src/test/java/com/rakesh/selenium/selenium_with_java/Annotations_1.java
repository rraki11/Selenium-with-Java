package com.rakesh.selenium.selenium_with_java;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*	login 			//before method
	search 			//test
	logout 			//after method
	
	login 			//before method
	advanced search //test
	logout 			//after method
*/

public class Annotations_1 {

	@BeforeMethod	//it runs before the test method 
	void login() {
		System.out.println("logged in !");
	}
	
	@AfterMethod	//it runs after the test method
	void logout() {
		System.out.println("logged out !");
	}
	
	@Test (priority = 1)	//this test method will run first
	void search() {
		System.out.println("searched..");
	}
	
	@Test (priority = 2)
	void advanced_search() {
		System.out.println("advanced searched..");
	}
	
}
