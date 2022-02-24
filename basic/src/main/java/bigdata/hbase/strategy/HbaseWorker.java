package bigdata.hbase.strategy;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;

/**
 * @author hahahey
 * @date 2022-02-24 23:25
 */
public class HbaseWorker extends ParentWorker{
    private IWriter writer;
    private String topic;
    private String target;
    public HbaseWorker(IWriter writer,String topic,String targetTable) {
        this(writer,"myGroupNameDefalut",topic,targetTable);
    }
    public HbaseWorker(IWriter writer,String groupName,String topic,String targetTable) {
        super(groupName);
        this.writer=writer;
        this.topic=topic;
        this.target=targetTable;
    }

    @Override
    public void fillData() {
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(prop);
        consumer.subscribe(Collections.singleton(this.topic));//user_friends

        try {
            //将消费的数据装入Hbase的表中
            while(true){
                ConsumerRecords<String, String> poll = consumer.poll(Duration.ofMillis(100));
                int rowNum = writer.write(poll, this.target);
                System.out.println("行数："+rowNum);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
