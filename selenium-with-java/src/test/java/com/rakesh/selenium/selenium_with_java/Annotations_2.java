package com.rakesh.selenium.selenium_with_java;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*	login			//before running the class/running all test cases
	search			//test
	advanced search	//test
	logout			//after running the class/running all test cases
*/

public class Annotations_2 {
	
	@BeforeClass	//it runs before, once the class stated run
	void login() {
		System.out.println("logged in !");
	}
	
	@AfterClass	//it runs after, once the class stated run
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
