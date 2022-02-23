package com.hahahey.Collection;


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListExample {


    static List<String> addEle() {
        List<String> list = new ArrayList();
        for (int i = 0; i < 11; i++) {
            list.add(String.valueOf(i));
        }
        return list;
    }


    static void removeByFor(List<String> list) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == "3") {
                list.remove(i);
            }
        }
        list.stream().forEach(System.out::print);
    }


    static void removeByIter(List<String> list) {
        //使用迭代器来删除元素
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == "3") {
                iterator.remove();
            }
        }
        list.stream().forEach(System.out::print);
    }


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
        List<String> list = addEle();



        //subList 相当于list的视图，支持集合的所有方法，任何对该视图的操作都会被原集合所取代
        List<String> subList = list.subList(1, 3);
        System.out.println(subList);
        subList.add("100");
        System.out.println(list);





//        removeByFor(list);
//        removeByIter(list);

        String[] str = {"0", "1", "2", "3", "4", "5", "6"};
        String[] str1 = new String[10];
        System.arraycopy(
                //原数组的起始位置，0开始的角标
                str, 2,
                //新数组的起始位置，0开始的角标
                str1, 2,
                //从起始位置取得的原数组的元素长度，即需要添加的元素个数
                5);
        //Arrays.stream(str1).forEach(System.out::print);


        // 并发修改异常 java.util.ConcurrentModificationException
        //List<String> list1 = new ArrayList<>();
//        CopyOnWriteArrayList list1 = new CopyOnWriteArrayList();
//
//        for (int i = 0; i <5 ; i++) {
//            new Thread(()->{
//                list1.add(UUID.randomUUID().toString().substring(0,3));
//                list1.add(UUID.randomUUID().toString().substring(0,3));
//                list1.add(UUID.randomUUID().toString().substring(0,3));
//                System.out.println(list1.toString());
//            },String.valueOf(i)).start();
//        }





        // 线程安全的list  写时复制ArrayList
        // 增加元素的时候是将底层数组的长度一个一个的增加，并非先初始容量然后再扩容，区别于ArrayList
        //
        // 优点：解决集合多线程读写并发问题，增删改上加锁，但是读不加锁，读方面优于Vector
        // 缺点：在写入时会复制一份到内存中，内存开销大，只能保证数据最终一致性，不能保证实时一致性
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add("a");
        copyOnWriteArrayList.add("b");
        copyOnWriteArrayList.remove("a");
        //copyOnWriteArrayList.forEach(System.out::print);


    }


}
