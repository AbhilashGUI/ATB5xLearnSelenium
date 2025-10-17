package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Selenium08 {

    @Test
    public void testbrowserisnotgettingclosed()
    {

        WebDriver driver= new EdgeDriver();
        driver.get("https://sdet.live");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        //driver.quit(); //It closes the full browser and webdriver session
        driver.close(); //It closes the current browser window, but not browser and webdriver session remains open

    }
}
