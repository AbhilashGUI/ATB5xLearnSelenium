package DemoSites;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTest2 {

    @Test
    @Description("Verify the login checks")
    public void Locked_out_user()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        //<input class="input_error form_input error" placeholder="Username" aria-label="Username" data-test="username" id="user-name" autocorrect="off" autocapitalize="none" type="text" value="locked_out_user" name="user-name">

        WebElement username=driver.findElement(By.id("user-name"));
        username.sendKeys("locked_out_user");

        //<input class="input_error form_input error" placeholder="Password" aria-label="Password" data-test="password" id="password" autocorrect="off" autocapitalize="none" type="password" value="secret_sauce" name="password">

        WebElement password=driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");


        //<input class="submit-button btn_action" data-test="login-button" id="login-button" type="submit" value="Login" name="login-button">
        WebElement loginbutton=driver.findElement(By.id("login-button"));
        loginbutton.click();


        //<h3 data-test="error" role="alert"><button type="button" class="error-button" data-test="error-button" aria-label="Dismiss error"><svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="xmark" class="svg-inline--fa fa-xmark" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 384 512"><path fill="currentColor" d="M342.6 150.6c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0L192 210.7 86.6 105.4c-12.5-12.5-32.8-12.5-45.3 0s-12.5 32.8 0 45.3L146.7 256 41.4 361.4c-12.5 12.5-12.5 32.8 0 45.3s32.8 12.5 45.3 0L192 301.3 297.4 406.6c12.5 12.5 32.8 12.5 45.3 0s12.5-32.8 0-45.3L237.3 256 342.6 150.6z"></path></svg></button>Epic sadface: Sorry, this user has been locked out.</h3>
        WebElement errortext=driver.findElement(By.xpath("//h3[@role='alert']"));
        System.out.println(errortext.getText());

        driver.quit();

    }

    @Test
    @Description("Verify the login checks")
    public void problem_user()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        //<input class="input_error form_input" placeholder="Username" aria-label="Username" data-test="username" id="user-name" autocorrect="off" autocapitalize="none" type="text" value="" name="user-name">
        WebElement username=driver.findElement(By.id("user-name"));
        username.sendKeys("problem_user");

        //<input class="input_error form_input" placeholder="Password" aria-label="Password" data-test="password" id="password" autocorrect="off" autocapitalize="none" type="password" value="" name="password">
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        //<input class="submit-button btn_action" data-test="login-button" id="login-button" type="submit" value="Login" name="login-button">
        WebElement loginbutton=driver.findElement(By.id("login-button"));
        loginbutton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Notice the UI Issue");

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"),"Working as expected");

        Actions actions=new Actions(driver);

        WebElement scrollbar=driver.findElement(By.xpath("//html[@lang='en']"));

        //Scrolldown
        actions.moveToElement(scrollbar).sendKeys(org.openqa.selenium.Keys.END).perform();

        System.out.println("Scrolled to down");

        //Scrollup
        actions.moveToElement(scrollbar).sendKeys(org.openqa.selenium.Keys.HOME).perform();

        System.out.println("Scrolled to the top");
        driver.quit();

    }

    @Test
    @Description("Verify the login checks")
    public void performance_glitch_user()
    {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        //<input class="input_error form_input" placeholder="Username" aria-label="Username" data-test="username" id="user-name" autocorrect="off" autocapitalize="none" type="text" value="" name="user-name">
        WebElement username=driver.findElement(By.id("user-name"));
        username.sendKeys("performance_glitch_user");

        //<input class="input_error form_input" placeholder="Password" aria-label="Password" data-test="password" id="password" autocorrect="off" autocapitalize="none" type="password" value="" name="password">
        WebElement password=driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");

        //<input class="submit-button btn_action" data-test="login-button" id="login-button" type="submit" value="Login" name="login-button">
        WebElement loginbutton=driver.findElement(By.name("login-button"));
        loginbutton.click();

        System.out.println("Latency in redirecting to Dashboard");

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"),"Working as expected");


        //<button type="button" id="react-burger-menu-btn" style="position: absolute; left: 0px; top: 0px; z-index: 1; width: 100%; height: 100%; margin: 0px; padding: 0px; border-width: medium; border-style: none; border-color: currentcolor; border-image: none; font-size: 0px; background: transparent; cursor: pointer;">Open Menu</button>
        WebElement loggingout=driver.findElement(By.id("react-burger-menu-btn"));
        loggingout.click();

        //<a id="logout_sidebar_link" class="bm-item menu-item" href="#" data-test="logout-sidebar-link" role="button" style="display: block;">Logout</a>

         WebElement logoutbutton=driver.findElement(By.id("logout_sidebar_link"));
         logoutbutton.click();


    }



}
