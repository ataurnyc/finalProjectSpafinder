package com.spafinder.testcases;

import java.awt.Color;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.spafinder.base.BaseClass;
import com.spafinder.locators.HomePageLocators;
import com.spafinder.utilities.Xls_Reader;
import com.spafinder.values.HomePageValues;

public class AboutMe extends BaseClass {

	HomePageLocators hpl = new HomePageLocators();
	HomePageValues hpv = new HomePageValues();

	Xls_Reader xl = new Xls_Reader(System.getProperty("user.dir") + "\\SpaFinder.xlsx");

	@Test(enabled = true)
	public void aboutMe() throws Exception {

		// Click on About Me link
		clickByXpath(hpl.aboutmeTopNavLink);

		// Verify if About Us text is present on the page
		String actText = driver.findElement(By.xpath(hpl.aboutusText)).getText();
		String expText = hpv.abtusHeader;

		boolean exist = (expText.equals(actText));
		if (!exist) {
			APPLICATION_LOG.debug("Exp Header is: " + expText + " Act Header is: " + actText);
			xl.setCellDataFailColor("Homepage", "passFail", 13, "FAIL", Color.RED);
			xl.setCellData("Homepage", "Verification", 13,
					"Exp Message is: " + expText + " | " + " Act Message: " + actText);
			screenShot("aboutMe_FAIL");
			Assert.assertTrue(exist);
		} else {
			APPLICATION_LOG.debug("Exp Header is: " + expText + " Act Header is: " + actText);
			xl.setCellDataPassColor("Homepage", "passFail", 13, "PASS", Color.GREEN);
			xl.setCellData("Homepage", "Verification", 13,
					"Exp Header is: " + expText + " | " + " Act Header: " + actText);
			screenShot("aboutMe");
			Assert.assertTrue(exist);
		}
	}

}
