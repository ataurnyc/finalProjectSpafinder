package com.spafinder.testcases;

import java.awt.Color;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.spafinder.base.BaseClass;
import com.spafinder.locators.HomePageLocators;
import com.spafinder.utilities.Xls_Reader;
import com.spafinder.values.HomePageValues;

public class SignUpForNewsletter extends BaseClass {
	HomePageLocators hpl = new HomePageLocators();
	HomePageValues hpv = new HomePageValues();

	Xls_Reader xlFile = new Xls_Reader(System.getProperty("user.dir") + "\\SpaFinder.xlsx");

	@Test
	public void newsLetterSignup() throws Exception {

		typeByXpath(hpl.newLetterEmail, hpv.newsletterEmail);
		clickByXpath(hpl.newsSignUpBtn);

		if (hpv.expectedSignupMsg.equals(driver.findElement(By.xpath(hpl.newsSignupConfirmation)).getText())) {
			xlFile.setCellDataPassColor("HomePage", "PassFail", 5, "PASS", Color.GREEN);
			xlFile.setCellData("HomePage", "Verification", 5, "Sign up for Newsletters Verified");
		} else {
			xlFile.setCellDataFailColor("HomePage", "PassFail", 5, "FAIL", Color.RED);
			xlFile.setCellData("HomePage", "Verification", 5, "Sign up for Newsletters Couldn't Verified");
		}

	}

}
