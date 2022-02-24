package bigdata.hbase.strategy;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Properties;

/**
 * @author hahahey
 * @date 2022-02-24 23:15
 */
public abstract class ParentWorker implements IWorker{
    protected Properties prop;
    public ParentWorker(String groupName) {
        //kafka消费端属性配置
        prop = new Properties();
        prop.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.136.20:9092");
        prop.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        prop.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        prop.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 30000);
        prop.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        prop.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 1000);
        //也可设置成自动提交，工作中很可能用自动提交
        //prop.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true)
        prop.put(ConsumerConfig.GROUP_ID_CONFIG, groupName);
        prop.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
    }
}
