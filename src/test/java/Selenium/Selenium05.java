package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Selenium05 {

    @Test
    public void testbrowsers() {
        WebDriver driver1 = new EdgeDriver();
        driver1.get("https://youtube.com");
        driver1.quit();
        WebDriver driver2 = new EdgeDriver();
        driver2.get("https://sdet.live");
        driver2.quit();

    }
}