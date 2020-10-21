package com.page.locators;

import org.openqa.selenium.By;

public interface DisciplinaryCasesPageLocator {

	By DisciplinaryCaseTitle=By.xpath("//div[@class='nav-wrapper customized-orange']/ul[1]/li[2]/span[1]");
	By AddDisciplinaryCaseButton=By.xpath("//a[@id='addItemBtn']/i");
	By EmployeeName=By.id("addCase_employeeName_empName");
	By CaseName=By.id("addCase_caseName");
	By Description=By.xpath("//div[@class='input-field col s12']/textarea");
	By Save = By.id("btnSave");
	By CloseDisciplinaryCases=By.id("btnAction_closeDisciplinaryCase");
	By FirstTabluarElement =By.xpath("//tr[@class='dataRaw'][1]/td[2]");
	
}
