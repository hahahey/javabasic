package strategy.factory.simplefactory;

/**
 * @author locks
 * @date 2022-02-28 16:41
 * 3. 定义简单工厂类：
 */
public class EasyFactory {
    // 简单工厂，根据字符串创建相应的对象
    public static Operation createOperation(String name) {
        Operation operationObj = null;
        switch (name) {
            case "+":
                operationObj = new Add();
                break;
            case "-":
                operationObj = new Sub();
                break;
            case "*":
                operationObj = new Mul();
                break;
            case "/":
                operationObj = new Div();
                break;
            default:break;
        }
        return operationObj;
    }
}
