package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg89 {

    @Test
    @Description("Verify the Tabs and Window")
    public void SwitchBackToOriginalTab() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://qaplayground.com/practice/tabs-windows");
        driver.manage().window().maximize();

        String Originalwindow = driver.getWindowHandle();

        //<a id="tw-open-and-return" data-testid="tw-open-and-return" href="/practice/tabs-windows" target="_blank" rel="noopener noreferrer" class="inline-flex h-8 items-center gap-1.5 rounded-md border border-input bg-background px-3 text-xs font-medium shadow-sm transition-colors hover:bg-accent">↗ Open New Tab</a>
        WebElement Newtab = driver.findElement(By.id("tw-open-and-return"));
        Newtab.click();

        for (String Secondarywindow : driver.getWindowHandles()) {
            if (!Secondarywindow.equals(Originalwindow)) {
                driver.switchTo().window(Secondarywindow);
                break;
            }
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //<button type="button" class="inline-flex items-center justify-center gap-1.5 h-8 rounded-md px-3 text-xs font-medium transition-colors focus-visible:outline-none focus-visible:ring-1 focus-visible:ring-ring cursor-pointer border border-input bg-background shadow-sm hover:bg-accent hover:text-accent-foreground">← Mark as Returned</button>
        WebElement Returnback=driver.findElement(By.xpath("//button[text()='← Mark as Returned']"));
        Returnback.click();

        driver.switchTo().window(Originalwindow);
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/tabs-windows");
        driver.quit();
         }

         @Test
         @Description("Verify the Same Scenario in different browser")
         public void switchbacktooriginalwindow()
         {
             WebDriver driver=new ChromeDriver();
             driver.get("https://qaplayground.com/practice/tabs-windows");
             driver.manage().window().maximize();


             String Originalwindow=driver.getWindowHandle();

             //<a id="tw-open-and-return" data-testid="tw-open-and-return" href="/practice/tabs-windows" target="_blank" rel="noopener noreferrer" class="inline-flex h-8 items-center gap-1.5 rounded-md border border-input bg-background px-3 text-xs font-medium shadow-sm transition-colors hover:bg-accent">↗ Open New Tab</a>
             WebElement window1=driver.findElement(By.id("tw-open-and-return"));
             window1.click();

             for (String Secondarywindow: driver.getWindowHandles())
             {
                 if (!Secondarywindow.equals(Originalwindow))
                 {
                     driver.switchTo().window(Originalwindow);
                     break;
                 }

             }

             //<button type="button" class="inline-flex items-center justify-center gap-1.5 h-8 rounded-md px-3 text-xs font-medium transition-colors focus-visible:outline-none focus-visible:ring-1 focus-visible:ring-ring cursor-pointer border border-input bg-background shadow-sm hover:bg-accent hover:text-accent-foreground">← Mark as Returned</button>
             WebElement Returnbackwindow=driver.findElement(By.xpath("//button[normalize-space()='← Mark as Returned']"));
             Returnbackwindow.click();

             driver.switchTo().window(Originalwindow);

             try {
                 Thread.sleep(2000);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }

             //<span id="result-s03" data-testid="result-s03" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Switched back to original tab ✓</span>
             WebElement messagecheck=driver.findElement(By.xpath("//span[@data-testid='result-s03']"));
             System.out.println(messagecheck.getText());

             driver.quit();
         }


         @Test
         @Description("Verify the same scenario in different browser")
         public void backtoorigin() throws InterruptedException {
             WebDriver driver=new FirefoxDriver();
             driver.get("https://qaplayground.com/practice/tabs-windows");
             driver.manage().window().maximize();

             String Mainwindow=driver.getWindowHandle();

             //<a id="tw-open-and-return" data-testid="tw-open-and-return" href="/practice/tabs-windows" target="_blank" rel="noopener noreferrer" class="inline-flex h-8 items-center gap-1.5 rounded-md border border-input bg-background px-3 text-xs font-medium shadow-sm transition-colors hover:bg-accent">↗ Open New Tab</a>
             WebElement newtab=driver.findElement(By.id("tw-open-and-return"));
             newtab.click();

             for (String NextWindow: driver.getWindowHandles())
             {
                 if (!NextWindow.equals(Mainwindow))
                 {
                     driver.switchTo().window(NextWindow);
                     break;
                 }
             }

             //<button type="button" class="inline-flex items-center justify-center gap-1.5 h-8 rounded-md px-3 text-xs font-medium transition-colors focus-visible:outline-none focus-visible:ring-1 focus-visible:ring-ring cursor-pointer border border-input bg-background shadow-sm hover:bg-accent hover:text-accent-foreground">← Mark as Returned</button>

             WebElement returnback=driver.findElement(By.xpath("//button[normalize-space()='← Mark as Returned']"));
             returnback.click();

             driver.switchTo().window(Mainwindow);

             Thread.sleep(2000);

             //<span id="result-s03" data-testid="result-s03" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Switched back to original tab ✓</span>
             WebElement messagecheck=driver.findElement(By.xpath("//span[@data-testid='result-s03']"));
             System.out.println(messagecheck.getText());

             driver.quit();



         }

}



