package DemoSites;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest5 {

    private static final String url= "https://www.saucedemo.com/";
    private static final By username=By.id("user-name");
    private static final By passowrd=By.id("password");
    private static final By login=By.id("login-button");
    private static final By sort=By.xpath("//select[@aria-label='Sort products']");
    private static final By product=By.xpath("//div[text()='Sauce Labs Bike Light']");
    private static final By addtocart=By.id("add-to-cart");
    private static final By carticonclick=By.xpath("//a[@data-test='shopping-cart-link']");
    private static final By checkout=By.id("checkout");
    private static final By firstname=By.id("first-name");
    private static final By lastname=By.id("last-name");
    private static final By zipcode=By.id("postal-code");
    private static final By Continue=By.id("continue");
    private static final By finish=By.id("finish");
    private static final By backhome=By.id("back-to-products");
    private static final By menu=By.id("react-burger-menu-btn");
    private static final By Logout=By.id("logout_sidebar_link");


    @Test
    @Description("Verify Complete saucedemo purchase and logoutflow")
    public void positiveflow()
    {
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();

        //Login
        driver.get(url);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys("standard_user");
        wait.until(ExpectedConditions.visibilityOfElementLocated(passowrd)).sendKeys("secret_sauce");
        wait.until(ExpectedConditions.elementToBeClickable(login)).click();


        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        System.out.println("Loggedin successfully");

        //Sorting
        WebElement sortdropdown=wait.until(ExpectedConditions.elementToBeClickable(sort));
        new Select(sortdropdown).selectByIndex(2);

        //Click on selected product
        wait.until(ExpectedConditions.elementToBeClickable(product)).click();

        //Scroll up and down
        Actions actions= new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        System.out.println("Scrolled down");
        actions.sendKeys(Keys.HOME).perform();
        System.out.println("Scrolled up");

        //Add product to cart
        wait.until(ExpectedConditions.elementToBeClickable(addtocart)).click();

        //Opencart
        wait.until(ExpectedConditions.elementToBeClickable(carticonclick)).click();
        wait.until(ExpectedConditions.elementToBeClickable(checkout)).click();

        //Fill checkout information
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstname)).sendKeys("Abhilash");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastname)).sendKeys("Varma");
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipcode)).sendKeys("500100");

        wait.until(ExpectedConditions.elementToBeClickable(Continue)).click();

        //Finish order

        wait.until(ExpectedConditions.elementToBeClickable(finish)).click();

        Assert.assertEquals(driver.getTitle(),"Swag Labs");

        //Thank you for your order!

        System.out.println("Order placed successfully");

        //Return to inventory
        wait.until(ExpectedConditions.elementToBeClickable(backhome)).click();

        //open memu and logout
        wait.until(ExpectedConditions.elementToBeClickable(menu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Logout)).click();

        System.out.println("Logged out successfully");


        //Verify logout
        wait.until(ExpectedConditions.elementToBeClickable(login));
        Assert.assertTrue(driver.findElement(login).isDisplayed());
        driver.quit();
    }

}