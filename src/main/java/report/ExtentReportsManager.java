package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import constants.FrameworkConstants;
import enums.ConfigProperties;
import utils.PropertyReader;

import java.awt.*;
import java.io.File;
import java.util.Objects;

public class ExtentReportsManager {
    private ExtentReportsManager(){}
    private static ExtentReports extent;

    public static ExtentReports initReport(){
        if(Objects.isNull(extent)){
            extent=new ExtentReports();
            extent.setSystemInfo("os",System.getProperty("os.name"));
            extent.setSystemInfo("Java Version: ",System.getProperty("java.version"));
            extent.setSystemInfo("user",System.getProperty("user.name"));
            extent.setSystemInfo("Browser", PropertyReader.getValue(ConfigProperties.BROWSER));
            extent.setSystemInfo("URL",PropertyReader.getValue(ConfigProperties.URL));
            ExtentSparkReporter spark=new ExtentSparkReporter(FrameworkConstants.getOutputFile());
            spark.config().setReportName("iteraQA");
            spark.config().setDocumentTitle("iteraQA Report");
            spark.config().setEncoding("UTF-8");
            spark.config().setTheme(Theme.DARK);
            extent.attachReporter(spark);
        }
        return extent;
    }
    public static void flushReport(){
        try{
            extent.flush();
            Desktop.getDesktop().browse(new File(FrameworkConstants.getOutputFile()).toURI());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
