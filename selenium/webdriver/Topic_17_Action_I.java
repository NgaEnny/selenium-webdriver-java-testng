package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_17_Action_I {

    // 1- Setup: OS/  Browser/ Web/ Page/ Data/ Variable/ Object/..
    WebDriver driver;
    WebDriverWait explicitWait;
    Actions action;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        action = new Actions(driver);

        action.moveByOffset(0, 0).perform();

        // Set browser tại vị trí 0x0
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));


    }

    // 2- Action/ Excute: Tương tác lên element nào/ nhập liệu/ verify/ ...
    @Test
    public void TC_01_Hover() throws InterruptedException {
        driver.get("https://automationfc.github.io/jquery-tooltip/");

        action.moveToElement(driver.findElement(By.cssSelector("input#age"))).perform();
        Thread.sleep(2000);

        Assert.assertEquals(
                driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(),
                "We ask for your age only for statistical purposes."
        );
    }

    @Test
    public void TC_02_Hover_Myntra() throws InterruptedException {
        driver.get("https://www.myntra.com/");

        action.moveToElement(driver.findElement(By.xpath("//a[@class='desktop-main' and text()='Kids']"))).perform();
        Thread.sleep(2000);

        // Web Element click();
//        driver.findElement(By.xpath("//a[@class='desktop-categoryName' and text()='Home & Bath']")).click();

        // Actions click();
        action.click(driver.findElement(By.xpath("//a[@class='desktop-categoryName' and text()='Home & Bath']"))).perform();
        Assert.assertEquals(driver.findElement(By.cssSelector("span.breadcrumbs-crumb")).getText(), "Kids Home Bath");
    }

    @Test
    public void TC_03_Hover_Fahasa() throws InterruptedException {
        driver.get("https://www.fahasa.com/");

        action.moveToElement(driver.findElement(By.cssSelector("span.icon_menu"))).perform();
        Thread.sleep(3000);//

//        driver.findElement(By.cssSelector("g#close-popup")).click();
        action.moveToElement(driver.findElement(By.xpath("//a//span[text()='Đồ Chơi']"))).perform();
        Thread.sleep(3000);

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement closePopup = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("g#close-popup")));
//        closePopup.click();
        driver.findElement(By.cssSelector("g#close-popup")).click();
        driver.findElement(By.xpath("//li//div[@class='mega-col-inner']//a[text()='Mô Hình Giấy']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='ves-breadcrumbs']//strong[text()='Mô Hình Giấy']")).isDisplayed());
    }

    // 3- Clean: delete data test/ account/ closed browser/ ...
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}
