package strategy.factory.abstractfactory;

/**
 * @author locks
 * @date 2022-02-28 17:08
 */
public class OracleLogin implements ILogin{
    @Override
    public void insert(Login login) {
        System.out.println("对 Oracle 里的 Login 表插入了一条数据");
    }
    @Override
    public Login getLogin(int id) {
        System.out.println("通过 uid 在 Oracle 里的 Login 表得到了一条数据");
        return null;
    }
}
