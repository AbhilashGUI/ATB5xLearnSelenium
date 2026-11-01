package DemoSites;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest31 {

    @Test
    @Description("Verify the logins check")
    public void logincheck() {
        WebDriver driver = new EdgeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://qaplayground.com/bank/login");

        //<input id="login-username" data-slot="input" autocomplete="username" placeholder="Enter username" data-testid="login-username-input" class="h-8 w-full min-w-0 rounded-lg border px-2.5 py-1 text-base transition-colors outline-none file:inline-flex file:h-6 file:border-0 file:bg-transparent file:text-sm file:font-medium file:text-foreground focus-visible:border-ring focus-visible:ring-3 disabled:pointer-events-none disabled:cursor-not-allowed disabled:bg-input/50 disabled:opacity-50 aria-invalid:border-destructive aria-invalid:ring-3 aria-invalid:ring-destructive/20 md:text-sm dark:bg-input/30 dark:disabled:bg-input/80 dark:aria-invalid:border-destructive/50 dark:aria-invalid:ring-destructive/40 border-slate-300 bg-white text-slate-900 placeholder:text-slate-400 focus-visible:ring-violet-500" type="text" value="" name="username">
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-username"))).sendKeys("standard_user");

        //<input id="login-password" data-slot="input" autocomplete="current-password" placeholder="Enter password" data-testid="login-password-input" class="h-8 w-full min-w-0 rounded-lg border px-2.5 py-1 text-base transition-colors outline-none file:inline-flex file:h-6 file:border-0 file:bg-transparent file:text-sm file:font-medium file:text-foreground focus-visible:border-ring focus-visible:ring-3 disabled:pointer-events-none disabled:cursor-not-allowed disabled:bg-input/50 disabled:opacity-50 aria-invalid:border-destructive aria-invalid:ring-3 aria-invalid:ring-destructive/20 md:text-sm dark:bg-input/30 dark:disabled:bg-input/80 dark:aria-invalid:border-destructive/50 dark:aria-invalid:ring-destructive/40 border-slate-300 bg-white pr-10 text-slate-900 placeholder:text-slate-400 focus-visible:ring-violet-500" type="password" value="" name="password">
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-password"))).sendKeys("bank_sauce");

        //<button type="submit" tabindex="0" data-slot="button" data-testid="login-submit-btn" aria-label="Sign in to SecureBank" class="group/button inline-flex shrink-0 items-center justify-center rounded-lg border border-transparent bg-clip-padding text-sm font-medium whitespace-nowrap transition-all outline-none select-none focus-visible:border-ring focus-visible:ring-3 active:not-aria-[haspopup]:translate-y-px disabled:pointer-events-none disabled:opacity-50 aria-invalid:border-destructive aria-invalid:ring-3 aria-invalid:ring-destructive/20 dark:aria-invalid:border-destructive/50 dark:aria-invalid:ring-destructive/40 [&amp;_svg]:pointer-events-none [&amp;_svg]:shrink-0 [&amp;_svg:not([class*='size-'])]:size-4 text-primary-foreground h-8 gap-1.5 px-2.5 has-data-[icon=inline-end]:pr-2 has-data-[icon=inline-start]:pl-2 w-full bg-violet-600 hover:bg-violet-700 focus-visible:ring-violet-500">Sign In</button>
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='login-submit-btn']"))).click();

        //<h1 class="text-2xl font-bold text-slate-900 dark:text-white" data-testid="dashboard-welcome-message">Welcome back, Alex</h1>
        String Username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-testid='dashboard-welcome-message']"))).getText();
        System.out.println(Username);
        Assert.assertEquals(Username, "Welcome back, Alex");
        driver.quit();
    }


    @Test
    @Description("Verify the incorrect login")
    public void incorrectlogin()
    {
        WebDriver driver=new ChromeDriver();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://qaplayground.com/bank/login");

        //<input id="login-username" data-slot="input" autocomplete="username" placeholder="Enter username" data-testid="login-username-input" class="h-8 w-full min-w-0 rounded-lg border px-2.5 py-1 text-base transition-colors outline-none file:inline-flex file:h-6 file:border-0 file:bg-transparent file:text-sm file:font-medium file:text-foreground focus-visible:border-ring focus-visible:ring-3 disabled:pointer-events-none disabled:cursor-not-allowed disabled:bg-input/50 disabled:opacity-50 aria-invalid:border-destructive aria-invalid:ring-3 aria-invalid:ring-destructive/20 md:text-sm dark:bg-input/30 dark:disabled:bg-input/80 dark:aria-invalid:border-destructive/50 dark:aria-invalid:ring-destructive/40 border-slate-300 bg-white text-slate-900 placeholder:text-slate-400 focus-visible:ring-violet-500" type="text" value="" name="username">
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-username"))).sendKeys("locked_user");

        //<input id="login-password" data-slot="input" autocomplete="current-password" placeholder="Enter password" data-testid="login-password-input" class="h-8 w-full min-w-0 rounded-lg border px-2.5 py-1 text-base transition-colors outline-none file:inline-flex file:h-6 file:border-0 file:bg-transparent file:text-sm file:font-medium file:text-foreground focus-visible:border-ring focus-visible:ring-3 disabled:pointer-events-none disabled:cursor-not-allowed disabled:bg-input/50 disabled:opacity-50 aria-invalid:border-destructive aria-invalid:ring-3 aria-invalid:ring-destructive/20 md:text-sm dark:bg-input/30 dark:disabled:bg-input/80 dark:aria-invalid:border-destructive/50 dark:aria-invalid:ring-destructive/40 border-slate-300 bg-white pr-10 text-slate-900 placeholder:text-slate-400 focus-visible:ring-violet-500" type="password" value="" name="password">
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-password"))).sendKeys("bank_sauce");

        //<button type="submit" tabindex="0" data-slot="button" data-testid="login-submit-btn" aria-label="Sign in to SecureBank" class="group/button inline-flex shrink-0 items-center justify-center rounded-lg border border-transparent bg-clip-padding text-sm font-medium whitespace-nowrap transition-all outline-none select-none focus-visible:border-ring focus-visible:ring-3 active:not-aria-[haspopup]:translate-y-px disabled:pointer-events-none disabled:opacity-50 aria-invalid:border-destructive aria-invalid:ring-3 aria-invalid:ring-destructive/20 dark:aria-invalid:border-destructive/50 dark:aria-invalid:ring-destructive/40 [&amp;_svg]:pointer-events-none [&amp;_svg]:shrink-0 [&amp;_svg:not([class*='size-'])]:size-4 text-primary-foreground h-8 gap-1.5 px-2.5 has-data-[icon=inline-end]:pr-2 has-data-[icon=inline-start]:pl-2 w-full bg-violet-600 hover:bg-violet-700 focus-visible:ring-violet-500">Sign In</button>
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='login-submit-btn']"))).click();

        //<span data-testid="login-error-message">The username or password you entered is incorrect.</span>
        String errortext=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-testid='login-error-message']"))).getText();
        System.out.println(errortext);

        Assert.assertEquals(errortext,"Your account has been suspended. Please contact support.");

        driver.quit();

    }
}
