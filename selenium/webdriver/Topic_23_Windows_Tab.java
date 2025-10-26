package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic_23_Windows_Tab {

    // 1- Setup: OS/  Browser/ Web/ Page/ Data/ Variable/ Object/..
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    // 2- Action/ Excute: Tương tác lên element nào/ nhập liệu/ verify/ ...
    @Test
    public void TC_01_Github() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        // Lấy ra ID của tab/window mà driver đang active tại page đó
        String githubWindowID = driver.getWindowHandle();

        System.out.println("Page ID = " + githubWindowID);
        System.out.println("Page Title = " + driver.getTitle());
        System.out.println("Page URL = " + driver.getCurrentUrl());

        // Click vào Goggle.com  link -> nó sẽ bật ra 1 tab mới và tự nhảy qua
        // Nhưng về code Selenium là driver ko tự nhảy qua - nó vẫn ở tab cũ
        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        Thread.sleep(3000);

        // switch qua tab Google
        switchToWindowByID(githubWindowID);
        Thread.sleep(3000);

        String googleWindowID = driver.getWindowHandle();
        driver.findElement(By.cssSelector("textarea[name='q']")).sendKeys("Selenium WebDriver");
        Thread.sleep(3000);

        //switch về tab Github
        switchToWindowByID(googleWindowID);

        // Click vào Facebook link - > nó sẽ bật lên 1 tab mới và tự nhảy qua
        driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
        Thread.sleep(3000);

        // Lấy toàn bộ các ID của window/ tab
        Set<String> allWindowIDs = driver.getWindowHandles();

        // Dùng vòng lặp duyệt qua từng ID
        for (String id : allWindowIDs){
            // Mỗi lần duyệt sẽ cho nó switch vào trước
            driver.switchTo().window(id);
            // Get ra title của window/ tab hiện tại
            String pageTitle = driver.getTitle();
            // Kiểm tra title
            if (pageTitle.equals("Facebook - log in or sign up")) {
                break;
            }
        }
        switchToWindowByTitle("Facebook - log in or sign up");

        System.out.println("Page title: " + driver.getTitle());
    }

    private void switchToWindowByTitle(String expectedPageTitle) throws InterruptedException {
        // Lấy tất cả các ID của các cửa sổ (tab) hiện đang mở
        Set<String> allWindowIDs = driver.getWindowHandles();

        // Duyệt qua từng ID (mỗi ID là một cửa sổ/tab khác nhau)
        for (String id : allWindowIDs) {

            //  Mỗi lần duyệt sẽ chuyển sang cửa sổ/tab tương ứng
            driver.switchTo().window(id);

            // (Tùy chọn) Tạm dừng 2 giây để đảm bảo trang được load ổn định
            Thread.sleep(2000);

            // Lấy ra tiêu đề (title) của tab hiện tại sau khi đã switch
            String pageTitle = driver.getTitle();

            // So sánh tiêu đề hiện tại với tiêu đề mong muốn (expectedPageTitle)
            if (pageTitle.equals(expectedPageTitle)) {
                // Nếu trùng khớp, dừng vòng lặp – driver đang đứng đúng tab cần tìm
                break;
            }
        }
    }

    // Chỉ đúng với 2 tab/ window
    private void switchToWindowByID(String githubWindowID) {
        // Lấy tất cả các ID của các cửa sổ (window/tab) hiện đang được mở trong trình duyệt
        Set<String> allWindowIDs = driver.getWindowHandles();
        // Duyệt qua từng ID trong danh sách các cửa sổ
        for (String id : allWindowIDs) {
            // Nếu ID hiện tại KHÔNG phải là cửa sổ GitHub ban đầu (githubWindowID)
            // thì chuyển hướng (switch) sang cửa sổ đó
            if (!id.equals(githubWindowID)){
                driver.switchTo().window(id);
            }
            System.out.println(id);
        }
    }

    @Test
    public void TC_02_() {

    }

    // 3- Clean: delete data test/ account/ closed browser/ ...
    @AfterClass
    public void cleanBrowser() {
//        driver.quit();
    }

}
