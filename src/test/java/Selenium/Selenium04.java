package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class Selenium04 {

    @Test

    public void exploreoptions1() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");  //Browser is handling the window size
        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://echallan.tspolice.gov.in");
        driver.quit();
    }

    @Test
    public void exploreoptions2() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--window-size=800,600");
        WebDriver driver1 = new ChromeDriver(chromeOptions);
        driver1.get("https://echallan.tspolice.gov.in");
        driver1.quit();
    }

    @Test
    public void exploreoptions3()
    {
        FirefoxOptions firefoxOptions= new FirefoxOptions();
        firefoxOptions.addArguments("--incognito");
        WebDriver driver2=new FirefoxDriver(firefoxOptions);
        driver2.get("https://echallan.tspolice.gov.in");
        driver2.quit();
    }

}
