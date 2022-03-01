package strategy.factory.simplefactory;

/**
 * @author locks
 * @date 2022-02-28 16:34
 * 2. 定义具体的操作类：
 */
public class Mul implements Operation {
    @Override
    public double getResult(double numberA, double numberB) throws Exception {
        return numberA * numberB;
    }
}
