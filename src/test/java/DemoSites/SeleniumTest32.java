package DemoSites;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import java.time.Duration;

public class SeleniumTest32 {

    @Test
    @Description("Verify the Accounts check")
    public void accountscheck() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://qaplayground.com/bank/login");

        //<input id="login-username" data-slot="input" autocomplete="username" placeholder="Enter username" data-testid="login-username-input" class="h-8 w-full min-w-0 rounded-lg border px-2.5 py-1 text-base transition-colors outline-none file:inline-flex file:h-6 file:border-0 file:bg-transparent file:text-sm file:font-medium file:text-foreground focus-visible:border-ring focus-visible:ring-3 disabled:pointer-events-none disabled:cursor-not-allowed disabled:bg-input/50 disabled:opacity-50 aria-invalid:border-destructive aria-invalid:ring-3 aria-invalid:ring-destructive/20 md:text-sm dark:bg-input/30 dark:disabled:bg-input/80 dark:aria-invalid:border-destructive/50 dark:aria-invalid:ring-destructive/40 border-slate-300 bg-white text-slate-900 placeholder:text-slate-400 focus-visible:ring-violet-500" type="text" value="" name="username">
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-username"))).sendKeys("standard_user");

        //<input id="login-password" data-slot="input" autocomplete="current-password" placeholder="Enter password" data-testid="login-password-input" class="h-8 w-full min-w-0 rounded-lg border px-2.5 py-1 text-base transition-colors outline-none file:inline-flex file:h-6 file:border-0 file:bg-transparent file:text-sm file:font-medium file:text-foreground focus-visible:border-ring focus-visible:ring-3 disabled:pointer-events-none disabled:cursor-not-allowed disabled:bg-input/50 disabled:opacity-50 aria-invalid:border-destructive aria-invalid:ring-3 aria-invalid:ring-destructive/20 md:text-sm dark:bg-input/30 dark:disabled:bg-input/80 dark:aria-invalid:border-destructive/50 dark:aria-invalid:ring-destructive/40 border-slate-300 bg-white pr-10 text-slate-900 placeholder:text-slate-400 focus-visible:ring-violet-500" type="password" value="" name="password">
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-password"))).sendKeys("bank_sauce");

