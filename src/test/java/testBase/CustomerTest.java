package testBase;

import assertion.AssertionHelper;
import logger.MyLogger;
import org.testng.annotations.Test;
import pages.objects.AddNewCustomerPage;
import pages.objects.DashBoardPage;
import pages.objects.HomePage;
import pages.objects.LoginPage;
import utils.ExcelDataProvider;
import java.lang.reflect.Method;

public class CustomerTest extends TestBase{
    @Test(dataProviderClass = ExcelDataProvider.class,dataProvider = "addNewCustomer")
    public void AddNewCustomerTest(Method method, String cn, String cc, String add, String city, String ph, String em){
        MyLogger.startTestCase(getClass(), method.getName());
        new HomePage().clickOnNavBar("Login");
        DashBoardPage dashBoardPage=new LoginPage().setUserName("evyTest03").setPassword("a1b1c1d").clickLoginBtn();
        AddNewCustomerPage addNewCustomerPage= dashBoardPage.clickCreateNewCustomer();
        addNewCustomerPage
                .setCustomerName(cn)
                .setCustomerCompany(cc)
                .setCustomerAddress(add)
                .setCustomerCity(city)
                .setCustomerPhone(ph)
                .setCustomerEmail(em)
                .clickCreateNewCustomerBtn();
        AssertionHelper.verifyEquals(dashBoardPage.getTitle(), "- Testautomation practice page");
        MyLogger.endTestCase(getClass(), method.getName());
    }
    @Test()
    public void searchCustomerByMailTest(Method method){
        MyLogger.startTestCase(getClass(), method.getName());
        new HomePage().clickOnNavBar("Login");
        DashBoardPage dashBoardPage=new LoginPage().setUserName("usertester1").setPassword("12345").clickLoginBtn();
        AssertionHelper.verifyTrue(dashBoardPage.searchCustomerByMail("evyMail@xyz.com"));
        MyLogger.endTestCase(getClass(), method.getName());

    }


}
