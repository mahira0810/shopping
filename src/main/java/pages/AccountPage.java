package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AccountPage {
WebDriver driver;
@FindBy(xpath = "//h2[text()='My Account']")
    private WebElement myAccountText;

@FindBy(xpath = "//a[@class='list-group-item']")
List<WebElement> rightPanelList;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait;
    public void verifyMyAccountText(){
        wait =new WebDriverWait(driver, Duration.ofSeconds(3));
       WebElement myAccountText=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='My Account']")));
        myAccountText.isDisplayed();

    }
    public String getAccountHeaderText()
    {
        verifyMyAccountText();
        return myAccountText.getText();
    }

    public int getRightPanelListCount(){
        int totalLink=rightPanelList.size();
        return totalLink;

    }

    public void getRightPaneLListText(){
        List<WebElement> panelLinks=rightPanelList;

        for (WebElement link : panelLinks){
            String linkText= link.getText();
            System.out.println(linkText);
        }
    }

}
