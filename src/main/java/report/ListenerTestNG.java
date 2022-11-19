package report;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtils;

public class ListenerTestNG implements ITestListener {
    public void onStart(ITestContext context) {
        ExtentReportsManager.initReport();
    }
    public  void onTestStart(ITestResult result) {
        String methodName=result.getMethod().getMethodName();
        ExtentTest test=ExtentReportsManager.initReport().createTest(methodName);
        ExtentTestManager.setTest(test);
    }

    public void onTestSuccess(ITestResult result) {
        String logText = "<b>Test Method " + result.getMethod().getMethodName() + " Successful</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        ExtentTestManager.getTest().pass(m);
    }

    public void onTestFailure(ITestResult result) {
        String methodName=result.getMethod().getMethodName();
        ExtentTestManager.getTest().fail("<b><font color=red>"+"screen shot of the failure"+"</font></b>"
        , MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Img()).build());
    }

    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().skip("<b><font color=red>" + "screenshot of the failure" + "</font></b>"
                , MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Img()).build());
    }

    public void onFinish(ITestContext context) {
        ExtentReportsManager.flushReport();
    }

}
