package com.test.practice;

import com.test.practice.SeleniumUtils;

public class PerformGoogleSearch {

	public static void main(String[] args) {

		SeleniumUtils util = new SeleniumUtils();
		
		String Browser = "firefox";
		String Url = "http://www.google.com";
		
		util.setBrowser(Browser);
		util.maximizeBrowser();
		util.setImplicitWait(25);
		util.launchURL(Url);
		util.sendText("id", "lst-ib", "selenium");
		util.clickElement("name", "btnG");
		util.matchPartialText(util.getLinkTextValue("xpath", "(//h3/a)[1]"), "selenium");
		util.matchCompleteText(util.getPageTitle(), "selenium - Google Search");
		util.closeAndQuit();
		
	}
}
