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

        //<span id="result-s06" data-testid="result-s06" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-border/50 bg-muted text-muted-foreground">Readonly — value can be read but not edited</span>

        WebElement messagecheck=driver.findElement(By.id("result-s06"));
        Assert.assertTrue(messagecheck.isDisplayed());
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

        //<span id="result-s06" data-testid="result-s06" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-border/50 bg-muted text-muted-foreground">Readonly — value can be read but not edited</span>

        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s06']a"));
        Assert.assertTrue(messagecheck.isDisplayed());
        driver.quit();
    }
}
