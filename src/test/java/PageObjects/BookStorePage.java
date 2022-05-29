package PageObjects;

import Common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Locale;

public class BookStorePage extends BasePage {

    private static final By btnToStore = By.id("gotoStore");
    WebDriverWait wait = new WebDriverWait(driver, 50L);
    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    public BookDetailPage SelectABook(){
        findElement(btnToStore).sendKeys(Keys.RETURN);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(bookNameLink)));
        driver.findElement(bookNameLink).click();
        return new BookDetailPage(driver);
    }

    public void IsSearchedBookCorrectly(List<WebElement> books , String searchKey){
        for (WebElement book : books) {
            String bookName = book.getText().toLowerCase();
            System.out.println(bookName);
            Assert.assertTrue(bookName.contains(searchKey.toLowerCase()), book.getText() + "doesn't contain"  + searchKey);
        }
    }
}
