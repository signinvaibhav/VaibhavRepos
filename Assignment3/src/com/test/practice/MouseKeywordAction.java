package com.test.practice;

import java.awt.AWTException;

import org.openqa.selenium.Keys;

public class MouseKeywordAction {

	public static void main(String[] args) throws AWTException {

		SeleniumUtils util = new SeleniumUtils();

		String Browser = "firefox";
		String Url = "https://www.burbank.com.au/victoria";
		String googleUrl = "http://www.google.com";

		util.setBrowser(Browser);
		util.maximizeBrowser();
		util.setImplicitWait(25);
		util.launchURL(Url);

		util.mouseHoverEvent("css", "#p_lt_ctl01_Submenunav_lblaboutburbank>span");
		util.mouseHoverEvent("xpath", "(//div[@class='col-sm-12'])[1]");

		util.launchURL(googleUrl);
		util.matchCompleteText(util.getPageTitle(), "Google");
		util.clickElement("id", "lst-ib");
		util.actionKeyPress(Keys.SHIFT, "hello");
		util.actionKeyRelease(Keys.SHIFT);
		util.closeAndQuit();
	}

}
