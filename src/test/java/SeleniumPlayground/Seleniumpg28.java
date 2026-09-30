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

public class Seleniumpg28 {

    @Test(groups = "QA")
    @Description("Verify the radioboxes and checkboxes")
    public void Dynamiccheckboxlist()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/radio-checkbox");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/radio-checkbox");
        Assert.assertEquals(driver.getTitle(),"How to Handle Radio Buttons and Checkboxes in Selenium and Playwright | QA Playground");

        //<input type="checkbox" id="perm_read_users" class="h-4 w-4 cursor-pointer rounded border-gray-300 accent-primary" aria-label="Read Users" name="perm_read_users">

        WebElement Dynamiccheckbox1=driver.findElement(By.xpath("//input[@type='checkbox' and starts-with(@name,'perm_read_users')]"));
        Dynamiccheckbox1.click();

        //<span id="result-s08" data-testid="result-s08" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Read perms: Read Users</span>
        WebElement messagecheckbox= driver.findElement(By.xpath("//span[@id='result-s08']"));
        Assert.assertEquals(messagecheckbox.getText(),"Read perms: Read Users");

        driver.quit();

    }


    @Test(groups = "QA")
    @Description("Verify the other element in differnt browser")
    public void Dynamiccheckboxlist2()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/radio-checkbox");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/radio-checkbox");
        Assert.assertEquals(driver.getTitle(),"How to Handle Radio Buttons and Checkboxes in Selenium and Playwright | QA Playground");


        //<input type="checkbox" id="perm_read_reports" class="h-4 w-4 cursor-pointer rounded border-gray-300 accent-primary" aria-label="Read Reports" name="perm_read_reports">

        WebElement Dynamiccheckbox2=driver.findElement(By.xpath("//input[@type='checkbox' and starts-with(@name,'perm_read_reports')]"));
        Dynamiccheckbox2.click();

        //<span id="result-s08" data-testid="result-s08" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Read perms: Read Users, Read Reports</span>

        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s08']"));
        Assert.assertEquals(messagecheck.getText(),"Read perms: Read Reports");

        driver.quit();
    }

    @Test(groups = "QA")
    @Description("Verify the other element in differnet browser")
    public void Dynamiccheckboxlist3()
    {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://qaplayground.com/practice/radio-checkbox");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getCurrentUrl(),"https://qaplayground.com/practice/radio-checkbox");
        Assert.assertEquals(driver.getTitle(),"How to Handle Radio Buttons and Checkboxes in Selenium and Playwright | QA Playground");

        //<input type="checkbox" id="perm_read_billing" class="h-4 w-4 cursor-pointer rounded border-gray-300 accent-primary" aria-label="Read Billing" name="perm_read_billing">

    WebElement Dynamiccheckbox3=driver.findElement(By.xpath("//input[@type='checkbox' and starts-with(@name,'perm_read_billing')]"));
    Dynamiccheckbox3.click();

    //<span id="result-s08" data-testid="result-s08" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Read perms: Read Users, Read Reports, Read Billing</span>
        WebElement messagecheck=driver.findElement(By.xpath("//span[@id='result-s08']"));
        Assert.assertEquals(messagecheck.getText(),"Read perms: Read Billing");
        driver.quit();
    }

}
