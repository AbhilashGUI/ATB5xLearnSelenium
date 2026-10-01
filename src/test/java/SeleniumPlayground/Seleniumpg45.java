package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg45 {

    @Test
    @Description("Verify the alerts and dialogs automation practice")
    public void ClickToDismiss()
    {
        WebDriver driver= new ChromeDriver();
        driver.get("https://qaplayground.com/practice/alerts-dialogs");
        driver.manage().window().maximize();
        //<button type="button" data-testid="open-backdrop-dialog" class="alerts-dialogs-module__nGvyEG__triggerBtn alerts-dialogs-module__nGvyEG__triggerBtnBackdrop">Open Backdrop Dialog</button>

        WebElement button=driver.findElement(By.xpath("//button[@data-testid='open-backdrop-dialog']"));
        button.click();

        //<div role="dialog" aria-modal="true" aria-labelledby="backdrop-dialog-title" data-testid="backdrop-dismiss-dialog" data-dialog-type="backdrop" class="alerts-dialogs-module__nGvyEG__dialogBackdrop"><div class="alerts-dialogs-module__nGvyEG__dialogBox" data-testid="backdrop-dialog-box"><div class="alerts-dialogs-module__nGvyEG__dialogHeader"><h2 id="backdrop-dialog-title" class="alerts-dialogs-module__nGvyEG__dialogTitle">Dismiss by Clicking Outside</h2></div><div class="alerts-dialogs-module__nGvyEG__dialogBody"><p class="alerts-dialogs-module__nGvyEG__dialogBodyText">Click the dark backdrop around this dialog box to close it. There is no close button — only the overlay area dismisses it.</p></div><div class="alerts-dialogs-module__nGvyEG__dialogActions"><span class="alerts-dialogs-module__nGvyEG__keyboardNotice">Click outside the white box to dismiss</span></div></div></div>
        WebElement dialoginfo=driver.findElement(By.xpath("//div[@aria-modal='true']"));
        System.out.println(dialoginfo.getText());

        WebElement outsidethebox=driver.findElement(By.xpath("//div[@aria-modal='true']"));
        outsidethebox.click();

        //<span id="result-s05" data-testid="result-s05" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Dialog not opened</span>
        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s05']"));
        Assert.assertEquals(messagecheck.getText(),"Dialog not opened");

        driver.quit();


    }
}
