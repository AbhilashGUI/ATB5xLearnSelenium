package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Seleniumpg65 {


    @Test
    @Description("Verify the Form Automation Practice")
    public void AddressForm() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://qaplayground.com/practice/forms");
        driver.manage().window().maximize();

        //<select id="country" name="country" data-testid="select-country" class="forms-module__ZLwUJq__input forms-module__ZLwUJq__select forms-module__ZLwUJq__inputError" aria-required="true" aria-describedby="countryError"><option value="" selected="">Select country</option><option value="IN">India</option><option value="US">United States</option><option value="GB">United Kingdom</option><option value="AU">Australia</option><option value="CA">Canada</option><option value="DE">Germany</option><option value="JP">Japan</option><option value="SG">Singapore</option></select>

        Select selectcountry = new Select(driver.findElement(By.id("country")));
        selectcountry.selectByIndex(1);

        //<input id="city" type="text" placeholder="Enter city" data-testid="input-city" class="forms-module__ZLwUJq__input forms-module__ZLwUJq__inputError" aria-required="true" name="city" value="" aria-describedby="cityError">

        WebElement entercity = driver.findElement(By.name("city"));
        entercity.sendKeys("Hyderabad");


        //<textarea id="bio" name="bio" rows="3" placeholder="Tell us a little about yourself…" class="forms-module__ZLwUJq__input forms-module__ZLwUJq__textarea"></textarea>

        WebElement textarea = driver.findElement(By.xpath("//textarea[@placeholder='Tell us a little about yourself…']"));
        textarea.sendKeys("Test check");


        //<button id="addressSubmitBtn" type="submit" data-testid="btn-address-submit" class="forms-module__ZLwUJq__submitBtn">Save Address</button>

        WebElement Saveaddress = driver.findElement(By.xpath("//button[@data-testid='btn-address-submit']"));
        Saveaddress.click();

        Thread.sleep(2000);

        //<div id="addressResult" data-testid="result-address" class="forms-module__ZLwUJq__successBanner" role="status">Address saved: Hyderabad, India</div>

        WebElement Savedaddress = driver.findElement(By.xpath("//div[@role='status']"));
        System.out.println(Savedaddress.getText());

        driver.quit();


    }


    @Test
    @Description("Verify the Form Automation Practice")
    public void InvalidAddressForm() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaplayground.com/practice/forms");
        driver.manage().window().maximize();

        //<select id="country" name="country" data-testid="select-country" class="forms-module__ZLwUJq__input forms-module__ZLwUJq__select forms-module__ZLwUJq__inputError" aria-required="true" aria-describedby="countryError"><option value="" selected="">Select country</option><option value="IN">India</option><option value="US">United States</option><option value="GB">United Kingdom</option><option value="AU">Australia</option><option value="CA">Canada</option><option value="DE">Germany</option><option value="JP">Japan</option><option value="SG">Singapore</option></select>

        Select selectcountry = new Select(driver.findElement(By.id("country")));
        selectcountry.selectByValue("");

        //<input id="city" type="text" placeholder="Enter city" data-testid="input-city" class="forms-module__ZLwUJq__input forms-module__ZLwUJq__inputError" aria-required="true" name="city" value="" aria-describedby="cityError">

        WebElement entercity = driver.findElement(By.name("city"));
        entercity.sendKeys("Hyderabad");


        //<textarea id="bio" name="bio" rows="3" placeholder="Tell us a little about yourself…" class="forms-module__ZLwUJq__input forms-module__ZLwUJq__textarea"></textarea>

        WebElement textarea = driver.findElement(By.xpath("//textarea[@placeholder='Tell us a little about yourself…']"));
        textarea.sendKeys("Test check");


        //<button id="addressSubmitBtn" type="submit" data-testid="btn-address-submit" class="forms-module__ZLwUJq__submitBtn">Save Address</button>

        WebElement Saveaddress = driver.findElement(By.xpath("//button[@data-testid='btn-address-submit']"));
        Saveaddress.click();

        Thread.sleep(2000);


       //<span id="countryError" data-testid="error-country" class="forms-module__ZLwUJq__errorMsg" role="alert">Please select a country.</span>

        WebElement errortext=driver.findElement(By.xpath("//span[@id='countryError']"));
        System.out.println(errortext.getText());



        driver.quit();
    }
}