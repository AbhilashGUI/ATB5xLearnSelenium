package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg46 {

    @Test
    @Description("Verify the alerts and dialogs automation practice")
    public void EscapekeyToDismiss()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/alerts-dialogs");
        driver.manage().window().maximize();

        //<button type="button" data-testid="open-escape-dialog" class="alerts-dialogs-module__nGvyEG__triggerBtn alerts-dialogs-module__nGvyEG__triggerBtnEscape">Open Keyboard Dialog</button>

        WebElement button=driver.findElement(By.xpath("//button[@data-testid='open-escape-dialog']"));
        button.click();

        //<div role="dialog" aria-modal="true" aria-labelledby="escape-dialog-title" data-testid="escape-dismiss-dialog" data-dialog-type="keyboard" class="alerts-dialogs-module__nGvyEG__dialogBackdrop"><div class="alerts-dialogs-module__nGvyEG__dialogBox"><div class="alerts-dialogs-module__nGvyEG__dialogHeader"><h2 id="escape-dialog-title" class="alerts-dialogs-module__nGvyEG__dialogTitle">Press Escape to Close</h2></div><div class="alerts-dialogs-module__nGvyEG__dialogBody"><p class="alerts-dialogs-module__nGvyEG__dialogBodyText">This dialog has no close button. Use the <kbd class="alerts-dialogs-module__nGvyEG__kbdKey">Escape</kbd> key on your keyboard to dismiss it.</p></div><div class="alerts-dialogs-module__nGvyEG__dialogActions"><div class="alerts-dialogs-module__nGvyEG__keyboardNotice"><kbd class="alerts-dialogs-module__nGvyEG__kbdKey">Esc</kbd><span>Press Escape to close</span></div></div></div></div>
        WebElement dialogmessage=driver.findElement(By.xpath("//div[@aria-modal='true']"));
        System.out.println(dialogmessage.getText());
        Assert.assertTrue(dialogmessage.isDisplayed(),"dialog should be displayed");

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).perform();

        driver.quit();
    }


    @Test
    @Description("Verify the same in other browser")
    public void escapeclick()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/alerts-dialogs");
        driver.manage().window().maximize();

        //<button type="button" data-testid="open-escape-dialog" class="alerts-dialogs-module__nGvyEG__triggerBtn alerts-dialogs-module__nGvyEG__triggerBtnEscape">Open Keyboard Dialog</button>

        WebElement button=driver.findElement(By.xpath("//button[@data-testid='open-escape-dialog']"));
        button.click();

        //<div role="dialog" aria-modal="true" aria-labelledby="escape-dialog-title" data-testid="escape-dismiss-dialog" data-dialog-type="keyboard" class="alerts-dialogs-module__nGvyEG__dialogBackdrop"><div class="alerts-dialogs-module__nGvyEG__dialogBox"><div class="alerts-dialogs-module__nGvyEG__dialogHeader"><h2 id="escape-dialog-title" class="alerts-dialogs-module__nGvyEG__dialogTitle">Press Escape to Close</h2></div><div class="alerts-dialogs-module__nGvyEG__dialogBody"><p class="alerts-dialogs-module__nGvyEG__dialogBodyText">This dialog has no close button. Use the <kbd class="alerts-dialogs-module__nGvyEG__kbdKey">Escape</kbd> key on your keyboard to dismiss it.</p></div><div class="alerts-dialogs-module__nGvyEG__dialogActions"><div class="alerts-dialogs-module__nGvyEG__keyboardNotice"><kbd class="alerts-dialogs-module__nGvyEG__kbdKey">Esc</kbd><span>Press Escape to close</span></div></div></div></div>

        WebElement dialoginfo=driver.findElement(By.xpath("//div[@aria-modal='true']"));
        System.out.println(dialoginfo.getText());

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).perform();
        driver.quit();

    }
}
