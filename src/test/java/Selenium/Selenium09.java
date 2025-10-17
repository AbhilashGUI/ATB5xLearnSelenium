package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium09 {

    public static void main(String[] args)
    {

        WebDriver driver = new EdgeDriver();
        //driver.get("https://app.vwo.com");
        //Navigate has the functions like forward and back

        driver.navigate().to("https://app.vwo.com");
        driver.navigate().to("https://google.com");
        driver.navigate().forward();
        driver.navigate().back();
        driver.navigate().refresh();



    }
}
