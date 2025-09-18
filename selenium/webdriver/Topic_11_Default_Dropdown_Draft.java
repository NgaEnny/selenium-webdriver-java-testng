package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_11_Default_Dropdown_Draft {

    // 1- Setup: OS/  Browser/ Web/ Page/ Data/ Variable/ Object/..
    WebDriver driver;
    Select select;
//    Action actions;
//    WebDriverWait explicitWait;
//    JavascriptExecutor jscriptExecutor;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        // tại sao ko nên khởi tạo ở đây?
        // Đi tìm 1 element mà hiện tại chưa phát hiện
        //select = new Select(driver.findElement(By.cssSelector("select#day")));
    }

    // 2- Action/ Excute: Tương tác lên element nào/ nhập liệu/ verify/ ...
    @Test
    public void TC_01_Facebook_SignUp() {
        driver.get("https://www.facebook.com/reg/");

        // Dropdown xuất hiện
//        Select select = new Select(driver.findElement(By.cssSelector("select#day")));
//        select.selectByIndex(20);

        // 1 - Index
        // Index thay đổi vị trí
        // Đọc code có biết nó là tỉnh nào không? -> Chạy fail -> Reproduce lại -> 20 -> Manual Test

        //select.selectByValue("9433");
        //select.selectByValue("8418");

        // 2 - Value
        // Option ko bắt buộc phải có attribute value
        // Đọc code có biết nó là tỉnh nào ko? -> Chạy fail -> Reproduce lại -> 20 -> Manual Test
        // Thêm 1 số buộc để đi tìm nó là cái gì / ở đâu

        //select.selectByVisibleText("thành phố Hà Nội");

        // 3 - Text
        // Giống như End User chọn
        // Ko bị trùng dữ liệu/ ko bị trống dữ liệu
        // Ko thay đổi text nên code ổn định
        // Chạy fail -> Reproduce lại -> 20 -> Manual Test -> ít mất time hơn

        // Chọn 1 item
//        select.selectByVisibleText("25");
//
//        // Chọn xong verify đã chọn đã đúng chưa
//        Assert.assertEquals(select.getFirstSelectedOption().getText(), "25");
//
//        // Verify cái dropdown có phải là multiple select hay ko?
//        // Nếu là multiple => trả về true
//        // Nếu là single => trả về false
//        Assert.assertFalse(select.isMultiple());
//
//        // Verify xem tổng số lượng item trong dropdown là bn?
//        Assert.assertEquals(select.getOptions().size(), 31);
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
