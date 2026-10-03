package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Seleniumpg67 {

    @Test
    @Description("Verify the Form Automation Practice")
    public void AccountSetup() throws InterruptedException {

        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/forms");
        driver.manage().window().maximize();

        //<input id="password" type="password" placeholder="Min. 6 characters" data-testid="input-password" class="forms-module__ZLwUJq__input forms-module__ZLwUJq__inputError" aria-required="true" autocomplete="new-password" name="password" value="" aria-describedby="passwordError">

        WebElement Password=driver.findElement(By.id("password"));
        Password.sendKeys("Testcheck");

        //<input id="confirmPassword" type="password" placeholder="Re-enter password" data-testid="input-confirm-password" class="forms-module__ZLwUJq__input forms-module__ZLwUJq__inputError" aria-required="true" autocomplete="new-password" name="confirmPassword" value="" aria-describedby="confirmPasswordError">

        WebElement ConfirmPassword=driver.findElement(By.xpath("//input[@placeholder='Re-enter password']"));
        ConfirmPassword.sendKeys("Testcheck");

        //<input id="terms" type="checkbox" data-testid="checkbox-terms" class="forms-module__ZLwUJq__checkboxInput" name="terms">

        WebElement checkbox=driver.findElement(By.xpath("//input[@data-testid='checkbox-terms']"));
        checkbox.click();


        //<button id="submitFormBtn" type="submit" data-testid="submit-form-btn" data-cta="submit" class="forms-module__ZLwUJq__submitBtn">Submit</button>

         WebElement submitbutton=driver.findElement(By.id("submitFormBtn"));
         submitbutton.click();

        //<p id="submittedName" data-testid="submitted-name" class="forms-module__ZLwUJq__successBody">Your account has been secured.</p>

           WebElement successtext=driver.findElement(By.xpath("//p[@data-testid='submitted-name']"));
           System.out.println(successtext);

        //<button type="button" data-testid="btn-fill-again" class="forms-module__ZLwUJq__fillAgainBtn">Fill Again</button>

           WebElement Fillagain=driver.findElement(By.xpath("//button[@data-testid='btn-fill-again']"));
           Fillagain.click();

           Thread.sleep(2000);

        //<button id="submitFormBtn" type="submit" data-testid="submit-form-btn" data-cta="submit" class="forms-module__ZLwUJq__submitBtn">Submit</button>

          WebElement Resubmit=driver.findElement(By.xpath("//button[@id='submitFormBtn']"));
          Resubmit.click();

          Thread.sleep(2000);

        //<button id="resetFormBtn" type="button" data-testid="reset-form-btn" data-cta="reset" class="forms-module__ZLwUJq__resetBtn">Reset</button>
        WebElement resetbutton= driver.findElement(By.id("resetFormBtn"));
        resetbutton.click();

        driver.quit();

    }

    @Test
    @Description("Verify the Form Automation Practice")
    public void Invalidcred1() throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.get("https://qaplayground.com/practice/forms");
        driver.manage().window().maximize();

        //<input id="password" type="password" placeholder="Min. 6 characters" data-testid="input-password" class="forms-module__ZLwUJq__input forms-module__ZLwUJq__inputError" aria-required="true" autocomplete="new-password" name="password" value="" aria-describedby="passwordError">

        WebElement Password = driver.findElement(By.id("password"));
        Password.sendKeys("Testing");

        //<input id="confirmPassword" type="password" placeholder="Re-enter password" data-testid="input-confirm-password" class="forms-module__ZLwUJq__input forms-module__ZLwUJq__inputError" aria-required="true" autocomplete="new-password" name="confirmPassword" value="" aria-describedby="confirmPasswordError">

        WebElement ConfirmPassword=driver.findElement(By.xpath("//input[@placeholder='Re-enter password']"));
        ConfirmPassword.sendKeys("Testing");



        //<button id="submitFormBtn" type="submit" data-testid="submit-form-btn" data-cta="submit" class="forms-module__ZLwUJq__submitBtn">Submit</button>

        WebElement submitbutton = driver.findElement(By.id("submitFormBtn"));
        submitbutton.click();


        Thread.sleep(2000);

        //<span id="confirmPasswordError" data-testid="error-confirm-password" class="forms-module__ZLwUJq__errorMsg" role="alert">Please confirm your password.</span>

        WebElement errormessage=driver.findElement(By.xpath("//span[@id='confirmPasswordError']"));
        System.out.println(errormessage.getText());

        driver.quit();

    }

    @Test
    @Description("Verify the Form Automation Practice")
    public void Invalidcred2() throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.get("https://qaplayground.com/practice/forms");
        driver.manage().window().maximize();

        //<input id="password" type="password" placeholder="Min. 6 characters" data-testid="input-password" class="forms-module__ZLwUJq__input forms-module__ZLwUJq__inputError" aria-required="true" autocomplete="new-password" name="password" value="" aria-describedby="passwordError">

        WebElement Password = driver.findElement(By.id("password"));
        Password.sendKeys("Testing");

        //<input id="confirmPassword" type="password" placeholder="Re-enter password" data-testid="input-confirm-password" class="forms-module__ZLwUJq__input forms-module__ZLwUJq__inputError" aria-required="true" autocomplete="new-password" name="confirmPassword" value="" aria-describedby="confirmPasswordError">
        WebElement ConfirmPassword=driver.findElement(By.xpath("//input[@placeholder='Re-enter password']"));
        ConfirmPassword.sendKeys("Testing");




        //<button id="submitFormBtn" type="submit" data-testid="submit-form-btn" data-cta="submit" class="forms-module__ZLwUJq__submitBtn">Submit</button>

        WebElement submitbutton = driver.findElement(By.id("submitFormBtn"));
        submitbutton.click();


        Thread.sleep(2000);

     //<span id="termsError" class="forms-module__ZLwUJq__errorMsg" role="alert">You must accept the Terms &amp; Conditions.</span>

        WebElement errormessage=driver.findElement(By.xpath("//span[@id='termsError']"));
        System.out.println(errormessage.getText());

        driver.quit();

    }




}
