package com.test.practice;

public class TableDemo {

	static SeleniumUtils util;

	public void getTableValue(int row, int column) {
		try {
			System.out.println("Value at Row: " + row + " and Column: " + column + " is:  " + util.createWebElement(
					"xpath",
					"//div[@id='post-body-8228718889842861683']/div/table/tbody/tr[" + row + "]/td[" + column + "]")
					.getText());
		} catch (Exception e) {
			System.out.println("Incorrect row/column value.");
		}
	}

	public static void main(String[] args) {
		util = new SeleniumUtils();
		TableDemo obj = new TableDemo();

		String Browser = "firefox";
		String Url = "http://only-testing-blog.blogspot.in/2014/05/form.html";
		int rows;
		int columns;

		util.setBrowser(Browser);
		util.maximizeBrowser();
		util.setImplicitWait(2);
		util.launchURL(Url);

		rows = util.createMultipleWebElement("xpath", "//div[@id='post-body-8228718889842861683']/div/table/tbody/tr")
				.size();
		columns = util.createMultipleWebElement("xpath",
				"//div[@id='post-body-8228718889842861683']/div/table/tbody/tr[1]/td").size();
		System.out.println("Number of Rows: " + rows);
		System.out.println("Number of Columns: " + columns);

		for (int i = 1; i <= rows; i++) {
			columns = util.createMultipleWebElement("xpath",
					"//div[@id='post-body-8228718889842861683']/div/table/tbody/tr[" + i + "]/td").size();
			for (int j = 1; j <= columns; j++) {
//				try {
					if (util.createWebElement("xpath",
							"//div[@id='post-body-8228718889842861683']/div/table/tbody/tr[" + i + "]/td[" + j + "]")
							.getSize() != null) {
						System.out.print(util.createWebElement("xpath",
								"//div[@id='post-body-8228718889842861683']/div/table/tbody/tr[" + i + "]/td[" + j
										+ "]")
								.getText() + "\t");
					}
//				} catch (Exception e) {
//					System.out.print("");
//				}
			}
			System.out.println("");
		}
		obj.getTableValue(6, 8);
		util.closeAndQuit();
	}
}
