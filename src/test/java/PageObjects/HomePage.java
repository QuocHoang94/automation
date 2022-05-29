package PageObjects;

import Common.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage GotoLoginPage(){
        return new LoginPage(driver);
    }
}
