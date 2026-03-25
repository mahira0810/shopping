package utils;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementUtils extends DriverManager {

    WebDriverWait wait;

    public WebElement waitForElement(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //Handle stale element
    public void clickElement(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(locator)));
    }

    //interact with  webTable element
    public void clickButtonFromRow(String name) {

        List<WebElement> rows = driver.findElements(By.xpath("//table//tr"));

        for (WebElement row : rows) {

            if (row.getText().contains(name)) {
                row.findElement(By.xpath(".//button")).click();
                break;
            }
        }
    }

    //Get shadow root element
    public WebElement getShadowElement(WebDriver driver, WebElement host, String cssSelector) {

        WebElement shadowHost = driver.findElement(By.xpath("Shadow host"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement shadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", host);
        return shadowRoot.findElement(By.cssSelector(cssSelector));
    }

    public void getNestedShadowElement(WebDriver driver, String selector) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Locate outer host
        WebElement outerHost = driver.findElement(By.cssSelector("outer-host"));
        //Get outer shadow root
        WebElement outerShadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", outerHost);
        //locate inner host
        WebElement innerHost = outerShadowRoot.findElement(By.cssSelector("inner-host"));
        //Get inner shadow root
        WebElement innerShadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", innerHost);
        //locate target element
        WebElement button = innerShadowRoot.findElement(By.cssSelector(selector));
        button.click();
    }
}