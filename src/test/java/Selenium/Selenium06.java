package Selenium;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class Selenium06 {


    @Test
    public void pagestrategy1()
    {
        EdgeOptions  edgeOptions= new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver=new EdgeDriver();
        driver.get("https://in.bookmyshow.com");
        System.out.println(driver.getTitle());
        driver.quit();

    }

    @Test
    public void pagestrategy2()
    {
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        WebDriver driver2= new ChromeDriver();
        driver2.get("https://open.spotify.com");
        System.out.println(driver2.getTitle());
        driver2.quit();
    }

    @Test
    public void pagestrategy3()
    {
        FirefoxOptions firefoxOptions=new FirefoxOptions();
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        WebDriver driver3= new FirefoxDriver();
        driver3.get("https://www.airtelxstream.in/");
        System.out.println(driver3.getTitle());
        driver3.quit();
    }
}