        //<button type="submit" tabindex="0" data-slot="button" data-testid="login-submit-btn" aria-label="Sign in to SecureBank" class="group/button inline-flex shrink-0 items-center justify-center rounded-lg border border-transparent bg-clip-padding text-sm font-medium whitespace-nowrap transition-all outline-none select-none focus-visible:border-ring focus-visible:ring-3 active:not-aria-[haspopup]:translate-y-px disabled:pointer-events-none disabled:opacity-50 aria-invalid:border-destructive aria-invalid:ring-3 aria-invalid:ring-destructive/20 dark:aria-invalid:border-destructive/50 dark:aria-invalid:ring-destructive/40 [&amp;_svg]:pointer-events-none [&amp;_svg]:shrink-0 [&amp;_svg:not([class*='size-'])]:size-4 text-primary-foreground h-8 gap-1.5 px-2.5 has-data-[icon=inline-end]:pr-2 has-data-[icon=inline-start]:pl-2 w-full bg-violet-600 hover:bg-violet-700 focus-visible:ring-violet-500">Sign In</button>
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='login-submit-btn']"))).click();

        //<a class="flex items-center gap-2.5 rounded-md px-2 py-2 text-sm transition-colors text-slate-600 hover:bg-slate-100 hover:text-slate-900 dark:text-slate-400 dark:hover:bg-slate-800 dark:hover:text-white" data-testid="sidebar-link-accounts" data-nav="accounts" href="/bank/accounts"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="lucide lucide-credit-card h-4 w-4 shrink-0" aria-hidden="true"><rect width="20" height="14" x="2" y="5" rx="2"></rect><line x1="2" x2="22" y1="10" y2="10"></line></svg><span>Accounts</span></a>
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/bank/accounts']"))).click();

        System.out.println("Accounts view");

        //<p class="font-medium text-slate-900 dark:text-white" data-testid="account-row-name">Everyday Checking</p>
        String Account1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Everyday Checking']"))).getText();
        System.out.println(Account1);

        //<p class="font-medium text-slate-900 dark:text-white" data-testid="account-row-name">High-Yield Savings</p>
        String Account2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='High-Yield Savings']"))).getText();
        System.out.println(Account2);

        driver.quit();
    }

    @Test
    @Description("Verify the Add account")
    public void addaccount() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://qaplayground.com/bank/login");

        //<input id="login-username" data-slot="input" autocomplete="username" placeholder="Enter username" data-testid="login-username-input" class="h-8 w-full min-w-0 rounded-lg border px-2.5 py-1 text-base transition-colors outline-none file:inline-flex file:h-6 file:border-0 file:bg-transparent file:text-sm file:font-medium file:text-foreground focus-visible:border-ring focus-visible:ring-3 disabled:pointer-events-none disabled:cursor-not-allowed disabled:bg-input/50 disabled:opacity-50 aria-invalid:border-destructive aria-invalid:ring-3 aria-invalid:ring-destructive/20 md:text-sm dark:bg-input/30 dark:disabled:bg-input/80 dark:aria-invalid:border-destructive/50 dark:aria-invalid:ring-destructive/40 border-slate-300 bg-white text-slate-900 placeholder:text-slate-400 focus-visible:ring-violet-500" type="text" value="" name="username">
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-username"))).sendKeys("standard_user");

        //<input id="login-password" data-slot="input" autocomplete="current-password" placeholder="Enter password" data-testid="login-password-input" class="h-8 w-full min-w-0 rounded-lg border px-2.5 py-1 text-base transition-colors outline-none file:inline-flex file:h-6 file:border-0 file:bg-transparent file:text-sm file:font-medium file:text-foreground focus-visible:border-ring focus-visible:ring-3 disabled:pointer-events-none disabled:cursor-not-allowed disabled:bg-input/50 disabled:opacity-50 aria-invalid:border-destructive aria-invalid:ring-3 aria-invalid:ring-destructive/20 md:text-sm dark:bg-input/30 dark:disabled:bg-input/80 dark:aria-invalid:border-destructive/50 dark:aria-invalid:ring-destructive/40 border-slate-300 bg-white pr-10 text-slate-900 placeholder:text-slate-400 focus-visible:ring-violet-500" type="password" value="" name="password">
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-password"))).sendKeys("bank_sauce");

        //<button type="submit" tabindex="0" data-slot="button" data-testid="login-submit-btn" aria-label="Sign in to SecureBank" class="group/button inline-flex shrink-0 items-center justify-center rounded-lg border border-transparent bg-clip-padding text-sm font-medium whitespace-nowrap transition-all outline-none select-none focus-visible:border-ring focus-visible:ring-3 active:not-aria-[haspopup]:translate-y-px disabled:pointer-events-none disabled:opacity-50 aria-invalid:border-destructive aria-invalid:ring-3 aria-invalid:ring-destructive/20 dark:aria-invalid:border-destructive/50 dark:aria-invalid:ring-destructive/40 [&amp;_svg]:pointer-events-none [&amp;_svg]:shrink-0 [&amp;_svg:not([class*='size-'])]:size-4 text-primary-foreground h-8 gap-1.5 px-2.5 has-data-[icon=inline-end]:pr-2 has-data-[icon=inline-start]:pl-2 w-full bg-violet-600 hover:bg-violet-700 focus-visible:ring-violet-500">Sign In</button>
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='login-submit-btn']"))).click();

        //<a class="flex items-center gap-2.5 rounded-md px-2 py-2 text-sm transition-colors text-slate-600 hover:bg-slate-100 hover:text-slate-900 dark:text-slate-400 dark:hover:bg-slate-800 dark:hover:text-white" data-testid="sidebar-link-accounts" data-nav="accounts" href="/bank/accounts"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="lucide lucide-credit-card h-4 w-4 shrink-0" aria-hidden="true"><rect width="20" height="14" x="2" y="5" rx="2"></rect><line x1="2" x2="22" y1="10" y2="10"></line></svg><span>Accounts</span></a>
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/bank/accounts']"))).click();

        //<button type="button" tabindex="0" data-slot="button" data-testid="add-account-btn" class="group/button inline-flex shrink-0 items-center justify-center rounded-lg border border-transparent bg-clip-padding text-sm font-medium whitespace-nowrap transition-all outline-none select-none focus-visible:border-ring focus-visible:ring-3 focus-visible:ring-ring/50 active:not-aria-[haspopup]:translate-y-px disabled:pointer-events-none disabled:opacity-50 aria-invalid:border-destructive aria-invalid:ring-3 aria-invalid:ring-destructive/20 dark:aria-invalid:border-destructive/50 dark:aria-invalid:ring-destructive/40 [&amp;_svg]:pointer-events-none [&amp;_svg]:shrink-0 [&amp;_svg:not([class*='size-'])]:size-4 text-primary-foreground h-8 px-2.5 has-data-[icon=inline-end]:pr-2 has-data-[icon=inline-start]:pl-2 gap-1.5 bg-violet-600 hover:bg-violet-700"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="lucide lucide-plus h-4 w-4" aria-hidden="true"><path d="M5 12h14"></path><path d="M12 5v14"></path></svg>Add Account</button>
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='add-account-btn']"))).click();

        //<input id="account-form-name" data-slot="input" placeholder="e.g. Everyday Checking" data-testid="account-form-name-input" class="h-8 w-full min-w-0 rounded-lg border border-input bg-transparent px-2.5 py-1 text-base transition-colors outline-none file:inline-flex file:h-6 file:border-0 file:bg-transparent file:text-sm file:font-medium file:text-foreground placeholder:text-muted-foreground focus-visible:border-ring focus-visible:ring-3 focus-visible:ring-ring/50 disabled:pointer-events-none disabled:cursor-not-allowed disabled:bg-input/50 disabled:opacity-50 aria-invalid:border-destructive aria-invalid:ring-3 aria-invalid:ring-destructive/20 md:text-sm dark:bg-input/30 dark:disabled:bg-input/80 dark:aria-invalid:border-destructive/50 dark:aria-invalid:ring-destructive/40" type="text" value="" name="name">
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account-form-name"))).sendKeys("Test account 1");

        //<button type="button" data-placeholder="" tabindex="0" id="account-form-type-trigger" role="combobox" aria-expanded="true" aria-haspopup="listbox" data-slot="select-trigger" data-size="default" data-testid="account-form-type-select" class="flex items-center justify-between gap-1.5 rounded-lg border border-input bg-transparent py-2 pr-2 pl-2.5 text-sm whitespace-nowrap transition-colors outline-none select-none focus-visible:border-ring focus-visible:ring-3 focus-visible:ring-ring/50 disabled:cursor-not-allowed disabled:opacity-50 aria-invalid:border-destructive aria-invalid:ring-3 aria-invalid:ring-destructive/20 data-placeholder:text-muted-foreground data-[size=default]:h-8 data-[size=sm]:h-7 data-[size=sm]:rounded-[min(var(--radius-md),10px)] *:data-[slot=select-value]:line-clamp-1 *:data-[slot=select-value]:flex *:data-[slot=select-value]:items-center *:data-[slot=select-value]:gap-1.5 dark:bg-input/30 dark:hover:bg-input/50 dark:aria-invalid:border-destructive/50 dark:aria-invalid:ring-destructive/40 [&amp;_svg]:pointer-events-none [&amp;_svg]:shrink-0 [&amp;_svg:not([class*='size-'])]:size-4 w-full" data-popup-open="" data-pressed="" data-popup-side="bottom" aria-controls="base-ui-_r_1s_-list"><span data-placeholder="" data-slot="select-value" class="flex flex-1 text-left">Select type</span><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="lucide lucide-chevron-down pointer-events-none size-4 text-muted-foreground" aria-hidden="true" data-popup-open=""><path d="m6 9 6 6 6-6"></path>▼</svg></button>
        wait.until(ExpectedConditions.elementToBeClickable(By.id("account-form-type-trigger"))).click();

        //<button type="button" data-placeholder="" tabindex="0" id="account-form-type-trigger" role="combobox" aria-expanded="false" aria-haspopup="listbox" data-slot="select-trigger" data-size="default" data-testid="account-form-type-select" class="flex items-center justify-between gap-1.5 rounded-lg border border-input bg-transparent py-2 pr-2 pl-2.5 text-sm whitespace-nowrap transition-colors outline-none select-none focus-visible:border-ring focus-visible:ring-3 focus-visible:ring-ring/50 disabled:cursor-not-allowed disabled:opacity-50 aria-invalid:border-destructive aria-invalid:ring-3 aria-invalid:ring-destructive/20 data-placeholder:text-muted-foreground data-[size=default]:h-8 data-[size=sm]:h-7 data-[size=sm]:rounded-[min(var(--radius-md),10px)] *:data-[slot=select-value]:line-clamp-1 *:data-[slot=select-value]:flex *:data-[slot=select-value]:items-center *:data-[slot=select-value]:gap-1.5 dark:bg-input/30 dark:hover:bg-input/50 dark:aria-invalid:border-destructive/50 dark:aria-invalid:ring-destructive/40 [&amp;_svg]:pointer-events-none [&amp;_svg]:shrink-0 [&amp;_svg:not([class*='size-'])]:size-4 w-full"><span data-placeholder="" data-slot="select-value" class="flex flex-1 text-left">Select type</span><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="lucide lucide-chevron-down pointer-events-none size-4 text-muted-foreground" aria-hidden="true"><path d="m6 9 6 6 6-6"></path>▼</svg></button>
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@role='option' and normalize-space(.)='Savings']"))).click();

        //<input id="base-ui-_r_1j_" data-slot="input" step="0.01" placeholder="0.00" class="h-8 w-full min-w-0 rounded-lg border border-input bg-transparent px-2.5 py-1 text-base transition-colors outline-none file:inline-flex file:h-6 file:border-0 file:bg-transparent file:text-sm file:font-medium file:text-foreground placeholder:text-muted-foreground focus-visible:border-ring focus-visible:ring-3 focus-visible:ring-ring/50 disabled:pointer-events-none disabled:cursor-not-allowed disabled:bg-input/50 disabled:opacity-50 aria-invalid:border-destructive aria-invalid:ring-3 aria-invalid:ring-destructive/20 md:text-sm dark:bg-input/30 dark:disabled:bg-input/80 dark:aria-invalid:border-destructive/50 dark:aria-invalid:ring-destructive/40 pl-7" type="number" value="100" name="account_balance_field" data-gtm-form-interact-field-id="2">
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-slot='input' and @step='0.01']"))).sendKeys("100");

        //<span data-unchecked="" role="checkbox" tabindex="0" id="base-ui-_r_1k_" aria-checked="false" data-slot="checkbox" data-testid="account-form-accept-terms-checkbox" class="peer relative flex size-4 shrink-0 items-center justify-center rounded-[4px] border transition-colors outline-none group-has-disabled/field:opacity-50 after:absolute after:-inset-x-3 after:-inset-y-2 focus-visible:border-ring focus-visible:ring-3 focus-visible:ring-ring/50 disabled:cursor-not-allowed disabled:opacity-50 aria-invalid:border-destructive aria-invalid:ring-3 aria-invalid:ring-destructive/20 aria-invalid:aria-checked:border-primary dark:bg-input/30 dark:aria-invalid:border-destructive/50 dark:aria-invalid:ring-destructive/40 data-checked:border-primary data-checked:bg-primary data-checked:text-primary-foreground dark:data-checked:bg-primary border-slate-300" aria-labelledby="account-form-accept-terms-label"></span>
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@role='checkbox']"))).click();


        //<button type="button" tabindex="0" data-slot="button" data-testid="save-account-form-btn" class="group/button inline-flex shrink-0 items-center justify-center rounded-lg border border-transparent bg-clip-padding text-sm font-medium whitespace-nowrap transition-all outline-none select-none focus-visible:border-ring focus-visible:ring-3 focus-visible:ring-ring/50 active:not-aria-[haspopup]:translate-y-px disabled:pointer-events-none disabled:opacity-50 aria-invalid:border-destructive aria-invalid:ring-3 aria-invalid:ring-destructive/20 dark:aria-invalid:border-destructive/50 dark:aria-invalid:ring-destructive/40 [&amp;_svg]:pointer-events-none [&amp;_svg]:shrink-0 [&amp;_svg:not([class*='size-'])]:size-4 text-primary-foreground h-8 gap-1.5 px-2.5 has-data-[icon=inline-end]:pr-2 has-data-[icon=inline-start]:pl-2 bg-violet-600 hover:bg-violet-700">Add Account</button>
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='save-account-form-btn']"))).click();

        System.out.println("Account added successfully");


    }
}