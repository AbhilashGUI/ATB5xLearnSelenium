package DemoSites;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest10 {

    private static final String url="https://www.saucedemo.com/";
    private static final By username=By.id("user-name");
    private static final By password=By.id("password");
    private static final By login=By.id("login-button");
//<div class="inventory_item_description" data-test="inventory-item-description"><div class="inventory_item_label"><a href="#" id="item_4_title_link" data-test="item-4-title-link" role="button" aria-label="View details for Sauce Labs Backpack"><div class="inventory_item_name " data-test="inventory-item-name">Sauce Labs Backpack</div></a><div class="inventory_item_desc" data-test="inventory-item-desc">carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.</div></div><div class="pricebar"><div class="inventory_item_price" data-test="inventory-item-price">$61.58</div><button class="btn btn_primary btn_small btn_inventory " data-test="add-to-cart-sauce-labs-backpack" id="add-to-cart-sauce-labs-backpack" name="add-to-cart-sauce-labs-backpack">Add to cart</button></div></div>
    private static final By product1=By.xpath("//div[@class='inventory_item_description']");
//<div class="inventory_item_name " data-test="inventory-item-name">Sauce Labs Backpack</div>
    private static final By productpick=By.xpath("//div[text()='Sauce Labs Backpack']");
    //<button class="btn btn_primary btn_small btn_inventory" data-test="add-to-cart" id="add-to-cart" name="add-to-cart">Add to cart</button>
    private static final By addtocart=By.id("add-to-cart");
//<div class="inventory_details_desc_container"><div class="inventory_details_name large_size" data-test="inventory-item-name">Sauce Labs Backpack</div><div class="inventory_details_desc large_size" data-test="inventory-item-desc">carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.</div><div class="inventory_details_price" data-test="inventory-item-price">$29.99</div><button class="btn btn_secondary btn_small btn_inventory" data-test="remove" id="remove" name="remove">Remove</button></div>
    private static final By Recheckproduct=By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]");
    private static final By carticon=By.xpath("//a[@data-test='shopping-cart-link']");
    private static final By checkout=By.id("checkout");
    private static final By firstname=By.id("first-name");
    private static final By lastname=By.id("last-name");
    private static final By zipcode=By.id("postal-code");
    private static final By Continue=By.id("continue");
    private static final By Finish=By.id("finish");
    private static final By Menu=By.id("react-burger-menu-btn");
    private static final By Logout=By.id("logout_sidebar_link");


    @Test
    @Description("Verify the purchase flow with the visual issue user")
    public void Issueuser3()
    {
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();

        //Login
        driver.get(url);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys("visual_user");
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys("secret_sauce");
        wait.until(ExpectedConditions.elementToBeClickable(login)).click();
        System.out.println("Logged in successfully");

        //product price view
        String product1details=wait.until(ExpectedConditions.visibilityOfElementLocated(product1)).getText();
        System.out.println("Check the pricedetails: "+product1details);


        //productpick
        wait.until(ExpectedConditions.elementToBeClickable(productpick)).click();


        //add to cart
        wait.until(ExpectedConditions.elementToBeClickable(addtocart)).click();


        //carticon
        wait.until(ExpectedConditions.elementToBeClickable(carticon)).click();
        System.out.println("Issue1: Cart Icon is an UI issue");



        //Recheck product details
        String recheckproductdetails =wait.until(ExpectedConditions.visibilityOfElementLocated(Recheckproduct)).getText();
        System.out.println("Recheck the price details: "+recheckproductdetails);

        //checkout
        wait.until(ExpectedConditions.elementToBeClickable(checkout)).click();
        System.out.println("Issue2: Checkout button is placed at the top header");

        //Form Filling
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstname)).sendKeys("Shashank");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastname)).sendKeys("raj");
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipcode)).sendKeys("569874");

        //continue
        wait.until(ExpectedConditions.elementToBeClickable(Continue)).click();

       //finish
        wait.until(ExpectedConditions.elementToBeClickable(Finish)).click();
        System.out.println("Order placed successfully");

      //Menu
        wait.until(ExpectedConditions.visibilityOfElementLocated(Menu)).click();
        System.out.println("Issue 3 : Menu bar is an UI Issue");

        //Logout
        wait.until(ExpectedConditions.elementToBeClickable(Logout)).click();
        System.out.println("Logged-out successfully");
        driver.quit();


    }



}
