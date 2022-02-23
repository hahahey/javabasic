package com.hahahey.String;


public class StringExample {
    public static void main(String[] args) {


        /*  public final class String
         *  private final char value[];
         *  String对象一旦在堆中创建出来，就无法再修改。因为String对象放在char数组中，该数组由final关键字修饰，不可变。
         *
         **/


        String str1 = "HelloWorld";
        String str2 = "Hello" + "World";

        String str3 = "Hello";
        String str4 = "World";

        String str5 = str3 + "World";
        String str6 = "Hello" + str4;

        String str7 = str3 + str4;

        String str8 = new String("HelloWorld");
        String str9 = new String("HelloWorld");

        //true  在堆中有个字符串常量池，里面只存在一个字符串，所以拿到的地址是相同的
        System.out.println(str1 == str2);

        //false 拿的是堆中的引用地址，所以不同，同理，涉及变量操作，和使用字符串方法操作 之后是返回堆中的地址，所以不同
        System.out.println(str5 == str6);

        //false 拿的是堆中的引用地址，所以不同
        System.out.println(str1 == str7);

        //false 堆中不同的引用地址
        System.out.println(str8 == str9);


        /*
         * intern() 方法，会先判断字符串常量池中是否含有相同(通过equals方法)的字符串字面量，如果不含，则将该
         * 字符串添加到字符串常量池中，并返回该对象在字符串常量池中的引用
         *
         **/
        str8 = str8.intern();
        //true 字符串常量池中有，则返回引用，所以相等
        System.out.println(str1 == str8);

    }
}
