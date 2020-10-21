package com.hrm.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

import com.hrm.base.TestBase;
import com.page.locators.HomepageLocator;
import com.page.locators.LoginPanelLocators;

import com.page.locators.MyProfilePageLocator;

public class HomePage extends TestBase implements HomepageLocator,LoginPanelLocators,MyProfilePageLocator {

	public HomePage() {
	
		PageFactory.initElements(driver, this);
		
	}
	@Step("Verify getting title of Home page step...")
	public String getHomePageTitle() {
		String PageTitle= driver.findElement(Title).getText();
		log.info("Title of HomePage is "+PageTitle);
		return PageTitle;
	}

	@Step("Verify clicking on Leave Button in HomePage step...")
	public LeavePage clickOnLeaveButton() {
		log.info("Clicking on leave button");
		driver.findElement(LeaveButton);
		log.info("Clicked on Leave Button");
		return new LeavePage();
	}

	@Step("Verify Clicing on logout button in MyProfile page step...")
	public Loginpage LogOut() {
		log.info("Clicking on MyProfile link");
		driver.findElement(MyProfile).click();
		log.info("Clicked on MyProfile link");
		log.info("Clicking on logOut link");
		driver.findElement(LogOutLink).click();
		log.info("Clicked on logOut link");
		return new Loginpage();
	}
	@Step("Verify clicking on Discipline link in HomePage step...")
	public DisciplinePage clickOnDisciplinePage() {
		log.info("Clicking on Discipline page");
		driver.findElement(Discipline).click();
		log.info("Clicked on Discipline page");
		log.info("Clicking on DisciplineCase page");
		driver.findElement(DisciplinaryCase).click();
		log.info("Clicked on DisciplinaryCase page");
		return new DisciplinePage();
	}

	@Step("Verify clicking on Recruitment page in HomePage step...")
	public RecruitmentPage clickOnRecruitmentPage() {
		log.info("Clicking on Recruitment page");
		driver.findElement(Recuirment).click();
		log.info("Clicked on Recruitment page");
		return new RecruitmentPage();
	}
}
