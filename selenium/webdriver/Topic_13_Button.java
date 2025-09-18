package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_13_Button {

    // 1- Setup: OS/  Browser/ Web/ Page/ Data/ Variable/ Object/..
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();

        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    // 2- Action/ Excute: Tương tác lên element nào/ nhập liệu/ verify/ ...
    @Test
    public void TC_01_Fahasa() throws InterruptedException {
        driver.get("https://www.fahasa.com/customer/account/create");

        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();

        By loginButton = By.cssSelector("button.fhs-btn-login");

        // isEnabled: Nếu element mà nó enable thì trả về true/ disable thì trả về false
        Assert.assertFalse(driver.findElement(loginButton).isEnabled());

        String loginBackgroundColor = driver.findElement(loginButton).getCssValue("background-color");
        System.out.println(loginBackgroundColor);

        Color loginColor = Color.fromString(loginBackgroundColor);
        Assert.assertEquals(loginColor.asHex().toUpperCase(), "#000000");

        driver.findElement(By.cssSelector("input#login_username")).sendKeys("dao@gmail.com");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("123456789");

        // Mong đợi nó là enabled
        Assert.assertTrue(driver.findElement(loginButton).isEnabled());

        Assert.assertEquals(Color.fromString(driver.findElement(loginButton).getCssValue("background-color")).asHex().toUpperCase(),"#C92127");

        driver.findElement(loginButton).click();

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.fhs-popup-msg.fhs-login-msg")));
        Assert.assertEquals(driver.findElement(By.cssSelector("div.fhs-popup-msg.fhs-login-msg")).getText(),"Số điện thoại/Email hoặc Mật khẩu sai!");

        Assert.assertEquals(driver.findElement(loginButton).getText(), "Đăng nhập");

        // Lấy màu nền của nút (rgba → hex → UPPER)
        WebElement loginButtonElement = driver.findElement(loginButton);
        String loginButtonRGBA = loginButtonElement.getCssValue("background-color"); // ví dụ: rgba(201,33,39,1)
        Color loginButtonColor = Color.fromString(loginButtonRGBA);
        String loginButtonHexa = loginButtonColor.asHex();          // ví dụ: #C92127
        String loginButtonHexaUpperCase = loginButtonHexa.toUpperCase(); // #C92127
    }

    @Test
    public void TC_02_Verify_Button_Enable() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(5000);
        Assert.assertTrue(driver.findElement(By.cssSelector("button[type='submit']")).isEnabled());
    }

    // 3- Clean: delete data test/ account/ closed browser/ ...
    @AfterClass
    public void cleanBrowser() {
//        driver.quit();
    }

}
