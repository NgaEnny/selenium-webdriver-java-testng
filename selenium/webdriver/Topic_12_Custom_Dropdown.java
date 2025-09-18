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
import java.util.List;

public class Topic_12_Custom_Dropdown {

    // 1- Setup: OS/  Browser/ Web/ Page/ Data/ Variable/ Object/..
    WebDriver driver;

    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    // 2- Action/ Excute: Tương tác lên element nào/ nhập liệu/ verify/ ...
    @Test
    public void TC_01_JQuery() throws InterruptedException {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        selectItemInCustomDropdown("span#speed-button", "ul#speed-menu>li>div", "Fast");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button > span.ui-selectmenu-text")).getText(), "Fast");

        selectItemInCustomDropdown("span#number-button","ul#number-menu>li>div", "10");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).getText(), "10");

        selectItemInCustomDropdown("span#salutation-button","ul#salutation-menu>li>div",  "Mrs.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button>span.ui-selectmenu-text")).getText(), "Mrs.");
    }

    @Test
    public void TC_02_React() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");

        selectItemInCustomDropdown("div.dropdown","div.item>span","Afghanistan");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Afghanistan");

        selectItemInCustomDropdown("div.dropdown","div.item>span","Aland Islands");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Aland Islands");
    }

    @Test
    public void TC_03_VueJS() throws InterruptedException {
        driver.get("https://mikerodham.github.io/vue-dropdowns/");

        selectItemInCustomDropdown("li.dropdown-toggle","ul.dropdown-menu>li>a","Second Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Second Option");

        selectItemInCustomDropdown("li.dropdown-toggle","ul.dropdown-menu>li>a","Third Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Third Option");

        selectItemInCustomDropdown("li.dropdown-toggle","ul.dropdown-menu>li>a","First Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "First Option");
    }

    @Test
    public void TC_04_Editable() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");

        enterItemInCustomDropdown("input.search","div.item>span","Albania");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Albania");

        enterItemInCustomDropdown("input.search","div.item>span","Barbados");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Barbados");


    }
    // Dự án thực tế: 1 hàm để thao tác lên dropdown ch dùng cho 1 site/ app
    // ko dùng nhiều cho nhiều application khác nhau
    // Cơ chế của dropdown giống nhau

    private void selectItemInCustomDropdown(String parentCss, String childCss, String textItem) throws InterruptedException {
        // Hành vi (behavior) để thao tác lên Dropdown
        // 1 - Chờ cho dropdown có thể thao tác lên được (clickable)
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(parentCss))).click();

        // 2 - Click vào element nào để nó xổ ra cái dropdown ra
//        driver.findElement(By.cssSelector("span#speed-button")).click();
        Thread.sleep(2000);

        // 3 - Chờ cho tất cả các item được load ra (presence)
        //explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));

        // 4 - Tìm cái item nào đúng vs mong đợi
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));
        // 5- items
        for (WebElement item: allItems) {
            System.out.println(item.getText());
            if (item.getText().equals(textItem)) {
                // 5- click lên item đó
                item.click();
                break;
            }
        }
    }

    private void enterItemInCustomDropdown(String parentCss, String childCss, String textItem) throws InterruptedException {
        // Hành vi (behavior) để thao tác lên Dropdown
        // 1 - Chờ cho dropdown có thể nhập được (visible)
        WebElement dropdownTextbox = explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(parentCss)));
        dropdownTextbox.clear();
        dropdownTextbox.sendKeys(textItem);

        // 2 - Sendkey vào cái dropdown
//        driver.findElement(By.cssSelector("span#speed-button")).click();
        Thread.sleep(2000);

        // 3 - Chờ cho tất cả các item được load ra (presence)
        //explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));

        // 4 - Tìm cái item nào đúng vs mong đợi
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));
        // 5- items
        for (WebElement item: allItems) {
            System.out.println(item.getText());
            if (item.getText().equals(textItem)) {
                // 5- click lên item đó
                item.click();
                break;
            }
        }
    }


    // 3- Clean: delete data test/ account/ closed browser/ ...
    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }

}
