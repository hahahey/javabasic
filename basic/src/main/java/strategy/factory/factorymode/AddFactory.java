package strategy.factory.factorymode;

import strategy.factory.simplefactory.Add;
import strategy.factory.simplefactory.Operation;

/**
 * @author locks
 * @date 2022-02-28 16:53
 */
public class AddFactory implements Factory{
    @Override
    public Operation createOperation() {
        System.out.println("加法运算");
        return new Add();
    }
}
