package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg79 {

    @Test
    @Description("Verify the File upload")
    public void UploadASingleFile()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/file-upload");
        driver.manage().window().maximize();

        //<input id="fu-single-input" data-testid="fu-single-input" class="file-upload-module__y8OjNq__fileInput" type="file">

        WebElement uploadafile=driver.findElement(By.xpath("//input[@data-testid='fu-single-input']"));
        uploadafile.sendKeys("C:\\Users\\Abhilash Sharma\\OneDrive\\Desktop\\Downloads\\testfile.txt");

        //<span id="result-s01" data-testid="result-s01" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">"Testfile.txt" selected (22 B)</span>
        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s01']"));
        Assert.assertEquals(messagecheck.getText(),"\"testfile.txt\" selected (22 B)");

        driver.quit();

    }

    @Test
    @Description("Verify the same scenario in differnt browser")
    public void uploadasinglefile()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/file-upload");
        driver.manage().window().maximize();

        //<input id="fu-single-input" data-testid="fu-single-input" class="file-upload-module__y8OjNq__fileInput" type="file">

        WebElement uploadafile=driver.findElement(By.xpath("//input[@id='fu-single-input']"));
        uploadafile.sendKeys("C:\\Users\\Abhilash Sharma\\OneDrive\\Desktop\\Downloads\\testfile.txt");

        //<span id="result-s01" data-testid="result-s01" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">"Testfile.txt" selected (22 B)</span>

        WebElement Assertcheck=driver.findElement(By.xpath("//span[@data-testid='result-s01']"));
        Assert.assertEquals(Assertcheck.getText(),"\"testfile.txt\" selected (22 B)");

        driver.quit();



    }
}
