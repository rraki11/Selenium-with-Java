package com.rakesh.selenium.selenium_with_java;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class _32_properitesfile_usage {

	public static void main(String[] args) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fileInputStream = new FileInputStream("C:\\Users\\shubh\\Documents\\GitHub\\Selenium-with-Java\\selenium-with-java\\propertiy.properties");
		
		//loading data from the properties file
		prop.load(fileInputStream);
		
		//reading data from properties file
		String name= prop.getProperty("name");
		String email= prop.getProperty("email");
		String phone_num= prop.getProperty("ph_num");
		String branch= prop.getProperty("branch");
		
		System.out.println(name +"\n" + email + "\n" + phone_num + "\n" + branch);
		
		//reading only the keys from the properties file
		Set<String> keys = prop.stringPropertyNames();
		System.out.println(keys);
		//or
		Set<Object> key = prop.keySet();
		System.out.println(key);
		
		//reading the actual values of keys from the properites file
		Collection<Object> values = prop.values();
		System.out.println(values);
		
		fileInputStream.close();
	}

}
