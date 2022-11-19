package report;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
    private ExtentTestManager(){}
    private static ExtentTest test;

    protected static void setTest(ExtentTest test){
        ExtentTestManager.test=test;
    }
    protected static ExtentTest getTest(){
        return ExtentTestManager.test;
    }
}
