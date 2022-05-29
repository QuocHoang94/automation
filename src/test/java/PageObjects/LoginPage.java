package PageObjects;

import Common.BasePage;
import Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private static final By usernameSel = By.id("userName");
    private static final By passwordSel = By.id("password");
    private static final By loginButton = By.id("login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void LogInPage(String username, String password) throws InterruptedException {
        findElement(usernameSel).sendKeys(username);
        findElement(passwordSel).sendKeys(password);
        findElement(loginButton).sendKeys(Keys.RETURN);
    }
}
