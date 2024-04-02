package com.wright;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Playwright;

public class ADuserImportAndLogin extends firstClass {
	String server="pam";
	public void adminTab() {
		if(server=="pmp")
		{
			page.waitForSelector("//li//span[text()='Admin'][1]").click();
			page.waitForSelector("(//a[.='LDAP'])[2]").click();
			page.waitForSelector("//em[normalize-space()='LDAP Server Details']").click();
			page.waitForSelector("//span[contains(@class,'icon-plus')]").click();
			page.waitForSelector("//input[@id='providerHost']").fill("pam-dc");
			page.waitForSelector("//input[@id='providerPort']").fill("389");
			page.waitForSelector("//input[@id='manualUserName']").fill("cn=administrator,cn=users,dc=pam360,dc=com");
			page.waitForSelector("//input[@id='manualPassword']").fill("zgNa9G$9gXBh60");
			page.waitForSelector("//input[@id='baseDN']").fill("dc=pam360,dc=com");
			page.waitForSelector("//em[normalize-space()='Save']").click();
			page.waitForSelector("//li//span[text()='Admin'][1]").click();
			page.waitForSelector("//a[.='LDAP']").click();
			page.waitForSelector("//em[normalize-space()='Enable Now']").click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
		page.waitForSelector("//li//span[text()='Admin'][1]").click();
		page.waitForSelector("//a[.='LDAP']").click();
		page.waitForSelector("//em[normalize-space()='LDAP Server Details']").click();
		page.waitForSelector("//em[normalize-space()='Add LDAP Server']").click();
		page.waitForSelector("//input[@id='providerHost']").fill("pam-dc");
		page.waitForSelector("//input[@id='providerPort']").fill("389");
		page.waitForSelector("//input[@id='manualUserName']").fill("cn=administrator,cn=users,dc=pam360,dc=com");
		page.waitForSelector("//input[@id='manualPassword']").fill("zgNa9G$9gXBh60");
		page.waitForSelector("//input[@id='baseDN']").fill("dc=pam360,dc=com");
		page.waitForSelector("//em[normalize-space()='Save']").click();
		page.waitForSelector("//li//span[text()='Admin'][1]").click();
		page.waitForSelector("//a[.='LDAP']").click();
		page.waitForSelector("//em[normalize-space()='Enable Now']").click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		page.waitForSelector("//em[normalize-space()='LDAP Server Details']").click();

		page.waitForSelector("//div[@pmpqaattr='AddResourceMenu']").click();
		page.waitForSelector("//a[@pmpqaattr='AdvanceSearchFilter.ec']").click();
		page.waitForSelector("//input[@id='searchFilter']").fill("cn=administrator");
		page.waitForSelector("//em[normalize-space()='Import & Save']").click();
		
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); 
		int width = (int)size.getWidth(); 
		int height = (int)size.getHeight();

		Playwright playwright = Playwright.create();

		Browser browser =
				playwright.chromium().launch(new
						BrowserType.LaunchOptions().setHeadless(false));

		// Create a new browser context with 'ignoreHTTPSErrors'
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setIgnoreHTTPSErrors(true).setViewportSize(width, height));

		// Create a new page within the context
		page=context.newPage();
		page.navigate("https://dhana-16587:8282/");

		page.waitForURL("https://dhana-16587:8282/PassTrixMain.cc");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ElementHandle uname=page.waitForSelector("input[id='username']");

		uname.fill("administrator");
		ElementHandle pwd=page.waitForSelector("//input[@id='password']");//button[@type='submit']

		pwd.fill("zgNa9G$9gXBh60");
		page.locator("//*[@id='pmp_domainName']");
		boolean isDisplayed =page.locator("//*[@id='pmp_domainName']").isVisible();

		if(isDisplayed) {
			page.selectOption("//*[@id='pmp_domainName']", "pam360.com");


		}
		else {}
		ElementHandle login=page.waitForSelector("//button[@type='submit']");

		login.click();
		


	}

}
