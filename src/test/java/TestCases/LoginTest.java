package TestCases;

import Common.BaseTest;
import Common.Constant;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import url.Urls;

public class LoginTest extends BaseTest implements Urls {

    @Test
    public void LoginWithValidUser(){
        try{
            WebDriver driver = getDriver();
            driver.get(BASE_URL.concat("login"));
            HomePage homePage = new HomePage(driver);
            LoginPage loginPage = homePage.GotoLoginPage();
            loginPage.LogInPage(Constant.USERNAME, Constant.PASSWORD);
            String headerText = homePage.GetUsernameLabelValue();
            Assert.assertEquals(Constant.USERNAME,headerText,"Username is not displayed as expected");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
