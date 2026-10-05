package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seleniumpg75 {

    @Test
    @Description("Verify the data table automation practice")
    public void ReadASpecificCell()
    {
        WebDriver driver=new EdgeDriver();
        driver.get("https://qaplayground.com/practice/data-table");
        driver.manage().window().maximize();

        //<tr data-testid="book-row" data-book-id="book-001" data-genre="technology" class="data-table-module__WJUPia__tr">
        // <td data-col="sr-no" data-testid="cell-sr-no" class="data-table-module__WJUPia__td">1</td>

        WebElement serialno=driver.findElement(By.xpath("//tr[@data-testid='book-row']/td[@data-col='sr-no']"));
        System.out.println("Serial number: "+serialno.getText());

        // <td data-col="book-name" class="data-table-module__WJUPia__td">The Pragmatic Programmer</td><span class="data-table-module__WJUPia__genreBadge data-table-module__WJUPia__genre-technology" data-testid="genre-badge">Technology</span>

        WebElement bookname=driver.findElement(By.xpath("//tr[@data-book-id='book-001']/td[@data-col='book-name']"));
        System.out.println("Book Name:"+bookname.getText());

        // </td><td data-col="book-author" class="data-table-module__WJUPia__td">Andrew Hunt</td>

        WebElement bookauthor=driver.findElement(By.xpath("//tr[@data-testid='book-row']/td[@data-col='book-author']"));
        System.out.println("Book author:"+bookauthor.getText());

        // <td data-col="book-isbn" class="data-table-module__WJUPia__td data-table-module__WJUPia__isbnCell">ISBN-9780135957059</td>


        WebElement ISBN=driver.findElement(By.xpath("//tr[@data-testid='book-row']/td[@data-col='book-isbn']"));
        System.out.println("ISBN:"+ISBN.getText());

        // <td data-col="book-genre" data-genre-value="Technology" class="data-table-module__WJUPia__td">
        WebElement generetype=driver.findElement(By.xpath("//tr[@data-testid='book-row']/td[@data-col='book-genre']"));
        System.out.println("Gener type:"+generetype.getText());

        // <td data-col="book-published" class="data-table-module__WJUPia__td">1999-10-20</td>

        WebElement publishedon=driver.findElement(By.xpath("//tr[@data-testid='book-row']/td[@data-col='book-published']"));
        System.out.println("Published on:"+publishedon.getText());


        Assert.assertEquals("The Pragmatic Programmer",bookname.getText());
        Assert.assertEquals("Andrew Hunt",bookauthor.getText());
        Assert.assertEquals("ISBN-9780135957059",ISBN.getText());
        Assert.assertEquals("Technology",generetype.getText());
        Assert.assertEquals("1999-10-20",publishedon.getText());

        driver.quit();



    }

    @Test
    @Description("Verify the same scenario in different browser")
    public void readaspecificcell()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://qaplayground.com/practice/data-table");
        driver.manage().window().maximize();

        //<button type="button" class="data-table-module__WJUPia__pgBtn" data-testid="pagination-page-2" aria-label="Page 2">2</button>

        WebElement page2=driver.findElement(By.xpath("//button[@data-testid='pagination-page-2']"));
        page2.click();


        //<tr data-testid="book-row" data-book-id="book-009" data-genre="non-fiction" class="data-table-module__WJUPia__tr">
        // <td data-col="sr-no" data-testid="cell-sr-no" class="data-table-module__WJUPia__td">9</td>

        WebElement serialnumber=driver.findElement(By.xpath("//tr[@data-book-id='book-009']/td[@data-col='sr-no']"));
        System.out.println("Serial number: "+serialnumber.getText());
        // <td data-col="book-name" class="data-table-module__WJUPia__td">Sapiens</td

        WebElement bookname=driver.findElement(By.xpath("//tr[@data-book-id='book-009']/td[@data-col='book-name']"));
        System.out.println("Book name: "+bookname.getText());

        // <td data-col="book-genre" data-genre-value="Non-Fiction" class="data-table-module__WJUPia__td"><span class="data-table-module__WJUPia__genreBadge data-table-module__WJUPia__genre-non-fiction" data-testid="genre-badge">Non-Fiction</span></td>
        WebElement generetype=driver.findElement(By.xpath("//tr[@data-book-id='book-009']/td[@data-col='book-genre']"));
        System.out.println("Generetype: " +generetype.getText());
        // <td data-col="book-author" class="data-table-module__WJUPia__td">Yuval Noah Harari</td>

        WebElement bookauthor=driver.findElement(By.xpath("//tr[@data-book-id='book-009']/td[@data-col='book-author']"));
        System.out.println("Book author: "+bookauthor.getText());

        // <td data-col="book-isbn" class="data-table-module__WJUPia__td data-table-module__WJUPia__isbnCell">ISBN-9780062316097</td>

        WebElement ISBN=driver.findElement(By.xpath("//tr[@data-book-id='book-009']/td[@data-col='book-isbn']"));
        System.out.println("ISBN: "+ISBN.getText());

        // <td data-col="book-published" class="data-table-module__WJUPia__td">2011-01-01</td><td data-col="actions" data-testid="cell-actions" class="data-table-module__WJUPia__td data-table-module__WJUPia__actionsCell"><button type="button" data-testid="btn-edit-book" aria-label="Edit Sapiens" data-book-id="book-009" class="data-table-module__WJUPia__btnEdit">Edit</button><button type="button" aria-label="Delete Sapiens" data-book-id="book-009" class="data-table-module__WJUPia__btnDelete">Delete</button></td></tr>

        WebElement publishedon=driver.findElement(By.xpath("//tr[@data-book-id='book-009']/td[@data-col='book-published']"));
        System.out.println("Published on: "+publishedon.getText());

        Assert.assertEquals("9",serialnumber.getText());
        Assert.assertEquals("Sapiens",bookname.getText());
        Assert.assertEquals("Non-Fiction",generetype.getText());
        Assert.assertEquals("Yuval Noah Harari",bookauthor.getText());
        Assert.assertEquals("ISBN-9780062316097",ISBN.getText());
        Assert.assertEquals("2011-01-01",publishedon.getText());


        driver.quit();


    }

}
