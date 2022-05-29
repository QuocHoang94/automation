package TestCases;

import Common.APIClass;
import Common.BaseTest;
import Common.Constant;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import url.Urls;

public class DeleteBookTest extends BaseTest implements Urls {

    @BeforeTest
    public void AddNewBook() {
        APIClass apiClass = new APIClass();
        apiClass.AddBookAPI(apiClass.GenerateTokenAPI());
    }

    @Test
    public void DeleteABook() {
        try {
            WebDriver driver = getDriver();
            driver.get(BASE_URL.concat("login"));
            HomePage homePage = new HomePage(driver);
            LoginPage loginPage = homePage.GotoLoginPage();
            loginPage.LogInPage(Constant.USERNAME, Constant.PASSWORD);
            loginPage.WaitElement();
            ProfilePage profilePage = new ProfilePage(driver);
            profilePage.InputSearchBookKey(Constant.BOOKTODELETE);
            Thread.sleep(3000);
            profilePage.ClickDeleteABook();
            profilePage.ConfirmDeleteABook();
            profilePage.IsSearchListEmpty(Constant.BOOKTODELETE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
