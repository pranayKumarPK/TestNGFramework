package com.page.locators;

import org.openqa.selenium.By;

public interface MyLeavePageLocator {

	By PendingApproval=By.xpath("//div[@class='row col s12 m12 l3']/label");
	By All=By.xpath("//div[@class='row col s12 m12 l1']/label");
	By FromDatePicker=By.xpath("//div[@class='schema-form-section row']/sf-decorator[1]/div/span/span/i");
	By ToDatePicker=By.xpath("//div[@class='schema-form-section row']/sf-decorator[2]/div/span/span/i");
	By SearchLeaveButton=By.xpath("//form[@id='searchLeaveList']/div/div/button");
}
