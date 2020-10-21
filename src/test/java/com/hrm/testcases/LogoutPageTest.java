package com.hrm.testcases;

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

import java.net.MalformedURLException;

@Listeners({TestListeners.class})
public class LogoutPageTest extends TestBase {

	HomePage homepage;
	Loginpage loginpage;
	public LogoutPageTest() {
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
		//homepage=new HomePage();
		loginpage=new Loginpage();
		homepage=loginpage.login(pro.getProperty("username"), pro.getProperty("password"));

	}
	@Test(priority=1,description = "Log out from Hrm application")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: Logout from the Hrm applicatiom")
	@Story("Story Name: Logout from Hrm Application")
	public void LogOut() {
		homepage.LogOut();
		Assert.assertEquals(loginpage.getLoginPanelTitle(), "LOGIN Panel");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
