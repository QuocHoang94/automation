package Common;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class BasePage {

    public final WebDriver driver;
    public final By bookNameLink = By.xpath("//a[contains(text(), \"" + Constant.BOOKNAME + "\")]");
    public final By profileLeftMenuBtn = By.xpath("//ul[@class='menu-list']//span[text()='Profile']/ancestor::li[contains(@class,'btn')]");
    public final By searchBox = By.id("searchBox");
    public final By bookList = By.xpath("//span[contains(@id,'see-book')]//a");
    public final By deleteBook = By.xpath("//a[contains(text(),'Learning JavaScript Design Patterns')]");

    public static final By usernameLabel = By.id("userName-value");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(By cssSelector) {
        return driver.findElement(cssSelector);
    }

    public String GetElementText(By cssSelector) {
        return driver.findElement(cssSelector).getText();
    }

    public String GetUsernameLabelValue() {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameLabel));
        return GetElementText(usernameLabel);
    }

    public boolean IsElementDisplay(By byLocator) {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
        return driver.findElement(byLocator).isDisplayed();
    }

    public void passAlert(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
            Assert.assertTrue(alert.getText().contains("Thanks."));
        } catch (Exception e) {
            //exception handling
        }
    }

    public void GoToProfilePage(){
        findElement(profileLeftMenuBtn).click();
    }

    public List<WebElement> InputSearchBookKey(String searchBookKey){
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        searchBookKey = searchBookKey.toLowerCase();
        findElement(searchBox).sendKeys(searchBookKey);
        return driver.findElements(bookList);
    }

    public void WaitElement(){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(deleteBook));
    }

    public void IsSearchListEmpty(String searchKey){
        List<WebElement> books = InputSearchBookKey(searchKey);
        Assert.assertEquals((long) books.size(), 0);
    }
}
