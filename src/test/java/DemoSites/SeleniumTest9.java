package DemoSites;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest9 {

    private static final String url="https://www.saucedemo.com/";
    private static final By username=By.id("user-name");
    private static final By password=By.id("password");
    private static final By login=By.id("login-button");
    private static final By addtocart=By.id("add-to-cart-sauce-labs-backpack");
    private static final By carticon=By.xpath("//a[@data-test='shopping-cart-link']");
    private static final By checkout=By.id("checkout");
    private static final By firstname=By.id("first-name");
    private static final By lastname=By.id("last-name");
    private static final By zipcode=By.id("postal-code");
    private static final By Continue=By.id("continue");
    private static final By Finish=By.id("finish");

    @Test
    @Description("Verify the flow with the error user")
    public void Issueuser2()
    {
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();

        //login
        driver.get(url);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys("error_user");
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys("secret_sauce");
        wait.until(ExpectedConditions.elementToBeClickable(login)).click();
        System.out.println("Logged-In");
        System.out.println("By-default a cart is seen with an count 1 ");

        //addtocart
        wait.until(ExpectedConditions.elementToBeClickable(addtocart)).click();

        //carticon
        wait.until(ExpectedConditions.elementToBeClickable(carticon)).click();

        //checkout
        wait.until(ExpectedConditions.elementToBeClickable(checkout)).click();

        //Form Filling

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstname)).sendKeys("Dhoni");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastname)).sendKeys("Raina");
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipcode)).sendKeys("632514");

        //Continue
        wait.until(ExpectedConditions.elementToBeClickable(Continue)).click();

        //finish
        wait.until(ExpectedConditions.elementToBeClickable(Finish)).click();
        System.out.println("Finish button is not clickable/disabled");
        driver.quit();





    }
}
