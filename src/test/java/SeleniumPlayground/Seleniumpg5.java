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

        //<span id="result-s05" data-testid="result-s05" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-border/50 bg-muted text-muted-foreground">Input is disabled — typing is blocked</span>

        WebElement messagecheck=driver.findElement(By.id("result-s05"));
        Assert.assertTrue(messagecheck.isDisplayed());
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

        //<span id="result-s05" data-testid="result-s05" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-border/50 bg-muted text-muted-foreground">Input is disabled — typing is blocked</span>

        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s05']"));
        Assert.assertTrue(messagecheck.isDisplayed());
        driver.quit();
    }

}

