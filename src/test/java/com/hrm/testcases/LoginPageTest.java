package com.hrm.testcases;

import java.net.MalformedURLException;

import com.hrm.Listeners.TestListeners;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.*;

import com.hrm.base.TestBase;
import com.hrm.pages.HomePage;
import com.hrm.pages.Loginpage;

@Listeners({TestListeners.class})
public class LoginPageTest extends TestBase {
	Loginpage loginpage;
	HomePage homepage;
	 
	public LoginPageTest() {
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
		
	}
	@Test(priority=1, description = "Validating Hrm logo")
	@Severity(SeverityLevel.MINOR)
	@Description("Test Case Description: Verify Hrm logo in login page")
	@Story("Story Name: Verify Hrm logo")
	public void validateHrmLogo() {
		Assert.assertTrue(loginpage.ValidateHrmLogo());
		
	}
	@Test(priority=2, description = "Login into the Hrm")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description: Login into the Hrm application")
	@Story("Story Name: Login into the Hrm application")
	public void login() {
		loginpage.login(pro.getProperty("username"), pro.getProperty("password"));
		Assert.assertEquals(homepage.getHomePageTitle(), "Dashboard");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
