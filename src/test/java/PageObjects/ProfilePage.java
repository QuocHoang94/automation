package PageObjects;

import Common.BasePage;
import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {

    private final By closeDeleteModelButton = By.id("closeSmallModal-ok");
    public final By deleteButton = By.id("delete-record-undefined");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void ClickDeleteABook() {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        driver.findElement(deleteButton).click();
    }

    public void ConfirmDeleteABook() {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.elementToBeClickable(closeDeleteModelButton));
        driver.findElement(closeDeleteModelButton).click();
    }
}
