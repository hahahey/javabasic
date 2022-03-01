package strategy.factory.factorymode;

import strategy.factory.simplefactory.Operation;

/**
 * @author locks
 * @date 2022-02-28 16:55
 * 1. 定义一个工厂接口：
 * 2. 具体的工厂类：
 * 3. 运算类跟简单工厂一样：
 * 4. 客户端代码：
 */
public class Client {
    public static void main(String[] args) throws Exception {

        // 使用反射机制实例化工厂对象，因为字符串是可以通过变量改变的
        Factory addFactory = (Factory) Class.forName("strategy.factory.factorymode.AddFactory").newInstance();
        Factory subFactory=(Factory) Class.forName("strategy.factory.factorymode.SubFactory").newInstance();

        // 通过工厂对象创建相应的实例对象
        Operation add = addFactory.createOperation();
        Operation sub = subFactory.createOperation();

        System.out.println(add.getResult(1, 1));
        System.out.println(sub.getResult(1, 1));
    }
}
