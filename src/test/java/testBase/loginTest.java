package testBase;

import assertion.AssertionHelper;
import logger.MyLogger;
import org.testng.annotations.Test;
import pages.objects.*;
import utils.ExcelDataProvider;
import java.lang.reflect.Method;




public class loginTest extends TestBase {

    @Test(dataProviderClass = ExcelDataProvider.class,dataProvider = "loginData")
    public void loginTest(Method method,String userName,String password) {
        MyLogger.startTestCase(getClass(), method.getName());
        new HomePage().clickOnNavBar("Login");
        DashBoardPage dashBoardPage = new LoginPage().setUserName(userName).setPassword(password).clickLoginBtn();
        AssertionHelper.verifyTrue(dashBoardPage.logoutDisplayStatus());
        MyLogger.endTestCase(getClass(), method.getName());

    }


}
