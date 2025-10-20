package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SeleniumP12 {

    @Test(groups = "QA")
    @Description("Verify the wellness site login ")
    public void wellnesslogin()
    {
        WebDriver driver= new EdgeDriver();
        driver.get("https://wf-ecomm-pwa-git-feat-enhanced-search-wellness-forever.vercel.app/");
        driver.manage().window().maximize();

        //<input
        //type="text"
        //name="user"
        // id="user"
        // data-placeholder="User Id"
        // placeholder=" "
        // class="block h-[56px] w-full appearance-none rounded-t-md border-0 border-b border-transparent bg-secondary-50 px-3 py-2 text-base placeholder-secondary-400 autofill:bg-secondary-50 focus-within:border-b-2 focus-within:border-primary-800 focus-within:bg-secondary-50 focus:border-primary-800 focus:outline-none focus:ring-0 sm:text-sm">
       // WebElement entermobilenumber= driver.findElement(By.xpath("//input[contains(@data-placeholder,'User Id')]"));
        //entermobilenumber.sendKeys("8977507845");

        //<div
        // class="flex cursor-pointer justify-between p-4 "
        // aria-hidden="true">
        // <div class="flex items-center gap-3">
        // <svg xmlns="http://www.w3.org/2000/svg"
        // fill="none"
        // viewBox="0 0 18 18"
        // class="h-4 w-4">
        // <path fill="#DC362E"
        // d="M2 18c-.55 0-1.02-.196-1.413-.587A1.926 1.926 0 0 1 0 16V2C0 1.45.196.98.588.587A1.926 1.926 0 0 1 2 0h7v2H2v14h7v2H2Zm11-4-1.375-1.45 2.55-2.55H6V8h8.175l-2.55-2.55L13 4l5 5-5 5Z">
        // </path></svg>
        // <p class="text-sm font-semibold text-red-500">
        // Logout
        // </p></div></div>


        //WebElement logout= driver.findElement(By.xpath("//div[contains@text,'Logout']"));
        //logout.click();
    }
}
