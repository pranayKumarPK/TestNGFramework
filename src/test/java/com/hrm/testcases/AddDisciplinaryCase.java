package com.hrm.testcases;

import com.hrm.Listeners.TestListeners;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.*;

import com.hrm.base.TestBase;
import com.hrm.pages.DisciplinePage;
import com.hrm.pages.HomePage;
import com.hrm.pages.Loginpage;
import com.hrm.utils.TestUtil;

import java.net.MalformedURLException;

@Listeners({TestListeners.class})
public class AddDisciplinaryCase extends TestBase {

	Loginpage loginpage;
	HomePage homepage;
	DisciplinePage disciplinepage;
	String sheetName="DisciplineCase";
	public AddDisciplinaryCase() {
		super();
	}

	@Parameters({"myBrowser"})
	@BeforeMethod
	public void setUp(String myBrowser) {
		try {
			initialize(myBrowser);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		loginpage=new Loginpage();
		 homepage=new HomePage();
		 
		 homepage=loginpage.login(pro.getProperty("username"), pro.getProperty("password"));
		 disciplinepage= homepage.clickOnDisciplinePage();
		 
		
	}
	@Test(priority=1, description = "Verifying DisciplineCase Title")
	@Severity(SeverityLevel.MINOR)
	@Description("Test Case Description: Verify Discipline Case Title in Create Discipline page")
	@Story("Story Name: To check Discipline title")
	public void validateDisciplineCaseTitle() {
		Assert.assertEquals(disciplinepage.verifyDisciplinePageTitle(),"Disciplinary Cases");
		
	}
	@Test(priority=2, dataProvider="getHRMTestData", description = "Add Discipline case")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: Add Discipline Case")
	@Story("Story Name: Add Discipline case")
	public void addDisciplineCase(String EmpName, String caseName,String Desc) {
		disciplinepage.ClickOnaddDisciplinaryCaseButton();
		disciplinepage.addDisciplineCase(EmpName, caseName, Desc);
		disciplinepage.CloseDisciplinaryCase();
		Assert.assertEquals(disciplinepage.getFirstElementFromTheList(), EmpName);
	}
	@DataProvider
	public Object[][] getHRMTestData() {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
				}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
