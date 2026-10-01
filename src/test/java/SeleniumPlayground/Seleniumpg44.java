package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Seleniumpg44 {

    @Test
    @Description("Verify the alerts and dialogs automation practice")
    public void DestructiveDeleteConfirm()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/alerts-dialogs");
        driver.manage().window().maximize();

        //<button type="button" data-testid="open-delete-dialog" class="alerts-dialogs-module__nGvyEG__triggerBtn alerts-dialogs-module__nGvyEG__triggerBtnDanger">Open Delete Dialog</button>
        WebElement button=driver.findElement(By.xpath("//button[@data-testid='open-delete-dialog']"));
        button.click();

        //<div role="dialog" aria-modal="true" aria-labelledby="delete-dialog-title" data-testid="delete-account-dialog" data-dialog-type="danger" class="alerts-dialogs-module__nGvyEG__dialogBackdrop"><div class="alerts-dialogs-module__nGvyEG__dialogBox"><div class="alerts-dialogs-module__nGvyEG__dialogHeader"><h2 id="delete-dialog-title" class="alerts-dialogs-module__nGvyEG__dialogTitle">Delete Account</h2></div><div class="alerts-dialogs-module__nGvyEG__dialogBody"><p class="alerts-dialogs-module__nGvyEG__dialogBodyText">Permanently delete <strong data-testid="delete-dialog-email" class="alerts-dialogs-module__nGvyEG__dialogHighlight">user@example.com</strong>? This cannot be undone.</p></div><div class="alerts-dialogs-module__nGvyEG__dialogActions"><button type="button" data-testid="delete-cancel-btn" class="alerts-dialogs-module__nGvyEG__btnCancel">Cancel</button><button type="button" aria-label="Confirm account deletion" class="alerts-dialogs-module__nGvyEG__btnDanger">Delete Account</button></div></div></div>
        WebElement dialoginfo=driver.findElement(By.xpath("//div[@aria-modal='true']"));
        System.out.println(dialoginfo.getText());


        //<button type="button" aria-label="Confirm account deletion" class="alerts-dialogs-module__nGvyEG__btnDanger">Delete Account</button>

        WebElement deleteaccount=driver.findElement(By.xpath("//button[@aria-label='Confirm account deletion']"));
        deleteaccount.click();

        //<span id="result-s04" data-testid="result-s04" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Account deleted!</span>
        WebElement message=driver.findElement(By.xpath("//span[@id='result-s04']"));
        Assert.assertEquals(message.getText(),"Account deleted!");

        driver.quit();
    }

    @Test
    @Description("Verify the other elements in different browser")
    public void Cancelconfirm()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/alerts-dialogs");
        driver.manage().window().maximize();

        //<button type="button" data-testid="open-delete-dialog" class="alerts-dialogs-module__nGvyEG__triggerBtn alerts-dialogs-module__nGvyEG__triggerBtnDanger">Open Delete Dialog</button>
         WebElement button=driver.findElement(By.xpath("//button[@data-testid='open-delete-dialog']"));
         button.click();


        //<button type="button" data-testid="delete-cancel-btn" class="alerts-dialogs-module__nGvyEG__btnCancel">Cancel</button>
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cancelbutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='delete-cancel-btn']")));
        cancelbutton.click();

        //<span id="result-s04" data-testid="result-s04" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-border/50 bg-muted text-muted-foreground">No deletion yet</span>

        WebElement messagecheck=driver.findElement(By.xpath("//span[normalize-space()='No deletion yet']"));
        Assert.assertEquals(messagecheck.getText(),"No deletion yet");

        driver.quit();

    }


}
