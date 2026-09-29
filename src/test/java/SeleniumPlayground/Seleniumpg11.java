package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg11 {

    @Test(groups = "QA")
    @Description("Verify the buttons automation practice")
    public void DisabledButton() throws InterruptedException {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/buttons");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/buttons");
        Assert.assertEquals(driver.getTitle(),"Button Automation Practice | QA Playground | QA Playground");

        Thread.sleep(2000);
//<button id="disabledBtn" data-testid="btn-disabled" class="buttons-module___Eoq3G__practiceBtn buttons-module___Eoq3G__btnDisabled" disabled="">Disabled</button>
        WebElement disabledbutton=driver.findElement(By.id("disabledBtn"));
        boolean statuscheck=disabledbutton.isEnabled();
        System.out.println("Button status check :"+statuscheck);
//<span id="result-s05" data-testid="result-s05" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-border/50 bg-muted text-muted-foreground">Button is disabled — no action fires</span>

        WebElement defaultmessage= driver.findElement(By.id("result-s05"));
        Assert.assertTrue(defaultmessage.isDisplayed());
        driver.quit();
    }

    @Test(groups = "QA")
    @Description("Verify the same in other browser")
    public void  disabledbutton() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/buttons");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/buttons");
        Assert.assertEquals(driver.getTitle(),"Button Automation Practice | QA Playground | QA Playground");


        //<button id="disabledBtn" data-testid="btn-disabled" class="buttons-module___Eoq3G__practiceBtn buttons-module___Eoq3G__btnDisabled" disabled="">Disabled</button>

        Thread.sleep(2000);
        WebElement disabledbutton=driver.findElement(By.xpath("//button[@id='disabledBtn']"));
        Assert.assertFalse(disabledbutton.isEnabled(),"Button is disabled");

        //<span id="result-s05" data-testid="result-s05" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-border/50 bg-muted text-muted-foreground">Button is disabled — no action fires</span>

        WebElement defaultmessage= driver.findElement(By.xpath("//span[@id='result-s05']"));
        Assert.assertTrue(defaultmessage.isDisplayed());
        driver.quit();

        driver.quit();

    }
}
