package Selenium;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Selenium02 {

    public static void main(String[] args)
    {


        /*Searchcontext interface has 2 functions
        Webdriver interface has several functions
        Remotewebdriver classes has several functions
        Chromedriver, Edgedriver,IEdriver, Filefoxdriver classes has respective browsers
         */


        //Selenium-Arch- API

        // interface interfaceRef = new Class();
        //  1. Inheritance
        //  2. Upcasting -> Dynamic Dispatch

        // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        // Max -> Selenium 4

//        WebDriver driver = new EdgeDriver();
//        WebDriver driver2 = new ChromeDriver();
//        WebDriver driver3 = new FirefoxDriver();
//        WebDriver driver4 = new InternetExplorerDriver();
//        WebDriver driver5 = new SafariDriver();

        // Opera - Selenium 4- Removed!

        SearchContext driver= new EdgeDriver();  //DD
        WebDriver driver1= new ChromeDriver();
        RemoteWebDriver driver2= new EdgeDriver();

         EdgeDriver driver3= new EdgeDriver(); //Cannot reuse the driver reference/instance
         WebDriver driver4= new ChromeDriver();
         driver4= new InternetExplorerDriver();  //can able to reuse the driver instance/reference

    }
}
