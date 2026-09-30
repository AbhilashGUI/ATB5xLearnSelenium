package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg35 {

    @Test(groups = "QA")
    @Description("Verify the status code button links")
    public void APIStatusCodeLink()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/links");
        driver.manage().window().maximize();
        //<button class="inline-flex h-8 items-center justify-center gap-2 rounded-md border border-input bg-background px-3 text-xs font-medium whitespace-nowrap shadow-sm transition-colors hover:bg-accent hover:text-accent-foreground focus-visible:ring-1 focus-visible:ring-ring focus-visible:outline-none disabled:pointer-events-none disabled:opacity-50">Create User (201)</button>

        WebElement createuser=driver.findElement(By.xpath("//button[contains(normalize-space(),'Create User')]"));
        Assert.assertTrue(createuser.isDisplayed());

        //<button class="inline-flex h-8 items-center justify-center gap-2 rounded-md border border-input bg-background px-3 text-xs font-medium whitespace-nowrap shadow-sm transition-colors hover:bg-accent hover:text-accent-foreground focus-visible:ring-1 focus-visible:ring-ring focus-visible:outline-none disabled:pointer-events-none disabled:opacity-50">No Content (204)</button>
        WebElement nocontent=driver.findElement(By.xpath("//button[contains(normalize-space(),'No Content')]"));
        Assert.assertTrue(nocontent.isDisplayed());

        //<button class="inline-flex h-8 items-center justify-center gap-2 rounded-md border border-input bg-background px-3 text-xs font-medium whitespace-nowrap shadow-sm transition-colors hover:bg-accent hover:text-accent-foreground focus-visible:ring-1 focus-visible:ring-ring focus-visible:outline-none disabled:pointer-events-none disabled:opacity-50">Moved (301)</button>
        WebElement moved=driver.findElement(By.xpath("//button[contains(normalize-space(),'Moved')]"));
        Assert.assertTrue(moved.isDisplayed());

        //<button class="inline-flex h-8 items-center justify-center gap-2 rounded-md border border-input bg-background px-3 text-xs font-medium whitespace-nowrap shadow-sm transition-colors hover:bg-accent hover:text-accent-foreground focus-visible:ring-1 focus-visible:ring-ring focus-visible:outline-none disabled:pointer-events-none disabled:opacity-50">Bad Request (400)</button>
        WebElement badrequest=driver.findElement(By.xpath("//button[contains(normalize-space(),'Bad Request')]"));
        Assert.assertTrue(badrequest.isDisplayed());

        //<button class="inline-flex h-8 items-center justify-center gap-2 rounded-md border border-input bg-background px-3 text-xs font-medium whitespace-nowrap shadow-sm transition-colors hover:bg-accent hover:text-accent-foreground focus-visible:ring-1 focus-visible:ring-ring focus-visible:outline-none disabled:pointer-events-none disabled:opacity-50">Unauthorized (401)</button>
        WebElement unauthorized=driver.findElement(By.xpath("//button[contains(normalize-space(),'Unauthorized')]"));
        Assert.assertTrue(unauthorized.isDisplayed());

        //<button class="inline-flex h-8 items-center justify-center gap-2 rounded-md border border-input bg-background px-3 text-xs font-medium whitespace-nowrap shadow-sm transition-colors hover:bg-accent hover:text-accent-foreground focus-visible:ring-1 focus-visible:ring-ring focus-visible:outline-none disabled:pointer-events-none disabled:opacity-50">Forbidden (403)</button>
        WebElement forbidden=driver.findElement(By.xpath("//button[contains(normalize-space(),'Forbidden')]"));
        Assert.assertTrue(forbidden.isDisplayed());

        //<button class="inline-flex h-8 items-center justify-center gap-2 rounded-md border border-input bg-background px-3 text-xs font-medium whitespace-nowrap shadow-sm transition-colors hover:bg-accent hover:text-accent-foreground focus-visible:ring-1 focus-visible:ring-ring focus-visible:outline-none disabled:pointer-events-none disabled:opacity-50">Not Found (404)</button>
        WebElement notfound=driver.findElement(By.xpath("//button[contains(normalize-space(),'Not Found')]"));
        Assert.assertTrue(notfound.isDisplayed());

        driver.quit();



    }
}
