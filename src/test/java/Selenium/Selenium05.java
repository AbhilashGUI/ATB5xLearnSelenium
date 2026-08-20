package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Selenium05 {


    @Test
    public void maximizingwindow()
    {
        //WebDriver driver= new EdgeDriver();
        ChromeDriver driver1=new ChromeDriver();
        driver1.manage().window().maximize();
        driver1.get("https://Linkedin.com");
        driver1.close();

    }
}