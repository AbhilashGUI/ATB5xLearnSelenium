package DemoSites;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest14 {

      private static final String url="https://automationexercise.com/";
      private static final By login= By.xpath("//a[@href='/login']");
      private static final By email=By.xpath("//input[@data-qa='login-email']");
      private static final By password=By.xpath("//input[@data-qa='login-password']");
      private static final By loginbutton=By.xpath("//button[@data-qa='login-button']");
      private static final By kids=By.xpath("//a[@href='#Kids']");
      private static final By dress=By.xpath("//a[@href='/category_products/4']");
      private static final By viewproduct=By.xpath("//a[@href='/product_details/20']");
      private static final By quantity=By.id("quantity");
      private static final By addtocart=By.xpath("//button[normalize-space()='Add to cart']");
      private static final By cartmodal=By.xpath("//div[contains(@class,'modal-content')]");
      private static final By viewcart=By.xpath("//a[contains(.,'View Cart')]");
      private static final By proccedtocheckout=By.xpath("//a[contains(@class,'check_out')]");
      private static final By deliveryaddress=By.id("address_delivery");
      private static final By message=By.name("message");
      private static final By placeorder=By.xpath("//a[@href='/payment']");
      private static final By cardname=By.name("name_on_card");
      private static final By cardnumber=By.name("card_number");
      private static final By cardcvc=By.name("cvc");
      private static final By expirtymonth=By.xpath("//input[@data-qa='expiry-month']");
      private static final By expiryyear=By.xpath("//input[@data-qa='expiry-year']");
      private static final By paybutton=By.id("submit");
      private static final By orderconfirmation=By.xpath("//p[normalize-space()='Congratulations! Your order has been confirmed!']");
      private static final By downloadinvoice=By.xpath("//a[contains(.,'Download Invoice')]");
      private static final By Continue=By.xpath("//a[@data-qa='continue-button']");
      private static final By logout=By.xpath("//a[@href='/logout']");

    private void dismissAlertIfPresent(WebDriver driver) {
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("JavaScript alert: " + alert.getText());
            alert.dismiss();
        } catch (NoAlertPresentException ignored) {
            // No JavaScript alert is present.
        }
    }


    private void clickWithFallback(
            WebDriver driver,
            WebDriverWait wait,
            By locator) {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(locator));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                element);

        try {
            wait.until(
                    ExpectedConditions.elementToBeClickable(locator)).click();

        } catch (ElementClickInterceptedException e) {
            System.out.println(
                    "Click intercepted for " + locator
                            + ". Trying JavaScript click.");

            element = wait.until(
                    ExpectedConditions.presenceOfElementLocated(locator));

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();", element);
        }
    }

    @Test
    @Description("Verify the purchase flow and logout")
    public void case1()
    {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        //login
        driver.get(url);
        wait.until(ExpectedConditions.elementToBeClickable(login)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys("vemulaabhilash7@gmail.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys("Testcheck123");
        wait.until(ExpectedConditions.elementToBeClickable(loginbutton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(logout));
        System.out.println("Logged-in successfully");

        // 2. Select men > Tshirts

        wait.until(ExpectedConditions.elementToBeClickable(kids)).click();
        dismissAlertIfPresent(driver);

        clickWithFallback(driver, wait, dress);


        //Product check
        wait.until(ExpectedConditions.elementToBeClickable(viewproduct)).click();
        WebElement quantitycheck =wait.until(ExpectedConditions.visibilityOfElementLocated(quantity));
        System.out.println("Product quantity: " + quantitycheck.getDomProperty("value"));

        //Add to cart
        wait.until(ExpectedConditions.elementToBeClickable(addtocart)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartmodal));

        //opencart
        wait.until(ExpectedConditions.elementToBeClickable(viewcart)).click();

        //checkout
        wait.until(ExpectedConditions.elementToBeClickable(proccedtocheckout)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryaddress));
        wait.until(ExpectedConditions.visibilityOfElementLocated(message)).sendKeys("verified");
        wait.until(ExpectedConditions.elementToBeClickable(placeorder)).click();

        //paymentdetails
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardname)).sendKeys("Abhilash");
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardnumber)).sendKeys("45464113131");
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardcvc)).sendKeys("456");
        wait.until(ExpectedConditions.visibilityOfElementLocated(expirtymonth)).sendKeys("05");
        wait.until(ExpectedConditions.visibilityOfElementLocated(expiryyear)).sendKeys("2028");
        wait.until(ExpectedConditions.visibilityOfElementLocated(paybutton)).click();

        //Orderconfirmatin
        String confirmation=wait.until(ExpectedConditions.visibilityOfElementLocated(orderconfirmation)).getText();
        Assert.assertEquals(confirmation,"Congratulations! Your order has been confirmed!");

        System.out.println(confirmation);

        //Downloadinvoice
        wait.until(ExpectedConditions.elementToBeClickable(downloadinvoice)).click();

        //continue and logout
        wait.until(ExpectedConditions.elementToBeClickable(Continue)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logout)).click();

        //Verify login
        wait.until(ExpectedConditions.elementToBeClickable(login));

        System.out.println("Logged out successfully");
        driver.quit();


    }
    }

