package com.hrm.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

//import com.hrm.testcases.LoginPageTest;
import com.hrm.utils.TestUtil;
import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestBase {
	
 public static WebDriver driver;
 public static Properties pro	;
 public static Logger log;
 public static String browser;
 public static DesiredCapabilities desired;
 public static DesiredCapabilities desired1;
 public static URL url;
 public static URL url1;
 public static String SystemName=System.getProperty("user.name");
	public TestBase() {

		DOMConfigurator.configure(System.getProperty("user.dir")+"\\src\\main\\java\\com\\hrm\\config\\log4j.xml");
		 log=Logger.getLogger(TestBase.class);
		 pro=new Properties();
		FileInputStream fi;
		try {
			fi = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\hrm\\config\\data.properties");
			pro.load(fi);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialize(String browser) throws MalformedURLException {
		//String browserName=pro.getProperty("browser");

		String browserName=browser;
		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Resources\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();

// 			 desired=DesiredCapabilities.chrome();

// 			desired.setPlatform(Platform.WINDOWS);
// 			System.out.println("H");
// 			try {
// 				 url = new URL("http://192.168.225.231:4444/wd/hub");
// 			}
// 			catch (Exception e){
// 				e.printStackTrace();
// 			}
// 			driver= new RemoteWebDriver(url,desired);
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{

			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Resources\\Drivers\\geckodriver.exe");
			desired1=DesiredCapabilities.firefox();
			File pathBinary=new File("C:\\Users\\"+SystemName+"\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
			FirefoxBinary firefoxBinary=new FirefoxBinary(pathBinary);
			FirefoxOptions options=new FirefoxOptions();
			options.setBinary(firefoxBinary);
  				//tSystem.out.println(options.setBinary(firefoxBinary));
			desired1.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
			desired1.setPlatform(Platform.WINDOWS);
			System.out.println("1"+desired1);
			System.out.println("0"+desired);
			try {
				url1 = new URL("http://192.168.225.231:4444/wd/hub");
			}
			catch (Exception e){
				e.printStackTrace();
			}
			driver= new RemoteWebDriver(url1,desired1);

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);	
		
		driver.get(pro.getProperty("url"));
	}
//	@Parameters("myBrowser")
//	@BeforeSuite
	public String getBrowser(String myBrowser){
	browser=myBrowser;
	return browser;
	}
	public WebDriver getDriver(){
		return driver;
	}
}
