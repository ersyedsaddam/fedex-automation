package pages;
import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {


    @FindBy(xpath = "//input[@name='trackingnumber']")
    WebElement trackingId;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    WebElement trackBtn;

    //Initializing the Page Objects:

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    public String trackingid(String trackid){
        trackingId.sendKeys(trackid);
        return trackid;
    }
    public String trackbtn(){
        trackBtn.click();
        return trackbtn();
    }










}
