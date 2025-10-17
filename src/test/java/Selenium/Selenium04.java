package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Selenium04 {

    public static void main(String[] args)
    {

        EdgeOptions edgeOptions= new EdgeOptions();
        edgeOptions.addArguments("--start-maximized"); //Directly operates by the browser
        //edgeOptions.addArguments("--window-size=800,600"); //Minimize check
        //edgeOptions.addArguments("--incognito");
        WebDriver driver= new EdgeDriver(edgeOptions);
        driver.get("https://youtube.com");
        driver.quit();

       // driver.manage().window().maximize(); //Operates by the driver
    }
}
