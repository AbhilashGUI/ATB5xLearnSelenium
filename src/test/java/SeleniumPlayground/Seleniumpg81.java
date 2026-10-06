package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg81 {

    @Test
    @Description("Verify the File Upload")
    public void Assertcheck()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/file-upload");
        driver.manage().window().maximize();

        //<input id="fu-filename-input" data-testid="fu-filename-input" type="file" class="file-upload-module__y8OjNq__fileInput">
        WebElement choosefile=driver.findElement(By.xpath("//input[@data-testid='fu-filename-input']"));
        choosefile.sendKeys("C:\\Users\\Abhilash Sharma\\OneDrive\\Desktop\\Downloads\\Testfile.webp");

        //<span id="result-s03" data-testid="result-s03" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Filename displayed: "Testfile.webp"</span>

        WebElement Assertioncheck= driver.findElement(By.xpath("//span[@id='result-s03']"));
        Assert.assertEquals(Assertioncheck.getText(),"Filename displayed: \"Testfile.webp\"");

        driver.quit();
    }

}
