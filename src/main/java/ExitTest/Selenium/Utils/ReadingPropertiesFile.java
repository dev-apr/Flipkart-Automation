package ExitTest.Selenium.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadingPropertiesFile {

	public static FileInputStream fis = null;
	public static Properties prop = new Properties();
	public static File file = null;

	// Static block to initialize class variables
	static {
			file = new File("./src/main/resources/config.properties");
			try {
				fis = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();

			}
	}
	
	static {
		file = new File("./src/main/resources/TestData.properties");
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();

		}
}


	public static String getProperty(String key) {

		return prop.getProperty(key);

	}

}
