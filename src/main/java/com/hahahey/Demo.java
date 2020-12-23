package com.hahahey;


public class Demo {

    public static void main(String[] args) {



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
