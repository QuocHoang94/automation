package PageObjects;

import Common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookDetailPage extends BasePage {

    private static final By addBookToCollectionButton = By.xpath("//button[contains(text(),'Add To Your Collection')]");

    WebDriverWait wait = new WebDriverWait(driver, 10);

    public BookDetailPage(WebDriver driver) {
        super(driver);
    }

    public void AddBookToCollection() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(addBookToCollectionButton));
        findElement(addBookToCollectionButton).sendKeys(Keys.RETURN);
//        wait.until(ExpectedConditions.alertIsPresent());
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
//        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//        alert.accept();

    }
}
