package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

     protected WebDriver driver;

    public WebDriver initDriver() {
        driver = new ChromeDriver();
        return driver;
    }

    public void quitDriver(){
        driver.quit();
    }
}
