package SeleniumPB;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumP19 {


    EdgeDriver driver;

    @BeforeTest
    public void openbrowser() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(options);
    }

    @Test(groups = "QA")
    @Description("Verify the webtables")
    public void positivecase() {
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/webtable.html");

        /***Following are the xpath of listed companies
         Google://*[@id="customers"]/tbody/tr[2]/td[1]
         Meta://*[@id="customers"]/tbody/tr[3]/td[1]
         Microsoft://*[@id="customers"]/tbody/tr[4]/td[1]
         Islandtrading:/*[@id="customers"]/tbody/tr[5]/td[1]
         Adobe:/*[@id="customers"]/tbody/tr[6]/td[1]
         Amazon:/*[@id="customers"]/tbody/tr[7]/td[1]

         //Tr=rows
         //Td=columns
         ***/

        String firstpart = "//table[@id=\"customers\"]/tbody/tr[";
        String secondpart = "]/td[";
        String thirdpart = "]";

        int row = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr")).size();
        int column = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr[2]/td")).size();


        for (int i = 2; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                String dynamic_xpath = firstpart + i + secondpart + j + thirdpart;
                String data = driver.findElement(By.xpath(dynamic_xpath)).getText();
                System.out.println(data);

                if (data.contains("Helen Bennet")) {
                    //String country_xpath = dynamic_xpath + "/following-sibling::td";
                    String row_xpath = "//table[@id='customers']/tbody/tr[5]";
                    String country = driver.findElement(By.xpath(row_xpath + "/td[3]")).getText();
                    System.out.println("______");
                    System.out.println("Helen Bennett is In - " + country + " Followed by  siblings");

                }
            }
            System.out.println();
        }
    }
        @AfterTest
        public void closebrowser () {
            driver.quit();
    }
}









