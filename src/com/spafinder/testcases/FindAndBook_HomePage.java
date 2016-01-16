package com.spafinder.testcases;

import java.awt.Color;

import org.testng.annotations.Test;

import com.spafinder.base.BaseClass;
import com.spafinder.locators.HomePageLocators;
import com.spafinder.utilities.Xls_Reader;
import com.spafinder.values.HomePageValues;

public class FindAndBook_HomePage extends BaseClass {

	HomePageLocators hpl = new HomePageLocators();
	HomePageValues hpv = new HomePageValues();
	Xls_Reader xlFile = new Xls_Reader(System.getProperty("user.dir") + "\\SpaFinder.xlsx");

	@Test
	public void findAndBookOnSF() throws Exception {

		typeByXpath(hpl.iwantTxtBox, hpv.iWant);
		typeByXpath(hpl.nearTxtBox, hpv.nearZip);
		clickByXpath(hpl.findBtn);

		int elementExist = findElementByid(hpl.searchResultid);

		if (elementExist > 0) { // Element exist
			getTextById(hpl.searchResultid);
			xlFile.setCellDataPassColor("HomePage", "PassFail", 4, "PASS", Color.GREEN);
			xlFile.setCellData("HomePage", "Verification", 4, "Search Result Verified");
		}

		else {

			xlFile.setCellDataFailColor("HomePage", "PassFail", 4, "Fail", Color.RED);
			xlFile.setCellData("HomePage", "Verification", 4, "Search Result Not Verified");
		}
	}

}
