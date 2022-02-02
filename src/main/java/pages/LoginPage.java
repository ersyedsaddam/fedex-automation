package pages;

import Base.TestBase;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;


public class LoginPage extends TestBase {

    private static final Map<String, String> langTitles = createTitleLangMap();
    //Page Factory - OR (Object Repository)

    private static Map<String, String> createTitleLangMap() {
        Map<String, String> titles = new HashMap<>();
        titles.put("EN", "Express Delivery, Courier & Shipping Services | FedEx United Kingdom");
        titles.put("NL", "FedEx | Express Delivery, Courier & Shipping Services | Belgium");
        titles.put("FR", "FedEx | Services de livraison, de coursier et d'expédition express| Belgique");
        return titles;
    }

    @FindBy(xpath = "//span[@class='fxg-user-options__sign-in-text sessioncamhidetext']")
    WebElement loginBtn;

    @FindBy(xpath = "//a[@title='Log In']")
    WebElement loginLink;

    @FindBy(xpath = "//a[@title='Log In']")
    WebElement loginLink_fr;

    @FindBy(xpath = "//a[@title='Log In']")
    WebElement loginLink_nl;

    @FindBy(xpath = "//input[@id='NavLoginUserId']")
    WebElement username;

    @FindBy(xpath = "//input[@id='NavLoginPassword']")
    WebElement password;

    @FindBy(xpath = "//*[@class='fxg-button fxg-button--orange fdx-login_error-label-change']")
    WebElement loginclick;

    @FindBy(xpath = "//img[@class='fxg-header__logo']")
    WebElement fedexLogo;

    String language = "EN";

    public LoginPage(){
        PageFactory.initElements(driver, this);

    }
    //Initializing the Page Objects:
    public LoginPage(String language){
        PageFactory.initElements(driver, this);
        this.language = language;
    }
    //Actions


    public void validateLoginPageTitle(final String language) {
        Assert.assertNotNull("Language cannot be null", language);
        Assert.assertNotEquals("Language is mandatory", "");
        String title = driver.getTitle();
        Assert.assertEquals(title, langTitles.get(language));
    }

    public boolean  validateFedexImage(){
        return fedexLogo.isDisplayed();
    }
    public void login(String un, String pwd){
        loginBtn.click();
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginclick.submit();
    }

}
