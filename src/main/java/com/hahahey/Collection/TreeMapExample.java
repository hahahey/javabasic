package com.hahahey.Collection;


import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {


        /**
         *
         * 红黑树实现
         * 可以实现元素的自动排序
         *
         *
         *
         *
         *
         *
         *
         **/


        Map<String,String> treeMap = new TreeMap<>();
        treeMap.put("d","4");
        treeMap.put("b","2");
        treeMap.put("c","3");
        treeMap.put("a","1");
        // {a=1, b=2, c=3, d=4}

        System.out.println(treeMap);


    }
}
