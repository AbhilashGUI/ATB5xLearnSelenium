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

public class Seleniumpg43 {

    @Test
    @Description("Verify the alerts and dialogs automation practice")
    public void CancelAndStayOnPage()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/alerts-dialogs");
        driver.manage().window().maximize();

        //<button type="button" data-testid="open-unsaved-dialog" class="alerts-dialogs-module__nGvyEG__triggerBtn alerts-dialogs-module__nGvyEG__triggerBtnWarning">Open Unsaved Dialog</button>
        WebElement button1= driver.findElement(By.xpath("//button[@data-testid='open-unsaved-dialog']"));
        button1.click();


        //<button type="button" data-testid="stay-on-page-btn" class="alerts-dialogs-module__nGvyEG__btnConfirm">Stay</button>
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement staybutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='stay-on-page-btn']")));
        staybutton.click();

        //<span id="result-s03" data-testid="result-s03" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Stayed — changes preserved</span>
         WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s03']"));
        Assert.assertEquals(messagecheck.getText(),"Stayed — changes preserved");

        driver.quit();

    }

     @Test
    @Description("Verify the other element in different browser")
    public void cancelthedialogbox()
     {
         WebDriver driver=new ChromeDriver();
         driver.get("https://qaplayground.com/practice/alerts-dialogs");
         driver.manage().window().maximize();


         //<button type="button" data-testid="open-unsaved-dialog" class="alerts-dialogs-module__nGvyEG__triggerBtn alerts-dialogs-module__nGvyEG__triggerBtnWarning">Open Unsaved Dialog</button>

         WebElement button1=driver.findElement(By.xpath("//button[@data-testid='open-unsaved-dialog']"));
         button1.click();


         //<div role="dialog" aria-modal="true" aria-labelledby="unsaved-dialog-title" data-testid="unsaved-changes-dialog" data-dialog-type="warning" class="alerts-dialogs-module__nGvyEG__dialogBackdrop"><div class="alerts-dialogs-module__nGvyEG__dialogBox"><div class="alerts-dialogs-module__nGvyEG__dialogHeader"><h2 id="unsaved-dialog-title" class="alerts-dialogs-module__nGvyEG__dialogTitle">Unsaved Changes</h2></div><div class="alerts-dialogs-module__nGvyEG__dialogBody"><p class="alerts-dialogs-module__nGvyEG__dialogBodyText">You have unsaved changes. Leave without saving?</p></div><div class="alerts-dialogs-module__nGvyEG__dialogActions"><button type="button" aria-label="Leave page and discard changes" class="alerts-dialogs-module__nGvyEG__btnCancel">Leave</button><button type="button" data-testid="stay-on-page-btn" class="alerts-dialogs-module__nGvyEG__btnConfirm">Stay</button></div></div></div>

         WebElement dialoginfo=driver.findElement(By.xpath("//div[@aria-modal='true']"));
         System.out.println(dialoginfo.getText());

         //<button type="button" aria-label="Leave page and discard changes" class="alerts-dialogs-module__nGvyEG__btnCancel">Leave</button>

         WebElement leavebutton=driver.findElement(By.xpath("//button[text()='Leave']"));
         leavebutton.click();

         //<span id="result-s03" data-testid="result-s03" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-border/50 bg-muted text-muted-foreground">Dialog not opened</span>
         WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s03']"));
         Assert.assertEquals(messagecheck.getText(), "Dialog not opened");

         driver.quit();

     }


}
