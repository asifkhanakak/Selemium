package com.class04;

import com.utilities.CommonMethods;
import com.utilities.Constants;

public class SetupDemo extends CommonMethods {

	public static void main(String[] args) {
		CommonMethods.setUp("firefox", Constants.HRMS_URL);
		driver.close();
	}

}
