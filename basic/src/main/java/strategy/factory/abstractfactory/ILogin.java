package strategy.factory.abstractfactory;

import strategy.factory.abstractfactory.Login;

public interface ILogin {
    public void insert(Login login);
    public Login getLogin(int id);

}
