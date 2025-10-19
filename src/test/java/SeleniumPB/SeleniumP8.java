package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumP8 {

    @Test(groups = "QA")
    @Description("Verify gmail signin")
    public void Gmailsigin()
    {

        WebDriver driver= new ChromeDriver();
        driver.get("https://workspace.google.com/intl/en-US/gmail/");

        //<a
        // class="button button--medium header__aside__button button--desktop button--tablet button--mobile"
        // href="https://accounts.google.com/AccountChooser/signinchooser?service=mail&amp;continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&amp;flowName=GlifWebSignIn&amp;flowEntry=AccountChooser&amp;ec=asw-gmail-globalnav-signin"
        // aria-label="Open the Sign into Gmail page in a new tab"
        // data-g-event="gmail_asw: global nav"
        // data-g-action="sign in"
        // data-g-label="https://accounts.google.com/AccountChooser/signinchooser?service=mail&amp;continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&amp;flowName=GlifWebSignIn&amp;flowEntry=AccountChooser&amp;
        // ec=asw-gmail-globalnav-signin">

            WebElement Signin= driver.findElement(By.xpath("//a[@data-g-action='sign in']"));
            Signin.click();



    }
}
