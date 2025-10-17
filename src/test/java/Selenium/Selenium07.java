package Selenium;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Selenium07 {

    @Test
            public void testproxyserver()
    {

        Proxy proxy= new Proxy();
        //proxy.setHttpProxy("<HTTP:PORT>");
        proxy.setHttpProxy("178.253.197.186 :4153");
        EdgeOptions options= new EdgeOptions();
        options.setCapability("proxy",proxy);
        WebDriver driver= new EdgeDriver();
        driver.get("https://sdet.live");
        driver.quit();



    }



    }

