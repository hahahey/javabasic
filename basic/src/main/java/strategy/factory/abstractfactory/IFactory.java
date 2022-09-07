package strategy.factory.abstractfactory;

public interface IFactory {
    public IUser createUser();
    public ILogin createLogin();
}
