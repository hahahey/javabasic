package strategy.factory.abstractfactory.plus;

import strategy.factory.abstractfactory.IUser;
import strategy.factory.abstractfactory.User;

/**
 * @author locks
 * @date 2022-02-28 17:19
 */
public class Client1 {
    public static void main(String[] args) throws Exception {



        IUser user = EasyFactory1.createUser();

        user.insert(new User());
        user.getUser(1);

    }
}
