package bigdata.wordcount.wordcount;

//public class WordCountReducer extends Reducer<Text, LongWritable, Text, LongWritable> {
//    private LongWritable out = new LongWritable();
//    @Override
//    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
//        int sum = 0;
//        for (LongWritable value : values) {
//            sum += value.get();
//        }
//        out.set(sum);
//        context.write(key,out);
//    }
//}

//public class WordCountReducer extends Reducer<Text, FlowBean, Text, FlowBean> {
//    private FlowBean flowBean = new FlowBean();
//    @Override
//    protected void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {
//        long up  = 0;
//        long down  = 0;
//        //聚合 total 字段
//        for (FlowBean value : values) {
//            up += value.getUpFlow();
//            down += value.getDownFlow();
//        }
//
//        flowBean.setUpFlow(up);
//        flowBean.setDownFlow(down);
//        flowBean.setTotalFlow();
//
//        context.write(key,flowBean);
//    }
//}


import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class WordCountReducer extends Reducer<FlowBean,Text, Text, FlowBean> {
    @Override
    protected void reduce(FlowBean key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        for (Text value : values) {
            context.write(value,key);
        }

    }
}
