package strategy.factory.simplefactory;

/**
 * @author locks
 * @date 2022-02-28 16:35
 * 2. 定义具体的操作类：
 */
public class Div implements Operation{
    @Override
    public double getResult(double numberA, double numberB) throws Exception {
        return numberA / numberB;
    }
}
