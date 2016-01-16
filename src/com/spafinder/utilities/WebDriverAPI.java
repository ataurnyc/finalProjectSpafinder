package com.spafinder.utilities;

//All actions are defined in the class
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WebDriverAPI {

	protected static WebDriver driver;
	public static Logger APPLICATION_LOG = Logger.getLogger("rootLogger");

	// .............................................Page Title
	// Check...........................................
	public void getTitle() {
		System.out.println("The Page Title is: " + driver.getTitle());
	}

	public void assertTitle(String value) {
		String act = driver.getTitle();
		String exp = value;

		boolean assertTrue = exp.equals(act);
		if (!assertTrue) {
			APPLICATION_LOG.debug("Expected: " + exp + " | Actual: " + act + " = " + assertTrue);
			System.err.println("Expected: " + exp + " | Actual: " + act + " = " + assertTrue);
		} else {
			System.out.println("Expected: " + exp + " | Actual: " + act + " = " + assertTrue);
			APPLICATION_LOG.debug("Expected: " + exp + " | Actual: " + act + " = " + assertTrue);
			System.out.println("");
		}
	}
	// ........................... Maximize the
	// page.......................................................

	public void maxPage() {
		driver.manage().window().maximize();
	}

	// ................................ Wait
	// Statement.............................................

	public void wait(int x) throws InterruptedException {
		Thread.sleep(x); // In test class just use: waitTillLoad(3000);
	}

	public void iWait(int X) {
		driver.manage().timeouts().implicitlyWait(X, TimeUnit.SECONDS);
	}
	// ............................................................. TYPE BY
	// ..................................

	public boolean typeById(String locator, String value) throws Exception {
		try {
			WebElement typeByID = driver.findElement(By.id(locator));
			typeByID.clear();
			typeByID.sendKeys(value);
			return true;
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
			APPLICATION_LOG.debug("Element not found and Reason is :==> " + e);
			return false;
		}
	}

	public boolean typeByName(String locator, String value) throws Exception {
		try {
			WebElement typeByName = driver.findElement(By.name(locator));
			typeByName.clear();
			typeByName.sendKeys(value);
			return true;
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
			APPLICATION_LOG.debug("Element not found and Reason is :==> " + e);
			return false;
		}
	}

	public boolean typeByXpath(String locator, String value) throws Exception {
		try {
			WebElement typeByXpath = driver.findElement(By.xpath(locator));
			typeByXpath.clear();
			typeByXpath.sendKeys(value);
			return true;
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
			APPLICATION_LOG.debug("Element not found and Reason is :==> " + e);
			return false;
		}
	}

	public boolean typeByCss(String locator, String value) throws Exception {
		try {
			WebElement typeByCss = driver.findElement(By.cssSelector(locator));
			typeByCss.clear();
			typeByCss.sendKeys(value);
			return true;
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
			APPLICATION_LOG.debug("Element not found and Reason is :==> " + e);
			return false;
		}
	}
	// ....................................................................
	// CLICK EVERYTHING ..................................

	public boolean clickById(String locator) throws Exception {
		try {
			WebElement clickById = driver.findElement(By.id(locator));
			clickById.click();
			Thread.sleep(500);
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			APPLICATION_LOG.debug("Element not found and Reason is :==> " + e);

			return false;
		}
	}

	public boolean clickByXpath(String locator) throws Exception {
		try {
			WebElement clickByXpath = driver.findElement(By.xpath(locator));
			clickByXpath.click();
			return true;
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
			APPLICATION_LOG.debug("Element not found and Reason is :==> " + e);
			return false;
		}
	}

	public boolean clickByLink(String locator) throws Exception {
		try {
			WebElement clickBylinkText = driver.findElement(By.linkText(locator));
			clickBylinkText.click();
			return true;
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
			APPLICATION_LOG.debug("Element not found and Reason is :==> " + e);
			return false;
		}
	}

	public boolean clickByCss(String locator) throws Exception {
		try {
			WebElement clickByCss = driver.findElement(By.cssSelector(locator));
			clickByCss.click();
			return true;
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
			APPLICATION_LOG.debug("Element not found and Reason is :==> " + e);
			return false;
		}
	}

	public boolean clickByName(String locator) throws Exception {
		try {
			WebElement clickByName = driver.findElement(By.name(locator));
			clickByName.click();
			return true;
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
			APPLICATION_LOG.debug("Element not found and Reason is :==> " + e);
			return false;
		}
	}
	// ....................................... getText
	// ..........................................

	public String getDataAttributeByXpath(String locator, String attribute) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		driver.findElement(By.xpath(locator));
		String value = driver.findElement(By.xpath(locator)).getAttribute("data-" + attribute);
		System.out.println("");
		return value;
	}

	public void getTextByXpath(String locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
			// driver.findElement(By.xpath(locator));
			System.out.println("" + driver.findElement(By.id(locator)).getText());
			System.out.println("");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			APPLICATION_LOG.debug("Element not found and Reason is :==> " + e);
		}
	}

	public void getTextById(String locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
			driver.findElement(By.id(locator));
			System.out.println("" + driver.findElement(By.id(locator)).getText());
			System.out.println("");

		} catch (Exception e) {
			System.err.println(e.getMessage());
			APPLICATION_LOG.debug("Element not found and Reason is :==> " + e);
		}

	}

	public void getTextByClassName(String locator) {
		try {
			System.out.println("" + driver.findElement(By.className(locator)).getText());
			System.out.println("");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			APPLICATION_LOG.debug("Element not found and Reason is :==> " + e);
		}
	}
	// ..........................................................................
	// VerifyImage...............................................

	public boolean verifyImageXpath(String locator, String containValues) {
		try {
			WebElement imageVerify = driver.findElement(By.xpath(locator));
			imageVerify.getAttribute("src").contains(containValues);
			imageVerify.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
			APPLICATION_LOG.debug("Element not found and Reason is :==> " + e);

			return false;
		}
	}

	// ........................................................... Switch Window
	// ......................................................

	public void popUpModal() {
		driver.switchTo().activeElement();
	}

	// ........................................................... Switch to
	// iFrame ......................................................

	public void iFrameByCss(String locator) {
		try {
			driver.switchTo().frame(driver.findElement(By.cssSelector(locator)));
		} catch (Throwable t) {
			System.err.println(t.getMessage());
			APPLICATION_LOG.debug("Could not switch to iFrame" + t);
		}
	}

	// .............................................................. Handle new
	// Window .............................
	public void switchToNewWindow() throws InterruptedException {
		Set<String> handles = driver.getWindowHandles();
		String current = driver.getWindowHandle();
		handles.remove(current);
		String newTab = handles.iterator().next();
		driver.switchTo().window(newTab);
		Thread.sleep(4000);
	}

	public void closeNewWindow() {
		String originalHandle = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
				driver.close();
			}
		}

		driver.switchTo().window(originalHandle);
	}
	// ................................................................. Accept
	// Pop Up Msg.................................................

	public void popUp() {
		try {
			Alert alert = driver.switchTo().alert();
			String msg = alert.getText();
			Thread.sleep(1000);
			System.out.println("The Pop Up Window Message is: " + msg);
			alert.accept();
		} catch (Throwable t) {
			System.err.println(t.getMessage());
			APPLICATION_LOG.debug("Element not found and Reason is :==> " + t);
		}
	}

	public void checkAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			APPLICATION_LOG.debug("Element not found and Reason is :==> " + e);
		}
	}

	public void closePopUPifPresent() {
		Set<String> winIds = driver.getWindowHandles();
		System.out.println("Total windows -> " + winIds.size());
		if (winIds.size() == 2) {
			Iterator<String> iter = winIds.iterator();
			String mainWinID = iter.next();
			String popupWindID = iter.next();
			driver.switchTo().window(popupWindID);
			driver.close();
			driver.switchTo().window(mainWinID);
		}

	}

	// -------Hover Over-------------------
	public boolean hoverOverByXpath(String locator) {
		try {
			Actions action = new Actions(driver);
			WebElement we = driver.findElement(By.xpath(locator));
			action.moveToElement(we).build().perform();
			return true;
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
			APPLICATION_LOG.debug("Element not found and Reason is :==> " + e);
			return false;
		}
	}

	// ...................................................
	// DropDown.....................................................

	public boolean dropDownById(String locator, String text) {
		try {
			WebElement dropDownListBox = driver.findElement(By.id(locator));
			Select clickThis = new Select(dropDownListBox);
			clickThis.selectByVisibleText(text);
			return true;
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
			APPLICATION_LOG.debug("Element not found and Reason is :==> " + e);
			return false;
		}
	}

	public boolean dropDownByName(String locator, String text) {
		try {
			WebElement dropDownListBox = driver.findElement(By.name(locator));
			Select clickThis = new Select(dropDownListBox);
			clickThis.selectByVisibleText(text);
			return true;
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
			APPLICATION_LOG.debug("Element not found and Reason is :==> " + e);
			return false;
		}
	}

	public boolean dropDownById_usingIndex(String locator) {
		try {
			WebElement dropDownListBox = driver.findElement(By.id(locator));
			Select clickThis = new Select(dropDownListBox);
			clickThis.selectByIndex(0);
			return true;
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
			APPLICATION_LOG.debug("Element not found and Reason is :==> " + e);
			return false;
		}
	}

	public boolean dropDownByName_usingIndex(String locator) {
		try {
			WebElement dropDownListBox = driver.findElement(By.name(locator));
			Select clickThis = new Select(dropDownListBox);
			clickThis.selectByIndex(0);
			return true;
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
			APPLICATION_LOG.debug("Element not found and Reason is :==> " + e);
			return false;
		}
	}

	// .............................................. Keyboard
	// ...................

	public void enter(String locator) {
		driver.findElement(By.xpath(locator)).sendKeys(Keys.ENTER);
	}

	public void backSpace(String locator) {
		driver.findElement(By.xpath(locator)).sendKeys(Keys.BACK_SPACE);
	}

	public void delete(String locator) {
		driver.findElement(By.xpath(locator)).sendKeys(Keys.DELETE);
	}

	public void scroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(0,3000)");
	}

	public void scrollToElementUsingXpath(String locator) throws InterruptedException {
		WebElement element = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
	}

	// ............................................. Radio Button
	// .............................................................

	public void radioButtonByName(String locator, String getAttribute, String containValue) {
		List<WebElement> radios = driver.findElements(By.name(locator));
		for (WebElement element : radios) {
			if (element.getAttribute(getAttribute).contains(containValue)) {
				element.click();
			}
		}
	}

	// .........................................................
	// Screenshot....................................................................

	public void screenShot(String screenshotName) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\screenShots\\" + screenshotName + ".png"));
	}

	public void futureDate(String locator) {
		String T;
		Date date;
		SimpleDateFormat formatter;
		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.DATE, 2);
		date = calendar.getTime();
		// formatter = new SimpleDateFormat("MM/dd/YYYY");
		formatter = new SimpleDateFormat("MMM" + " " + "dd" + "," + " YYYY");
		T = formatter.format(date);
		System.out.println("The future selected date is: " + T);
		driver.findElement(By.xpath(locator)).sendKeys(T);
	}

	public void todaysDateByXpath(String locator) {
		String t;
		Date date;
		Calendar currentDate = Calendar.getInstance(); // Get the current date
		date = currentDate.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("MMM" + " " + "dd" + "," + " YYYY"); // format
		// it
		// as
		// per
		// your
		// requirement
		t = formatter.format(date);
		System.out.println("Today's date is: =>  " + t);
		driver.findElement(By.xpath(locator)).sendKeys(t);
	}

	// ............................................... upload file from
	// computer.........................

	public boolean uploadFileByName(String locator, String location) {
		try {
			driver.findElement(By.name(locator)).sendKeys(location);
			return true;
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
			APPLICATION_LOG.debug("Element not found and Reason is :==> " + e);
			return false;
		}
	}

	public void uploadFileByName2(String locator) throws IOException {
		driver.findElement(By.name(locator)).click();
		BufferedReader in = new BufferedReader(
				new FileReader(System.getProperty("user.dir") + "\\Upload\\profilePic.jpg"));
		in.readLine();
		in.close();
	}

	public void uploadFileByName3(String locator) {
		WebElement UploadImg = driver.findElement(By.name(locator));
		UploadImg.click();
		StringSelection ss = new StringSelection(System.getProperty("user.dir") + "\\Upload\\profilePic.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	}

	public void uploadFileByName4(String locator) {
		WebElement UploadImg = driver.findElement(By.name(locator));
		UploadImg.click();
		WebElement frame = driver.switchTo().activeElement();
		frame.sendKeys(System.getProperty("user.dir") + "\\Upload\\profilePic.jpg");
	}

	// ====Ataur======
	public boolean assertTrueByXpath(String locator, String msg) {
		APPLICATION_LOG.debug(driver.findElement(By.xpath(locator)).getText() + " " + msg);
		Assert.assertTrue(driver.findElement(By.xpath(locator)).getText().equals(msg));
		return true; // ???????
	}

	// Count if the element is exist or not
	public int findElementByXpath(String locator) {
		WebDriverWait expWait = new WebDriverWait(driver, 15);
		expWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
		int numofelements = driver.findElements(By.xpath(locator)).size();
		return numofelements;
	}

	// Count if the element is exist or not
	public int findElementByid(String locator) {
		WebDriverWait expWait = new WebDriverWait(driver, 15);
		expWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(locator)));
		int numofelements = driver.findElements(By.id(locator)).size();
		return numofelements;
	}

}