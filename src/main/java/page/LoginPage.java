package page;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(name = "username")
    public WebElement userName;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//div[contains(@class,'orangehrm-login-action')]")
    public WebElement login;

    @FindBy(xpath = "//div/*[@class=\"orangehrm-login-branding\"]")
    public WebElement orangeHRMLogo;

    //intiliazing page object class
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }


    public String validationLoginPageTitle (){
        return driver.getTitle();
    }

    public boolean validateOrangeHrmLogo() {
        return orangeHRMLogo.isDisplayed();
    }

    public HomePage loginTOOrangeHRM(String userName, String password) {
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        this.login.click();
        return new HomePage();
    }
}
