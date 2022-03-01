package strategy.factory.abstractfactory.plus;

import strategy.factory.abstractfactory.*;

/**
 * @author locks
 * @date 2022-02-28 17:04
 */
public class EasyFactory {
    // 数据库名称
    private static String db="MySQL";
    // private static String db="Oracle";

    public static IUser createUser(){

        IUser user=null;
        switch (db){
            case "MySQL":
                user=new MysqlUser();
                break;

            case "Oracle":
                user=new OracleUser();
                break;
        }
        return user;
    }

    public static ILogin createLogin(){

        ILogin login=null;
        switch (db){
            case "MySQL":
                login=new MysqlLogin();
                break;

            case "Oracle":
                login=new OracleLogin();
                break;
        }
        return login;
    }
}
