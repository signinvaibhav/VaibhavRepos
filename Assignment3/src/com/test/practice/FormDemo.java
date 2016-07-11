package com.test.practice;

public class FormDemo {

	public static void main(String[] args) {

		SeleniumUtils util = new SeleniumUtils();

		String Browser = "chrome";
		String Url = "http://only-testing-blog.blogspot.in/2014/09/selectable.html";

		util.setBrowser(Browser);
		util.maximizeBrowser();
		util.setImplicitWait(3);
		util.launchURL(Url);
		
		util.clickElement("id", "datepicker");
		util.clickElement("xpath", "//a[@title='Prev']");
		util.clickElement("xpath", "//a[@title='Next']");
		
		util.matchCompleteText(util.getLinkTextValue("xpath", "//span[@class='ui-datepicker-month']"), "July");
		util.matchCompleteText(util.getLinkTextValue("xpath", "//span[@class='ui-datepicker-year']"), "2016");
		
		util.clickElement("linktext", "15");
		
		util.closeAndQuit();
	}

}
