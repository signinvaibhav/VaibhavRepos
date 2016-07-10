package com.test.practice;

public class GoogleFormDemo {

	public static void main(String[] args) {

		SeleniumUtils util = new SeleniumUtils();

		String Browser = "chrome";
		String Url = "https://docs.google.com/forms/d/1uZohjwz4oYQnyc8qKRhRvURgMAi3nCIaI0GSMVAKSRM/viewform?c=0&w=1&usp=mail_form_link";

		util.setBrowser(Browser);
		util.maximizeBrowser();
		util.setImplicitWait(3);
		util.launchURL(Url);

		util.sendText("xpath", "//textarea[@aria-label='Name']", "Vaibhav");
		util.sendText("xpath", "//input[@aria-label='Paragraph Type']", "Sample Paragraph");
		util.clickElement("xpath", "//div[@aria-label='Radio 5']/..");
		util.clickElement("xpath", "//div[@aria-label='CheckBox 2']/..");
		util.clickElement("xpath", "//div[@aria-label='Option 4']/..");

		util.clickElement("xpath", "(//div[@aria-label='Column 3'])[1]");
		util.clickElement("xpath", "(//div[@aria-label='Column 2'])[2]");
		util.clickElement("xpath", "(//div[@aria-label='Column 4'])[3]");

		util.sendText("xpath", "//input[@aria-label='Month']", "05");
		util.sendText("xpath", "//input[@aria-label='Day of the month']", "04");
		util.sendText("xpath", "//input[@aria-label='Year']", "2015");
		// util.mouseHoverEvent("xpath", "//input[@type='date']");
		// util.clickElement("xpath", "//input[@type='date']");

		util.sendText("xpath", "//input[@aria-label='Hour']", "2");
		util.sendText("xpath", "//input[@aria-label='Minute']", "43");

		 util.clickElement("xpath", "//div[@role='listbox']");
		// util.clickElement("xpath", "//div[@data-value='PM']");

		 util.clickElement("xpath", "//div[@data-value='4']");

		// util.closeAndQuit();

	}

}
