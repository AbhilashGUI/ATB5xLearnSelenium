package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg5 {

    @Test(groups = "QA")
    @Description("Verify the input field automation practice")
    public void DisabledInputfield() throws InterruptedException {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/input-fields");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/input-fields");
        Assert.assertEquals(driver.getTitle(),"Input Field Automation Practice | QA Playground | QA Playground");

        //<input id="disabledInput" data-testid="input-disabled" type="text" class="input-fields-module__pJ4Qbq__practiceInput" disabled="" aria-label="Disabled input" value="You can't type here">

        WebElement disabledfield= driver.findElement(By.id("disabledInput"));
        boolean enabled=disabledfield.isEnabled();
        System.out.println("Is the field enabled? "+enabled);

        Thread.sleep(2000);

        driver.quit();
    }


    @Test(groups = "QA")
    @Description("Verify the same in other browser")
    public void disabledinputfield() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/input-fields");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/input-fields");
        Assert.assertEquals(driver.getTitle(),"Input Field Automation Practice | QA Playground | QA Playground");


        //<input id="disabledInput" data-testid="input-disabled" type="text" class="input-fields-module__pJ4Qbq__practiceInput" disabled="" aria-label="Disabled input" value="You can't type here">

        WebElement disableinput= driver.findElement(By.xpath("//input[@id='disabledInput']"));
        Assert.assertFalse(disableinput.isEnabled());

        Thread.sleep(2000);
        driver.quit();
    }

}

