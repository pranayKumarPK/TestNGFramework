package com.page.locators;

import org.openqa.selenium.By;

public interface LeavePageLocator {

	By ApplyButton=By.xpath("//a[@id='menu_leave_applyLeave']/span[2]");
	By LeaveType= By.xpath("//input[@class='select-dropdown']");
	By FromDate= By.xpath("//input[@id='from']");
	By ToDate= By.xpath("//input[@id='to']");
	By Comment=By.xpath("//textarea[@id='comment']");
	By ApplyLeaveButton=By.xpath("//button[@class='btn waves-effect waves-green']");
	By overlappingLeave=By.xpath("//div[@class='modal-heading']/h4");
	By OverlappingCloseButton= By.xpath("//div[@class='row']/a");
	
}
