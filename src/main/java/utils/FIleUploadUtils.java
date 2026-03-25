package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FIleUploadUtils {

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
    public static void uploadUsingRobot(String filePath) throws AWTException {
        //copy file path to clipboard
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        Robot robot=new Robot();
        robot.delay(1000);

        //Paste (Mac: CMD+V, Windows: CTRL+V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        //press enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
