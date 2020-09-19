package com.hahahey.Collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author lizhongkai
 * @description
 * @date 2020-09-19
 */
public class LinkedHashMapExample {
    public static void main(String[] args) {

        Map<String,String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("四","4");
        linkedHashMap.put("二","2");
        linkedHashMap.put("三","3");
        linkedHashMap.put("一","1");

        System.out.println(linkedHashMap);
    }
}
