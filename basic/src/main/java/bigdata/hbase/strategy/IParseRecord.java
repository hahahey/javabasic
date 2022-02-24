package bigdata.hbase.strategy;

import org.apache.hadoop.hbase.client.Put;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.util.List;

/**
 * @author hahahey
 * @date 2022/2/24 23:12
 */
public interface IParseRecord {
    public List<Put> parse(ConsumerRecords<String,String> records);
}
