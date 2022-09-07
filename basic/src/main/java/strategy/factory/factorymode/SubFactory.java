package strategy.factory.factorymode;

import strategy.factory.simplefactory.Operation;
import strategy.factory.simplefactory.Sub;

/**
 * @author locks
 * @date 2022-02-28 16:53
 */
public class SubFactory implements Factory{
    @Override
    public Operation createOperation() {
        System.out.println("减法运算");
        return new Sub();
    }
}
