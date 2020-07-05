package com.crm.qa.analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	
	int count = 0;
	int no_of_try = 3;
	
	public boolean retry(ITestResult result) {
		
		if(count < no_of_try){
			count++;
			return true;
		}
		return false;
	}
	
	


}
