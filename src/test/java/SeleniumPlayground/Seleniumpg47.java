package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Seleniumpg47 {

    @Test
    @Description("Verify the alerts and dialogs automation practice")
    public void AssertDialogcontent()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/alerts-dialogs");
        driver.manage().window().maximize();

        //<button type="button" data-testid="open-notification-dialog" class="alerts-dialogs-module__nGvyEG__triggerBtn alerts-dialogs-module__nGvyEG__triggerBtnNeutral">Open Notification</button>
        WebElement openbutton=driver.findElement(By.xpath("//button[@data-testid='open-notification-dialog']"));
        openbutton.click();

        //<div role="dialog" aria-modal="true" aria-labelledby="notif-dialog-title" data-testid="system-notification-dialog" data-dialog-type="notification" class="alerts-dialogs-module__nGvyEG__dialogBackdrop"><div class="alerts-dialogs-module__nGvyEG__dialogBox"><div class="alerts-dialogs-module__nGvyEG__dialogHeader"><h2 id="notif-dialog-title" class="alerts-dialogs-module__nGvyEG__dialogTitle">Maintenance Window</h2></div><div class="alerts-dialogs-module__nGvyEG__dialogBody"><span class="alerts-dialogs-module__nGvyEG__dialogBadge alerts-dialogs-module__nGvyEG__dialogBadgeScheduled">Scheduled</span><p class="alerts-dialogs-module__nGvyEG__dialogBodyText">Service will be offline from Sunday 3:00–5:00 AM UTC. Please plan accordingly and save any active work before the window begins.</p></div><div class="alerts-dialogs-module__nGvyEG__dialogActions"><button type="button" data-testid="notif-ack-btn" class="alerts-dialogs-module__nGvyEG__btnConfirm">Got It</button></div></div></div>
        WebElement dialoginfo=driver.findElement(By.xpath("//div[@aria-modal='true']"));
        System.out.println(dialoginfo.getText());


        //<button type="button" data-testid="notif-ack-btn" class="alerts-dialogs-module__nGvyEG__btnConfirm">Got It</button>
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Gotitbutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='notif-ack-btn']")));
         Gotitbutton.click();

         //<span id="result-s07" data-testid="result-s07" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Notification acknowledged</span>

        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s07']"));
        Assert.assertEquals(messagecheck.getText(), "Notification acknowledged");

        driver.quit();


    }
}
