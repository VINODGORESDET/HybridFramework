package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties properties;

    public TestBase() {
        try{
            properties = new Properties();
            FileInputStream file = new FileInputStream("src/main/java/config/config.properties");
            properties.load(file);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void initialize(){
        String browser = properties.get("browser").toString();

        if (browser.equals("chrome")){
            driver = new ChromeDriver();
        } else if (browser.equals("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("invalid input/browser not supported");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.get(properties.get("url").toString());
    }

}
