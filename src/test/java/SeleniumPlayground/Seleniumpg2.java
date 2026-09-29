package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg2 {


    @Test(groups = "QA")
    @Description("Input field Automation practice")
    public void AppendTextAndPressTab()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/input-fields");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Input Field Automation Practice | QA Playground | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/input-fields");

        //<input id="appendInput" data-testid="input-append" class="input-fields-module__pJ4Qbq__practiceInput" aria-label="Append text and press Tab" type="text" value="Avengers">

        WebElement appendtext=driver.findElement(By.id("appendInput"));
        appendtext.sendKeys(" The Monarch ");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        appendtext.sendKeys(Keys.TAB);

        //<span id="result-s02" data-testid="result-s02" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Current value: Avengers </span>
        WebElement messagecheck=driver.findElement(By.id("result-s02"));
        Assert.assertTrue(messagecheck.isDisplayed());
        driver.quit();
        }


        @Test(groups = "QA")
        @Description("Verify the same in other browser")
      public void appendtextandpresstab()
        {
            WebDriver driver= new ChromeDriver();
            driver.get("https://qaplayground.com/practice/input-fields");
            driver.manage().window().maximize();
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());
            Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/input-fields");
            Assert.assertEquals(driver.getTitle(),"Input Field Automation Practice | QA Playground | QA Playground");

            //<input id="appendInput" data-testid="input-append"
            WebElement appendtext=driver.findElement(By.xpath("//input[@id='appendInput']"));
            appendtext.sendKeys(" Dictator");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            appendtext.sendKeys(Keys.TAB);

            //<span id="result-s02" data-testid="result-s02" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Current value: Avengers </span>
            WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s02']"));
            Assert.assertTrue(messagecheck.isDisplayed());

            driver.quit();
        }

    }

