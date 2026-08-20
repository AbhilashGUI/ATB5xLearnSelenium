package Selenium;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium01 {

    public static void main(String[] args)
    {

        WebDriver driver= new EdgeDriver();
        driver.get("https://flipkart.com");
        driver.quit();

        WebDriver driver1=new ChromeDriver();
        driver1.get("https://flipkart.com");
        driver1.quit();
    }

}

