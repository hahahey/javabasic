package com.hahahey.Collection;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {

/**
 *  ArrayList 底层使用数组结构装载数据 特点：查询快，增删慢
 *  如果使用空构造函数，返回一个 {} 在第一次调用 add 的时候，会返回初始容量 10  Math.max(DEFAULT_CAPACITY = 10, minCapacity) = 10
 *  会将数组容量扩容到 DEFAULT_CAPACITY = 10 底层数据会执行 elementData = Arrays.copyOf(elementData, newCapacity) 将元素复制过来 (创建一个新的数组)。
 *  如果数组容量达到10，在添加新元素的时候会执行 newCapacity = oldCapacity + (oldCapacity >> 1); 容量变为原来的1.5倍
 *
 *
 *
 **/


        List<String> list = new ArrayList();
        for (int i = 0; i < 11 ; i++) {
            list.add(String.valueOf(i));
        }


//        for (int i = 0; i < list.size(); i++) {
//            if(list.get(i) == "3"){
//                list.remove(i);
//            }
//        }


        //使用迭代器来删除元素
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == "3") {
                iterator.remove();
            }
        }


        String[] str = {"0", "1", "2", "3", "4", "5", "6"};
        String[] str1 = new String[10];
        System.arraycopy(
                //原数组的起始位置，0开始的角标
                str, 2,
                //新数组的起始位置，0开始的角标
                str1, 2,
                //从起始位置取得的原数组的元素长度，即需要添加的元素个数
                5);
        Arrays.stream(str1).forEach(System.out::print);


    }


}
