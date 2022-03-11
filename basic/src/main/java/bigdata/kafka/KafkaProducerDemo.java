package bigdata.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author locks
 * @date 2022-02-09 10:15
 */
public class KafkaProducerDemo {
  public static void main(String[] args) {

    Properties properties = new Properties();
    properties.put(
        ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "hadoop101:9092,hadoop102:9092,hadoop103:9092");
    // properties.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SASL_PLAINTEXT");
    properties.put(ProducerConfig.ACKS_CONFIG, "all");
    properties.put(ProducerConfig.RETRIES_CONFIG, 0);
    properties.put(ProducerConfig.BATCH_SIZE_CONFIG, 10000);
    properties.put(ProducerConfig.LINGER_MS_CONFIG, 500);
    properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

    Producer<String, String> producer = new KafkaProducer<>(properties);

//    String topicName = "topic_1_partiton_3_factor";
     String topicName = "test_topic";
    for (int i = 0; i < 100000; i++) {
      String data = "这是第 " + i + " 条消息";
      ProducerRecord record = new ProducerRecord<>(topicName, null, null, String.valueOf(i), data, null);
      producer.send(record);
      System.out.println(data);
    }
    producer.close();
  }
}
