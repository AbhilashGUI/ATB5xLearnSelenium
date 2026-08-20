package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Selenium08 {

    @Test
    public void close()
    {
        WebDriver driver= new EdgeDriver();
        driver.get("https://www.naukri.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.close(); //It closes the current browser window and other window remains open

    }

    @Test
    public void quit()
    {
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.naukri.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.quit(); //It closes the browser
    }

}