package bigdata.hbase.strategy;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hahahey
 * @date 2022-02-24 23:22
 */
public class UserFriendHandler implements IParseRecord{
    @Override
    public List<Put> parse(ConsumerRecords<String, String> records) {
        List<Put> datas=new ArrayList<>();
        for (ConsumerRecord<String, String> p : records) {
            String[] split = p.value().split(",");
            Put put = new Put(Bytes.toBytes((split[0] + split[1]).hashCode()));
            put.addColumn("uf".getBytes(),"userid".getBytes(),split[0].getBytes());
            put.addColumn("uf".getBytes(),"friendid".getBytes(),split[1].getBytes());
            datas.add(put);
        }
        return datas;
    }
}
