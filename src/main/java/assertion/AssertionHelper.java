package assertion;

import logger.MyLogger;
import org.testng.Assert;
import report.ExtentLogger;

public class AssertionHelper {
    private AssertionHelper() {
    }

    public static void verifyTrue(boolean status) {
        Assert.assertTrue(status);
    }

    public static void verifyEquals(String s, String t) {
        Assert.assertEquals(s, t);
        MyLogger.info(AssertionHelper.class, "Verify is " + s + " equals: " + t);
        ExtentLogger.pass("Verify if " + s + " Equals: " + t);
    }

}
