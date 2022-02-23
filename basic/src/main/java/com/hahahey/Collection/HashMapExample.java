package com.hahahey.Collection;


import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        /**
         *  允许null键和null值
         **/

        /**
         * HashMap
         * 底层数据结构 数组+链表  1.8 -> 数据+链表+红黑树 头插法改为尾插法
         * 初始容量是 16  扩容因子是 0.75
         * 链表长度 > 8 & 数组大小 >= 64的时候 ==> 红黑树
         * 红黑树节点个数 < 6 转为链表
         *
         *
         **/

        /**
         * 头插法会使链表发生反转，多线程环境下会产生环  A线程在插入B，B线程也在插入，遇到容量不够开始扩容，重新hash，放置元素
         * 采用头插法，后遍历到的B节点放入到了头部。这样就形成了环。
         *
         * 多线程环境下
         * 1.7 会产生死循环，数据丢失，数据覆盖等问题，
         * 1.8 会有数据覆盖的问题 A判断index为空的时候挂起，B开始往index位置写入节点数据，这时候A线程执行，则覆盖了之前B的值
         *
         **/


        /**
         *
         *  线程安全类
         *  HashTable 直接在方法上加synchronized 关键字，锁住整个数组，粒度比较大
         *  Collection.synchronizedMap 内部定义了一个对象锁，方法内通过对象锁实现
         *  ConcurrentHashMap 使用了分段锁，降低了锁粒度，提高了并发度 成员变量使用volatile修饰，免除了指令重排序，同时保证
         *      内存可见性，多线程操作只会锁住当前操作索引的节点
         *
         *
         **/
        Map<String, String> map = new HashMap<>();





        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");
        map.put("5", "e");
        map.put("6", "f");
        map.put("7", "g");
        map.put("8", "h");
        map.put("9", "i");
        map.put("10", "j");
        map.put("11", "k");
        map.put("12", "l");
        map.put("13", "m");
        map.put("14", "n");
        map.put("15", "o");
        map.put("16", "p");
        map.put("17", "q");

        System.out.println(12 > 12 );

        int cap = 10;
        int n = cap - 1;
        System.out.println(Integer.toBinaryString(n));

        int n1  = n >>> 1;
        System.out.println(Integer.toBinaryString(n1));

        int n2  = n >>> 2;
        System.out.println(Integer.toBinaryString(n2));

        int n4 = n >>> 4;
        System.out.println(Integer.toBinaryString(n4));

        int n8  = n >>> 8;
        System.out.println(Integer.toBinaryString(n8));

        int n16  = n >>> 16;
        System.out.println(Integer.toBinaryString(n16));

//        map.put("1", "a");
//        map.put("2", "b");
//        map.put("3", "c");
//        map.put("4", "d");
//        map.put("5", "e");
//        map.put("6", "f");
//        map.put("7", "g");
//        map.put("8", "h");
//        map.put("9", "i");
//        map.put("10", "j");
//        map.put("11", "k");
//        map.put("12", "l");
//        map.put("13", "m");
//        map.put("14", "n");
//        map.put("15", "o");
//        map.put("16", "p");
//        map.put("17", "q");

    }





}
