package strategy.factory.simplefactory;

/**
 * @author locks
 * @date 2022-02-28 16:42
 * 4. 用户端代码：
 */
public class Client {
    public static void main(String[] args) throws Exception {

        // 1. 定义一个操作接口：
        // 2. 定义具体的操作类：
        // 3. 定义简单工厂类：
        // 4. 用户端代码：


        Operation add = EasyFactory.createOperation("+");
        Operation sub = EasyFactory.createOperation("-");
        Operation mul = EasyFactory.createOperation("*");
        Operation div = EasyFactory.createOperation("/");

        System.out.println(add.getResult(1, 1));
        System.out.println(sub.getResult(1, 1));
        System.out.println(mul.getResult(1, 1));
        System.out.println(div.getResult(1, 1));

    }
}
