package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    AccountPage accountPage;
    @Test
    public void loginTest(){
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        loginPage=new LoginPage(driver);
        accountPage = loginPage.login();
        //Assertion
        String expectedText="My Account";
        String actualText=accountPage.getAccountHeaderText();
        Assert.assertEquals(actualText,expectedText);
        //verify right panel links
        accountPage.getRightPanelListCount();
        int actualLinks=accountPage.getRightPanelListCount();
        Assert.assertEquals(actualLinks,13);
        accountPage.getRightPaneLListText();

    }
//    @Test(dependsOnMethods = "loginTest")
//    public void verifyAccountPage(){
//        loginPage.login();
//        accountPage.getRightPanelListCount();
//        accountPage.getRightPaneLListText();
//    }
}
