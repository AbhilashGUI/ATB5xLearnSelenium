package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg61 {

    @Test
    @Description("Verify the Date-pickers")
    public void SiblingLocatedDatefields()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/date-picker");
        driver.manage().window().maximize();

        //<input aria-label="Appointment date" class="h-9 rounded-md border border-input bg-background px-3 text-sm shadow-sm focus:ring-1 focus:ring-ring focus:outline-none" type="date" name="appointment_date_2025">
        //<span class="date-picker-module__PNVq0G__fieldLabel">Appointment Date</span>
        WebElement appointmentdate=driver.findElement(By.name("appointment_date_2025"));
        appointmentdate.sendKeys("01-10-2025");

        String Lastvisit=appointmentdate.getAttribute("value");
        System.out.println("Last Visit was on: "+Lastvisit);

        //<span id="result-s06" data-testid="result-s06" class="flex min-h-8 min-w-[220px] flex-1 items-center rounded-[6px] border px-2.5 py-1.5 font-[family-name:var(--font-ibm-plex-mono)] text-[12.5px] transition-colors max-sm:min-w-full border-[color-mix(in_srgb,var(--success)_25%,transparent)] bg-[color-mix(in_srgb,var(--success)_8%,transparent)] text-[var(--success-readable)]">Appointment: 2026-10-01</span>

        WebElement messagecheck=driver.findElement(By.id("result-s06"));
        Assert.assertEquals(messagecheck.getText(),"Appointment: 2025-10-01");

//<input aria-label="Return date" class="h-9 rounded-md border border-input bg-background px-3 text-sm shadow-sm focus:ring-1 focus:ring-ring focus:outline-none" type="date" name="return_date_2025">
        WebElement returndate=driver.findElement(By.name("return_date_2025"));
        returndate.sendKeys("15-10-2025");

        String Nextvisit=returndate.getAttribute("value");
        System.out.println("Next visit is on: "+Nextvisit);

        driver.quit();
    }

    @Test
    @Description("verify the Same  in the other browser")
    public void Firstandnextdatecheck() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/date-picker");
        driver.manage().window().maximize();

        //<input aria-label="Appointment date" class="h-9 rounded-md border border-input bg-background px-3 text-sm shadow-sm focus:ring-1 focus:ring-ring focus:outline-none" type="date" name="appointment_date_2025">
        WebElement Firstappointment=driver.findElement(By.xpath("//input[@name='appointment_date_2025']"));
        Firstappointment.sendKeys("01-10-2026");

        Thread.sleep(2000);

        //<input aria-label="Return date" class="h-9 rounded-md border border-input bg-background px-3 text-sm shadow-sm focus:ring-1 focus:ring-ring focus:outline-none" type="date" name="return_date_2025">
        WebElement NextAppointment=driver.findElement(By.name("return_date_2025"));
        NextAppointment.sendKeys("10-10-2026");

        Thread.sleep(2000);

        driver.quit();
    }


}
