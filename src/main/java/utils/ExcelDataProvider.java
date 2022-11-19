package utils;

import constants.FrameworkConstants;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ExcelDataProvider {

    public static Object[][] getData(String sheetName) {
        Object data[][] = null;
        try {
            FileInputStream fis = new FileInputStream(FrameworkConstants.getDataPath());
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getLastCellNum();
            data = new Object[rows - 1][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j <cols; j++) {
                    data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
                }
            }
            workbook.close();
            fis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;


    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        Object data[][] = getData("login1");
        return data;
    }
    @DataProvider(name="signupData")
    public Object[][]getSignupData(){
        Object data[][]=getData("signup");
        return data;
    }
    @DataProvider(name="addNewCustomer")
    public Object[][]getCustomerData(){
        Object data[][]=getData("customers");
        return data;
    }

}
