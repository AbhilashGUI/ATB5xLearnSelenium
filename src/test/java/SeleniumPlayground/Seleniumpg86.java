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

public class Seleniumpg86 {

    @Test
    @Description("Verify the File Upload")
    public void UploadProgressBar()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/file-upload");
        driver.manage().window().maximize();

        //<input id="fu-progress-file" data-testid="fu-progress-file" type="file" class="file-upload-module__y8OjNq__fileInput">
        WebElement choosefile=driver.findElement(By.xpath("//input[@id='fu-progress-file']"));
        choosefile.sendKeys("C:\\Users\\Abhilash Sharma\\OneDrive\\Desktop\\Downloads\\Testfile.webp");


        //<button type="button" data-testid="fu-upload-btn" class="file-upload-module__y8OjNq__triggerBtn">▶ Upload</button>
        WebElement uploadbutton=driver.findElement(By.xpath("//button[@data-testid='fu-upload-btn']"));
        uploadbutton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //<span id="result-s08" data-testid="result-s08" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Upload complete — "Testfile.webp"</span>
        WebElement messagecheck=driver.findElement(By.id("result-s08"));
        Assert.assertEquals(messagecheck.getText(),"Upload complete — \"Testfile.webp\"");

        driver.quit();

    }

    @Test
    @Description("Verify the same scenario in different browser")
    public void uploadprogressbar()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/file-upload");
        driver.manage().window().maximize();

        //<input id="fu-progress-file" data-testid="fu-progress-file" type="file" class="file-upload-module__y8OjNq__fileInput">

        WebElement selectafile=driver.findElement(By.xpath("//input[@id='fu-progress-file']"));
        selectafile.sendKeys("C:\\Users\\Abhilash Sharma\\OneDrive\\Desktop\\Downloads\\Form8.pdf");


        //<button type="button" data-testid="fu-upload-btn" class="file-upload-module__y8OjNq__triggerBtn">▶ Upload</button>
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement uploadbutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='fu-upload-btn']")));
        uploadbutton.click();

        driver.quit();
    }
}
