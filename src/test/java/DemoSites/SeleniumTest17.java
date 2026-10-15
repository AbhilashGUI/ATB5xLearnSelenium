package DemoSites;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest17 {

    private static final String url = "https://automationexercise.com/";
    private static final By homepagevisible = By.xpath("//a[@href='/products']");
    private static final By productbutton = By.xpath("//a[@href='/products']");
    private static final By allproductsheading = By.xpath("//h2[normalize-space()='All Products']");
    private static final By viewproduct = By.xpath("//a[@href='/product_details/1']");
    private static final By advertisement=By.xpath("//iframe[@title='Advertisement']");
    private static final By productinformation = By.xpath("//div[contains(@class,'product-information')]");



    @Test
    @Description("Verify the product details on Automation Exercise")
    public void productdetails()
    {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));

        //Access to site
        driver.get(url);
        //Homepage
        wait.until(ExpectedConditions.visibilityOfElementLocated(homepagevisible));
        System.out.println("Homepage is visible successfully");
        //Click on product button
        wait.until(ExpectedConditions.elementToBeClickable(productbutton)).click();
        wait.until(ExpectedConditions.urlContains("/products"));
        WebElement heading=wait.until(ExpectedConditions.visibilityOfElementLocated(allproductsheading));
        System.out.println("Heading:"+heading.getText());
        //First product link is visible
        WebElement productlink=wait.until(ExpectedConditions.visibilityOfElementLocated(viewproduct));
        System.out.println("Product list is visible");
        //Scroll to view product
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                productlink);

        // Try a normal Selenium click first.
        // If an advertisement intercepts it, wait and retry.
        try {
            wait.until(ExpectedConditions.elementToBeClickable(viewproduct)).click();

        } catch (ElementClickInterceptedException e) {

            wait.until(ExpectedConditions.invisibilityOfElementLocated(advertisement));

            wait.until(ExpectedConditions.elementToBeClickable(viewproduct)).click();
        }


        wait.until(ExpectedConditions.urlContains("/product_details/"));

        WebElement productinfo = wait.until(ExpectedConditions.visibilityOfElementLocated(productinformation));



        System.out.println("Product detail page opened successfully.");


        //Verify six product details
        String productName = productinfo.findElement(By.tagName("h2")).getText();

        String category = productinfo.findElement(By.xpath(".//p[contains(.,'Category:')]")).getText();

        String price = productinfo.findElement(By.xpath(".//span/span")).getText();

        String availability = productinfo.findElement(By.xpath(".//p[contains(.,'Availability:')]")).getText();

        String condition = productinfo.findElement(By.xpath(".//p[contains(.,'Condition:')]")).getText();

        String brand = productinfo.findElement(By.xpath(".//p[contains(.,'Brand:')]")).getText();

        // Print details to the console
        System.out.println("Product Name: " + productName);
        System.out.println(category);
        System.out.println("Price: " + price);
        System.out.println(availability);
        System.out.println(condition);
        System.out.println(brand);

        // Assertions
        Assert.assertFalse(productName.trim().isEmpty(), "Product name is missing.");

        Assert.assertTrue(category.contains("Category:"), "Category is missing.");

        Assert.assertTrue(price.contains("Rs."), "Price is missing or not in the expected format.");

        Assert.assertTrue(availability.contains("Availability:"), "Availability is missing.");

        Assert.assertTrue(condition.contains("Condition:"), "Condition is missing.");

        Assert.assertTrue(brand.contains("Brand:"), "Brand is missing.");

        System.out.println("PASS: All six product details are displayed.");

        driver.quit();
    }
}
