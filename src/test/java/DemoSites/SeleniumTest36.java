package DemoSites;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest36 {

    @Test
    @Description("Verify the Billpay")
    public void billpay()
    {
        WebDriver driver=new EdgeDriver();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.manage().window().maximize();
        driver.get("https://qaplayground.com/bank/login");

        //<input id="login-username" data-slot="input" autocomplete="username" placeholder="Enter username" data-testid="login-username-input" class="h-8 w-full min-w-0 rounded-lg border px-2.5 py-1 text-base transition-colors outline-none file:inline-flex file:h-6 file:border-0 file:bg-transparent file:text-sm file:font-medium file:text-foreground focus-visible:border-ring focus-visible:ring-3 disabled:pointer-events-none disabled:cursor-not-allowed disabled:bg-input/50 disabled:opacity-50 aria-invalid:border-destructive aria-invalid:ring-3 aria-invalid:ring-destructive/20 md:text-sm dark:bg-input/30 dark:disabled:bg-input/80 dark:aria-invalid:border-destructive/50 dark:aria-invalid:ring-destructive/40 border-slate-300 bg-white text-slate-900 placeholder:text-slate-400 focus-visible:ring-violet-500" type="text" value="" name="username">
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-username"))).sendKeys("standard_user");

        //<input id="login-password" data-slot="input" autocomplete="current-password" placeholder="Enter password" data-testid="login-password-input" class="h-8 w-full min-w-0 rounded-lg border px-2.5 py-1 text-base transition-colors outline-none file:inline-flex file:h-6 file:border-0 file:bg-transparent file:text-sm file:font-medium file:text-foreground focus-visible:border-ring focus-visible:ring-3 disabled:pointer-events-none disabled:cursor-not-allowed disabled:bg-input/50 disabled:opacity-50 aria-invalid:border-destructive aria-invalid:ring-3 aria-invalid:ring-destructive/20 md:text-sm dark:bg-input/30 dark:disabled:bg-input/80 dark:aria-invalid:border-destructive/50 dark:aria-invalid:ring-destructive/40 border-slate-300 bg-white pr-10 text-slate-900 placeholder:text-slate-400 focus-visible:ring-violet-500" type="password" value="" name="password">
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-password"))).sendKeys("bank_sauce");

        //<button type="submit" tabindex="0" data-slot="button" data-testid="login-submit-btn" aria-label="Sign in to SecureBank" class="group/button inline-flex shrink-0 items-center justify-center rounded-lg border border-transparent bg-clip-padding text-sm font-medium whitespace-nowrap transition-all outline-none select-none focus-visible:border-ring focus-visible:ring-3 active:not-aria-[haspopup]:translate-y-px disabled:pointer-events-none disabled:opacity-50 aria-invalid:border-destructive aria-invalid:ring-3 aria-invalid:ring-destructive/20 dark:aria-invalid:border-destructive/50 dark:aria-invalid:ring-destructive/40 [&amp;_svg]:pointer-events-none [&amp;_svg]:shrink-0 [&amp;_svg:not([class*='size-'])]:size-4 text-primary-foreground h-8 gap-1.5 px-2.5 has-data-[icon=inline-end]:pr-2 has-data-[icon=inline-start]:pl-2 w-full bg-violet-600 hover:bg-violet-700 focus-visible:ring-violet-500">Sign In</button>
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='login-submit-btn']"))).click();

        //<span>Bill Pay</span>
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Bill Pay']"))).click();

        //<button type="button" class="nav-module__Efbrta__themeToggle" aria-label="Switch to dark mode" title="Switch to dark mode"><span class="nav-module__Efbrta__themeToggleIcon"><svg width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" aria-hidden="true"><path d="M21 12.79A9 9 0 1 1 11.21 3 7 7 0 0 0 21 12.79z"></path></svg></span></button>
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Switch to dark mode']"))).click();

        //<button type="button" data-placeholder="" tabindex="0" id="bill-pay-from-trigger" role="combobox" aria-expanded="false" aria-haspopup="listbox" data-slot="select-trigger" data-size="default" data-testid="bill-pay-from-select" class="flex items-center justify-between gap-1.5 rounded-lg border border-input bg-transparent py-2 pr-2 pl-2.5 text-sm whitespace-nowrap transition-colors outline-none select-none focus-visible:border-ring focus-visible:ring-3 focus-visible:ring-ring/50 disabled:cursor-not-allowed disabled:opacity-50 aria-invalid:border-destructive aria-invalid:ring-3 aria-invalid:ring-destructive/20 data-placeholder:text-muted-foreground data-[size=default]:h-8 data-[size=sm]:h-7 data-[size=sm]:rounded-[min(var(--radius-md),10px)] *:data-[slot=select-value]:line-clamp-1 *:data-[slot=select-value]:flex *:data-[slot=select-value]:items-center *:data-[slot=select-value]:gap-1.5 dark:bg-input/30 dark:hover:bg-input/50 dark:aria-invalid:border-destructive/50 dark:aria-invalid:ring-destructive/40 [&amp;_svg]:pointer-events-none [&amp;_svg]:shrink-0 [&amp;_svg:not([class*='size-'])]:size-4 w-full"><span data-placeholder="" data-slot="select-value" class="flex flex-1 text-left">Select account</span><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="lucide lucide-chevron-down pointer-events-none size-4 text-muted-foreground" aria-hidden="true"><path d="m6 9 6 6 6-6"></path>▼</svg></button>
        wait.until(ExpectedConditions.elementToBeClickable(By.id("bill-pay-from-trigger"))).click();

        //<div role="option" aria-selected="false" tabindex="-1" data-slot="select-item" data-testid="bill-pay-from-option" data-account-id="acc-savings-1" class="relative flex w-full cursor-default items-center gap-1.5 rounded-md py-1 pr-8 pl-1.5 text-sm outline-hidden select-none focus:bg-accent focus:text-accent-foreground not-data-[variant=destructive]:focus:**:text-accent-foreground data-disabled:pointer-events-none data-disabled:opacity-50 [&amp;_svg]:pointer-events-none [&amp;_svg]:shrink-0 [&amp;_svg:not([class*='size-'])]:size-4 *:[span]:last:flex *:[span]:last:items-center *:[span]:last:gap-2"><div class="flex flex-1 shrink-0 gap-2 whitespace-nowrap">High-Yield Savings — $12,820.00</div></div>
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='option' and  @data-testid='bill-pay-from-option']"))).click();


        //<input id="biller-search-input" data-slot="input" role="combobox" aria-expanded="false" aria-controls="biller-search-results" autocomplete="off" placeholder="Search billers…" data-testid="biller-search-input" class="h-8 w-full min-w-0 rounded-lg border border-input bg-transparent px-2.5 py-1 text-base transition-colors outline-none file:inline-flex file:h-6 file:border-0 file:bg-transparent file:text-sm file:font-medium file:text-foreground placeholder:text-muted-foreground focus-visible:border-ring focus-visible:ring-3 focus-visible:ring-ring/50 disabled:pointer-events-none disabled:cursor-not-allowed disabled:bg-input/50 disabled:opacity-50 aria-invalid:border-destructive aria-invalid:ring-3 aria-invalid:ring-destructive/20 md:text-sm dark:bg-input/30 dark:disabled:bg-input/80 dark:aria-invalid:border-destructive/50 dark:aria-invalid:ring-destructive/40 pl-8" type="text" value="">
        wait.until(ExpectedConditions.elementToBeClickable(By.id("biller-search-input"))).click();


        //<div class="mt-1.5 flex items-center gap-1.5 text-xs text-slate-500" data-testid="biller-selected-summary"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="lucide lucide-circle-check h-3 w-3 text-emerald-500" aria-hidden="true"><circle cx="12" cy="12" r="10"></circle><path d="m9 12 2 2 4-4"></path></svg><span class="font-medium text-slate-700 dark:text-slate-300">City Electric Co.</span><span>— Ref: ACC-0042</span></div>
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@role='option' and contains(.,'City Electric Co.')]"))).click();


        //<input id="bill-amount" data-slot="input" min="0.01" step="0.01" placeholder="0.00" data-testid="bill-amount-input" class="h-8 w-full min-w-0 rounded-lg border border-input bg-transparent px-2.5 py-1 text-base transition-colors outline-none file:inline-flex file:h-6 file:border-0 file:bg-transparent file:text-sm file:font-medium file:text-foreground placeholder:text-muted-foreground focus-visible:border-ring focus-visible:ring-3 focus-visible:ring-ring/50 disabled:pointer-events-none disabled:cursor-not-allowed disabled:bg-input/50 disabled:opacity-50 aria-invalid:border-destructive aria-invalid:ring-3 aria-invalid:ring-destructive/20 md:text-sm dark:bg-input/30 dark:disabled:bg-input/80 dark:aria-invalid:border-destructive/50 dark:aria-invalid:ring-destructive/40 pl-7" type="number" value="" name="amount">
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bill-amount"))).sendKeys("1");


        //<input id="bill-payment-date" data-slot="input" min="2026-11-01" data-testid="bill-payment-date-input" class="h-8 min-w-0 rounded-lg border border-input bg-transparent px-2.5 py-1 text-base transition-colors outline-none file:inline-flex file:h-6 file:border-0 file:bg-transparent file:text-sm file:font-medium file:text-foreground placeholder:text-muted-foreground focus-visible:border-ring focus-visible:ring-3 focus-visible:ring-ring/50 disabled:pointer-events-none disabled:cursor-not-allowed disabled:bg-input/50 disabled:opacity-50 aria-invalid:border-destructive aria-invalid:ring-3 aria-invalid:ring-destructive/20 md:text-sm dark:bg-input/30 dark:disabled:bg-input/80 dark:aria-invalid:border-destructive/50 dark:aria-invalid:ring-destructive/40 w-40" type="date" value="2026-11-01">
        wait.until(ExpectedConditions.elementToBeClickable(By.id("bill-payment-date"))).sendKeys("04-11-2026");

        //<button type="submit" tabindex="0" data-slot="button" data-testid="review-bill-btn" class="group/button inline-flex items-center justify-center rounded-lg border border-transparent bg-clip-padding text-sm font-medium whitespace-nowrap transition-all outline-none select-none focus-visible:border-ring focus-visible:ring-3 focus-visible:ring-ring/50 active:not-aria-[haspopup]:translate-y-px disabled:pointer-events-none disabled:opacity-50 aria-invalid:border-destructive aria-invalid:ring-3 aria-invalid:ring-destructive/20 dark:aria-invalid:border-destructive/50 dark:aria-invalid:ring-destructive/40 [&amp;_svg]:pointer-events-none [&amp;_svg]:shrink-0 [&amp;_svg:not([class*='size-'])]:size-4 text-primary-foreground h-8 gap-1.5 px-2.5 has-data-[icon=inline-end]:pr-2 has-data-[icon=inline-start]:pl-2 flex-1 bg-violet-600 hover:bg-violet-700">Review Payment</button>
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='review-bill-btn' and text()='Review Payment']"))).click();

        //<button type="button" tabindex="0" data-slot="button" data-testid="confirm-bill-btn" class="group/button inline-flex shrink-0 items-center justify-center rounded-lg border border-transparent bg-clip-padding text-sm font-medium whitespace-nowrap transition-all outline-none select-none focus-visible:border-ring focus-visible:ring-3 focus-visible:ring-ring/50 active:not-aria-[haspopup]:translate-y-px disabled:pointer-events-none disabled:opacity-50 aria-invalid:border-destructive aria-invalid:ring-3 aria-invalid:ring-destructive/20 dark:aria-invalid:border-destructive/50 dark:aria-invalid:ring-destructive/40 [&amp;_svg]:pointer-events-none [&amp;_svg]:shrink-0 [&amp;_svg:not([class*='size-'])]:size-4 text-primary-foreground h-8 gap-1.5 px-2.5 has-data-[icon=inline-end]:pr-2 has-data-[icon=inline-start]:pl-2 bg-violet-600 hover:bg-violet-700">Confirm Payment</button>
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='confirm-bill-btn' and normalize-space()='Confirm Payment']"))).click();


        //<h1 class="mb-1 text-2xl font-bold text-slate-900 dark:text-white" data-testid="bill-pay-success-heading">Payment Scheduled</h1>
        String message=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-testid='bill-pay-success-heading']"))).getText();
        System.out.println(message);

        Assert.assertEquals(message,"Payment Scheduled");
        driver.quit();






    }
}
