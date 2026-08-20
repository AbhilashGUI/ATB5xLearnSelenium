package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class Selenium03 {

    @Test
    public void optioncheck()
    {
        EdgeOptions edgeoptions= new EdgeOptions();
        //edgeoptions.addArguments("/headless");  //UI is hidden, but the execution remains same
        edgeoptions.addExtensions(new File("C:\\Users\\Abhilash Sharma\\OneDrive\\Desktop\\The Testing Academy\\AdBlock1.crx"));
        WebDriver driver= new EdgeDriver(edgeoptions);
        driver.get("https://youtube.com");
        System.out.println(driver.getTitle());
        driver.quit();

  //Can create a video and ss of running also

    }
}