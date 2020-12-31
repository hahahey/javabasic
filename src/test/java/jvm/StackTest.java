package jvm;

import java.util.Date;

public class StackTest {
    public static void main(String[] args) {
        int i = 100;
        double j = 10.0;
        System.out.println(i);

        testStatic();
    }

    public static void testStatic(){
        Date date = new Date();
        int count = 100;
        System.out.println(count);
    }
}
