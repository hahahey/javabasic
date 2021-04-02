package com.hahahey.Collection;

import java.util.UUID;
import java.util.Vector;


public class VectorExample {
    public static void main(String[] args) {
        /**
         *  vector 线程安全，使用synchronized 关键字修饰方法。
         *
         *
         *
         *
         *
         *
         **/
        //初始容量为10 的 Object[]
        //所有方法都是synchronized ，所以线程安全，其他特性和ArrayList保持一致
        Vector vector = new Vector();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                vector.add(UUID.randomUUID().toString().substring(0,2));
                vector.add(UUID.randomUUID().toString().substring(0,2));
                vector.add(UUID.randomUUID().toString().substring(0,2));
                System.out.println(vector);
            },String.valueOf(i)).start();
        }


    }
}
