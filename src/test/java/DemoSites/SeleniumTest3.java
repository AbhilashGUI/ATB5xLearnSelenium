package DemoSites;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SeleniumTest3 {

    @Test
    @Description("Verify the login checks")
    public void error_user()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        //<input class="input_error form_input" placeholder="Username" aria-label="Username" data-test="username" id="user-name" autocorrect="off" autocapitalize="none" type="text" value="" name="user-name">

        WebElement username=driver.findElement(By.id("user-name"));
        username.sendKeys("error_user");

        //<input class="input_error form_input" placeholder="Password" aria-label="Password" data-test="password" id="password" autocorrect="off" autocapitalize="none" type="password" value="" name="password">

        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");


        //<input class="submit-button btn_action" data-test="login-button" id="login-button" type="submit" value="Login" name="login-button">

        WebElement loginbutton=driver.findElement(By.name("login-button"));
        loginbutton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //<div class="inventory_item_name " data-test="inventory-item-name">Sauce Labs Backpack</div>

        WebElement Firstproduct=driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        Firstproduct.click();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Identified the issue above the price , that there is no content available");

        driver.quit();

    }

    @Test
    @Description("Verify the login checks")
    public void visual_user()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        //<input class="input_error form_input" placeholder="Username" aria-label="Username" data-test="username" id="user-name" autocorrect="off" autocapitalize="none" type="text" value="" name="user-name">

        WebElement username=driver.findElement(By.id("user-name"));
        username.sendKeys("visual_user");


        //<input class="input_error form_input" placeholder="Password" aria-label="Password" data-test="password" id="password" autocorrect="off" autocapitalize="none" type="password" value="" name="password">

        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");


        //<input class="submit-button btn_action" data-test="login-button" id="login-button" type="submit" value="Login" name="login-button">

        WebElement loginbutton=driver.findElement(By.id("login-button"));
        loginbutton.click();

        //<html lang="en"><head>
        WebElement scrollbar=driver.findElement(By.xpath("//html[@lang='en']"));

        Actions actions=new Actions(driver);
        System.out.println("Scrolled down");
        //Scrolldown
        actions.moveToElement(scrollbar).sendKeys(org.openqa.selenium.Keys.END).perform();

        //Scrollup
        actions.moveToElement(scrollbar).sendKeys(org.openqa.selenium.Keys.HOME).perform();
        System.out.println("Scrolled up");

        System.out.println("Noticed the visual issues and prices are quoted incorrect for products displayed");

        driver.quit();


    }
}
