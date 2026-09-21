package  Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Selenium09 {


    @Test
    public void Navigatefundtions()
    {


        //driver.get("https://chatgpt.com/");
        //Since navigation has several functions/control commands, exploring the same below

        WebDriver driver=new EdgeDriver();
        driver.navigate().to("https://chatgpt.com/");
        driver.manage().window().maximize();
        driver.navigate().to("https://gemini.google.com/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();

    }


    }
