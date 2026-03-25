package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.datatransfer.StringSelection;

public class FIleUtils {

    public static void uploadFileUsingSendKeys(WebDriver driver, String filePath, By locator){
        WebElement element = driver.findElement(locator);
        element.sendKeys(filePath);
    }

    //upload when element is hidden
    public static void uploadHiddenElement(WebDriver driver, String filepath, By locator){
        WebElement element =driver. findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //make hidden element visible
        js.executeScript("arguments[0].style.display='block';", element);
        element.sendKeys(filepath);
    }

    public static void uploadFileWithAutoIt(String exePath, String filePath) {
        try {
            Runtime.getRuntime().exec(exePath + " " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //upload using Robot class
    public static void uploadUsingRobot(String filePath){
        //copy file path to clipboard
        StringSelection selection = new StringSlection(filePath);
    }
}
