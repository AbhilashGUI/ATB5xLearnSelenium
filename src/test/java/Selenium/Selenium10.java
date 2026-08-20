package Selenium;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium10 {

    @Test(groups ="QA")
    @Description("Verify the current url and title of vwo application")
    public void Testvwologin()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(),"Login - Wingify");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");
        driver.quit();

    }

    @Test(groups = "QA")
    @Description("Verify the title and current url of naukri.com")
    public void naukriuicheck()
    {
      WebDriver driver= new ChromeDriver();
      driver.get("https://www.naukri.com/");
      driver.manage().window().maximize();
      System.out.println(driver.getTitle());
      System.out.println(driver.getCurrentUrl());
      Assert.assertEquals(driver.getCurrentUrl(),"https://www.naukri.com/");
      Assert.assertEquals(driver.getTitle(),"Jobs - Recruitment - Job Search - Employment - Job Vacancies - Naukri.com");
      driver.quit();

    }

}