package DemoSites;


import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest7 {

    private static final String url="https://www.saucedemo.com/";
    private static final By username=By.id("user-name");
    private static final By password=By.id("password");
    private static final By login=By.id("login-button");
    private static final By sort=By.xpath("//select[@aria-label='Sort products']");
    private static final By productpick=By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']");
    private static final By addtocart=By.id("add-to-cart");
    private static final By carticon=By.xpath("//a[@data-test='shopping-cart-link']");
    private static final By continueshopping=By.id("continue-shopping");
    private static final By removefromcart=By.id("remove-test.allthethings()-t-shirt-(red)");
    private static final By Repickproduct=By.xpath("//div[text()='Sauce Labs Bike Light']");
    private static final By readdproduct=By.id("add-to-cart");
    private static final By carticon2=By.xpath("//a[@data-test='shopping-cart-link']");
    private static final By checkout=By.id("checkout");
    private static final By firstname=By.id("first-name");
    private static final By lastname=By.id("last-name");
    private static final By zipcode=By.id("postal-code");
    private static final By Continue=By.id("continue");
    private static final By finish=By.id("finish");
    private static final By back2home=By.id("back-to-products");
    private static final By menu=By.id("react-burger-menu-btn");
    private static final By logout=By.id("logout_sidebar_link");


    @Test
    @Description("Verify the purchase flow with removing and readding the product")
    public void positivecheck()
    {
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();

        //Login
        driver.get(url);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys("standard_user");
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys("secret_sauce");
        wait.until(ExpectedConditions.elementToBeClickable(login)).click();
        System.out.println("Logged-IN");

        //Sort
        WebElement sortinreverse=wait.until(ExpectedConditions.visibilityOfElementLocated(sort));
        new Select(sortinreverse).selectByIndex(1);
        System.out.println("Sorted as expected");

        //product pick
        wait.until(ExpectedConditions.elementToBeClickable(productpick)).click();
        System.out.println("Picked the product");

        //add to cart
        wait.until(ExpectedConditions.elementToBeClickable(addtocart)).click();
        System.out.println("Added to cart");

        //carticon
        wait.until(ExpectedConditions.elementToBeClickable(carticon)).click();


        //continueshopping
        wait.until(ExpectedConditions.elementToBeClickable(continueshopping)).click();

        //Remove
        wait.until(ExpectedConditions.elementToBeClickable(removefromcart)).click();
        System.out.println("Removed the product from the cart");

        //repickup
        wait.until(ExpectedConditions.elementToBeClickable(Repickproduct)).click();


        //Readdproduct
        wait.until(ExpectedConditions.elementToBeClickable(readdproduct)).click();
        System.out.println("Readded the product to the cart");

        //carticon
        wait.until(ExpectedConditions.elementToBeClickable(carticon2)).click();

        //checkout
        wait.until(ExpectedConditions.elementToBeClickable(checkout)).click();

        //Firstname
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstname)).sendKeys("Abhilash");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastname)).sendKeys("Cool");
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipcode)).sendKeys("652145");


        //continue
        wait.until(ExpectedConditions.elementToBeClickable(Continue)).click();

        //finish
        wait.until(ExpectedConditions.elementToBeClickable(finish)).click();
        System.out.println("Order placed successfully");

        //b2h
        wait.until(ExpectedConditions.elementToBeClickable(back2home)).click();

        //menu
        wait.until(ExpectedConditions.elementToBeClickable(menu)).click();

        //logout
        wait.until(ExpectedConditions.elementToBeClickable(logout)).click();
        System.out.println("Logged-out successfully");

        driver.quit();



    }

}

