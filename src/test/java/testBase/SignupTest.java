package testBase;

import assertion.AssertionHelper;
import logger.MyLogger;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.objects.HomePage;
import pages.objects.SignupPage;
import report.ListenerTestNG;
import utils.ExcelDataProvider;
import java.lang.reflect.Method;



@Listeners(ListenerTestNG.class)
public class SignupTest extends TestBase{
    @Test(dataProviderClass = ExcelDataProvider.class,dataProvider = "signupData" )
    public void signupTest(Method method, String fn, String sn, String em, String mob, String un, String pw, String cpw) {
        MyLogger.startTestCase(getClass(), method.getName());
        new HomePage().clickOnNavBar("Sign Up");
        SignupPage signupPage = new SignupPage();
        signupPage
                .setFirstName(fn)
                .setSureName(sn)
                .setEmail(RandomStringUtils.randomAlphabetic(8)+"@xyz.com")
                .setMobile(mob)
                .setUserName(RandomStringUtils.randomAlphabetic(8))
                .setPassword(pw)
                .setConfirmPassword(cpw)
                .clickSubmit();
        AssertionHelper.verifyEquals(signupPage.getSuccessSignupMsg(), "Registration Successful");
        MyLogger.endTestCase(getClass(), method.getName());
    }

}
