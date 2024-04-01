package com.wright;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class firstClass {
	public static Page page;
	public static resourceTab rTab;
	static firstClass pamClass1;
	public static ADuserImportAndLogin ldap;

	public static void main(String[] args) throws InterruptedException {
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); 
		int width = (int)size.getWidth(); 
		int height = (int)size.getHeight();


		Playwright playwright = Playwright.create();
		// Launch the browser with the 'ignoreHTTPSErrors' option
		Browser browser =
				playwright.chromium().launch(new
						BrowserType.LaunchOptions().setHeadless(false));

		// Create a new browser context with 'ignoreHTTPSErrors'
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setIgnoreHTTPSErrors(true).setViewportSize(width, height));

		// Create a new page within the context
		page=context.newPage();
		page.navigate("https://dhana-16587:7272/");

		//page.waitForURL("https://dhana-16587:7272/PassTrixMain.cc");
		/*
		 * try { Thread.sleep(2000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		System.out.println(page.title());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ElementHandle uname=page.waitForSelector("input[id='username']");

		uname.fill("admin");
		ElementHandle pwd=page.waitForSelector("//input[@id='password']");//button[@type='submit']

		pwd.fill("Test@123");
		page.locator("//*[@id='pmp_domainName']");
		boolean isDisplayed =page.locator("//*[@id='pmp_domainName']").isVisible();

		if(isDisplayed) {
			page.selectOption("//*[@id='pmp_domainName']", "Local Authentication");


		}
		else {}
		ElementHandle login=page.waitForSelector("//button[@type='submit']");

		login.click();
		
		rTab=new resourceTab();
		ldap=new ADuserImportAndLogin();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * rTab.resourceTab(); rTab.addResource(); rTab.accessControl();
		 */
		ldap.adminTab();
	}

}
