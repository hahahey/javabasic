package strategy.factory.simplefactory;

/**
 * @author locks
 * @date 2022-02-28 16:31
 * 2. 定义具体的操作类：
 */
public class Add implements Operation{
    @Override
    public double getResult(double numberA, double numberB) throws Exception {
        return numberA + numberB;
    }
}
