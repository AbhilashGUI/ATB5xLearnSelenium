package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Seleniumpg68 {

    @Test
    @Description("Verify the similar scenario in different browser")
    public void tabledataofrow() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://qaplayground.com/practice/data-table");
        driver.manage().window().maximize();

        //<tr data-testid="book-row" data-book-id="book-001" data-genre="technology" class="data-table-module__WJUPia__tr"><td data-col="sr-no" data-testid="cell-sr-no" class="data-table-module__WJUPia__td">1</td><td data-col="book-name" class="data-table-module__WJUPia__td">The Pragmatic Programmer</td><td data-col="book-genre" data-genre-value="Technology" class="data-table-module__WJUPia__td"><span class="data-table-module__WJUPia__genreBadge data-table-module__WJUPia__genre-technology" data-testid="genre-badge">Technology</span></td><td data-col="book-author" class="data-table-module__WJUPia__td">Andrew Hunt</td><td data-col="book-isbn" class="data-table-module__WJUPia__td data-table-module__WJUPia__isbnCell">ISBN-9780135957059</td><td data-col="book-published" class="data-table-module__WJUPia__td">1999-10-20</td><td data-col="actions" data-testid="cell-actions" class="data-table-module__WJUPia__td data-table-module__WJUPia__actionsCell"><button type="button" data-testid="btn-edit-book" aria-label="Edit The Pragmatic Programmer" data-book-id="book-001" class="data-table-module__WJUPia__btnEdit">Edit</button><button type="button" aria-label="Delete The Pragmatic Programmer" data-book-id="book-001" class="data-table-module__WJUPia__btnDelete">Delete</button></td></tr>

        WebElement tablerowdata = driver.findElement(By.xpath("//tr[@data-testid='book-row']"));
        String Rowdata = tablerowdata.getText();
        System.out.println(Rowdata + " | ");


        driver.quit();

    }

    @Test
    @Description("Verify the data table automation practice")
    public void tabledataofcolumn() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaplayground.com/practice/data-table");
        driver.manage().window().maximize();


        //<thead data-testid="table-head"><tr><th scope="col" data-testid="col-sr-no" data-col="sr-no" class="data-table-module__WJUPia__th">Sr No.</th><th scope="col" data-testid="col-book-name" data-col="book-name" data-sort="bookName" aria-sort="none" class="data-table-module__WJUPia__th data-table-module__WJUPia__thSortable" tabindex="0" role="columnheader"><span class="data-table-module__WJUPia__thContent">Book Name<span aria-hidden="true" class="data-table-module__WJUPia__sortNeutral">⇅</span></span></th><th scope="col" data-testid="col-book-genre" data-col="book-genre" data-sort="bookGenre" aria-sort="none" class="data-table-module__WJUPia__th data-table-module__WJUPia__thSortable" tabindex="0" role="columnheader"><span class="data-table-module__WJUPia__thContent">Book Genre<span aria-hidden="true" class="data-table-module__WJUPia__sortNeutral">⇅</span></span></th><th scope="col" data-testid="col-book-author" data-col="book-author" data-sort="bookAuthor" aria-sort="none" class="data-table-module__WJUPia__th data-table-module__WJUPia__thSortable" tabindex="0" role="columnheader"><span class="data-table-module__WJUPia__thContent">Book Author<span aria-hidden="true" class="data-table-module__WJUPia__sortNeutral">⇅</span></span></th><th scope="col" data-testid="col-book-isbn" data-col="book-isbn" data-sort="bookIsbn" aria-sort="none" class="data-table-module__WJUPia__th data-table-module__WJUPia__thSortable" tabindex="0" role="columnheader"><span class="data-table-module__WJUPia__thContent">Book ISBN<span aria-hidden="true" class="data-table-module__WJUPia__sortNeutral">⇅</span></span></th><th scope="col" data-testid="col-book-published" data-col="book-published" data-sort="bookPublished" aria-sort="none" class="data-table-module__WJUPia__th data-table-module__WJUPia__thSortable" tabindex="0" role="columnheader"><span class="data-table-module__WJUPia__thContent">Book Published<span aria-hidden="true" class="data-table-module__WJUPia__sortNeutral">⇅</span></span></th><th scope="col" data-testid="col-actions" data-col="actions" class="data-table-module__WJUPia__th">Actions</th></tr></thead>
        WebElement tablecolumndata=driver.findElement(By.xpath("//thead[@alldata-testid='table-head']"));
        String Columndata = tablecolumndata.getText();
        System.out.println(Columndata + " | ");


        driver.quit();

    }
    //td: table
    //tr: table row
    //th: table column
}
