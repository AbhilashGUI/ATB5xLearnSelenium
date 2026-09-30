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

public class Seleniumpg33 {

    @Test(groups = "QA")
    @Description("Verify the links")
    public void Buttonlinks() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://qaplayground.com/practice/links");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(), "How to Handle Links in Selenium and Playwright | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qaplayground.com/practice/links");

        //<button class="inline-flex h-9 items-center justify-center gap-2 rounded-md bg-primary px-4 py-2 text-sm font-medium whitespace-nowrap text-primary-foreground shadow transition-colors hover:bg-primary/90 focus-visible:ring-1 focus-visible:ring-ring focus-visible:outline-none disabled:pointer-events-none disabled:opacity-50">Broken Button</button>

        WebElement brokebutton = driver.findElement(By.xpath("//button[text()='Broken Button']"));
        brokebutton.click();


        //<span id="result-s05" data-testid="result-s05" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Clicked Broken Button</span>

        WebElement messagecheck = driver.findElement(By.id("result-s05"));
        Assert.assertEquals(messagecheck.getText(), "Clicked Broken Button");
        driver.quit();

    }

    @Test(groups = "QA")
    @Description("Verify the links in the other browser")
    public void ButtonLinks2() {

        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/links");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(), "How to Handle Links in Selenium and Playwright | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qaplayground.com/practice/links");

        //<button class="inline-flex h-9 items-center justify-center gap-2 rounded-md bg-destructive px-4 py-2 text-sm font-medium whitespace-nowrap text-destructive-foreground shadow-sm transition-colors hover:bg-destructive/90 focus-visible:ring-1 focus-visible:ring-ring focus-visible:outline-none disabled:pointer-events-none disabled:opacity-50">Broken Link Button</button>

        WebElement brokelinkbutton=driver.findElement(By.xpath("//button[text()='Broken Link Button']"));
        brokelinkbutton.click();

        //<span id="result-s05" data-testid="result-s05" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Clicked Broken Link Button</span>
       WebElement messagecheck=driver.findElement(By.xpath("//span[@data-testid='result-s05']"));
       Assert.assertEquals(messagecheck.getText(),"Clicked Broken Link Button");
       driver.quit();
    }

    @Test(groups = "QA")
    @Description("Verify the link in different browser")
    public void ButtonLinks3() throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://qaplayground.com/practice/links");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(), "How to Handle Links in Selenium and Playwright | QA Playground");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qaplayground.com/practice/links");

        //<button class="inline-flex h-9 items-center justify-center gap-2 rounded-md border border-input bg-background px-4 py-2 text-sm font-medium whitespace-nowrap shadow-sm transition-colors hover:bg-accent hover:text-accent-foreground focus-visible:ring-1 focus-visible:ring-ring focus-visible:outline-none disabled:pointer-events-none disabled:opacity-50">Home Button</button>

         WebElement homebutton=driver.findElement(By.xpath("//button[text()='Home Button']"));
         homebutton.click();

         Thread.sleep(3000);

         System.out.println(driver.getCurrentUrl());
         driver.quit();


    }
}