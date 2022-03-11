package strategy.factory.abstractfactory.plus;

import strategy.factory.abstractfactory.ILogin;
import strategy.factory.abstractfactory.IUser;
import strategy.factory.abstractfactory.Login;
import strategy.factory.abstractfactory.User;

/**
 * @author locks
 * @date 2022-02-28 17:16
 */
public class Client {
    public static void main(String[] args){

        User user=new User();
        Login login = new Login();

        // 直接得到实际的数据库访问实例，而不存在任何依赖
        IUser userOperation= EasyFactory.createUser();

        userOperation.getUser(1);
        userOperation.insert(user);

        // 直接得到实际的数据库访问实例，而不存在任何依赖
        ILogin loginOperation=EasyFactory.createLogin();

        loginOperation.insert(login);
        loginOperation.getLogin(1);



    }

}
