package SeleniumPlayground;


import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Seleniumpg12 {

    @Test(groups = "QA")
    @Description("Verify the buttons automation practice")
    public void ClickAndHold() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://qaplayground.com/practice/buttons");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(), "Button Automation Practice | QA Playground | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qaplayground.com/practice/buttons");

        //<button id="clickHoldBtn" data-testid="btn-click-hold" class="buttons-module___Eoq3G__practiceBtn buttons-module___Eoq3G__btnBlue">Click and Hold!</button>

        WebElement button = driver.findElement(By.id("clickHoldBtn"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(button)
                .pause(Duration.ofSeconds(2))
                .release()
                .perform();
//<span id="result-s06" data-testid="result-s06" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Released too early - hold for 1.5s</span>
        WebElement messagecheck=driver.findElement(By.id("result-s06"));
        Assert.assertTrue(messagecheck.isDisplayed());

        driver.quit();

    }

    @Test(groups = "QA")
    @Description("Verify the same in other browser")
    public void clickandhold() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaplayground.com/practice/buttons");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(), "Button Automation Practice | QA Playground | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qaplayground.com/practice/buttons");

        //<button id="clickHoldBtn" data-testid="btn-click-hold" class="buttons-module___Eoq3G__practiceBtn buttons-module___Eoq3G__btnBlue">Click and Hold!</button>

         WebElement button=driver.findElement(By.xpath("//button[@id='clickHoldBtn']"));

         Actions actions=new Actions(driver);
         actions.clickAndHold(button)
                 .pause(Duration.ofSeconds(5))
                 .release()
                 .perform();

        //<span id="result-s06" data-testid="result-s06" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Released too early - hold for 1.5s</span>
        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s06']"));
        Assert.assertTrue(messagecheck.isDisplayed());

        driver.quit();


    }
}
