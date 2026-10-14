package DemoSites;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTest19 {

    @Test
    @Description("Verify the subscription in the homepage")
    public void subscribe()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        System.out.println("Scrolled down");

        String subscriptiontext=driver.findElement(By.xpath("//h2[text()='Subscription']")).getText();
        System.out.println(subscriptiontext);

        WebElement emailaddress=driver.findElement(By.id("susbscribe_email"));
        emailaddress.sendKeys("abhilash@gmail.com");

        WebElement submitbutton=driver.findElement(By.id("subscribe"));
        submitbutton.click();

        driver.quit();
    }

    @Test
    @Description("Verify the subscription in the cart page")
    public void subscribe2()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();

        WebElement carticon=driver.findElement(By.xpath("//a[@href='/view_cart']"));
        carticon.click();

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        System.out.println("Scrolled down");

        String subscriptiontext=driver.findElement(By.xpath("//h2[normalize-space()='Subscription']")).getText();
        System.out.println(subscriptiontext);
        Assert.assertEquals(subscriptiontext,"SUBSCRIPTION");

        WebElement emailaddress=driver.findElement(By.id("susbscribe_email"));
        emailaddress.sendKeys("abhilash4@gmail.com");

        WebElement submitbutton=driver.findElement(By.id("subscribe"));
        submitbutton.click();

        driver.quit();


    }
}
