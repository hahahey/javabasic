package com.hahahey.Collection;

import java.util.Iterator;
import java.util.LinkedList;


public class LinkedListExample  {
    public static void main(String[] args) {

/*        private static class Node<E> {
            E item;
            LinkedList.Node<E> next;
            LinkedList.Node<E> prev;

            Node(LinkedList.Node<E> prev, E element, LinkedList.Node<E> next) {
                this.item = element;
                this.next = next;
                this.prev = prev;
            }
        }
*/
        /**
         *  底层数据结构是双向链表  item:数据 next:指向后节点 prev:指向前节点
         *  优点: 增删快，有直接的头尾节点增加/查询方法，没有固定容量，需要的时候就增加节点数量
         *  缺点: 查询慢，需要遍历，占用空间大，需要保存节点信息
         *
         *
         *
         **/

        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");


        list.add(1,"a");
        list.addFirst("i");
        list.addLast("l");
        //循环将每个node 的 值赋为null
        //list.clear();

        //会先计算index 与 size >> 1 的大小，如果小于则从first 开始遍历， 如果大于则从last往回遍历
        list.get(2);

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            if("c".equals(iterator.next())){
                iterator.remove();
            }
        }

        //打印输出
        //list.stream().forEach(System.out::println);



    }
}
