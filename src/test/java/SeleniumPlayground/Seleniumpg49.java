package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg49 {


    @Test
    @Description("Verify the Multi-select")
    public void SelectASingleOption() throws InterruptedException {
       WebDriver driver=new EdgeDriver();
       driver.get("https://qaplayground.com/practice/multi-select");
       driver.manage().window().maximize();

       //<select id="ms-native-select" data-testid="ms-native-select" size="4" class="multi-select-module__ep-fQa__nativeSelect"><option value="playwright">Playwright</option><option value="cypress">Cypress</option><option value="selenium">Selenium</option><option value="webdriverio">WebdriverIO</option></select>

        Select selectonefromfour=new Select(driver.findElement(By.id("ms-native-select")));
        //selectonefromfour.selectByIndex(0);
        selectonefromfour.selectByIndex(1);
        Thread.sleep(2000);

        //<span id="result-s01" data-testid="result-s01" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Playwright selected</span>
        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s01']"));
        Assert.assertEquals(messagecheck.getText(),"Cypress selected");
        driver.quit();

    }

    @Test
    @Description("Verify the same in other browser")
    public void Singleoptioncheck() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/multi-select");
        driver.manage().window().maximize();

        //<select id="ms-native-select" data-testid="ms-native-select" size="4" class="multi-select-module__ep-fQa__nativeSelect"><option value="playwright">Playwright</option><option value="cypress">Cypress</option><option value="selenium">Selenium</option><option value="webdriverio">WebdriverIO</option></select>

         Select selectone=new Select(driver.findElement(By.xpath("//select[@size='4']")));
       //selectone.selectByValue("selenium");
         selectone.selectByValue("webdriverio");
         Thread.sleep(2000);

         //<span id="result-s01" data-testid="result-s01" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">WebdriverIO selected</span>
        WebElement messagecheck=driver.findElement(By.xpath("//span[@data-testid='result-s01']"));
        Assert.assertEquals(messagecheck.getText(),"WebdriverIO selected");

        driver.quit();



    }
}


