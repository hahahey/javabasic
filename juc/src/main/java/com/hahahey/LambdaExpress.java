package com.hahahey;

/**
 * @author hahahey
 * @date 2021/5/21 15:18
 * @description:
 */

/**
 * 2.1 拷贝小括号，写死右箭头,落地大括号
 * 2.2 @FunctionalInterface 接口中只有一个方法的时候，叫做函数式接口，默认加上了这个注解
 * 2.3 default 可以在接口中定义方法的实现，用default关键字来修饰，可以有多个方法
 * 2.4 函数式接口中还可以有静态方法实现，可以有多个方法
 **/
public class LambdaExpress {
    public static void main(String[] args) {
        Foo foo = new Foo() {
            @Override
            public int add() {
                return 5;
            }
        };
        System.out.println(foo.add());



    }
}

@FunctionalInterface
interface Foo {
    public int add();
    default  int add1(int x, int y){
        return x+y;
    }
    public static int add2(int x, int y){
        return  x - y;
    }
}
