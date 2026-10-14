package DemoSites;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SeleniumTest16 {

    @Test
    @Description("Verify Contactus form")
    public void formfilling() throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();


        WebElement contactus=driver.findElement(By.xpath("//a[@href='/contact_us']"));
        contactus.click();

        WebElement Text=driver.findElement(By.xpath("//h2[normalize-space()='Get In Touch']"));
        System.out.println(Text.getText());

        WebElement name=driver.findElement(By.xpath("//input[@data-qa='name']"));
        name.sendKeys("Abhilash");

        WebElement email=driver.findElement(By.xpath("//input[@data-qa='email']"));
        email.sendKeys("abhilash486@gmail.com");

        WebElement subject=driver.findElement(By.xpath("//input[@data-qa='subject']"));
        subject.sendKeys("Would like to list some of my products");

        WebElement textarea=driver.findElement(By.xpath("//textarea[@data-qa='message']"));
        textarea.sendKeys("Reach me on 9632514782");

        WebElement uploadfile=driver.findElement(By.xpath("//input[@name='upload_file']"));
        uploadfile.sendKeys("C:\\Users\\Abhilash Sharma\\OneDrive\\Desktop\\Downloads\\invoice.txt");

        WebElement submitbutton=driver.findElement(By.xpath("//input[@data-qa='submit-button']"));
        submitbutton.click();

        Thread.sleep(2000);

        WebElement confirmationtext=driver.findElement(By.xpath("//div[text()='Success! Your details have been submitted successfully.']"));
        Assert.assertEquals(confirmationtext.getText(),"Success! Your details have been submitted successfully.");
        System.out.println(confirmationtext.getText());

        //Home:<span><i class="fa fa-angle-double-left"></i> Home</span>
        WebElement homebutton=driver.findElement(By.xpath("//a[@class='btn btn-success']"));
        homebutton.click();

        System.out.println("landed back to homepage successfully");

        driver.quit();

    }

    @Test
    @Description("Verify the Test cases page")
    public void testcaseview()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();

        WebElement testcase=driver.findElement(By.xpath("//a[@href='/test_cases']"));
        testcase.click();

        WebElement testcasetext=driver.findElement(By.xpath("//h2[@class='title text-center']"));
        System.out.println(testcasetext.getText());
        Assert.assertEquals(testcasetext.getText(),"TEST CASES");

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        System.out.println("Scrolled down");
        actions.sendKeys(Keys.HOME).perform();
        System.out.println("Scrolled up");
        System.out.println("Reviewed test cases");
        driver.quit();

    }

    @Test
    @Description("Verify the API testcases page")
    public void testcaseview2()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();

        WebElement testcase=driver.findElement(By.xpath("//a[@href='/api_list']"));
        testcase.click();

        String testcasestext=driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();
        System.out.println("Shown as Expected: "+testcasestext);
        Assert.assertEquals(testcasestext,"FEATURES ITEMS");

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        System.out.println("Scrolled down");
        actions.sendKeys(Keys.HOME).perform();
        System.out.println("Scrolled up");

        System.out.println("Listed 14 test cases");
        driver.quit();
    }

}
