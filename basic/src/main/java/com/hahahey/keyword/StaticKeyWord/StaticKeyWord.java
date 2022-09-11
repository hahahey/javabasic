package com.hahahey.keyword.StaticKeyWord;


public class StaticKeyWord {
    /*
     * 一:static 变量
     *      static变量随着类的加载而存在，随着类的消失而消失，当类被加载时，就会为静态变量在Java Heap中分配内存空间，
     *      可以通过【类.变量名】和【对象.变量名】的方式调用，建议直接使用【类.变量名】的方式，
     * 二:static 方法
     *      静态方法只能访问静态成员（静态变量、静态方法），而非静态方法既可访问静态方法也可访问非静态方法；
     *      因为静态成员优于对象而存在，因此无法调用和对象相关的关键字，如this,super，无法通过关键字访问对象资源。
     * 三:static 代码块
     *      static代码块在加载一个类的时候最先执行，且只执行一次。
     * 四:static内部类
     *      定义一个内部类，加上static，就成为了一个static内部类，static只能修饰内部类，不能修饰顶级类
     * 五:static包内导入
     *      import static java.util.Arrays.*  即可把Arrays类中所有的静态变量，方法，内部类等都引入当前类中，调用时直接调用sort(arra)，asList(arra)，
     *
     *
     *
     **/


}
