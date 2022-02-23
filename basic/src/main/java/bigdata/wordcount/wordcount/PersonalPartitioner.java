package bigdata.wordcount.wordcount;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class PersonalPartitioner extends Partitioner<FlowBean,Text> {
    @Override
    public int getPartition(FlowBean flowBean,Text text,  int numPartitions) {
        String phone = text.toString();
        if ("131".equals(phone.substring(0, 3))) {
            return 0;
        } else if ("132".equals(phone.substring(0, 3))) {
            return 1;
        } else if ("133".equals(phone.substring(0, 3))) {
            return 2;
        } else if ("134".equals(phone.substring(0, 3))) {
            return 3;
        } else if ("135".equals(phone.substring(0, 3))) {
            return 4;
        } else {
            return 5;
        }
    }
}
