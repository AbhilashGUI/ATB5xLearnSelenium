package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg41 {

    @Test(priority = 1)
    @Description("Verify the alerts and dialogs automation practice")
    public void CloseInfoAlertDialog()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/alerts-dialogs");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"How to Handle Alerts and Dialogs in Selenium and Playwright | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/alerts-dialogs");

        //<button type="button" data-testid="open-info-dialog" class="alerts-dialogs-module__nGvyEG__triggerBtn alerts-dialogs-module__nGvyEG__triggerBtnInfo">Open Info Dialog</button>

        WebElement openinfodialog=driver.findElement(By.xpath("//button[text()='Open Info Dialog']"));
        openinfodialog.click();

        //<div role="dialog" aria-modal="true" aria-labelledby="info-dialog-title" data-testid="info-alert-dialog" data-dialog-type="info" class="alerts-dialogs-module__nGvyEG__dialogBackdrop"><div class="alerts-dialogs-module__nGvyEG__dialogBox"><div class="alerts-dialogs-module__nGvyEG__dialogHeader"><h2 id="info-dialog-title" class="alerts-dialogs-module__nGvyEG__dialogTitle">Session Notice</h2><button type="button" data-testid="info-dialog-close-btn" aria-label="Close info dialog" class="alerts-dialogs-module__nGvyEG__dialogCloseBtn">×</button></div><div class="alerts-dialogs-module__nGvyEG__dialogBody"><p class="alerts-dialogs-module__nGvyEG__dialogBodyText">Your session will expire in 30 minutes. Please save your work before the session ends.</p></div><div class="alerts-dialogs-module__nGvyEG__dialogActions"><button type="button" data-testid="info-dialog-ok-btn" class="alerts-dialogs-module__nGvyEG__btnConfirm">Got It</button></div></div></div>
        WebElement Dialogmessage=driver.findElement(By.xpath("//div[@data-testid='info-alert-dialog']"));
        String dialogmessage=Dialogmessage.getText();
        System.out.println(dialogmessage);



        //<button type="button" data-testid="info-dialog-ok-btn" class="alerts-dialogs-module__nGvyEG__btnConfirm">Got It</button>
        WebElement Gotit=driver.findElement(By.xpath("//button[@data-testid='info-dialog-ok-btn']"));
        Gotit.click();

        //<span id="result-s01" data-testid="result-s01" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Info dialog dismissed</span>

         WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s01']"));
         Assert.assertEquals(messagecheck.getText(),"Info dialog dismissed");

         driver.quit();

    }

    @Test
    @Description("Verify the same in other browser")
    public void closeinfoalertdialog()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/alerts-dialogs");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"How to Handle Alerts and Dialogs in Selenium and Playwright | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/alerts-dialogs");

        //<button type="button" data-testid="open-info-dialog" class="alerts-dialogs-module__nGvyEG__triggerBtn alerts-dialogs-module__nGvyEG__triggerBtnInfo">Open Info Dialog</button>

        WebElement button1=driver.findElement(By.xpath("//button[@data-testid='open-info-dialog']"));
        button1.click();

        //<button type="button" data-testid="info-dialog-ok-btn" class="alerts-dialogs-module__nGvyEG__btnConfirm">Got It</button>
        WebElement button2=driver.findElement(By.xpath("//button[text()='Got It']"));
        button2.click();

        //<span id="result-s01" data-testid="result-s01" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Info dialog dismissed</span>

        WebElement messagcheck=driver.findElement(By.xpath("//span[@id='result-s01']"));
        Assert.assertEquals(messagcheck.getText(),"Info dialog dismissed");

        driver.quit();
    }
}
