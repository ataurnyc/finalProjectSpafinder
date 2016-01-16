package com.spafinder.testcases;

import java.awt.Color;

import org.testng.annotations.Test;

import com.spafinder.base.BaseClass;
import com.spafinder.locators.HomePageLocators;
import com.spafinder.utilities.Xls_Reader;

public class SelectCountry extends BaseClass {

	Xls_Reader xlFile = new Xls_Reader(System.getProperty("user.dir") + "\\SpaFinder.xlsx");
	HomePageLocators hpl = new HomePageLocators();

	@Test
	public void selectCountry() throws Exception {
		APPLICATION_LOG.debug("Before Click, URL is: " + driver.getCurrentUrl());
		hoverOverByXpath(hpl.selectedCountry);
		clickByXpath(hpl.selectUK);
		APPLICATION_LOG.debug("After click, Current URL is: " + driver.getCurrentUrl());

		int res = findElementByXpath(hpl.selectUK);
		if (res > 0) {
			xlFile.setCellDataPassColor("HomePage", "PassFail", 6, "PASS", Color.GREEN);
			String country = driver.getCurrentUrl();
			xlFile.setCellData("HomePage", "Verification", 6, "Region Successfully Changed to :" + country);
		} else {
			xlFile.setCellDataFailColor("HomePage", "PassFail", 6, "Fail", Color.RED);
			xlFile.setCellData("HomePage", "Verification", 6, "Region Change Un-successfull.");
		}
	}

}
