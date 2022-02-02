package pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SitePopupHandler extends TestBase {

    @FindBy(xpath = "//*[@class='fxg-button fxg-button--orange fxg-geo-locator__button js-geo-country-url' and @aria-label='Nederlands']")
    WebElement locationSelectNL;

    @FindBy(xpath = "(//*[@class='fxg-geo-locator__link-label' and text()='Français']")
    WebElement locationSelectFR;

    @FindBy(xpath= "//*[@class='fxg-geo-locator__link-label' and text()='English']")
    WebElement locationSelectEN;

    @FindBy(xpath = "//label[@for='level2' and text()='Other Analytical Cookies']")
    WebElement checkBx1;

    @FindBy(xpath = "//label[@for='level3' and text()='Tracking Cookies']")
    WebElement checkBx2;

    @FindBy(xpath = "//button[@class=\'" +
            "fxg-cookie-consent__accept fxg-button fxg-button--orange js-fxg-cookie-save is-save-all\']")
    WebElement acceptCks;

    public SitePopupHandler(){
        PageFactory.initElements(driver, this);
    }

    public void languageSelector(String language) {
        if(language.equals("NL")) {
            locationSelectNL.click();
        } else if(language.equals("FR")) {
            locationSelectFR.click();
        } else {
            locationSelectEN.click();
        }
    }
    public void handleCookies() {
        checkBx1.click();
        checkBx2.click();
        acceptCks.click();
    }
}





