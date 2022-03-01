package strategy.factory.abstractfactory.plus;

import strategy.factory.abstractfactory.*;

/**
 * @author locks
 * @date 2022-02-28 17:04
 */
public class EasyFactory1 {
    private static String packName = "strategy.factory.abstractfactory";
    private static String sqlName = "Mysql";

    public static IUser createUser() throws Exception{
        String className = packName+"."+sqlName+"User";
        return (IUser)Class.forName(className).newInstance();
    }

    public static ILogin createLogin() throws Exception{
        String className = packName+"."+sqlName+"Login";
        return (ILogin)Class.forName(className).newInstance();
    }

}
