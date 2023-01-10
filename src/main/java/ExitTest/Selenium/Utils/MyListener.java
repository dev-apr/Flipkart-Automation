package ExitTest.Selenium.Utils;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;


public class MyListener implements IAnnotationTransformer{
	
	List<String> activeTests;
	
	String excelFile = ReadingPropertiesFile.getProperty("excelFileLocation");
	String excelSheet = ReadingPropertiesFile.getProperty("excelSheetName");

    public MyListener() throws IOException{
    	
    	activeTests = new ArrayList<>();
    	
    	//Create an object of File class to open excel file

        File file = new File(excelFile);

        //Create an object of FileInputStream class to read excel file

        FileInputStream inputStream = new FileInputStream(file);

        //Create object of XSSFWorkbook class to open workbook

        Workbook Workbook = new XSSFWorkbook(inputStream);

        //Read sheet inside the workbook by its name

        Sheet sheet = Workbook.getSheet(ReadingPropertiesFile.getProperty("excelSheetName"));

        //Find number of rows in excel file

        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum()+1;

        //Create a loop over all the rows of excel file to read it

        for (int i = 1,j=0; i < rowCount; i++) {

            Row row = sheet.getRow(i);            // To fetch row
            Cell req = row.getCell(j+1);          // To fetch cell containing Yes or No
            Cell test = row.getCell(j);           // To fetch cell containing test case name

            if(req.getStringCellValue().equalsIgnoreCase("Yes")){
                activeTests.add(test.getStringCellValue());               // Test cases corresponding to Yes are added to list
            }
            
            else {
            	continue;
            }
        } 
        
        Workbook.close();
    }  
    
    
    //  To enable/disable test cases by reading data from excel file 
    
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
    	
    	// Only if test case is present in list(activeTests), it will be enabled i.e., it will run
    	
  	    if (activeTests.contains(testMethod.getName())) {
  	      annotation.setEnabled(true);
  	    }
  	    
  	    else {
  	      annotation.setEnabled(false);
  	    }
  	}

}
