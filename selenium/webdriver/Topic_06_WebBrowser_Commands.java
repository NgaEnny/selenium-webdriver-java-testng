package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Topic_06_WebBrowser_Commands {

    // 1- Setup: OS/  Browser/ Web/ Page/ Data/ Variable/ Object/..
    WebDriver driver;

    @BeforeClass
    public void initialBrowser() throws MalformedURLException {
        // Run with browser (local)
        driver = new FirefoxDriver();
        driver = new EdgeDriver();
        driver = new ChromeDriver();
        driver = new SafariDriver();
        driver = new InternetExplorerDriver();

        // Remote (Grid/ Docker/ Cloud Testing)
        // Networking (LAN/ WAN/ IP/ Port)
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);

        driver.get("https://demo.nopcommerce.com");
    }

    // 2- Action/ Excute: Tương tác lên element nào/ nhập liệu/ verify/ ...
    @Test
    public void TC_01_() {
        driver.get("https://demo.nopcommerce.com"); //**

        // Đóng browser (active tab/ window)
        driver.close(); //*

        // Đóng browser (bao gồm all tab/  window)
        driver.quit(); //**

        // Lấy ra title của page hiện tại
        // 1 - Lưu dữ liệu lại rồi kiểm tra sau
        String homePageTitle = driver.getTitle();
        Assert.assertEquals(homePageTitle, "nopCommerce demo store");
        Assert.assertTrue(homePageTitle.contains("demo store"));

        // 2 - Kiểm tra trực tiếp
        Assert.assertEquals(driver.getTitle(), "nopCommerce demo store");

        // Lấy ra URL của page hiện tại
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/cart");

        // Lấy ra Page Source Code
        String homePageSourceCode = driver.getPageSource();

        // Kiểm tra tương đối
        Assert.assertTrue(homePageSourceCode.contains("Conditions of Use"));

        // Lấy ra ID của tab/ window đang active
        driver.getWindowHandle();

        // Lấy ra tất cả ID của tất cả các tab/ window đang có
        driver.getWindowHandles();

        // Đi tìm 1 element
        driver.findElement(By.xpath("")); //**

        // Đi tìm n element
        driver.findElements(By.xpath("")); //**

        WebDriver.Options options = driver.manage();

        // Selenium ver 3
        options.timeouts().implicitlyWait(15, TimeUnit.DAYS);
        options.timeouts().implicitlyWait(15, TimeUnit.HOURS);

        options.timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        options.timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        options.timeouts().implicitlyWait(45, TimeUnit.SECONDS);

        options.timeouts().implicitlyWait(15, TimeUnit.MILLISECONDS);
        options.timeouts().implicitlyWait(15, TimeUnit.MICROSECONDS);
        options.timeouts().implicitlyWait(15, TimeUnit.NANOSECONDS);

        WebDriver.Timeouts timeouts = driver.manage().timeouts();
        // Selenium ver 4
        // Dùng để chờ cho việc tìm element (findElement/ findElements)
        timeouts.implicitlyWait(Duration.ofDays(15));
        timeouts.implicitlyWait(Duration.ofHours(15));

        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //*
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofNanos(15));

        // Dùng để chờ cho việc page được load xong
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

        // Dùng để chờ cho 1 đoạn script được thực thi xong
        // JavascriptExecutor - js
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(15));

        WebDriver.Window window = driver.manage().window();

        // Thu nhỏ về Taskbar để chạy
        driver.manage().window().minimize();

        // Phóng to lên (vẫn còn taskbar)
        driver.manage().window().maximize();

        // Tràn màn hình (ko có taskbar)
        driver.manage().window().fullscreen();

        // Responsive
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.manage().window().getSize();

        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().getPosition();

        // Lấy hết tất cả Cookie: Test Class 01 (Register tài khoản - lưu cookie lại)
        Set<Cookie> cookies = driver.manage().getCookies(); //*

        driver.manage().getCookieNamed(".Nop.Antiforgery");

        // Xóa hết Cookie
        driver.manage().deleteAllCookies();

        for (Cookie cookie : cookies) {
            // Xóa cookie theo thứ tự
            driver.manage().deleteCookie(cookie);
        }

        // Xóa cookie theo tên
        driver.manage().deleteCookieNamed(".Nop.Antiforgery");

        // Đến 1 Test Class khác 02/03/04/.. (Ko cần Login - set cookie đã có vào đây rồi refresh lại)
        for (Cookie cookie : cookies) {
            // Add cookie theo thứ tự
            driver.manage().addCookie(cookie);
        }
        driver.navigate().refresh(); // Login thành công

        Logs log = driver.manage().logs();
        LogEntries logEntries = log.get("BROWSER");

        for (LogEntry logEn: logEntries) {
            System.out.println(logEn);
        }

        log.getAvailableLogTypes();

        WebDriver.Navigation navigation = driver.navigate();

        //Refresh/ F5
        navigation.refresh();

        //Quay lại trang trước đó
        navigation.back();

        //Chuyển tiếp tới trang trước nó
        navigation.forward();

        // Mở URL bất kì
        navigation.to("https://cnn.com");

        // Alert/ Iframe/ Windows (Tab)
        WebDriver.TargetLocator targetLocator = driver.switchTo();
        
        // Alert
        targetLocator.alert().accept(); //*
        targetLocator.alert().dismiss();

        // Frame/ Iframe
        targetLocator.frame(""); //*
        targetLocator.defaultContent(); //*

        // Windows
        targetLocator.window(""); //*

        // Lấy ra ID của tab/ window đang active
        driver.getWindowHandle(); //*

        // Lấy ra tất cả ID của tất cả các tab/ window đang có
        driver.getWindowHandles(); //*

    }

    @Test
    public void TC_02_() {

    }

    // 3- Clean: delete data test/ account/ closed browser/ ...
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}
