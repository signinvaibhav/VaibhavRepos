package com.test.practice;

public class AlertDialogDemo {

	public static void main(String[] args) {

		SeleniumUtils util = new SeleniumUtils();

		String Browser = "firefox";
		String Url = "https://joecolantonio.com/SeleniumTestPage.html";

		util.setBrowser(Browser);
		util.maximizeBrowser();
		util.setImplicitWait(25);
		util.launchURL(Url);
		util.matchCompleteText(util.getPageTitle(), "Selenium WebDriver Validation");
		util.clickElement("partiallinktext", "Alert Dialog");
		System.out.println(util.handleAlert());
		util.closeAndQuit();
	}

}
