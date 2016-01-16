package com.spafinder.testcases;

import java.awt.Color;

import org.testng.annotations.Test;

import com.spafinder.base.BaseClass;
import com.spafinder.locators.CreateAccountLocators;
import com.spafinder.utilities.Xls_Reader;
import com.spafinder.values.CreateAccountValues;

public class CreateAccount extends BaseClass {

	CreateAccountLocators cal = new CreateAccountLocators();
	CreateAccountValues cav = new CreateAccountValues();

	Xls_Reader xlFile = new Xls_Reader(System.getProperty("user.dir") + "\\SpaFinder.xlsx");

	@Test
	public void createaccount() throws Exception {
		clickByXpath(cal.myaccountLink);

		// Assertion page verification
		APPLICATION_LOG.debug("We are in the page: " + driver.getTitle());

		clickByXpath(cal.createaccountLink);
		// Assertion page verification

		typeByXpath(cal.FirstName, cav.FirstNameValue);
		typeByXpath(cal.LastName, cav.LastNameValue);
		typeByXpath(cal.email, cav.emailValue);
		typeByXpath(cal.password, cav.passwordValue);
		typeByXpath(cal.reTypePass, cav.reTypePassValue);

		clickByXpath(cal.btnSignUp);

		// Assertion if the user account info shows correctly
		boolean tf = false;

		if (findElementByXpath(cal.msgUserExist) == 0) { // not exist

			tf = assertTrueByXpath(cal.emailAfterAcCreat, cav.emailValue);
		} else {
			APPLICATION_LOG.error("User exist or check password requirements !!!"); // validation??verification
		}

		if (tf) {
			APPLICATION_LOG.debug("User created successfully.");
			xlFile.setCellDataPassColor("HomePage", "PassFail", 3, "PASS", Color.GREEN);
			xlFile.setCellData("HomePage", "Verification", 3, "Account Craeted for email: " + cav.emailValue);

		} else if (!tf) {
			APPLICATION_LOG.error("User create un-successfully !!!");
			xlFile.setCellDataFailColor("HomePage", "PassFail", 3, "FAIL", Color.RED);
			xlFile.setCellData("HomePage", "Verification", 3, "Tried to Create Account for email: " + cav.emailValue);

		}
	}

}
