package com.spafinder.locators;

public class CreateAccountLocators {

	public String FirstName = ".//*[@id='first-name']";
	public String LastName = ".//*[@id='last-name']";
	public String email = ".//*[@id='register-email']";
	public String password = ".//*[@id='register-password']";
	public String reTypePass = ".//*[@id='confirm-password']";

	public String acceptEmail = ".//*[@id='register-form']/ul[2]/li[4]/span";

	public String myaccountLink = ".//*[@id='account']/ul/li[2]/a";
	public String createaccountLink = ".//*[@id='content']/div[4]/a";

	public String btnSignUp = ".//*[@id='register-form']/ul[2]/li[5]/button";

	public String passValidationError = ".//*[@id='register-password-error']";

	public String emailAfterAcCreat = ".//*[@id='content']/div[4]/ul/li[1]/div/ul/li[2]";
	public String msgUserExist = ".//*[@id='statusMessage']/div";

}
