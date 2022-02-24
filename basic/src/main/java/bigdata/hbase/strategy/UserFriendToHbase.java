package bigdata.hbase.strategy;

/**
 * @author hahahey
 * @date 2022-02-24 23:26
 */
public class UserFriendToHbase {
    public static void main(String[] args) {
        IParseRecord record = new UserFriendHandler();
        IWriter writer = new HbaseWriter(record);
        IWorker worker = new HbaseWorker(writer,
                "user_friendsGroupId",   //groupId
                "user_friends",		//kafka topic
                "events_db:user_friend");  //Hbase的表，需要提前创建
        worker.fillData();
    }
}
