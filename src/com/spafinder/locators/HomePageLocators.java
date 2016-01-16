package com.spafinder.locators;

public class HomePageLocators {

	// Top Navigation Bar
	public String aboutmeTopNavLink = ".//*[@id='account']/ul/li[1]/a";
	public String myaccTopNavLink = ".//*[@id='account']/ul/li[2]/a";
	public String busspartTopNavLink = ".//*[@id='account']/ul/li[3]/a";

	public String aboutusText = ".//*[@id='spafinder']/body/div[1]/section/div/h1";

	public String iwantTxtBox = ".//*[@id='content-top']/div[2]/div/form/ul/li[1]/input";
	public String nearTxtBox = ".//*[@id='content-top']/div[2]/div/form/ul/li[2]/input";
	public String findBtn = ".//*[@id='content-top']/div[2]/div/form/ul/li[4]/button";

	public String searchResult = ".//*[@id='querytotalhitscount']";
	public String searchResultid = "querytotalhitscount";
	public String newLetterEmail = ".//*[@id='newsletter-email']";
	public String newsSignUpBtn = ".//*[@id='newsletter-submit']";

	public String newsSignupConfirmation = ".//*[@id='content']/section[2]/div[2]/div[1]/div/h3";

	public String selectedCountry = ".//*[@id='account']/ul/li[5]/a";
	public String selectUK = ".//*[@id='account']/ul/li[5]/ul/li[1]/a";
	public String clkCloseBtn = ".//*[@id='WindowCloseBtn']";
}
