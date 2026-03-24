package base;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends DriverManager {

    protected WebDriver driver;
    DriverManager driverManager=new DriverManager();

    @BeforeMethod
    public void setUp(){
        driver = driverManager.initDriver();

    }

    @AfterMethod
    public void tearDown(){
        driverManager.quitDriver();
    }
}
