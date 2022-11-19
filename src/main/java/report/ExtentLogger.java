package report;

import com.aventstack.extentreports.ExtentTest;

public class ExtentLogger {
    private ExtentLogger(){}
    public static void pass(String message){
        ExtentTestManager.getTest().pass(message);
    }
    public static void fail(String message){
        ExtentTestManager.getTest().fail(message);
    }
    public static void skip(String message){
        ExtentTestManager.getTest().skip(message);
    }
}
