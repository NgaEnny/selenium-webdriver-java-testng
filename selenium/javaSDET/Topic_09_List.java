package javaSDET;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.*;

public class Topic_09_List {
    public  static void  main(String[] args){
        WebDriver driver; // Cha

        driver = new FirefoxDriver(); // Con
        driver = new ChromeDriver(); // Con
        driver = new EdgeDriver(); // Con

        FirefoxDriver ffDriver = new FirefoxDriver();

//        ArrayList<String> address = new ArrayList<>();
//
//        Vector<Float> studentPoint = new Vector<>();
//
//        LinkedList<Integer> studentAge = new LinkedList<>();
//
//        Stack<Boolean> status = new Stack<>();

        List<String> address = new ArrayList<>();
        address.add("Ho Chi Minh");
        address.add("Ha Noi");
        address.add("Da Nang");
        address.add("Hai Phong");
        address.add("Can Tho");
        address.add("Dong Nai");

        System.out.println(address.get(0));
        System.out.println(address.get(2));
        System.out.println(address.get(5));

        // Lay ra 1 element cu the
        System.out.println(address.get(2));

        // Lấy ra toàn bộ
        for (int i = 0; i < address.size(); i++) {
            System.out.println(address.get(i));
        }

        // Lấy ra toàn bộ
        for (String a: address) {
            System.out.println(a);
        }
    }
}
