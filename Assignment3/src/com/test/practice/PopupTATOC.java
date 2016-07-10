package com.test.practice;

public class PopupTATOC {

	public static void main(String[] args) {
		
		SeleniumUtils util = new SeleniumUtils();

		String Browser = "firefox";
		String Url = "http://10.0.1.86/tatoc/basic/windows";
		String currentWindow;

		util.setBrowser(Browser);
		util.maximizeBrowser();
		util.setImplicitWait(25);
		util.launchURL(Url);
		
		util.matchPartialText(util.getPageTitle(), "Windows");
		
		currentWindow = util.getCurrentWindow();
		util.clickElement("linktext", "Launch Popup Window");
		
		util.goToPopupWindow();
		util.sendText("css", "#name", "Vaibhav");
		util.clickElement("css", "#submit");
		
		util.switchToSpecificWindow(currentWindow);
		util.clickElement("linktext", "Proceed");
		
		util.closeAndQuit();
	}
}
