package SeleniumPlayground;

import io.qameta.allure.Description;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg10 {

    @Test(groups = "QA")
    @Description("Verify the buttons automation practice")
    public void GetButtonHeightandWidth() throws InterruptedException {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/buttons");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"Button Automation Practice | QA Playground | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/buttons");

        //<button id="sizeBtn" data-testid="btn-get-size" class="buttons-module___Eoq3G__practiceBtn buttons-module___Eoq3G__btnDark">Do you know my size?</button>

        Thread.sleep(2000);
        WebElement checkbutton=driver.findElement(By.id("sizeBtn"));
        checkbutton.click();

        //<span id="result-s04" data-testid="result-s04" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">W: 175px, H: 29px</span>

        WebElement buttonmeasures= driver.findElement(By.id("result-s04"));
        Assert.assertTrue(buttonmeasures.isDisplayed());

        driver.quit();
    }

    @Test(groups = "QA")
    @Description("Verify the same in other browser")
    public void getbuttonheighandwidth() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/buttons");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"Button Automation Practice | QA Playground | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/buttons");

        //<button id="sizeBtn" data-testid="btn-get-size" class="buttons-module___Eoq3G__practiceBtn buttons-module___Eoq3G__btnDark">Do you know my size?</button>

        Thread.sleep(2000);
        WebElement buttonsizecheck=driver.findElement(By.xpath("//button[@id='sizeBtn']"));
        buttonsizecheck.click();


        //<span id="result-s04" data-testid="result-s04" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">W: 175px, H: 29px</span>

        WebElement buttonmeasures= driver.findElement(By.xpath("//span[@id='result-s04']"));
        Assert.assertTrue(buttonmeasures.isDisplayed());

        driver.quit();

    }
}
