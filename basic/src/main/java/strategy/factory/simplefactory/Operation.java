package strategy.factory.simplefactory;

/**
 * @author locks
 * @date 2022-02-28 16:34
 * 1.定义一个操作接口
 */
public interface Operation {
    public double getResult(double numberA,double numberB) throws Exception;
}
