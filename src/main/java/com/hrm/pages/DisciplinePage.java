package com.hrm.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.hrm.base.TestBase;
import com.hrm.utils.TestUtil;
import com.page.locators.DisciplinaryCasesPageLocator;
import com.page.locators.HomepageLocator;

public class DisciplinePage extends TestBase implements HomepageLocator, DisciplinaryCasesPageLocator {
	public DisciplinePage() {

		PageFactory.initElements(driver, this);

	}
	TestUtil tUtil;
	@Step("Verifying Discipline page title step...")
	public String verifyDisciplinePageTitle() {
		log.info("Verifying Discipline Page Title");
		tUtil=new TestUtil();
		tUtil.switchToFrame();
		String DisciplinePageTitle = driver.findElement(DisciplinaryCaseTitle).getText();
		log.info("Discipline page title is" + DisciplinePageTitle);
		return DisciplinePageTitle;

	}
    @Step("Verify clicking on Add Disciplinary Case Button step...")
	public void ClickOnaddDisciplinaryCaseButton() {
		log.info("Clicking on Disciplinary Case Button");
		tUtil=new TestUtil();
		tUtil.switchToFrame();
		driver.findElement(AddDisciplinaryCaseButton).click();
		log.info("Clicked on Disciplinary Case Button");
	}
	@Step("Verify adding DisciplineCase step...")
	public void addDisciplineCase(String EmpName, String caseName, String Desc) {
		tUtil=new TestUtil();
		//tUtil.switchToFrame();
		WebElement Select = driver.findElement(EmployeeName);
		log.info("Clicking in Employee name field");
		Select.click();
		log.info("Clicked on Employee name field");
		try {
		Select.sendKeys(EmpName);
		log.info(EmpName+ " name is entered in employee name field");
		Select.sendKeys(Keys.ARROW_DOWN);
		log.info("Clicked arrow down key");
		Select.sendKeys(Keys.ENTER);
		log.info("Enter key after selecting element");
		}
		catch (Exception e) {
			log.error(EmpName+" name is not present");
		}
		driver.findElement(CaseName).sendKeys(caseName);
		log.info("Entered Case name");
		driver.findElement(Description).click();
		driver.findElement(Description).sendKeys(Desc);
		log.info("Entered Description");
		driver.findElement(Save).click();
		log.info("Clicked on saved button ");
	}
    @Step("Verify closing Disciplinary Case button step...")
	public void CloseDisciplinaryCase() {
		log.info("Closing Discipline case window");
		driver.findElement(CloseDisciplinaryCases).click();
		log.info("Discipline case window closed");
	}
    @Step("Verify getting first element from the list step...")
	public String getFirstElementFromTheList() {
		log.info("Getting first element from the Discipline Case Table");
		String FirstElement=driver.findElement(FirstTabluarElement).getText();
		log.info("First element from the table is "+FirstElement);
		return FirstElement;
	}
}
