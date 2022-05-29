package TestCases;

import Common.BaseTest;
import PageObjects.BookStorePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import url.Urls;

import java.util.List;

public class SearchBooksTest extends BaseTest implements Urls {
    @Test
    public void SearchBooks() {
        WebDriver driver = getDriver();
        driver.navigate().to(BASE_URL.concat("books"));
        BookStorePage bookStorePage = new BookStorePage(driver);
        List<WebElement> books = bookStorePage.InputSearchBookKey("Design");
        bookStorePage.IsSearchedBookCorrectly(books, "Design");
    }
}
