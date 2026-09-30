package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg32 {

    @Test(groups = "QA")
    @Description("Verify the links")
    public void ImageLinks()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/links");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"How to Handle Links in Selenium and Playwright | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/links");

//<div class="flex h-16 w-16 items-center justify-center rounded border border-dashed border-gray-300 bg-gray-50 text-center text-[10px] text-muted-foreground dark:border-gray-600 dark:bg-gray-800">Broken Image</div>

        WebElement brokenimage=driver.findElement(By.xpath("//div[text()='Broken Image']"));
        brokenimage.click();

        //<span id="result-s04" data-testid="result-s04" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Clicked broken image link</span>

        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s04']"));
        Assert.assertEquals(messagecheck.getText(), "Clicked broken image link");

        driver.quit();

    }

    @Test(groups = "QA")
    @Description("Verify the links")
    public void ImageLinks2() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/links");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"How to Handle Links in Selenium and Playwright | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/links");

    //<img src="https://ashisheditz.com/wp-content/uploads/2023/10/4k-iron-man-wallpaper.jpg" class="h-14 w-20 rounded object-cover shadow" alt="Iron Man" width="80">

       WebElement imagelink= driver.findElement(By.xpath("//img[@alt='Iron Man']"));
       imagelink.click();

       Thread.sleep(10000);

       //<span id="result-s04" data-testid="result-s04" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Clicked Iron Man image link</span>

    WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s04']"));
    Assert.assertEquals(messagecheck.getText(),"Clicked Iron Man image link");
    driver.quit();
    }
}
