package base;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends DriverManager {

    protected WebDriver driver;
    DriverManager driverManager=new DriverManager();

    @BeforeMethod
    public void setUp(){
        driver = driverManager.initDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=product/category&path=18");//add url
    }

    @AfterMethod
    public void tearDown(){
        driverManager.quitDriver();
    }
}
