package com.wright;

import com.microsoft.playwright.ElementHandle;

public class resourceTab extends firstClass{
	public  void resourceTab() {
		ElementHandle resourceTabBtn=page.waitForSelector("//span[normalize-space()='Resources']");
		resourceTabBtn.click();
		ElementHandle totalrescount=page.waitForSelector("//div[normalize-space()='Total Count']");
		totalrescount.click();
		ElementHandle addAccount=page.waitForSelector("//div[@pmpqaattr='AddResourceMenu']");
		System.out.println(addAccount.innerText());
		addAccount.click();
		page.waitForSelector("//*[@pmpqaattr='AddResource.ec']").click();


		
		

}
	public void addResource() throws InterruptedException {
		page.waitForSelector("//input[@id='sysname']").fill("Resource0");
		page.waitForSelector("//input[@id='DNSName']").fill("Resource1");
		page.selectOption("//select[@id='SysType']", "Linux");
		page.waitForSelector("//em[normalize-space()='Save & Proceed']").click();
		page.waitForSelector("//input[@id='Usr1']").fill("LinuxAcc1");
		Thread.sleep(1000);

		page.waitForSelector("//div[@id='GENPASS']").click();
		page.waitForSelector("//em[normalize-space()='Save']").click();

	}
	public void accessControl() throws InterruptedException {
		Thread.sleep(2000);

		page.waitForSelector("//input[contains(@name,'toggleAll')]").click();
		page.waitForSelector("//div[@divtype='parentDiv'][normalize-space()='Resource Actions']").click();
		Thread.sleep(2000);

		//page.waitForSelector("//div[@class='hand ddbsel'and normalize-space()='Resource Actions']").click();
		//page.waitForSelector("//a[normalize-space()='Share']").hover();
        ElementHandle triggerElement = page.querySelector("//a[normalize-space()='Share']");
       // page.evaluate("element => element.dispatchEvent(new MouseEvent('mouseover', { bubbles: true }))", triggerElement);
		triggerElement.hover();
		Thread.sleep(2000);

        boolean isDisplayed =page.locator("//a[normalize-space()='With Users']").isVisible();

		if(isDisplayed) {
			Thread.sleep(3000);
			

				page.waitForSelector("//a[normalize-space()='With Users']").click();
				System.out.println("Available");
				Thread.sleep(2000);


		}
		else {	
			System.out.println("Sorry ");
}
		Thread.sleep(3000);
		page.waitForSelector("(//span[@class='hand grant'][normalize-space()='Grant'])[1]").click();
		Thread.sleep(2000);

		page.waitForSelector("//li//a[text()='Full Access'][1]").click();
		/*
		 * page.waitForSelector("(//div[@class='hand ddbsel'])[1]").click();
		 * 
		 * 
		 * Thread.sleep(2000);
		 * 
		 * page.
		 * waitForSelector("//input[contains(@name,'toggleAll') and @type='checkbox']").
		 * click(); Thread.sleep(2000);
		 * 
		 * page.waitForSelector("//a[normalize-space()='Full Access']").click();
		 */
		
	}
	
}
