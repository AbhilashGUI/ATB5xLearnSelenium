package Selenium;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Selenium06 {

    public static void main(String[] args)
    {

        EdgeOptions edgeOptions= new EdgeOptions();
        //TMS
        //edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        //edgeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        WebDriver driver= new EdgeDriver();
        driver.get("https://sdet.live");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
