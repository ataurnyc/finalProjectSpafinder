package com.spafinder.base;

import java.io.IOException;
import java.lang.reflect.Method;
//import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.spafinder.utilities.WebDriverAPI;

public class BaseClass extends WebDriverAPI {
	protected static String baseURL;
	protected static String mailBaseURL;
	public static String Browser;

	public static Logger APPLICATION_LOG = Logger.getLogger("rootLogger");
	// @BeforeClass
	// public static void initiAlize () throws FailingHttpStatusCodeException,
	// IOException {
	//
	// Browser = "FF";
	//
	// if (Browser.equalsIgnoreCase("ff")) {
	// ProfilesIni FP = new ProfilesIni();
	// FirefoxProfile myprofile = FP.getProfile("Automation");
	// driver = new FirefoxDriver(myprofile);
	// driver = new FirefoxDriver();
	//
	// } else if (Browser.equalsIgnoreCase("IE")) {
	// System.setProperty("webdriver.ie.driver",(System.getProperty("user.dir")+"\\CrossBrowserDriver\\IEDriverServer.exe"));
	// DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
	// dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
	// true);
	// driver = new InternetExplorerDriver(dc);
	// driver.manage().deleteAllCookies();
	//
	// } else if (Browser.equalsIgnoreCase("ch")){
	// System.setProperty("webdriver.chrome.driver",
	// (System.getProperty("user.dir")+"\\CrossBrowserDriver\\chromedriver.exe"));
	// driver = new ChromeDriver();
	// System.err.println("Google Chrome is selected");
	// } else if (Browser.equalsIgnoreCase("Safari")){
	// driver = new SafariDriver();
	// System.err.println("Safari has been selected");
	// } else if (Browser.equalsIgnoreCase("iOS")){
	// new RemoteWebDriver(new URL("http://localhost:3001/driver/hub"),
	// DesiredCapabilities.ipad());
	// System.err.println("iOS is selected To do the Cross Browser Test");
	// } else {
	// throw new IllegalArgumentException("The Browser Type is Undefined");
	// }
	//
	//
	// baseURL = "http://qa.corporaterewards.us";
	// URL url = new URL( baseURL );
	// HttpURLConnection httpConn = (HttpURLConnection)url.openConnection();
	// httpConn.setInstanceFollowRedirects( false );
	// httpConn.setRequestMethod( "HEAD" );
	// httpConn.connect();
	// System.err.println( baseURL + " Response Code is: " +
	// httpConn.getResponseCode());
	// System.out.println ("");
	//
	// iWait (10);
	// maxPage();
	// }

	@BeforeMethod
	public void browserOpen(Method method) throws IOException {
		Browser = "FF";
		if (Browser.equalsIgnoreCase("ff")) {
			driver = new FirefoxDriver();
		} else if (Browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",
					(System.getProperty("user.dir") + "\\CrossBrowserDriver\\IEDriverServer.exe"));
			DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
			dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			driver = new InternetExplorerDriver(dc);
			driver.manage().deleteAllCookies();
		} else if (Browser.equalsIgnoreCase("ch")) {
			System.setProperty("webdriver.chrome.driver",
					(System.getProperty("user.dir") + "\\CrossBrowserDriver\\chromedriver.exe"));
			driver = new ChromeDriver();
			System.err.println("Google Chrome is selected");
		} else if (Browser.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
			System.err.println("Safari has been selected");
		} else if (Browser.equalsIgnoreCase("iOS")) {
			new RemoteWebDriver(new URL("http://localhost:3001/driver/hub"), DesiredCapabilities.ipad());
			System.err.println("iOS is selected To do the Cross Browser Test");
		} else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}

		// mailBaseURL = "https://debugmail.io";
		// baseURL = "http://qa.corporaterewards.us";
		// baseURL = "http://devakrongeneralcelebrations.workstride.com";
		// //AKRON
		baseURL = "http://www.spafinder.com"; // SpaFinder
		driver.get(baseURL);

		iWait(10);
		maxPage();
		String testName = method.getName();
		String pageTitle = driver.getTitle();
		APPLICATION_LOG.debug(
				"==========================================================================================================");
		APPLICATION_LOG.debug("Test Page is: ==> " + pageTitle + " Just S-T-A-R-T-E-D");
		APPLICATION_LOG.debug("Test Method is: ==> " + testName + " Just S-T-A-R-T-E-D");
		APPLICATION_LOG.debug(
				"==========================================================================================================");
	}

	@AfterMethod(enabled = true)
	public void browserClose(Method method) {
		try {
			String testName = method.getName();
			APPLICATION_LOG.debug(
					"==========================================================================================================");
			APPLICATION_LOG.debug("Test Method is: ==> " + testName + " Just E-N-D-E-D");
			APPLICATION_LOG.debug(
					"==========================================================================================================");
			Thread.sleep(2000);
			driver.close();
		} catch (InterruptedException e) {
			APPLICATION_LOG.debug(e);
		}
	}

	@AfterSuite(enabled = false)
	public static void tearDown() {
		try {
			Thread.sleep(200);
			driver.quit();
		} catch (InterruptedException e) {
			APPLICATION_LOG.debug(e);
		}
	}

}