package com.test.practice;

public class MultipleHyperLinkDemo {

	public static void main(String[] args) throws InterruptedException {
		SeleniumUtils util = new SeleniumUtils();

		String Browser = "firefox";
		String Url = "http://newtours.demoaut.com/";
		int underConstruction = 0, developed = 0;

		util.setBrowser(Browser);
		util.maximizeBrowser();
		util.setImplicitWait(25);
		util.launchURL(Url);

		util.allLinks = util.getMultipleElements("a");

		for (int i = 0; i < util.allLinks.size(); i++) {
			util.allLinks = util.getMultipleElements("a");
			util.allLinks.get(i).click();
			if (util.getPageTitle().contains("Construction") || util.getPageTitle().contains("404")) {
				underConstruction += 1;
			} else {
				developed += 1;
			}
			util.navigateBrowser("back");
			util.explicitWait("linktext", "Home", 10);
		}
		System.out.println("Developed Links = " + developed);
		System.out.println("Under Construction Links and 404 Links = " + underConstruction);
		util.closeAndQuit();
	}

}
