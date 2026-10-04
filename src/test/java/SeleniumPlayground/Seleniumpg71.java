package SeleniumPlayground;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Seleniumpg71 {

    @Test
    @Description("Verify the data tables automation practice")
    public void Editagenere() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://qaplayground.com/practice/data-table");
        driver.manage().window().maximize();

        //<select id="genre-filter-select" data-testid="genre-filter" aria-label="Filter by genre" class="data-table-module__WJUPia__filterSelect"><option value="All" selected="">All Genres</option><option value="Technology">Technology</option><option value="Fantasy">Fantasy</option><option value="Science Fiction">Science Fiction</option><option value="Dystopian">Dystopian</option><option value="Fiction">Fiction</option><option value="Non-Fiction">Non-Fiction</option></select>

        Select selectgenere = new Select(driver.findElement(By.xpath("//select[@id='genre-filter-select']")));
        selectgenere.selectByValue("Science Fiction");

        Thread.sleep(2000);

        //<button type="button" data-testid="btn-edit-book" aria-label="Edit Dune" data-book-id="book-005" class="data-table-module__WJUPia__btnEdit">Edit</button>
        WebElement editcheck = driver.findElement(By.xpath("//button[@data-testid='btn-edit-book']"));
        editcheck.click();

        //<input id="edit-book-name" data-testid="edit-input-book-name" class="data-table-module__WJUPia__fieldInput" type="text" value="Dune" name="bookName">

        WebElement bookname = driver.findElement(By.xpath("//input[@id='edit-book-name']"));
        bookname.clear();
        bookname.sendKeys("Testcheck");

        //<input id="edit-book-author" data-testid="edit-input-book-author" class="data-table-module__WJUPia__fieldInput" type="text" value="Frank Herbert" name="bookAuthor">
        WebElement authorname = driver.findElement(By.xpath("//input[@ data-testid='edit-input-book-author']"));
        authorname.clear();
        authorname.sendKeys("Testcheck2");

        //<input class="data-table-module__WJUPia__fieldInput" type="text" value="ISBN-9780441013593" name="isbn_field_book-005">
        WebElement ISBNname = driver.findElement(By.xpath("//input[@value='ISBN-9780441013593']"));
        ISBNname.clear();
        ISBNname.sendKeys("ISBN-4158963214587");


        //<input id="edit-book-published" placeholder="YYYY-MM-DD" data-testid="edit-input-book-published" class="data-table-module__WJUPia__fieldInput" type="text" value="1965-08-01" name="bookPublished">
        WebElement publisheddate = driver.findElement(By.xpath("//input[@placeholder='YYYY-MM-DD']"));
        publisheddate.clear();
        publisheddate.sendKeys("1526-04-14");

        //<button type="button" aria-label="Save changes for Dune" data-testid="edit-dialog-save" class="data-table-module__WJUPia__btnPrimary">Save Changes</button>
        WebElement savebutton = driver.findElement(By.xpath("//button[@aria-label='Save changes for Dune']"));
        savebutton.click();

        Thread.sleep(3000);

        driver.quit();

    }

    @Test
    @Description("Verify the similar scenrio in differnt browser")
    public void Editagenere2() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaplayground.com/practice/data-table");
        driver.manage().window().maximize();

        //<select id="genre-filter-select" data-testid="genre-filter" aria-label="Filter by genre" class="data-table-module__WJUPia__filterSelect"><option value="All" selected="">All Genres</option><option value="Technology">Technology</option><option value="Fantasy">Fantasy</option><option value="Science Fiction">Science Fiction</option><option value="Dystopian">Dystopian</option><option value="Fiction">Fiction</option><option value="Non-Fiction">Non-Fiction</option></select>
        Select selectgenere2 = new Select(driver.findElement(By.xpath("//select[@data-testid='genre-filter']")));
        selectgenere2.selectByIndex(5);

        //<button type="button" data-testid="btn-edit-book" aria-label="Edit Murder on the Orient Express" data-book-id="book-020" class="data-table-module__WJUPia__btnEdit">Edit</button>
        WebElement editbutton = driver.findElement(By.xpath("//button[@aria-label='Edit Murder on the Orient Express']"));
        editbutton.click();

        //<input id="edit-book-name" data-testid="edit-input-book-name" class="data-table-module__WJUPia__fieldInput" type="text" value="Murder on the Orient Express" name="bookName">

        WebElement bookname = driver.findElement(By.xpath("//input[@id='edit-book-name']"));
        bookname.clear();
        bookname.sendKeys("Testcheck");

        //<select id="edit-book-genre" name="bookGenre" data-testid="edit-select-genre" class="data-table-module__WJUPia__fieldInput"><option value="Technology">Technology</option><option value="Fantasy">Fantasy</option><option value="Science Fiction">Science Fiction</option><option value="Dystopian">Dystopian</option><option value="Fiction">Fiction</option><option value="Non-Fiction">Non-Fiction</option></select>

        Select selectagenere3 = new Select(driver.findElement(By.name("bookGenre")));
        selectagenere3.selectByValue("Non-Fiction");

        //<input id="edit-book-published" placeholder="YYYY-MM-DD" data-testid="edit-input-book-published" class="data-table-module__WJUPia__fieldInput" type="text" value="1934-01-01" name="bookPublished">
        WebElement publishedon = driver.findElement(By.xpath("//input[@placeholder='YYYY-MM-DD']"));
        publishedon.clear();
        publishedon.sendKeys("1739-10-01");


        //<button type="button" aria-label="Save changes for Murder on the Orient Express" data-testid="edit-dialog-save" class="data-table-module__WJUPia__btnPrimary">Save Changes</button>

        WebElement savechangesbutton = driver.findElement(By.xpath("//button[text()='Save Changes']"));
        savechangesbutton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }

}

