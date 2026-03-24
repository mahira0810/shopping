package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

     protected static WebDriver driver;
    //private static WebDriver driver;//But this will fail in parallel execution

    public static WebDriver initDriver() {
        if(driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public void quitDriver(){
        driver.quit();
    }
}
