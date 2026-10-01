package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg42 {

    @Test
    @Description("Verify the alerts and dialog automation practice")
    public void ConfirmActionInDialog()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/alerts-dialogs");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/alerts-dialogs");
        Assert.assertEquals(driver.getTitle(),"How to Handle Alerts and Dialogs in Selenium and Playwright | QA Playground");

        //<button type="button" data-testid="open-confirm-dialog" class="alerts-dialogs-module__nGvyEG__triggerBtn alerts-dialogs-module__nGvyEG__triggerBtnConfirm">Open Confirm Dialog</button>
        WebElement confirmbutton=driver.findElement(By.xpath("//button[@data-testid='open-confirm-dialog']"));
        confirmbutton.click();

        //<button type="button" data-testid="confirm-ok-btn" class="alerts-dialogs-module__nGvyEG__btnConfirm">Confirm</button>
        WebElement cancelbutton=driver.findElement(By.xpath("//button[@data-testid='confirm-ok-btn']"));
        cancelbutton.click();

        //<span id="result-s02" data-testid="result-s02" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Submission confirmed!</span>
        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s02']"));
        Assert.assertEquals(messagecheck.getText(), "Submission confirmed!");

        driver.quit();
    }

    @Test(priority = 1)
    @Description("Verify the other element in different browser")
    public void cancelactionindialog()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/alerts-dialogs");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/alerts-dialogs");
        Assert.assertEquals(driver.getTitle(),"How to Handle Alerts and Dialogs in Selenium and Playwright | QA Playground");

        //<button type="button" data-testid="open-confirm-dialog" class="alerts-dialogs-module__nGvyEG__triggerBtn alerts-dialogs-module__nGvyEG__triggerBtnConfirm">Open Confirm Dialog</button>

        WebElement confirmbutton1=driver.findElement(By.xpath("//button[@data-testid='open-confirm-dialog']"));
        confirmbutton1.click();

        //<div role="dialog" aria-modal="true" aria-labelledby="confirm-dialog-title" data-testid="confirm-action-dialog" data-dialog-type="confirm" class="alerts-dialogs-module__nGvyEG__dialogBackdrop"><div class="alerts-dialogs-module__nGvyEG__dialogBox"><div class="alerts-dialogs-module__nGvyEG__dialogHeader"><h2 id="confirm-dialog-title" class="alerts-dialogs-module__nGvyEG__dialogTitle">Confirm Submission</h2></div><div class="alerts-dialogs-module__nGvyEG__dialogBody"><p class="alerts-dialogs-module__nGvyEG__dialogBodyText">Submit this form response? This action cannot be reversed.</p></div><div class="alerts-dialogs-module__nGvyEG__dialogActions"><button type="button" data-testid="confirm-cancel-btn" class="alerts-dialogs-module__nGvyEG__btnCancel">Cancel</button><button type="button" data-testid="confirm-ok-btn" class="alerts-dialogs-module__nGvyEG__btnConfirm">Confirm</button></div></div></div>
        WebElement dialogbox= driver.findElement(By.xpath("//div[@aria-modal='true']"));
        String dialogmessagge=dialogbox.getText();
        System.out.println(dialogmessagge);

        //<button type="button" data-testid="confirm-cancel-btn" class="alerts-dialogs-module__nGvyEG__btnCancel">Cancel</button>
        WebElement cancelbutton1= driver.findElement(By.xpath("//button[normalize-space()='Cancel']"));
        confirmbutton1.click();

        //<span id="result-s02" data-testid="result-s02" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-border/50 bg-muted text-muted-foreground">Awaiting confirmation</span>
        WebElement messagecheck=driver.findElement(By.xpath("//span[text()='Awaiting confirmation']"));
        Assert.assertEquals(messagecheck.getText(),"Awaiting confirmation");

        driver.quit();


    }
}
