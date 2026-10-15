package DemoSites;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SeleniumTest18{

private static final String url="https://automationexercise.com/";
private static final By productsbutton=By.xpath("//a[@href='/products']");
private static final By productsheading=By.xpath("//h2[normalize-space()='All Products']");
private static final By searchbox=By.id("search_product");
private static final By searchsubmit=By.id("submit_search");
private static final By searchedproductheading=By.xpath("//h2[text()='Searched Products']");
private static final By productcard=By.xpath("//div[@class='product-image-wrapper']");

@Test
@Description("Verify product search via text")
public void productsearch()
{
    WebDriver driver=new EdgeDriver();
    driver.manage().window().maximize();

    //Login
    driver.get(url);
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    //productbutton
    wait.until(ExpectedConditions.elementToBeClickable(productsbutton)).click();
    WebElement heading=wait.until(ExpectedConditions.visibilityOfElementLocated(productsheading));
    System.out.println(heading.getText());
    System.out.println("Able to view all products.");
    //Textarea
    wait.until(ExpectedConditions.visibilityOfElementLocated(searchbox)).sendKeys("Tshirts");
    wait.until(ExpectedConditions.elementToBeClickable(searchsubmit)).click();
    //searchheading
    WebElement searchedheading=wait.until(ExpectedConditions.visibilityOfElementLocated(searchedproductheading));
    System.out.println(searchedheading+"Searched Products heading is displayed");
    wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(productcard,0));
    List<WebElement> productcards=driver.findElements(productcard);
    Assert.assertFalse(productcards.isEmpty(), "No products were returned by the search.");

    System.out.println("Number of product cards displayed: " + productcards.size());
    for (WebElement card : productcards) {
        WebElement name = card.findElement(
                By.xpath(".//div[contains(@class,'productinfo')]//p"));

        String productname = name.getText().trim();

        if (!productname.isEmpty()) {
            System.out.println("Product: " + productname);
        }
    }

    System.out.println("Product search completed.");
    driver.quit();

}

        }


