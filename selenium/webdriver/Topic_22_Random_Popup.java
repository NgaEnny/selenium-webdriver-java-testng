package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_22_Random_Popup {

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
    public void TC_01_JavaCodeGeeks() throws InterruptedException {
        driver.get("https://www.javacodegeeks.com/");

        By newsLetterPopupBy = By.xpath("//div[@data-title='Newsletter Free eBooks' " +
                "and not(contains(@style, 'display:none'))]");

        // Hiển thị thì close đi rồi action tiếp
        if (!driver.findElements(newsLetterPopupBy).isEmpty()
                && driver.findElements(newsLetterPopupBy).get(0).isDisplayed()) {
            System.out.println("--------- GO TO IF ---------");
            driver.findElement(By.xpath("//div[@data-title='Newsletter Free eBooks' " +
                    "and not(contains(@style, 'display:none'))]//a[contains(@onclick, 'lepopup_close')]")).click();
            Thread.sleep(2000);

            // Verify popup không còn hiển thị -> ko còn trong HTML -> ko isDisplayed được
            Assert.assertTrue(driver.findElement(newsLetterPopupBy).isDisplayed());
        }

        // Ko hiển thị thì action tiếp
        System.out.println("--------- IGNORE IF ---------");
        driver.findElement(By.cssSelector("input#search-input")).sendKeys("Agile");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("form#search span.tie-search-icon")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("header>h1.page-title")).isDisplayed());
    }


    @Test
    public void TC_02_VNK() throws InterruptedException {
        driver.get("https://vnk.edu.vn/");

        By marketingPopupBy = By.cssSelector("div.popmake-content");

        // Hiển thị thì close đi rồi action tiếp
        if (!driver.findElements(marketingPopupBy).isEmpty()
                && driver.findElements(marketingPopupBy).get(0).isDisplayed()) {
            System.out.println("--------- GO TO IF ---------");
            driver.findElement(By.cssSelector("button.popmake-close")).click();
            Thread.sleep(2000);
        }

        // Ko hiển thị thì action tiếp
        System.out.println("--------- IGNORE IF ---------");
        driver.findElement(By.cssSelector("ul#mega-menu-primary a[href*='lien-he']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("div.title-content>h1")).isDisplayed());
    }

    @Test
    public void TC_03_Dehieu() throws InterruptedException {
        driver.get("https://dehieu.vn/");

        By contentPopupBy = By.cssSelector("div.modal-content");

        // Hiển thị thì close đi rồi action tiếp
        if (!driver.findElements(contentPopupBy).isEmpty()
                && driver.findElements(contentPopupBy).get(0).isDisplayed()) {
            System.out.println("--------- GO TO IF ---------");
            driver.findElement(By.cssSelector("button.close")).click();
            Thread.sleep(2000);

            // Verify popup không còn hiển thị -> còn trong HTML -> isDisplayed được
            Assert.assertFalse(driver.findElement(contentPopupBy).isDisplayed());

        }

        /// Ko hiển thị thì action tiếp
        System.out.println("----------- IGNORE IF -----------");
        driver.findElement(By.cssSelector("input.search-form")).sendKeys("Khóa học Lập dự toán M&E");
        driver.findElement(By.cssSelector("button.header-search")).click();

        Assert.assertEquals(
                driver.findElement(By.cssSelector("div.course-item-detail a")).getAttribute("title"),
                "Khóa học Lập dự toán M&E"
        );

    }

    // 3- Clean: delete data test/ account/ closed browser/ ...
    @AfterClass
    public void cleanBrowser() {
//        driver.quit();
    }

}
