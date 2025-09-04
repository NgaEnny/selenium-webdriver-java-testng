package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Run_On_Browser_Version_3x {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    @Test
    public void TC_01_Run_On_Firefox() {
        System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        driver = new FirefoxDriver();

        // Selenium version 4.x
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Selenium version 3.x
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.get("https://demo.nopcommerce.com/");

        driver.quit();
    }

    @Test
    public void TC_02_Run_On_Chrome() {
        System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://demo.nopcommerce.com/");
        driver.quit();
    }

    @Test
    public void TC_02_Run_On_Edge() {
        System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
        driver = new EdgeDriver();

        driver.get("https://demo.nopcommerce.com/");
        driver.quit();
    }
}

