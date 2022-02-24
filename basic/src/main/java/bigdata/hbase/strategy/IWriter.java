package bigdata.hbase.strategy;

import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.io.IOException;

/**
 * @author hahahey
 * @date 2022/2/24 22:41
 *
 */
public interface IWriter {
    public int write(ConsumerRecords<String,String> records,String tableName) throws IOException;
}
