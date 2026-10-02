package SeleniumPlayground;

import io.qameta.allure.Description;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Seleniumpg51 {

    @Test
    @Description("Verify the Multi-select")
    public void DeselectASpecificOptions() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://qaplayground.com/practice/multi-select");
        driver.manage().window().maximize();


//<select data-testid="ms-native-select" multiple="" size="4" class="multi-select-module__ep-fQa__nativeSelect"><option value="playwright">Playwright</option><option value="cypress">Cypress</option><option value="selenium">Selenium</option><option value="webdriverio">WebdriverIO</option></select>

        Select selectAll = new Select(driver.findElement(By.xpath("(//select[@data-testid='ms-native-select'])[3]")));
        selectAll.selectByValue("playwright");
        selectAll.selectByValue("cypress");
        selectAll.selectByValue("selenium");
        selectAll.selectByValue("webdriverio");

        Thread.sleep(2000);

        selectAll.deselectByIndex(0);
        selectAll.deselectByIndex(2);
        driver.quit();


    }

    @Test
    @Description("Verify the other elements in different browser")
    public void deselectthespecificoption() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaplayground.com/practice/multi-select");
        driver.manage().window().maximize();

        //<button type="button" data-testid="ms-deselect-trigger" class="inline-flex h-8 w-fit items-center rounded-md border border-input bg-background px-3 text-xs font-medium shadow-sm transition-colors hover:bg-accent disabled:opacity-50">▶ Pre-select All</button>

        WebElement preselectall = driver.findElement(By.xpath("//button[@data-testid='ms-deselect-trigger']"));
        preselectall.click();

        Thread.sleep(2000);

        //<option value="playwright">Playwright</option>
        WebElement deselectvalue1 = driver.findElement(By.xpath("(//option[@value='playwright'])[3]"));


        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .click(deselectvalue1)
                .keyUp(Keys.CONTROL)
                .perform();

        driver.quit();
    }


    @Test
    @Description("Verify the other element in different browser")
    public void deselectthespecificoption2() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/multi-select");
        driver.manage().window().maximize();

        //<button type="button" data-testid="ms-deselect-trigger" class="inline-flex h-8 w-fit items-center rounded-md border border-input bg-background px-3 text-xs font-medium shadow-sm transition-colors hover:bg-accent disabled:opacity-50">▶ Pre-select All</button>

        WebElement preselectall = driver.findElement(By.xpath("//button[@data-testid='ms-deselect-trigger']"));
        preselectall.click();

        Thread.sleep(2000);

        //<option value="selenium">Selenium</option>
        WebElement deselectvalue2 = driver.findElement(By.xpath("(//option[@value='selenium'])[3]"));

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .click(deselectvalue2)
                .keyUp(Keys.CONTROL)
                .perform();


        driver.quit();

    }
}

