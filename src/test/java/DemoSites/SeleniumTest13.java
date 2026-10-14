package DemoSites;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest13 {



        private static final String URL = "https://automationexercise.com/";

        private static final By LOGIN = By.xpath("//a[@href='/login']");

        private static final By EMAIL = By.xpath("//input[@data-qa='login-email']");

        private static final By PASSWORD = By.xpath("//input[@data-qa='login-password']");

        private static final By LOGIN_BUTTON = By.xpath("//button[@data-qa='login-button']");

        private static final By WOMEN = By.xpath("//a[@href='#Women']");

        private static final By SAREES = By.xpath("//a[@href='/category_products/7']");

        private static final By VIEW_PRODUCT = By.xpath("//a[@href='/product_details/39']");

        private static final By QUANTITY = By.id("quantity");

        private static final By ADD_TO_CART = By.xpath("//button[normalize-space()='Add to cart']");

        private static final By CART_MODAL = By.xpath("//div[contains(@class,'modal-content')]");

        private static final By VIEW_CART = By.xpath("//a[contains(.,'View Cart')]");

        private static final By PROCEED_TO_CHECKOUT = By.xpath("//a[contains(@class,'check_out')]");

        private static final By DELIVERY_ADDRESS = By.id("address_delivery");

        private static final By MESSAGE = By.name("message");

        private static final By PLACE_ORDER = By.xpath("//a[@href='/payment']");

        private static final By CARD_NAME = By.name("name_on_card");
        private static final By CARD_NUMBER = By.name("card_number");
        private static final By CVC = By.name("cvc");

        private static final By EXPIRY_MONTH = By.xpath("//input[@data-qa='expiry-month']");

        private static final By EXPIRY_YEAR = By.xpath("//input[@data-qa='expiry-year']");

        private static final By PAY_BUTTON = By.id("submit");

        private static final By ORDER_CONFIRMATION = By.xpath("//p[normalize-space()='Congratulations! Your order has been confirmed!']");

        private static final By DOWNLOAD_INVOICE = By.xpath("//a[contains(.,'Download Invoice')]");

        private static final By CONTINUE = By.xpath("//a[@data-qa='continue-button']");

        private static final By LOGOUT = By.xpath("//a[@href='/logout']");


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
        public void case1() {

            WebDriver driver = new ChromeDriver();

            try {
                driver.manage().window().maximize();

                WebDriverWait wait =
                        new WebDriverWait(driver, Duration.ofSeconds(15));

                // 1. Login
                driver.get(URL);

                wait.until(
                        ExpectedConditions.elementToBeClickable(LOGIN)).click();

                wait.until(
                                ExpectedConditions.visibilityOfElementLocated(EMAIL))
                        .sendKeys("vemulaabhilash7@gmail.com");

                wait.until(
                                ExpectedConditions.visibilityOfElementLocated(PASSWORD))
                        .sendKeys("Testcheck123");

                wait.until(
                                ExpectedConditions.elementToBeClickable(LOGIN_BUTTON))
                        .click();

                // Verify login by waiting for the logout link.
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(LOGOUT));

                System.out.println("Logged in successfully");

                // 2. Select Women > Sarees
                wait.until(
                        ExpectedConditions.elementToBeClickable(WOMEN)).click();

                dismissAlertIfPresent(driver);

                clickWithFallback(driver, wait, SAREES);

                // 3. Open the product
                wait.until(
                                ExpectedConditions.elementToBeClickable(VIEW_PRODUCT))
                        .click();

                WebElement quantityField = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(QUANTITY));

                System.out.println(
                        "Product quantity: "
                                + quantityField.getDomProperty("value"));

                // 4. Add to cart
                wait.until(
                                ExpectedConditions.elementToBeClickable(ADD_TO_CART))
                        .click();

                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(CART_MODAL));

                // Open cart from the modal.
                wait.until(
                        ExpectedConditions.elementToBeClickable(VIEW_CART)).click();

                // 5. Checkout
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                PROCEED_TO_CHECKOUT)).click();

                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                DELIVERY_ADDRESS));

                wait.until(
                                ExpectedConditions.visibilityOfElementLocated(MESSAGE))
                        .sendKeys("Checked");

                wait.until(
                                ExpectedConditions.elementToBeClickable(PLACE_ORDER))
                        .click();

                // 6. Payment
                wait.until(
                                ExpectedConditions.visibilityOfElementLocated(CARD_NAME))
                        .sendKeys("Test");

                wait.until(
                                ExpectedConditions.visibilityOfElementLocated(CARD_NUMBER))
                        .sendKeys("1259864787654321");

                wait.until(
                                ExpectedConditions.visibilityOfElementLocated(CVC))
                        .sendKeys("123");

                wait.until(
                                ExpectedConditions.visibilityOfElementLocated(EXPIRY_MONTH))
                        .sendKeys("10");

                wait.until(
                                ExpectedConditions.visibilityOfElementLocated(EXPIRY_YEAR))
                        .sendKeys("2027");

                wait.until(
                        ExpectedConditions.elementToBeClickable(PAY_BUTTON)).click();

                // 7. Verify order confirmation
                String confirmation = wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                ORDER_CONFIRMATION)).getText();

                Assert.assertEquals(
                        confirmation,
                        "Congratulations! Your order has been confirmed!",
                        "Order confirmation message is incorrect");

                System.out.println("Order placed successfully");

                // 8. Download invoice
                wait.until(
                                ExpectedConditions.elementToBeClickable(DOWNLOAD_INVOICE))
                        .click();

                // 9. Continue and logout
                wait.until(
                        ExpectedConditions.elementToBeClickable(CONTINUE)).click();

                wait.until(
                        ExpectedConditions.elementToBeClickable(LOGOUT)).click();

                // Verify logout
                wait.until(
                        ExpectedConditions.elementToBeClickable(LOGIN));

                System.out.println("Logged out successfully");

            } finally {
                driver.quit();
            }
        }
    }

