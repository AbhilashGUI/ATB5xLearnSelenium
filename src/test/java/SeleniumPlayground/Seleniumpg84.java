package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg84 {

    @Test
    @Description("Verify the File Upload")
    public void FileSizeValidation() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaplayground.com/practice/file-upload");
        driver.manage().window().maximize();

        //<input id="fu-size-input" data-testid="fu-size-input" type="file" class="file-upload-module__y8OjNq__fileInput">
        WebElement Desiredfile = driver.findElement(By.xpath("//input[@id='fu-size-input']"));
        Desiredfile.sendKeys("C:\\Users\\Abhilash Sharma\\OneDrive\\Desktop\\Downloads\\Form8.pdf");

        driver.quit();
    }

    @Test
    @Description("Verify the File Upload")
    public void FileSizeValidationexceeds() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaplayground.com/practice/file-upload");
        driver.manage().window().maximize();

        //<input id="fu-size-input" data-testid="fu-size-input" type="file" class="file-upload-module__y8OjNq__fileInput">
        WebElement Desiredfile = driver.findElement(By.xpath("//input[@id='fu-size-input']"));
        Desiredfile.sendKeys("C:\\Users\\Abhilash Sharma\\OneDrive\\Desktop\\Downloads\\2026-EROLLGEN-S29-69-SIR-DraftRoll-Revision1-ENG-19-WI.pdf");

        //<span id="result-s06" data-testid="result-s06" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Size error: 163.2 MB exceeds 2 MB</span>
        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s06']"));
        Assert.assertEquals(messagecheck.getText(),"Size error: 12.9 MB exceeds 2 MB");
        //

        driver.quit();

    }
}