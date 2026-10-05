package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Seleniumpg76 {

    @Test
    @Description("Verify the data table automation practice")
    public void ReadAllHeaders()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/data-table");
        driver.manage().window().maximize();

        //<thead data-testid="table-head"><tr><th scope="col" data-testid="col-sr-no" data-col="sr-no" class="data-table-module__WJUPia__th">Sr No.</th><th scope="col" data-testid="col-book-name" data-col="book-name" data-sort="bookName" aria-sort="none" class="data-table-module__WJUPia__th data-table-module__WJUPia__thSortable" tabindex="0" role="columnheader"><span class="data-table-module__WJUPia__thContent">Book Name<span aria-hidden="true" class="data-table-module__WJUPia__sortNeutral">⇅</span></span></th><th scope="col" data-testid="col-book-genre" data-col="book-genre" data-sort="bookGenre" aria-sort="none" class="data-table-module__WJUPia__th data-table-module__WJUPia__thSortable" tabindex="0" role="columnheader"><span class="data-table-module__WJUPia__thContent">Book Genre<span aria-hidden="true" class="data-table-module__WJUPia__sortNeutral">⇅</span></span></th><th scope="col" data-testid="col-book-author" data-col="book-author" data-sort="bookAuthor" aria-sort="none" class="data-table-module__WJUPia__th data-table-module__WJUPia__thSortable" tabindex="0" role="columnheader"><span class="data-table-module__WJUPia__thContent">Book Author<span aria-hidden="true" class="data-table-module__WJUPia__sortNeutral">⇅</span></span></th><th scope="col" data-testid="col-book-isbn" data-col="book-isbn" data-sort="bookIsbn" aria-sort="none" class="data-table-module__WJUPia__th data-table-module__WJUPia__thSortable" tabindex="0" role="columnheader"><span class="data-table-module__WJUPia__thContent">Book ISBN<span aria-hidden="true" class="data-table-module__WJUPia__sortNeutral">⇅</span></span></th><th scope="col" data-testid="col-book-published" data-col="book-published" data-sort="bookPublished" aria-sort="none" class="data-table-module__WJUPia__th data-table-module__WJUPia__thSortable" tabindex="0" role="columnheader"><span class="data-table-module__WJUPia__thContent">Book Published<span aria-hidden="true" class="data-table-module__WJUPia__sortNeutral">⇅</span></span></th><th scope="col" data-testid="col-actions" data-col="actions" class="data-table-module__WJUPia__th">Actions</th></tr></thead>

        List<WebElement> headers=driver.findElements(By.xpath("//thead[@data-testid='table-head']"));

        for (WebElement Header:headers)
        {
            System.out.println(Header.getText());
        }


        //// Selenium WebDriver — read all headers
        //List<WebElement> headers = driver.findElements(
        //  By.cssSelector("#dataTable thead th")
        //);
        //for (WebElement h : headers) {
        //  System.out.println(h.getText());
        //}

        driver.quit();
    }

}
