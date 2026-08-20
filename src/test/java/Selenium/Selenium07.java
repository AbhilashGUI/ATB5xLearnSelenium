package Selenium;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;



public class Selenium07 {

    @Test
    public void Testproxyserver()
    {
        Proxy proxy= new Proxy();
        proxy.setHttpProxy("39.68.66.152,1080");
        EdgeOptions edgeOptions=new EdgeOptions();
        edgeOptions.setCapability("proxy",proxy);
        WebDriver driver= new EdgeDriver();
        driver.get("https://geonode.com/free-proxy-list");
        System.out.println(driver.getTitle());
        driver.quit();


    }
}