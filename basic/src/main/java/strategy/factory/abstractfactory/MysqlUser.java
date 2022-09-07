package strategy.factory.abstractfactory;

/**
 * @author locks
 * @date 2022-02-28 16:58
 */
public class MysqlUser implements IUser{
    @Override
    public void insert(User user){
        System.out.println("在mysql中的user表中插入一条元素");
    }

    @Override
    public User getUser(int id) {
        System.out.println("在mysql中的user表得到id为" + id + "的一条数据");
        return null;
    }
}
