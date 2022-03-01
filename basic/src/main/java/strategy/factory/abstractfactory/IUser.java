package strategy.factory.abstractfactory;
/**
 *
 * @author locks
 * @date 2022-02-28 16:58
 */
public interface IUser {
    public void insert(User user);
    public User getUser(int uid);
}
