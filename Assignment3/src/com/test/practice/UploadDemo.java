package com.test.practice;

public class UploadDemo {

	public static void main(String[] args) {

		SeleniumUtils util = new SeleniumUtils();
		
		String Browser = "firefox";
		String Url = System.getProperty("user.dir") + "\\Files\\uploadSample.html";

		util.setBrowser(Browser);
		util.maximizeBrowser();
		util.setImplicitWait(25);
		util.launchURL(Url);
		
		util.sendText("name", "uploadsubmit", System.getProperty("user.dir") + "\\Files\\Payment.pdf");
		System.out.print(util.executeJavaScript("return document.getElementsByName('uploadsubmit')[0].value"));
		util.closeAndQuit();		
	}
}
