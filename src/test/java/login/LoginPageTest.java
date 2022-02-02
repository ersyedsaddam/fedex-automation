package login;

import Base.TestBase;
import Utility.DataInitializer;
import model.User;
import model.UserType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FedexPageFactory;
import pages.HomePage;
import pages.LoginPage;
import pages.SitePopupHandler;

public class LoginPageTest extends TestBase {

    HomePage homePage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
    }

    @Test
    public void loginPageTitleTest() {
        LoginPage loginPage = FedexPageFactory.loginPage();
        loginPage.validateLoginPageTitle("EN");

        SitePopupHandler sitePopupHandler = FedexPageFactory.sitePopupHandler();
        sitePopupHandler.languageSelector("EN");

        loginPage.validateLoginPageTitle("NL");

        sitePopupHandler.handleCookies();

        User privateUser = DataInitializer.usersMap.get(UserType.Individual);
        loginPage.login(privateUser.getUsername(), privateUser.getPassword());
    }

    @Test
    public void loginPageTitleTest_NL() {
        LoginPage loginPage = FedexPageFactory.loginPage();
        loginPage.validateLoginPageTitle("EN");

        SitePopupHandler sitePopupHandler = FedexPageFactory.sitePopupHandler();
        sitePopupHandler.languageSelector("NL");
        loginPage.validateLoginPageTitle("NL");
    }

    @Test
    public void validateFedexImage() {
        boolean flag = FedexPageFactory.loginPage().validateFedexImage();
        Assert.assertTrue(flag);
    }

    @Test(priority = 2)
    public void loginTest() {
        User privateUser = DataInitializer.usersMap.get(UserType.Individual);

        FedexPageFactory.loginPage().login(privateUser.getUsername(), privateUser.getPassword());
    }

    @Test(priority = 2)
    public void loginTest_FR() {
        FedexPageFactory.loginPage("FR").login(prop.getProperty("username"), prop.getProperty("password"));
    }

    /* @AfterMethod
    public void tearDown() {
        driver.quit();
    }*/
}





