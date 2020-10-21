package com.hrm.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Resources\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://pranay9123-trials65141.orangehrmlive.com/client/#/noncore/discipline/viewDisciplinaryCases");
		//driver.findElement(by)
	}
}
