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

public class Seleniumpg80 {

    @Test
    @Description("Verify the File upload")
    public void MultipleFileUploads() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://qaplayground.com/practice/file-upload");
        driver.manage().window().maximize();

        String Filepath1 = "C:\\Users\\Abhilash Sharma\\OneDrive\\Desktop\\Downloads\\Testfile.txt";
        String Filepath2 = "C:\\Users\\Abhilash Sharma\\OneDrive\\Desktop\\Downloads\\Testfile.webp";


        //<input id="fu-multi-input" data-testid="fu-multi-input" type="file" multiple="" class="file-upload-module__y8OjNq__fileInput">
        WebElement Multiplefiles = driver.findElement(By.xpath("//input[@id='fu-multi-input']"));
        Multiplefiles.sendKeys(Filepath1 + "\n" + Filepath2);

        //<span id="result-s02" data-testid="result-s02" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">2 file(s) selected: Testfile.txt, Testfile.webp</span>
        WebElement messagecheck = driver.findElement(By.xpath("//span[@id='result-s02']"));
        Assert.assertEquals(messagecheck.getText(), "2 file(s) selected: Testfile.txt, Testfile.webp");

        driver.quit();
    }

    @Test
    @Description("Verify the same scenario in different browser")
    public void dualfiles() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaplayground.com/practice/file-upload");
        driver.manage().window().maximize();

        String filepath1 = "C:\\Users\\Abhilash Sharma\\OneDrive\\Desktop\\Downloads\\testfile.txt";
        String filepath2 = "C:\\Users\\Abhilash Sharma\\OneDrive\\Desktop\\Downloads\\testfile.webp";


        //<input id="fu-multi-input" data-testid="fu-multi-input" type="file" multiple="" class="file-upload-module__y8OjNq__fileInput">
        WebElement Dualfiles=driver.findElement(By.id("fu-multi-input"));
        Dualfiles.sendKeys(filepath1+ "\n" +filepath2);


        //<span id="result-s02" data-testid="result-s02" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">2 file(s) selected: Testfile.txt, Testfile.webp</span>
        WebElement messagecheck = driver.findElement(By.xpath("//span[@id='result-s02']"));
        Assert.assertEquals(messagecheck.getText(), "2 file(s) selected: testfile.txt, testfile.webp");

        driver.quit();

    }

    @Test
    @Description("Verify the same scenario in different browser")
    public void Triplefiles()
    {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://qaplayground.com/practice/file-upload");
        driver.manage().window().maximize();

        String path1="C:\\Users\\Abhilash Sharma\\OneDrive\\Desktop\\Downloads\\Testfile.txt";
        String path2="C:\\Users\\Abhilash Sharma\\OneDrive\\Desktop\\Downloads\\Testfile.webp";
        String path3="C:\\Users\\Abhilash Sharma\\OneDrive\\Desktop\\Downloads\\Testfile.pdf";

        //<input id="fu-multi-input" data-testid="fu-multi-input" type="file" multiple="" class="file-upload-module__y8OjNq__fileInput">
        WebElement selectfiles=driver.findElement(By.xpath("//input[@data-testid='fu-multi-input']"));
        selectfiles.sendKeys(path1+ "\n" +path2+ "\n" +path3);
        driver.quit();

    }
}