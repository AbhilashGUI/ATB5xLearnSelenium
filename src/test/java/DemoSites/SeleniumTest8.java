package DemoSites;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest8 {

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


    @Test
    @Description("Verify the flow with the problem user")
    public void Issueuser()
    {
        WebDriver driver=new FirefoxDriver();
        driver.manage().window().maximize();
        //login
        driver.get(url);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys("problem_user");
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys("secret_sauce");
        wait.until(ExpectedConditions.elementToBeClickable(login)).click();
        System.out.println("LoggedIn successfully");
        System.out.println("By-default a cart is seen with an count 1 ");


        //addtocart
        wait.until(ExpectedConditions.elementToBeClickable(addtocart)).click();

        //carticon
        wait.until(ExpectedConditions.elementToBeClickable(carticon)).click();

        //Continue
        wait.until(ExpectedConditions.elementToBeClickable(checkout)).click();

        //Form filling
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstname)).sendKeys("Rohith");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastname)).sendKeys("Sharma");
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipcode)).sendKeys("365987");

       //continue
        wait.until(ExpectedConditions.elementToBeClickable(Continue)).click();

        //<div class="error-message-container error"><h3 data-test="error" role="alert"><button type="button" class="error-button" data-test="error-button" aria-label="Dismiss error"><svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="xmark" class="svg-inline--fa fa-xmark" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 384 512"><path fill="currentColor" d="M342.6 150.6c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0L192 210.7 86.6 105.4c-12.5-12.5-32.8-12.5-45.3 0s-12.5 32.8 0 45.3L146.7 256 41.4 361.4c-12.5 12.5-12.5 32.8 0 45.3s32.8 12.5 45.3 0L192 301.3 297.4 406.6c12.5 12.5 32.8 12.5 45.3 0s12.5-32.8 0-45.3L237.3 256 342.6 150.6z"></path></svg></button>Error: Last Name is required</h3></div>
        WebElement errormessage=driver.findElement(By.xpath("//div[@class='error-message-container error']"));
        System.out.println(errormessage.getText());
        Assert.assertEquals(errormessage.getText(),"Error: Last Name is required");

        driver.quit();


    }
}
