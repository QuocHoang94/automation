package TestCases;

import Common.APIClass;
import Common.BaseTest;
import Common.Constant;
import PageObjects.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import url.Urls;

public class AddBookToCollectionTest extends BaseTest implements Urls {


    @Test
    public void AddBookToCollection() {
        try {
            APIClass apiClass = new APIClass();
            WebDriver driver = getDriver();
            driver.get(BASE_URL.concat("login"));
            apiClass.DeleteBookAPI(apiClass.GenerateTokenAPI());
            HomePage homePage = new HomePage(driver);
            LoginPage loginPage = homePage.GotoLoginPage();
            loginPage.LogInPage(Constant.USERNAME, Constant.PASSWORD);

            //        Select a book
            BookStorePage bookStorePage = new BookStorePage(driver);
            bookStorePage.SelectABook();
            BookDetailPage bookDetailPage = new BookDetailPage(driver);

            //        Add book to collection then display success alert
            bookDetailPage.AddBookToCollection();
            loginPage.passAlert(driver);


            //        check if book shown in  profile
            ProfilePage profilePage = new ProfilePage(driver);
            loginPage.GoToProfilePage();
            Assert.assertTrue(loginPage.IsElementDisplay(profilePage.bookNameLink));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
