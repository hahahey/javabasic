package strategy.factory.factorymode;

import strategy.factory.simplefactory.Operation;

/**
 * @author locks
 * @date 2022-02-28 16:51
 * 1. 定义一个工厂接口：
 */
public interface Factory {
    public Operation createOperation() ;
}
