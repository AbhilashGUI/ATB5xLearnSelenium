package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg64 {


    @Test
    @Description("Verify the Form Automation Practice")
    public void Personaldetailsform() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://qaplayground.com/practice/forms");
        driver.manage().window().maximize();

        //<input id="firstName" type="text" placeholder="First name" data-testid="input-first-name" class="forms-module__ZLwUJq__input " aria-required="true" name="firstName" value="">

        WebElement firstname = driver.findElement(By.id("firstName"));
        firstname.sendKeys("Abhilash");

        //<input id="lastName" type="text" placeholder="Last name" data-testid="input-last-name" class="forms-module__ZLwUJq__input " aria-required="true" name="lastName" value="">

        WebElement lastname = driver.findElement(By.name("lastName"));
        lastname.sendKeys("Sharma");

        //<input id="phone" type="tel" placeholder="10-digit number" data-testid="input-phone" class="forms-module__ZLwUJq__input " aria-required="true" name="phone" value="">

        WebElement phonenumber = driver.findElement(By.xpath("//input[@placeholder='10-digit number']"));
        phonenumber.sendKeys("2569863147");


        //<input id="dob" type="date" data-testid="input-dob" class="forms-module__ZLwUJq__input " aria-required="true" name="dob" value="">

        WebElement DOB = driver.findElement(By.xpath("//input[@data-testid='input-dob']"));
        DOB.sendKeys("14-07-2021");


        //<input id="gender-male" type="radio" data-testid="radio-gender-male" data-gender="male" class="forms-module__ZLwUJq__radioInput" name="gender" value="male">

        WebElement gender = driver.findElement(By.xpath("//input[@type='radio']"));
        gender.click();


        //<button id="personalSubmitBtn" type="submit" data-testid="btn-personal-submit" class="forms-module__ZLwUJq__submitBtn">Save Details</button>

        WebElement savedetails = driver.findElement(By.xpath("//button[text()='Save Details']"));
        savedetails.click();

        //<div id="personalResult" data-testid="result-personal" class="forms-module__ZLwUJq__successBanner" role="status">Saved: Abhilash Sharma</div>

        WebElement savedtext = driver.findElement(By.xpath("//div[@role='status']"));
        System.out.println(savedtext.getText());
        Assert.assertEquals(savedtext.getText(), "Saved: Abhilash Sharma");

        Thread.sleep(2000);

        driver.quit();

    }

    @Test
    @Description("Verify the invalid scenario")
    public void invalidcheck() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://qaplayground.com/practice/forms");
        driver.manage().window().maximize();

        //<input id="firstName" type="text" placeholder="First name" data-testid="input-first-name" class="forms-module__ZLwUJq__input " aria-required="true" name="firstName" value="">

        WebElement firstname = driver.findElement(By.id("firstName"));
        firstname.sendKeys("Abhilash");

        //<input id="lastName" type="text" placeholder="Last name" data-testid="input-last-name" class="forms-module__ZLwUJq__input " aria-required="true" name="lastName" value="">

        WebElement lastname = driver.findElement(By.name("lastName"));
        lastname.sendKeys("Sharma");

        //<input id="phone" type="tel" placeholder="10-digit number" data-testid="input-phone" class="forms-module__ZLwUJq__input " aria-required="true" name="phone" value="">

        WebElement phonenumber = driver.findElement(By.xpath("//input[@placeholder='10-digit number']"));
        phonenumber.sendKeys("2569863147");


        //<input id="dob" type="date" data-testid="input-dob" class="forms-module__ZLwUJq__input " aria-required="true" name="dob" value="">

        WebElement DOB = driver.findElement(By.xpath("//input[@data-testid='input-dob']"));
        DOB.sendKeys("");


        //<input id="gender-male" type="radio" data-testid="radio-gender-male" data-gender="male" class="forms-module__ZLwUJq__radioInput" name="gender" value="male">

        WebElement gender = driver.findElement(By.xpath("//input[@type='radio']"));
        gender.click();


        //<button id="personalSubmitBtn" type="submit" data-testid="btn-personal-submit" class="forms-module__ZLwUJq__submitBtn">Save Details</button>

        WebElement savedetails = driver.findElement(By.xpath("//button[text()='Save Details']"));
        savedetails.click();


        //<span id="dobError" data-testid="error-dob" class="forms-module__ZLwUJq__errorMsg" role="alert">Date of birth is required.</span>
        WebElement errortext = driver.findElement(By.id("dobError"));
        System.out.println(errortext);

        Thread.sleep(2000);

        driver.quit();

    }


    @Test
    @Description("Verify the Form Automation practice")
    public void invalidcheck2() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaplayground.com/practice/forms");
        driver.manage().window().maximize();

        //<input id="firstName" type="text" placeholder="First name" data-testid="input-first-name" class="forms-module__ZLwUJq__input " aria-required="true" name="firstName" value="">

        WebElement firstname = driver.findElement(By.id("firstName"));
        firstname.sendKeys("Abhilash");

        //<input id="lastName" type="text" placeholder="Last name" data-testid="input-last-name" class="forms-module__ZLwUJq__input " aria-required="true" name="lastName" value="">

        WebElement lastname = driver.findElement(By.name("lastName"));
        lastname.sendKeys("Sharma");

        //<input id="phone" type="tel" placeholder="10-digit number" data-testid="input-phone" class="forms-module__ZLwUJq__input " aria-required="true" name="phone" value="">

        WebElement phonenumber = driver.findElement(By.xpath("//input[@placeholder='10-digit number']"));
        phonenumber.sendKeys("2569863147");


        //<input id="dob" type="date" data-testid="input-dob" class="forms-module__ZLwUJq__input " aria-required="true" name="dob" value="">

        WebElement DOB = driver.findElement(By.xpath("//input[@data-testid='input-dob']"));
        DOB.sendKeys("14-07-2021");


        //<input id="gender-male" type="radio" data-testid="radio-gender-male" data-gender="male" class="forms-module__ZLwUJq__radioInput" name="gender" value="male">

        WebElement gender = driver.findElement(By.xpath("//input[@type='radio']"));
        gender.click();


        //<button id="personalSubmitBtn" type="submit" data-testid="btn-personal-submit" class="forms-module__ZLwUJq__submitBtn">Save Details</button>

        WebElement savedetails = driver.findElement(By.xpath("//button[text()='Save Details']"));
        savedetails.click();


        Thread.sleep(2000);

        //<button type="button" data-testid="btn-personal-reset" class="forms-module__ZLwUJq__resetBtn">Reset</button>
        WebElement resetbutton = driver.findElement(By.xpath("//button[@data-testid='btn-personal-reset']"));
        resetbutton.click();

        Thread.sleep(2000);

        driver.quit();


    }
}



