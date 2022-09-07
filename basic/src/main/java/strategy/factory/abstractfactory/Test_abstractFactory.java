package strategy.factory.abstractfactory;

/**
 * @author locks
 * @date 2022-02-28 17:01
 * 1. 我们现在要对mysql/oracle数据库中的User表进行操作
 * 2. 接下来我们定义一个对User进行操作的接口：
 * 3. 实现一个对mysql/oracle中User进行操作的类：
 * 4. 接下来定义一个工厂接口，用于生产访问User表的对象：
 * 5. 生产mysqlUser对象的mysql工厂类：oracleUser对象的oracle工厂类：
 * 6. 用户测试类
 *
 */
public class Test_abstractFactory {
    public static void main(String[] args) {
//        SqlFactory factory1 = new MysqlFactory();
//        IUser userOperator = factory1.createUser();
//        userOperator.getUser(1);
//        userOperator.insert(new User());
    }
}
