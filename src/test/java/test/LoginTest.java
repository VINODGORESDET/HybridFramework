package test;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;

public class LoginTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    public LoginTest() {
        super();
    }

    @BeforeMethod
    public void setUpBrowser() {
        initialize();
         loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest (){
        String title = loginPage.validationLoginPageTitle();
        Assert.assertEquals(title,"OrangeHRM");
    }

    @Test(priority = 2)
    public void hrmLogoTest (){
        boolean logoDisplayed = loginPage.validateOrangeHrmLogo();
        Assert.assertTrue(logoDisplayed);
    }

    @Test(priority = 3)
    public void loginToHRMTest () {
       homePage = loginPage.loginTOOrangeHRM(properties.getProperty("username"),properties.getProperty("password"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
