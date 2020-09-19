package com.hahahey.Collection;

import java.util.LinkedHashMap;
import java.util.Map;


public class LinkedHashMapExample {
    public static void main(String[] args) {


        /**
         * key 和value 都允许重复
         * 有序 双向链表保证顺序
         *
         *
         *
         *
         *
         **/

        Map<String,String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("四","4");
        linkedHashMap.put("二","2");
        linkedHashMap.put("三","3");
        linkedHashMap.put("一","1");

        System.out.println(linkedHashMap);
    }
}
