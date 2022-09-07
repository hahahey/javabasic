package strategy.factory.abstractfactory;

/**
 * @author locks
 * @date 2022-02-28 17:00
 */
public class OracleFactory implements IFactory {
    @Override
    public IUser createUser() {
        return new OracleUser();
    }
    @Override
    public ILogin createLogin() {
        return new OracleLogin();
    }
}
