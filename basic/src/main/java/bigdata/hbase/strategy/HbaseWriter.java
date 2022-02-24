package bigdata.hbase.strategy;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.io.IOException;
import java.util.List;

/**
 * @author hahahey
 * @date 2022-02-24 23:17
 */
public class HbaseWriter implements IWriter{

        private Connection connection;
        private IParseRecord parseRecord;
        //get和set方法方便访问私有属性
        //另一方法：利用构造方法的参数访问私有属性
        public IParseRecord getParseRecord() {
            return parseRecord;
        }
        public void setParseRecord(IParseRecord parseRecord) {
            this.parseRecord = parseRecord;
        }
        //配置hbase信息 连接hbase数据库
    public HbaseWriter(IParseRecord parseRecord) {
            this.parseRecord=parseRecord;
            Configuration conf = HBaseConfiguration.create();
            conf.set("hbase.rootdir", "hdfs://192.168.136.20:9000/hbase");
            conf.set("hbase.zookeeper.quorum", "192.168.136.20");
            conf.set("hbase.zookeeper.property.clientPort", "2181");
            try {
                connection= ConnectionFactory.createConnection(conf);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        @Override
        public int write(ConsumerRecords<String, String> records, String tableName) throws IOException {
            Table userFriendsTable = connection.getTable(TableName.valueOf(tableName));
            List<Put> datas=parseRecord.parse(records);
            userFriendsTable.put(datas);
            return datas.size();
        }

}
