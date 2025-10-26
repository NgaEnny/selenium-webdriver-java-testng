package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_21_Fixed_Popup {

    // 1- Setup: OS/  Browser/ Web/ Page/ Data/ Variable/ Object/..
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    // 2- Action/ Excute: Tương tác lên element nào/ nhập liệu/ verify/ ...
    @Test
    public void TC_01_NgoaiNgu24h() throws InterruptedException {
        driver.get("https://ngoaingu24h.vn/");

        driver.findElement(By.cssSelector("div.action button.nav-auth:first-of-type")).click();

        By loginPopup = By.cssSelector("div.custom-dialog-paper");

        // Kiểm tra 1 element hiển thị có trong HTML
        // Hiển thị trên UI -> true
        // Ko hiển thị trên UI -> false
        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());

        driver.findElement(By.cssSelector("div.input-item input[type='text']")).sendKeys("automationfc");
        driver.findElement(By.cssSelector("div.input-item input[type='password']")).sendKeys("automationfc");
        driver.findElement(By.cssSelector("div.auth-form button.dialog-button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement snackbar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("notistack-snackbar")));

        Assert.assertEquals(snackbar.getText(),
                "Bạn đã nhập sai tài khoản hoặc mật khẩu!");

        driver.findElement(By.cssSelector("button.close-btn")).click();
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElements(loginPopup).size(), 0);
        //element biến mất trong DOM

    }

    @Test
    public void TC_02_Kyna() throws InterruptedException {
        driver.get("https://skills.kynaenglish.vn/dang-nhap");

        By loginPopup = By.cssSelector("div.k-popup-account-mb-content");

        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());

        driver.findElement(By.id("user-login")).sendKeys("automationfc");
        driver.findElement(By.id("user-password")).sendKeys("automationfc");
        driver.findElement(By.id("btn-submit-login")).click();
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.id("password-form-login-message")).getText(), "Sai tên đăng nhập hoặc mật khẩu");
    }

    @Test
    public void TC_03_Tiki() throws InterruptedException {
        driver.get("https://tiki.vn");

        driver.findElement(By.cssSelector("div[data-view-id='header_header_account_container']")).click();
        Thread.sleep(3000);

        By loginPopup = By.cssSelector("div.ReactModal__Content");

        // Popup hiển thị
        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());
        Assert.assertEquals(driver.findElements(loginPopup).size(), 1);

        driver.findElement(By.cssSelector("p.login-with-email")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='error-mess'][1]")).getText(), "Email không được để trống");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='error-mess'][2]")).getText(), "Mật khẩu không được để trống");

        driver.findElement(By.cssSelector("img.close-img")).click();
        Thread.sleep(2000);

// Popup ko hiển thị (ko còn trong DOM/HTML)
        Assert.assertEquals(driver.findElements(loginPopup).size(), 0);

    }

    @Test
    public void TC_04_Facebook(){
        driver.get("https://www.facebook.com");

        //find element -> click()
        driver.findElement(By.cssSelector("a[role='button'][rel='dialog']")).click();

        By anotherLanguage = By.cssSelector("a[role='button'][class*='layerCancel']");

        // Kiểm tra hiển thị
        Assert.assertTrue(driver.findElement(anotherLanguage).isDisplayed());

        // Close đi
        driver.findElement(By.cssSelector("a[role='button'][class*='layerCancel']")).click();

    }



    // 3- Clean: delete data test/ account/ closed browser/ ...
    @AfterClass
    public void cleanBrowser() {
//        driver.quit();
    }

}
