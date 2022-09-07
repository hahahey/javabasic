package strategy.factory.abstractfactory;

public class MysqlFactory implements IFactory {
    @Override
    public IUser createUser() {
        return new MysqlUser();
    }
    @Override
    public ILogin createLogin() {
        return new MysqlLogin();
    }
}
