package DemoSites;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;

public class SeleniumTest4 {


    private static final String url = "https://www.saucedemo.com/";
    //id="user-name"
    private static final By Username = By.id("user-name");
    //id="password"
    private static final By Password = By.id("password");
    //id="login-button"
    private static final By Loginbuttn = By.id("login-button");
    //id="react-burger-menu-btn"
    private static final By Menubutton = By.id("react-burger-menu-btn");
    //id="dynamic_catalog_sidebar_link"
    private static final By Dynamiccatalog = By.id("dynamic_catalog_sidebar_link");
    //id="dynamic_catalog_lazy_load_link"
    private static final By Lazyload = By.id("dynamic_catalog_lazy_load_link");
    //id="about_sidebar_link"
    private static final By Aboutclick = By.id("about_sidebar_link");

    //Resuable login method

    private void login(WebDriver driver, WebDriverWait wait)
    {
      driver.get(url);
      wait.until(ExpectedConditions.visibilityOfElementLocated(Username)).sendKeys("standard_user");
      driver.findElement(Password).sendKeys("secret_sauce");
      driver.findElement(Loginbuttn).click();
     //Verify successful login
        wait.until(ExpectedConditions.urlContains("inventory.html"));
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"),"Login failed: inventory page was not opened");
    }

    @Test
    @Description("Verify dynamic catalog and lazy load navigation")
    public void Dashboardaccess()
    {
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        //Login
        login(driver,wait);
        System.out.println("Login successful");
        //open sidebar
        wait.until(ExpectedConditions.elementToBeClickable(Menubutton)).click();
        //open dynamic catalog
        wait.until(ExpectedConditions.elementToBeClickable(Dynamiccatalog)).click();
        //open lazy load
        wait.until(ExpectedConditions.elementToBeClickable(Lazyload)).click();
        System.out.println("Lazy load option is clicked");
        //Scroll down and up using keyboard

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        System.out.println("Scrolled down");
        actions.sendKeys(Keys.HOME).perform();
        System.out.println("Scrolled up");
        driver.quit();

    }

   @Test
   @Description("Verify about navigation from the sidebar")
   public void Dasboardaccess2() {
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();

       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       //Login
       login(driver, wait);
       //Open sidebar
       wait.until(ExpectedConditions.elementToBeClickable(Menubutton)).click();
       //Click About only once
       wait.until(ExpectedConditions.elementToBeClickable(Aboutclick)).click();
       //Verify navigation to saucelabs
       wait.until(ExpectedConditions.urlContains("saucedemo.com"));
       Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo.com"), "About Navigation Failed");
       System.out.println("About navigation successful");
       driver.quit();
   }
   }
