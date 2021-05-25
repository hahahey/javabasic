package com.hahahey.jvm.stack;


public class StackDemo {
    public static void main(String[] args) {
        if (args == null) {
            Demo demo = new Demo();
        }
        int num = 6;
    }

}

class Demo {

    public static void main(String[] args) {

        System.out.println();
        System.out.println();

    }
}


class Node{
    public Object data;
    public Node left;
    public Node right;

    public Node(Object data){
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}