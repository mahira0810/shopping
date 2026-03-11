package pages;

import com.thoughtworks.qdox.model.expression.GreaterThan;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DashboardPage{

    protected WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='list-group']/a")//TEMP
    private List<WebElement> listOfCategory;//List of elements

    //method call
    public Map<String, Integer> getCategoryMap(){

        Map<String, Integer> categoryMap = new HashMap();
        for(WebElement category : listOfCategory){
            String fullText = category.getText();

            String categoryName = fullText.substring(0, fullText.indexOf("(")).trim();//takes the substring from index 0 up to index 11 (not including "(").

            int count = Integer.parseInt(fullText.substring(fullText.indexOf("(")+1, fullText.indexOf(")")));
            //fullText.indexOf("(")+1 → start after the “(” AND fullText.indexOf(")") → finds the closing parenthesis )

            categoryMap.put(categoryName, count);
        }
        return categoryMap;
    }

}
