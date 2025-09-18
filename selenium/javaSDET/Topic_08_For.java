package javaSDET;

import java.util.ArrayList;
import java.util.List;

public class Topic_08_For {
    public static void main(String[] args) {
        // Biểu thức vòng lặp (loop)
        int number = 100;

        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
        System.out.println(4);

        // for
        for (int i = 0; i < number; i++) {
            if (i == 5) {
            System.out.println(i);
            break;
            }
        }

        // Collection: List/ Set/ Queue/ Map
        List<String> name = new ArrayList<String>();
        name.add("Manual Testing");
        name.add("Automation Testing");
        name.add("Regression Testing");
        name.add("UI Testing");
        name.add("API Testing");
        name.add("Mobile Testing");

        // for-each
        for (String a:name) {
            System.out.println(a);
        }

        int i = 0;
        // while
        while (i < number); {
            System.out.println(i);
            i++;
        }

        // do-while
        do { // Action truoc
            System.out.println(i);
            i++;
        } while (i < number);
    }
}
