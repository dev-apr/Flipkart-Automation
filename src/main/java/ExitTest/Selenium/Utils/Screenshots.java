package ExitTest.Selenium.Utils;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {

	public static String takeScreenShot(WebDriver driver, String fileName) {

		String screenshotFileName = System.getProperty("user.dir") + "\\screenshots\\" + fileName+".jpg";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {

			FileUtils.copyFile(scrFile, new File(screenshotFileName));

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
		
		return screenshotFileName;
	}
}
