package com.hahahey.Collection;


import java.util.HashSet;
import java.util.Set;

public class HashSetExample {

    /**
     * 底层数据结构是 HashMap (e,PRESENT)     private static final Object PRESENT = new Object();
     * 默认初始容量是16，加载因子0.75
     *
     *
     *
     **/


    public static void main(String[] args) {
        Set<String> hashSet = new HashSet();
        hashSet.add("hello");
        hashSet.add("world");
        hashSet.add("hello");

        System.out.println(hashSet);
    }
}
