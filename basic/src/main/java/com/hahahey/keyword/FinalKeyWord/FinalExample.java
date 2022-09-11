package com.hahahey.keyword.FinalKeyWord;


public class FinalExample {
    public static void main(String[] args) {

        /*
         * 一. final类
         *  final修饰的类，该类不能被继承。当你确认一个类永远不会被继承或不想被继承，那么就可以用final修饰。
         * 二. final方法
         *  final修饰的方法不可被重写。
         * 三. final变量
         *  final变量包括成员变量和局部变量。变量类型包括基本数据类型、对象。
         *  1.通过final修饰局部基本类型变量（及其包装类），数值一经初始化（可以定义时初始化，也可以在使用前初始化）不可改变
         *  2.通过final修饰局部引用类型变量时，其引用的对象（内存地址）（可以定义时初始化，也可以在使用前初始化）不可改变，但对象中存放的数据可以改变
         *  3.final修饰的成员变量必须在定义的时候直接初始化，否则会编译出错
         *
         *
         *
         **/

        String str0 = "helloWorldChina";
        String str1 = "helloWorld";
        String str3 = str1 + "China";
        //false
        System.out.println(str0 == str3);

        final String str2 = "helloWorld";
        String str4 = str2 + "China";
        //true  是因为在编译的时候，已经知道了确切值，(定义变量的时候已经初始化了)，在编译的时候就当做常量使用了，等于 "helloWorld" + "China"
        System.out.println(str0 == str4);

        final String str5;
        str5 = "helloWorld";
        String str6 = str5 + "China";
        //false  编译的时候未指定具体值，在使用之前才初始化，str5 + "china" 就返回了一个新的字符串，当然地址就不相同了
        System.out.println(str0 == str6);

    }
}
