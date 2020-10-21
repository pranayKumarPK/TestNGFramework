package com.page.locators;

import org.openqa.selenium.By;

public interface HomepageLocator {

	By Title=By.xpath("//li[@class='page-title']");
	By LeaveButton=By.xpath("//li[@id='menu_leave_viewLeaveModule']/a/span[2]");
	By Recuirment =By.xpath("//li[@id='menu_recruitment_viewRecruitmentModule']/a/span[2]");
	By Discipline =By.xpath("//li[@id='menu_discipline_defaultDisciplinaryView']/a/span[2]");
	By MyProfile= By.xpath("//a[@id='user-dropdown']");
	By DisciplinaryCase=By.xpath("//a[@id='menu_discipline_viewDisciplinaryCases']/span[2]");
}
