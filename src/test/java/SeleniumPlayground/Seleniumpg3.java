package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg3 {


    @Test(groups = "QA")
    @Description("Input field automation practice")
    public void ReadTheFieldValue()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/input-fields");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"Input Field Automation Practice | QA Playground | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/input-fields");

        //<input id="readValueInput" data-testid="input-read-value" class="input-fields-module__pJ4Qbq__practiceInput input-fields-module__pJ4Qbq__inputReadonly" readonly="" aria-label="Field with a value to read" type="text" value="The Matrix">

        WebElement readvalue=driver.findElement(By.id("readValueInput"));
        System.out.println(readvalue.getAttribute("value"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //<button type="button" id="readValueBtn" data-testid="btn-read-value" class="input-fields-module__pJ4Qbq__actionBtn input-fields-module__pJ4Qbq__actionBtnOutline">Read Value</button>
        WebElement valuebutton= driver.findElement(By.id("readValueBtn"));
        valuebutton.click();

     //<span id="result-s03" data-testid="result-s03" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-border/50 bg-muted text-muted-foreground">Value: —</span>

        WebElement messagecheck=driver.findElement(By.id("result-s03"));
        Assert.assertTrue(messagecheck.isDisplayed());

        driver.quit();

    }

    @Test(groups = "QA")
    @Description("Verify the same in other browser")
    public void readthefieldvalue()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/input-fields");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"Input Field Automation Practice | QA Playground | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/input-fields");


        //<input id="readValueInput" data-testid="input-read-value" class="input-fields-module__pJ4Qbq__practiceInput input-fields-module__pJ4Qbq__inputReadonly" readonly="" aria-label="Field with a value to read" type="text" value="The Matrix">

        WebElement readvalue= driver.findElement(By.xpath("//input[@id='readValueInput']"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //<button type="button" id="readValueBtn" data-testid="btn-read-value" class="input-fields-module__pJ4Qbq__actionBtn input-fields-module__pJ4Qbq__actionBtnOutline">Read Value</button>

        WebElement valuebutton=driver.findElement(By.xpath("//button[text()='Read Value']"));
        valuebutton.click();

        //<span id="result-s03" data-testid="result-s03" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-border/50 bg-muted text-muted-foreground">Value: —</span>

        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s03']"));
        Assert.assertTrue(messagecheck.isDisplayed());

        driver.quit();



    }
}


