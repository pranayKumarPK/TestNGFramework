package com.hrm.Listeners;


import com.hrm.base.TestBase;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

public class TestListeners extends TestBase implements ITestListener {

    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {

    }

    public void onTestFailure(ITestResult result) {
        System.out.println("***** Error "+result.getName()+" test has failed *****");
        String methodName=result.getMethod().getConstructorOrMethod().getName();
        System.out.println("Screenshot captured for "+ methodName);
        takeScreenShot(driver);
        saveTextLog(methodName+ " failed and screenshot has taken");

        takeScreenShot(driver);
    }
    //Text Attachment for allure
    @Attachment(value="Page Screenshot", type="image/png")
    public byte[] takeScreenShot(WebDriver driver)
    {
    return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    //Text Attachment for allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message){
        return message;
    }

    //Html Attachment for allure
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html){
        return html;
    }

//    private void takeScreenShot(String methodName, WebDriver driver) {
//         File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//         try {
//             FileUtils.copyFile(scrFile, new File(".//test-output//Automation Reports//"+methodName+".png"));
//         }
//         catch (IOException e){
//             e.printStackTrace();
//         }
//    }

    public void onTestSkipped(ITestResult result) {
     driver.quit();
     String returnValue=result.getMethod().getConstructorOrMethod().getName()+" Test case is skipped";
     System.out.println(returnValue);
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }
}
