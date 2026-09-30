package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg17 {

    @Test(groups = "QA")
    @Description("Verify the dropdown automation practice")
    public void SelectLastLanguageandReadAllOptions()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/dropdowns");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/dropdowns");
        Assert.assertEquals(driver.getTitle(),"How to Handle Dropdowns in Selenium and Playwright | QA Playground | QA Playground");

//<select id="languageSelect" name="language" data-testid="language-select" data-list-id="language-options-2026" class="dropdowns-module__P6SCTq__practiceSelect"><option value="python">Python</option><option value="java">Java</option><option value="javascript">JavaScript</option><option value="typescript">TypeScript</option></select>

        Select selectlan=new Select(driver.findElement(By.id("languageSelect")));


        //<button type="button" id="selectLastLanguageBtn" class="dropdowns-module__P6SCTq__actionBtn" aria-label="Select last programming language">Select Last</button>

        WebElement button=driver.findElement(By.id("selectLastLanguageBtn"));
        button.click();

        //<span id="result-s03" data-testid="result-s03" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Selected TypeScript; options: Python, Java, JavaScript, TypeScript</span>

        WebElement messagecheck=driver.findElement(By.id("result-s03"));
        Assert.assertEquals(messagecheck.getText(),"Selected TypeScript; options: Python, Java, JavaScript, TypeScript");

        System.out.println(messagecheck.getText());
        driver.quit();
    }

    @Test(groups = "QA")
    @Description("Verify the same in other browser")
    public void selectlastlanguageandreadalloptions()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/dropdowns");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/dropdowns");
        Assert.assertEquals(driver.getTitle(),"How to Handle Dropdowns in Selenium and Playwright | QA Playground | QA Playground");

        //<select id="languageSelect" name="language" data-testid="language-select" data-list-id="language-options-2026" class="dropdowns-module__P6SCTq__practiceSelect"><option value="python">Python</option><option value="java">Java</option><option value="javascript">JavaScript</option><option value="typescript">TypeScript</option></select>

        Select selectlan=new Select(driver.findElement(By.xpath("//select[@id='languageSelect']")));


        //<button type="button" id="selectLastLanguageBtn" class="dropdowns-module__P6SCTq__actionBtn" aria-label="Select last programming language">Select Last</button>

        WebElement button=driver.findElement(By.xpath("//button[@id='selectLastLanguageBtn']"));
        button.click();

        //<span id="result-s03" data-testid="result-s03" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Selected TypeScript; options: Python, Java, JavaScript, TypeScript</span>

        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s03']"));
        Assert.assertEquals(messagecheck.getText(),"Selected TypeScript; options: Python, Java, JavaScript, TypeScript");

        System.out.println(messagecheck.getText());
        driver.quit();
    }

}


