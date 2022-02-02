package Base;

import Utility.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

    public TestBase(){

        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("C:\\Users\\ersye\\IdeaProjects\\Fedex\\src" +
                    "\\main\\java\\config\\config.properties");
            prop.load(fis);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void initialization(){
        String browsername = prop.getProperty("browser");
        if(browsername.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\ersye\\" +
                    "IdeaProjects\\Webdriver\\chromedriver.exe");
           driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
        driver.get(prop.getProperty("url"));
    }

}
