
package DemoSites;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SeleniumTest20 {

    private static final String URL =
            "https://automationexercise.com/";

    private static final By PRODUCTS_BUTTON =
            By.xpath("//a[@href='/products']");

    private static final By PRODUCT_1_ADD_TO_CART =
            By.xpath("//a[@data-product-id='1' " +
                    "and contains(@class,'add-to-cart')]");

    private static final By PRODUCT_2_ADD_TO_CART =
            By.xpath("//a[@data-product-id='2' " +
                    "and contains(@class,'add-to-cart')]");

    private static final By CONTINUE_SHOPPING =
            By.xpath("//button[normalize-space()='Continue Shopping']");

    private static final By VIEW_CART =
            By.xpath("//a[@href='/view_cart' " +
                    "and contains(normalize-space(.),'View Cart')]");

    private static final By PRODUCT_1_CART_ROW =
            By.id("product-1");

    private static final By PRODUCT_2_CART_ROW =
            By.id("product-2");

    @Test
    @Description("Verify adding multiple products to cart")
    public void multipleProducts() {

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            // Step 1: Launch browser
            driver.manage().window().maximize();

            // Step 2: Open the website
            driver.get(URL);

            // Step 3: Navigate to Products
            wait.until(ExpectedConditions.elementToBeClickable(
                    PRODUCTS_BUTTON)).click();

            wait.until(ExpectedConditions.urlContains("/products"));

            System.out.println("PASS: Products page opened.");

            // Step 4: Add product 1 to cart
            wait.until(ExpectedConditions.elementToBeClickable(
                    PRODUCT_1_ADD_TO_CART)).click();

            // Step 5: Wait for the add-to-cart modal
            wait.until(ExpectedConditions.elementToBeClickable(
                    CONTINUE_SHOPPING)).click();

            // Step 6: Wait for the modal to close
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    CONTINUE_SHOPPING));

            // Step 7: Add product 2 to cart
            wait.until(ExpectedConditions.elementToBeClickable(
                    PRODUCT_2_ADD_TO_CART)).click();

            // Step 8: Open the cart from the modal
            wait.until(ExpectedConditions.elementToBeClickable(
                    VIEW_CART)).click();

            wait.until(ExpectedConditions.urlContains("/view_cart"));

            // Step 9: Verify product 1 is in the cart
            WebElement product1 = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            PRODUCT_1_CART_ROW));

            Assert.assertTrue(
                    product1.isDisplayed(),
                    "Product 1 is not displayed in the cart."
            );

            String product1Details = product1.getText();
            System.out.println("Product 1 details:\n" + product1Details);

            // Step 10: Verify product 2 is in the cart
            WebElement product2 = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            PRODUCT_2_CART_ROW));

            Assert.assertTrue(
                    product2.isDisplayed(),
                    "Product 2 is not displayed in the cart."
            );

            String product2Details = product2.getText();
            System.out.println("Product 2 details:\n" + product2Details);

            // Step 11: Verify both cart rows are present
            List<WebElement> cartProducts =
                    driver.findElements(
                            By.xpath("//tr[starts-with(@id,'product-')]"));

            Assert.assertEquals(
                    cartProducts.size(),
                    2,
                    "Expected exactly two products in the cart."
            );

            System.out.println(
                    "PASS: Both products are present in the cart."
            );

        } finally {
            // Always close the browser
            driver.quit();
        }
    }
}

