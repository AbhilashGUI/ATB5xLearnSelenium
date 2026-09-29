package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg6 {

    @Test(groups = "QA")
    @Description("Verify the input field automation practice")
    public void ReadOnlyInputField()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/input-fields");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Input Field Automation Practice | QA Playground | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/input-fields");

        //<input id="readonlyInput" data-testid="input-readonly" class="input-fields-module__pJ4Qbq__practiceInput input-fields-module__pJ4Qbq__inputReadonly" readonly="" aria-label="Readonly input" type="text" value="Read-only content">

        WebElement Readonlyfield= driver.findElement(By.id("readonlyInput"));
        String value=Readonlyfield.getAttribute("readonly");
        System.out.println("Readonly attribute "+value);

        driver.quit();

    }

    @Test(groups = "QA")
    @Description("Verify the same in other browser")
    public void readonlyinputfield()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/input-fields");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Input Field Automation Practice | QA Playground | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/input-fields");

        //<input id="readonlyInput" data-testid="input-readonly" class="input-fields-module__pJ4Qbq__practiceInput input-fields-module__pJ4Qbq__inputReadonly" readonly="" aria-label="Readonly input" type="text" value="Read-only content">

        WebElement Readonlyfield= driver.findElement(By.xpath("//input[@id='readonlyInput']"));

        Assert.assertTrue(Readonlyfield.getAttribute("readonly") !=null,"Field is not read-only");
        driver.quit();
    }
}
