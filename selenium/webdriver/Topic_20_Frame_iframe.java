package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_20_Frame_iframe {

    // 1- Setup: OS/  Browser/ Web/ Page/ Data/ Variable/ Object/..
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    // 2- Action/ Excute: Tương tác lên element nào/ nhập liệu/ verify/ ...
    @Test
    public void TC_01_Iframe_FormSite() throws InterruptedException {
        // Trang HTML A
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");

        driver.findElement(By.cssSelector("img[alt='Campus Safety Survey']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[contains(@class, 'osano-cm-dialog__close')]")).click();

        // Switch qua iframe
        // Index: page hiện tại có nhiều iframe/ frame
        // Frame/ iframe đầu tiên sẽ có index = 0
        // Khi thêm mới/ update lại/ xóa bớt đi thì đổi index của các iframe
        //driver.switchTo().frame(0); //cách 1

        // Id hoặc name (page có iframe/ frame có id/ name)
        //driver.switchTo().frame("frame-one85593366"); //cách 2

        // WebElement (có thể cover cả 2 cách trên)
        driver.switchTo().frame(driver.findElement(By.cssSelector("div#formTemplateContainer>iframe")));

        //Element thuộc trang HTML B
        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-2"))).selectByVisibleText("Sophomore");
        new Select(driver.findElement(By.cssSelector("select#RESULT_RadioButton-3"))).selectByVisibleText("South Dorm");
        driver.findElement(By.xpath("//label[text()='Male']")).click();
        Thread.sleep(3000);

        // Từ B quay lại A
        driver.switchTo().defaultContent();
//        Thread.sleep(3000);
        // driver đã quay lại A rồi
        driver.findElement(By.cssSelector("a.menu-item-login.fs-btn--transparent-kashmir")).click();
        driver.findElement(By.cssSelector("button#login")).click();
        Thread.sleep(3000);

        Assert.assertEquals(
                driver.findElement(By.cssSelector("div#message-error")).getText(),
                "Username and password are both required.");
    }

    @Test
    public void TC_02_Iframe_ToiDiCodeDao() {
        driver.get("https://toidicodedao.com/");

        driver.switchTo().frame(driver.findElement(By.cssSelector("div.fb_iframe_widget iframe")));

        By followerText = By.xpath("//a[@title='Tôi đi code dạo']/parent::div/following-sibling::div[text()]");
        Assert.assertEquals(driver.findElement(followerText).getText(), "393,339 followers");
    }

    @Test
    public void TC_03_Frame() throws InterruptedException {
        driver.get("https://netbanking.hdfcbank.com/netbanking/");

        driver.switchTo().frame("login_page");

        driver.findElement(By.cssSelector("input[name='fldLoginUserId']")).sendKeys("automationfc");
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("a.login-btn")).click();
        Thread.sleep(5000);

        driver.switchTo().defaultContent();

        driver.findElement(By.cssSelector("input#keyboard")).sendKeys("123456789");
        driver.findElement(By.cssSelector("a#loginBtn")).click();
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.cssSelector("p.error-msg")).getText(),
                "Customer ID/IPIN (Password) is invalid. Please try again.");

    }


    // 3- Clean: delete data test/ account/ closed browser/ ...
    @AfterClass
    public void cleanBrowser() {
//        driver.quit();
    }

}
