package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;

import java.util.Map;

public class DashboardTest extends BaseTest {

@Test
    public void verifyCategoryCounts(){
    driver.get("https://naveenautomationlabs.com/opencart/index.php?route=product/category&path=18");

    DashboardPage dashboardPage = new DashboardPage(driver);

    //Get category map from the page
    Map<String, Integer> categoryMap = dashboardPage.getCategoryMap();
    System.out.println(categoryMap.toString());
//Assertions
    Assert.assertTrue(categoryMap.containsKey("Desktops"), "Desktops category is missing");
    Assert.assertEquals(categoryMap.get("Desktops").intValue(), 13, "Desktops count mismatch");

    Assert.assertTrue(categoryMap.containsKey("Components"), "Components category is missing");
    Assert.assertEquals(categoryMap.get("Components").intValue(), 2, "Desktops count mismatch");

    Assert.assertTrue(categoryMap.containsKey("MP3 Players"), "MP3 Players category is missing");
    Assert.assertEquals(categoryMap.get("MP3 Players").intValue(), 4, "Desktops count mismatch");
}
}
