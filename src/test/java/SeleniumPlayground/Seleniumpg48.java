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


public class Seleniumpg48 {

    @Test
    @Description("Verify the alerts and dialogs automation practice")
    public void ScoppedDismiss() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://qaplayground.com/practice/alerts-dialogs");
        driver.manage().window().maximize();

        //<button type="button" data-testid="notif-dismiss-btn" class="alerts-dialogs-module__nGvyEG__notifDismissBtn">Dismiss</button>
        WebElement lowdiskdismiss = driver.findElement(By.xpath("//button[@data-testid='notif-dismiss-btn']"));
        lowdiskdismiss.click();

        //<div role="dialog" aria-modal="true" aria-labelledby="dismiss-dialog-title" data-testid="dismiss-confirm-dialog" data-notif-id="notif-1" data-dialog-type="dismiss-confirm" class="alerts-dialogs-module__nGvyEG__dialogBackdrop"><div class="alerts-dialogs-module__nGvyEG__dialogBox"><div class="alerts-dialogs-module__nGvyEG__dialogHeader"><h2 id="dismiss-dialog-title" class="alerts-dialogs-module__nGvyEG__dialogTitle">Dismiss Low Disk Space?</h2></div><div class="alerts-dialogs-module__nGvyEG__dialogBody"><p class="alerts-dialogs-module__nGvyEG__dialogBodyText">This notification will be removed from your list.</p></div><div class="alerts-dialogs-module__nGvyEG__dialogActions"><button type="button" data-testid="dismiss-cancel-btn" class="alerts-dialogs-module__nGvyEG__btnCancel">Cancel</button><button type="button" aria-label="Confirm dismiss Low Disk Space" class="alerts-dialogs-module__nGvyEG__btnSmallDanger">Dismiss</button></div></div></div>

        WebElement dialogtext = driver.findElement(By.xpath("//div[@aria-modal='true']"));
        System.out.println(dialogtext.getText());

        //<button type="button" aria-label="Confirm dismiss Low Disk Space" class="alerts-dialogs-module__nGvyEG__btnSmallDanger">Dismiss</button>

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dismissbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Confirm dismiss Low Disk Space']")));
        dismissbutton.click();


        //<span id="result-s08" data-testid="result-s08" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Low Disk Space — notification dismissed</span>
        WebElement messagecheck = driver.findElement(By.xpath("//span[@id='result-s08']"));
        Assert.assertEquals(messagecheck.getText(), "Low Disk Space — notification dismissed");

        driver.quit();

    }

    @Test
    @Description("Verify the next element in different browser")
    public void ScoppedCancel() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaplayground.com/practice/alerts-dialogs");
        driver.manage().window().maximize();

        //<button type="button" data-testid="notif-dismiss-btn" class="alerts-dialogs-module__nGvyEG__notifDismissBtn">Dismiss</button>
        WebElement sessionexpiry = driver.findElement(By.xpath("//button[@data-testid='notif-dismiss-btn']"));
        sessionexpiry.click();

        //<div role="dialog" aria-modal="true" aria-labelledby="dismiss-dialog-title" data-testid="dismiss-confirm-dialog" data-notif-id="notif-2" data-dialog-type="dismiss-confirm" class="alerts-dialogs-module__nGvyEG__dialogBackdrop"><div class="alerts-dialogs-module__nGvyEG__dialogBox"><div class="alerts-dialogs-module__nGvyEG__dialogHeader"><h2 id="dismiss-dialog-title" class="alerts-dialogs-module__nGvyEG__dialogTitle">Dismiss Session Expiring Soon?</h2></div><div class="alerts-dialogs-module__nGvyEG__dialogBody"><p class="alerts-dialogs-module__nGvyEG__dialogBodyText">This notification will be removed from your list.</p></div><div class="alerts-dialogs-module__nGvyEG__dialogActions"><button type="button" data-testid="dismiss-cancel-btn" class="alerts-dialogs-module__nGvyEG__btnCancel">Cancel</button><button type="button" aria-label="Confirm dismiss Session Expiring Soon" class="alerts-dialogs-module__nGvyEG__btnSmallDanger">Dismiss</button></div></div></div>

        WebElement dialoginfo = driver.findElement(By.xpath("//div[@aria-modal='true']"));
        System.out.println(dialoginfo.getText());

        //<button type="button" data-testid="dismiss-cancel-btn" class="alerts-dialogs-module__nGvyEG__btnCancel">Cancel</button>
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cancelbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='dismiss-cancel-btn']")));
        cancelbutton.click();

        driver.quit();
    }


}