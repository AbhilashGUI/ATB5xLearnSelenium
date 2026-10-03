package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg63 {

    @Test
    @Description("Verify the Form Automation Practice")
    public void Loginform() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://qaplayground.com/practice/forms");
        driver.manage().window().maximize();

        //<input id="login-email" placeholder="you@example.com" data-testid="input-login-email" class="forms-module__ZLwUJq__input " aria-required="true" type="email" value="" name="email">

        WebElement Emailinputbox = driver.findElement(By.id("login-email"));
        Emailinputbox.sendKeys("Abhi@gmail.com");

        //<input id="login-password" placeholder="Enter password" class="forms-module__ZLwUJq__input " aria-required="true" type="password" value="" name="password">
        WebElement Passwordinputbox = driver.findElement(By.name("password"));
        Passwordinputbox.sendKeys("testcheck");


        //<button id="loginSubmitBtn" type="submit" data-testid="btn-login-submit" class="forms-module__ZLwUJq__submitBtn">Login</button>
        WebElement login = driver.findElement(By.xpath("//button[@data-testid='btn-login-submit']"));
        login.click();

        Assert.assertTrue(login.isDisplayed(), "Login is successful");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //<div id="loginResult" data-testid="result-login" class="forms-module__ZLwUJq__successBanner" role="alert">Login successful! Welcome, Abhi@gmail.com.</div>

        WebElement loginresult = driver.findElement(By.xpath("//div[@id='loginResult']"));
        Assert.assertEquals(loginresult.getText(), "Login successful! Welcome, Abhi@gmail.com.");

        driver.quit();

    }


    @Test
    @Description("Verify the invalid scenario")
    public void Invalidlogin1() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaplayground.com/practice/forms");
        driver.manage().window().maximize();

        //<input id="login-email" placeholder="you@example.com" data-testid="input-login-email" class="forms-module__ZLwUJq__input " aria-required="true" type="email" value="" name="email">

        WebElement emailinput = driver.findElement(By.xpath("//input[@id='login-email']"));
        emailinput.sendKeys("abhi@gmail.com");

        //<input id="login-password" placeholder="Enter password" class="forms-module__ZLwUJq__input " aria-required="true" type="password" value="" name="password">
        WebElement passwordinput = driver.findElement(By.xpath("//input[@type='password']"));
        passwordinput.sendKeys("");

        //<button id="loginSubmitBtn" type="submit" data-testid="btn-login-submit" class="forms-module__ZLwUJq__submitBtn">Login</button>

        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        Thread.sleep(2000);


        //<span id="loginPasswordError" data-testid="error-login-password" class="forms-module__ZLwUJq__errorMsg" role="alert">Password is required.</span>
        WebElement errormessage = driver.findElement(By.xpath("//span[@id='loginPasswordError']"));
        System.out.println(errormessage.getText());

        driver.quit();

    }

    @Test
    @Description("Verify the invalid scenario")
    public void Invalidlogin2() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://qaplayground.com/practice/forms");
        driver.manage().window().maximize();

        //<input id="login-email" placeholder="you@example.com" data-testid="input-login-email" class="forms-module__ZLwUJq__input " aria-required="true" type="email" value="" name="email">

        WebElement emailinput = driver.findElement(By.xpath("//input[@id='login-email']"));
        emailinput.sendKeys("");

        //<input id="login-password" placeholder="Enter password" class="forms-module__ZLwUJq__input " aria-required="true" type="password" value="" name="password">
        WebElement passwordinput = driver.findElement(By.xpath("//input[@type='password']"));
        passwordinput.sendKeys("testcheck");

        //<button id="loginSubmitBtn" type="submit" data-testid="btn-login-submit" class="forms-module__ZLwUJq__submitBtn">Login</button>

        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        Thread.sleep(2000);

//<span id="loginEmailError" data-testid="error-login-email" class="forms-module__ZLwUJq__errorMsg" role="alert">Email is required.</span>
        WebElement errormessage = driver.findElement(By.xpath("//span[@id='loginEmailError']"));
        System.out.println(errormessage.getText());

        driver.quit();

    }

    @Test
    @Description("Verify the invalid scenario")
    public void Invalidlogin3() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaplayground.com/practice/forms");
        driver.manage().window().maximize();

        //<input id="login-email" placeholder="you@example.com" data-testid="input-login-email" class="forms-module__ZLwUJq__input " aria-required="true" type="email" value="" name="email">

        WebElement emailinput = driver.findElement(By.xpath("//input[@id='login-email']"));
        emailinput.sendKeys("");

        //<input id="login-password" placeholder="Enter password" class="forms-module__ZLwUJq__input " aria-required="true" type="password" value="" name="password">
        WebElement passwordinput = driver.findElement(By.xpath("//input[@type='password']"));
        passwordinput.sendKeys("");

        //<button id="loginSubmitBtn" type="submit" data-testid="btn-login-submit" class="forms-module__ZLwUJq__submitBtn">Login</button>

        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        Thread.sleep(2000);

//<span id="loginEmailError" data-testid="error-login-email" class="forms-module__ZLwUJq__errorMsg" role="alert">Email is required.</span>
        WebElement errormessage = driver.findElement(By.xpath("//span[@id='loginEmailError']"));
        System.out.println(errormessage.getText());

        //<span id="loginPasswordError" data-testid="error-login-password" class="forms-module__ZLwUJq__errorMsg" role="alert">Password is required.</span>
        WebElement errormessage2 = driver.findElement(By.xpath("//span[@id='loginPasswordError']"));
        System.out.println(errormessage2.getText());


        driver.quit();

    }

    @Test
    @Description("Verify the invalid scenario")
    public void Invalidlogin4() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://qaplayground.com/practice/forms");
        driver.manage().window().maximize();

        //<input id="login-email" placeholder="you@example.com" data-testid="input-login-email" class="forms-module__ZLwUJq__input " aria-required="true" type="email" value="" name="email">

        WebElement emailinput = driver.findElement(By.xpath("//input[@id='login-email']"));
        emailinput.sendKeys("Abhi@gmail.com");

        //<input id="login-password" placeholder="Enter password" class="forms-module__ZLwUJq__input " aria-required="true" type="password" value="" name="password">
        WebElement passwordinput = driver.findElement(By.xpath("//input[@type='password']"));
        passwordinput.sendKeys("Testcheck");

//<button id="loginResetBtn" type="button" data-testid="btn-login-reset" class="forms-module__ZLwUJq__resetBtn">Reset</button>
        WebElement Reset = driver.findElement(By.xpath("//button[@data-testid='btn-login-reset']"));
        Reset.click();
        Thread.sleep(2000);

//<span id="loginEmailError" data-testid="error-login-email" class="forms-module__ZLwUJq__errorMsg" role="alert">Email is required.</span>
        WebElement errormessage = driver.findElement(By.xpath("//span[@id='loginEmailError']"));
        System.out.println(errormessage.getText());

        //<span id="loginPasswordError" data-testid="error-login-password" class="forms-module__ZLwUJq__errorMsg" role="alert">Password is required.</span>
        WebElement errormessage2 = driver.findElement(By.xpath("//span[@id='loginPasswordError']"));
        System.out.println(errormessage2.getText());

        driver.quit();

    }
}