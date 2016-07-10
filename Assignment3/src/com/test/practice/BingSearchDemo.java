package com.test.practice;

public class BingSearchDemo {

	public static void main(String[] args) {
		
		
//		Open Bing Search
//		Verify Bing logo on home page
//		Select hindi as language
//		Verify sign in text is displayed in hindi
//		Again, click on English
//		Perform search with text you like
//		Add assertion on search result page
		
		
		SeleniumUtils util = new SeleniumUtils();

		String Browser = "firefox";
		String Url = "http://www.bing.com/";

		util.setBrowser(Browser);
		util.maximizeBrowser();
		util.setImplicitWait(25);
		util.launchURL(Url);
		util.matchCompleteText(util.getPageTitle(), "Bing");
		
		util.matchCompleteText(util.getLinkTextValue("xpath", "//div[@class='hp_sw_logo hpcLogoWhite']"), "Bing");
		
		util.clickElement("xpath", "//div[@class='cSwitchLang sm_hvr']/a[1]");
		util.matchPartialText(util.getCurrentURL(), "setlang=hi-in");
		
		util.clickElement("xpath", "//div[@class='cSwitchLang']/a[1]");
		util.matchPartialText(util.getCurrentURL(), "setlang=en-in");
		
		util.sendText("id", "sb_form_q", "TESTING");
		util.clickElement("id", "sb_form_go");
		
		util.matchPartialText(util.getLinkTextValue("xpath", "(//h2/a)[1]"), "testing");
		
		util.closeAndQuit();
		
	}
	
}
