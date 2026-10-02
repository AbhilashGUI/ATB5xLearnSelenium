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

public class Seleniumpg52 {

    @Test
    @Description("Verify the Multi-select")
    public void CustomCheckbox() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaplayground.com/practice/multi-select");
        driver.manage().window().maximize();

        //<button type="button" data-testid="ms-custom-trigger" aria-haspopup="listbox" aria-expanded="true" class="multi-select-module__ep-fQa__customTrigger multi-select-module__ep-fQa__customTriggerOpen">Select frameworks<span class="multi-select-module__ep-fQa__caret multi-select-module__ep-fQa__caretOpen">▾</span></button>

        WebElement selectbutton = driver.findElement(By.xpath("//button[@aria-haspopup='listbox'] "));
        selectbutton.click();

        //<div role="option" aria-selected="true" data-testid="ms-custom-option" data-value="react" class="multi-select-module__ep-fQa__customOption multi-select-module__ep-fQa__customOptionSelected"><span class="multi-select-module__ep-fQa__checkbox multi-select-module__ep-fQa__checkboxChecked">✓</span>React</div>

        WebElement option1 = driver.findElement(By.xpath("//div[@data-value='react']"));
        option1.click();
        Assert.assertTrue(option1.isDisplayed());


        //<span id="result-s04" data-testid="result-s04" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">React selected</span>
        WebElement messagecheck = driver.findElement(By.xpath("//span[@id='result-s04']"));
        Assert.assertEquals(messagecheck.getText(), "React selected");

        //<p class="text-[11px] text-muted-foreground">Selected: <strong>React</strong></p>

        WebElement selectedtext = driver.findElement(By.xpath("//p[contains(.,'React')]"));
        System.out.println(selectedtext.getText());


        driver.quit();

    }

    @Test
    @Description("Verify the other element select in different browser")
    public void CustomCheckbox2() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://qaplayground.com/practice/multi-select");
        driver.manage().window().maximize();

        //<button type="button" data-testid="ms-custom-trigger" aria-haspopup="listbox" aria-expanded="true" class="multi-select-module__ep-fQa__customTrigger multi-select-module__ep-fQa__customTriggerOpen">Select frameworks<span class="multi-select-module__ep-fQa__caret multi-select-module__ep-fQa__caretOpen">▾</span></button>

        WebElement selectbutton = driver.findElement(By.xpath("//button[@aria-haspopup='listbox'] "));
        selectbutton.click();


        //<div role="option" aria-selected="false" data-testid="ms-custom-option" data-value="vue" class="multi-select-module__ep-fQa__customOption "><span class="multi-select-module__ep-fQa__checkbox "></span>Vue.js</div>

        WebElement option2=driver.findElement(By.xpath("//div[@data-value='vue']"));
        option2.click();

        //<span id="result-s04" data-testid="result-s04" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Vue.js selected</span>
        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s04']"));
        Assert.assertEquals(messagecheck.getText(),"Vue.js selected");
        driver.quit();

    }

    @Test
    @Description("Verify the other element in different browser")
    public void CustomCheckbox3()
    {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://qaplayground.com/practice/multi-select");
        driver.manage().window().maximize();

        //<button type="button" data-testid="ms-custom-trigger" aria-haspopup="listbox" aria-expanded="true" class="multi-select-module__ep-fQa__customTrigger multi-select-module__ep-fQa__customTriggerOpen">Select frameworks<span class="multi-select-module__ep-fQa__caret multi-select-module__ep-fQa__caretOpen">▾</span></button>

        WebElement selectbutton=driver.findElement(By.xpath("//button[@aria-haspopup='listbox']"));
        selectbutton.click();

        //<div role="option" aria-selected="false" data-testid="ms-custom-option" data-value="angular" class="multi-select-module__ep-fQa__customOption "><span class="multi-select-module__ep-fQa__checkbox "></span>Angular</div>
        WebElement option=driver.findElement(By.xpath("//div[@data-value='angular']"));
        option.click();

        //<span id="result-s04" data-testid="result-s04" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Angular selected</span>
        WebElement messagecheck= driver.findElement(By.xpath("//span[@data-testid='result-s04']"));
        Assert.assertEquals(messagecheck.getText(),"Angular selected");
        driver.quit();
    }
}