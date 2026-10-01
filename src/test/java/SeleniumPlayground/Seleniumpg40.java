package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg40 {

    @Test(groups = "QA")
    @Description("Verify the modal window automation practice")
    public void MissingLocatorModal() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://qaplayground.com/practice/modals");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getCurrentUrl(), "https://qaplayground.com/practice/modals");
        Assert.assertEquals(driver.getTitle(), "How to Automate Modal Windows in Selenium and Playwright | QA Playground");

        //<button class="flex h-9 items-center justify-center rounded-md border border-gray-300 bg-white px-4 text-sm font-medium text-gray-700 shadow-sm hover:bg-gray-50" data-testid="btn-open-challenge-modal">Open Challenge Modal</button>

        WebElement openchallengebutton = driver.findElement(By.xpath("//button[@data-testid='btn-open-challenge-modal']"));
        openchallengebutton.click();

        //<button aria-label="Accept terms" class="h-9 rounded bg-black px-4 text-sm font-medium text-white hover:bg-gray-800">Accept</button>
        WebElement acceptbutton = driver.findElement(By.xpath("//button[@aria-label='Accept terms']"));
        acceptbutton.click();

        //<span id="result-s04" data-testid="result-s04" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Accepted</span>

        WebElement messagecheck = driver.findElement(By.xpath("//span[text()='Accepted']"));
        Assert.assertEquals(messagecheck.getText(),
                "Accepted");

        driver.quit();


    }

    @Test(groups = "QA")
    @Description("Verify the other elemen in different browser")
    public void missinglocatormodal() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaplayground.com/practice/modals");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getCurrentUrl(), "https://qaplayground.com/practice/modals");
        Assert.assertEquals(driver.getTitle(), "How to Automate Modal Windows in Selenium and Playwright | QA Playground");

        //<button class="flex h-9 items-center justify-center rounded-md border border-gray-300 bg-white px-4 text-sm font-medium text-gray-700 shadow-sm hover:bg-gray-50" data-testid="btn-open-challenge-modal">Open Challenge Modal</button>

        WebElement openchallengebutton = driver.findElement(By.xpath("//button[@data-testid='btn-open-challenge-modal']"));
        openchallengebutton.click();

        //<button aria-label="Decline terms" class="h-9 rounded bg-gray-200 px-4 text-sm font-medium text-gray-900 hover:bg-gray-300">Decline</button>

        WebElement Declinebutton=driver.findElement(By.xpath("//button[@aria-label='Decline terms']"));
        Declinebutton.click();

        //<span id="result-s04" data-testid="result-s04" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Opened</span>

        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s04']"));
        Assert.assertEquals(messagecheck.getText(),"Opened");

        driver.quit();


    }
}