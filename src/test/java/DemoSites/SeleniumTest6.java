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

public class SeleniumTest6 {

    private static String url="https://www.saucedemo.com/";
    private static final By username=By.id("user-name");
    private static final By password=By.id("password");
    private static final By login=By.id("login-button");
    private static final By sort=By.xpath("//select[@aria-label='Sort products']");
    private static final By addtocart1=By.id("add-to-cart-sauce-labs-fleece-jacket");
    private static final By addtocart2=By.id("add-to-cart-sauce-labs-backpack");
    private static final By addtocart3=By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private static final By addtocart4=By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    private static final By addtocart5=By.id("add-to-cart-sauce-labs-bike-light");
    private static final By addtocart6=By.id("add-to-cart-sauce-labs-onesie");
    private static final By carticonclick=By.xpath("//a[@data-test='shopping-cart-link']");
    private static final By checkout=By.id("checkout");
    private static final By firstname=By.id("first-name");
    private static final By lastname=By.id("last-name");
    private static final By zipcode=By.id("postal-code");
    private static final By Continue=By.id("continue");
    private static final By Finish=By.id("finish");
    private static final By Orderacknowledge=By.id("checkout_complete_container");
    private static final By generatepdf=By.id("generate-pdf-order");


    @Test
    @Description("Verify the purchase of multiple products flow and generate the pdf ")
    public void positiveflow()
    {
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();

        //Login
        driver.get(url);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys("standard_user");
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys("secret_sauce");
        wait.until(ExpectedConditions.elementToBeClickable(login)).click();
        System.out.println("Logged-in successfully");

        //Sort
        WebElement sortpriceh2l=wait.until(ExpectedConditions.visibilityOfElementLocated(sort));
        new Select(sortpriceh2l).selectByIndex(3);
        System.out.println("Sorted as expected");

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        System.out.println("Scrolled down");
        actions.sendKeys(Keys.HOME).perform();
        System.out.println("Scrolled up");

        //Add products to cart
        wait.until(ExpectedConditions.elementToBeClickable(addtocart1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addtocart2)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addtocart3)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addtocart4)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addtocart5)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addtocart6)).click();
        System.out.println("All items are added to cart");

        //Carticon
        wait.until(ExpectedConditions.elementToBeClickable(carticonclick)).click();
        System.out.println("Able to view all products");

        //checkout
        wait.until(ExpectedConditions.elementToBeClickable(checkout)).click();

        //Form fill
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstname)).sendKeys("Abhilash");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastname)).sendKeys("Sharma");
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipcode)).sendKeys("520010");

        //Procced
        wait.until(ExpectedConditions.elementToBeClickable(Continue)).click();

        //Finish
        wait.until(ExpectedConditions.elementToBeClickable(Finish)).click();
        System.out.println("Loggedin successfully");

        WebElement confirmationcheck=wait.until(ExpectedConditions.visibilityOfElementLocated(Orderacknowledge));
        Assert.assertEquals(confirmationcheck.getText(),"Thank you for your order!\n" +
                "Your order has been dispatched, and will arrive just as fast as the pony can get there!\n" +
                "Back Home\n" +
                "Generate PDF order");

        //Generateorder
        wait.until(ExpectedConditions.elementToBeClickable(generatepdf)).click();
        System.out.println("PDF is saved in local");

        driver.quit();
    }

}