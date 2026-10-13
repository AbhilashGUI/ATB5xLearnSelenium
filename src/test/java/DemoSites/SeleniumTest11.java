package DemoSites;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest11 {

    private static String url = "https://automationexercise.com/";
    private static final By signup = By.xpath("//a[@href='/login']");
    private static final By name = By.xpath("//input[@data-qa='signup-name']");
    private static final By emailaddress = By.xpath("//input[@data-qa='signup-email']");
    private static final By signupbutton = By.xpath("//button[@data-qa='signup-button']");
    private static final By title=By.id("id_gender1");
    private static final By password = By.id("password");
    private static final By selectday = By.id("days");
    private static final By selectmonth = By.id("months");
    private static final By selectyears = By.id("years");
    private static final By checkbox1 = By.id("newsletter");
    private static final By checkbox2 = By.id("optin");
    private static final By firstname = By.id("first_name");
    private static final By lastname = By.id("last_name");
    private static final By address = By.id("address1");
    private static final By selectcountry = By.id("country");
    private static final By state = By.id("state");
    private static final By city = By.id("city");
    private static final By zipcode = By.id("zipcode");
    private static final By mobilenumber = By.id("mobile_number");
    private static final By createaccount = By.xpath("//button[@data-qa='create-account']");
    private static final By accountcreationmessage = By.xpath("//h2[@data-qa='account-created']");
    private static final By Continuebutton = By.xpath("//a[@data-qa='continue-button'] ");
    private static final By usernamecheck = By.xpath("//a[contains(.,'Logged in as')]/b");
    private static final By deleteaccount = By.xpath("//a[@href='/delete_account']");
    private static final By deletemessage=By.xpath("//h2[@data-qa='account-deleted']");


    @Test
    @Description("Verify the Account Registration")
    public void Registration()
    {
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();

        //Login
        driver.get(url);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(signup)).click();
        //Use a unique email for each run
        String email="vemulaabhilash"+System.currentTimeMillis()+"@gmail.com";
        wait.until(ExpectedConditions.visibilityOfElementLocated(name)).sendKeys("Abhilash");
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailaddress)).sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(signupbutton)).click();;
        //Fill account information
        wait.until(ExpectedConditions.elementToBeClickable(title)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys("Testcheck123");
        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(selectday))).selectByValue("14");
        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(selectmonth))).selectByIndex(5);
        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(selectyears))).selectByValue("2008");
        wait.until(ExpectedConditions.elementToBeClickable(checkbox1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(checkbox2)).click();

        //Address information
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstname)).sendKeys("Suresh");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastname)).sendKeys("Raina");
        wait.until(ExpectedConditions.visibilityOfElementLocated(address)).sendKeys("Thane");
        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(selectcountry))).selectByValue("India");
        wait.until(ExpectedConditions.visibilityOfElementLocated(state)).sendKeys("Maharashtra");
        wait.until(ExpectedConditions.visibilityOfElementLocated(city)).sendKeys("Mumbai");
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipcode)).sendKeys("536278");
        wait.until(ExpectedConditions.visibilityOfElementLocated(mobilenumber)).sendKeys("6589741258");
        wait.until(ExpectedConditions.elementToBeClickable(createaccount)).click();
        //Account creation check
        String Messagecheck=wait.until(ExpectedConditions.visibilityOfElementLocated(accountcreationmessage)).getText();
        Assert.assertEquals(Messagecheck,"ACCOUNT CREATED!");

        System.out.println("Account creation is successful");
        System.out.println("Registration email :"+email);

        //Continue to homepage

        wait.until(ExpectedConditions.elementToBeClickable(Continuebutton)).click();

        String username=wait.until(ExpectedConditions.visibilityOfElementLocated(usernamecheck)).getText();
        System.out.println("Username: "+username);

        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteaccount)).click();
        String deleteconfirmation=wait.until(ExpectedConditions.visibilityOfElementLocated(deletemessage)).getText();
        System.out.println("Status of account :"+deleteconfirmation);
        System.out.println("Account is deleted successfully");
        driver.quit();

    }
}











