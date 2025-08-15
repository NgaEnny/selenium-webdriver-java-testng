package javaSDET;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.*;

public class Topic_01_DataType {
    // 2 nhóm kiểu dữ liệu

    // Cách khai báo:
    // Access Modifier: phạm vi truy cập (private/ public/ protected/ default)
    // 1 - Access Modifier - Kiểu dữ liệu - Tên biến - Giá trị của biến (Ngoài hàm/ Trong hàm đều được)
    public char cName = 'b';

    // 2.1 - Access Modifier - Kiểu dữ liệu - Tên
    private char cAddress;


    // 2.2 - Tên biến - Giá trị gán sau (Hàm)
    public void clickToElement() {
        char cAddress = 'c';
        char cCity = 'd';
    }

    // Nhóm 1 - Kiểu dữ liệu nguyên thủy
    // char: kí tự (char)
    // Khi gán giá trị (khởi tạo) thì nằm trong dấu nháy đơn (')
        char cZip = 'b';

    // byte/ short/ int/ long: số nguyên
    // Khi gán giá trị (khởi tạo) thì ko nằm trong dấu gì
    byte bNumber = -120;

    short sNumber = 1200;

    int iNumber = 350000;

    long lNumber = 234240234;


    // float/ double: số thực (có dấu chấm or phẩy)
    // Khi gán giá trị (khởi tạo) thì ko nằm trong dấu gì
    float fNumber = 15.7f;
    double dNumber = 15.7d;

    // boolean: logic
    // Khi gán giá trị (khởi tạo) thì ko nằm trong dấu
    boolean gender = true;


    // Nhóm 2 - Kiểu dữ liệu tham chiếu
    // String: Chuỗi
    // Khi gán giá trị (khởi tạo) thì nằm trong dấu nháy đôi (")
    String fullName = "Automation FC";

    // Class
    FirefoxDriver fDriver = new FirefoxDriver();
    Actions actions = new Actions(fDriver);
    Topic_01_DataType topic01 = new Topic_01_DataType();

    // Interface
    WebDriver driver;
    JavascriptExecutor jsExecutor;

    // Array
    String[] studentName = {"Nga", "Nam"};
    Integer[] studentPhone = {23123, 31231, 31213};

    // List/ Set/ Queue
    List<String> studentAddres = new ArrayList<String>();
    List<String> studentCity = new LinkedList<String>();

    // Map
    Map<String, Integer> zip = new HashMap<String, Integer>();

    // Object
    Object name = "Nam";
    Object phone = 13123;
    Object isDisplayed = true;


    // Convention: Quy ước khi lập trình
    // Tên biến/ tên hàm: viết dưới dạng camel case
    // Chữ cái đầu tiên luôn viết thường
    // name/address/ city/ phone/ zipCode
    // clickToElement/ getUserName/ getPhoneNumber/ selectItemInDropdown

}