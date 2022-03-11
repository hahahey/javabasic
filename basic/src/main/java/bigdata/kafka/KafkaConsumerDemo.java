package bigdata.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author locks
 * @date 2022-02-09 9:56
 */
public class KafkaConsumerDemo {
  private static final Logger log = LoggerFactory.getLogger(KafkaConsumerDemo.class);

  public static void main(String[] args) {

    Properties props = new Properties();
    props.put("bootstrap.servers", "hadoop101:9092,hadoop102:9092,hadoop103:9092");
    props.put("group.id", "groupId11");
    props.put("enable.auto.commit", "true");
    props.put("auto.offset.reset", "earliest");
    props.put("max.poll.records", 10);
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

    //    String topicName = "test_topic";
    String topicName = "topic_1_partiton_3_factor";

    KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
    consumer.subscribe(Collections.singletonList(topicName));
    Map<TopicPartition, OffsetAndMetadata> map = new HashMap<>();
    int count = 0;

    ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
    for (ConsumerRecord<String, String> recordData : records) {

      String value = recordData.value();

      System.out.println(value);

      TopicPartition topicPartition =
      new TopicPartition(recordData.topic(), recordData.partition());
      OffsetAndMetadata offsetAndMetadata = new OffsetAndMetadata(recordData.offset());
      map.put(topicPartition, offsetAndMetadata);

      consumer.commitSync(map);

    }
  }
}
