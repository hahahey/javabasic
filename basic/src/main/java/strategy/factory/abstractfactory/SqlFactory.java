package strategy.factory.abstractfactory;

/**
 * @author locks
 * @date 2022-02-28 16:59
 */
public interface SqlFactory {
    public IUser createUser();     //用于访问User表的对象
}
