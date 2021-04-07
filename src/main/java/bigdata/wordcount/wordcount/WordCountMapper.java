package bigdata.wordcount.wordcount;

//public class WordCountMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
//      private Text text = new Text();
//      private LongWritable longWritable = new LongWritable(1);
//
//    @Override
//    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
//        String[] arr = value.toString().split(" ");
//        for (String s : arr) {
//            text.set(s);
//        }
//        context.write(text,longWritable);
//    }
//}

//public class WordCountMapper extends Mapper<LongWritable, Text, Text, FlowBean> {
//    FlowBean flowBean = new FlowBean();
//    Text text = new Text();
//
//    @Override
//    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
//        String[] arr = value.toString().split(" ");
//        flowBean.setUpFlow(Long.parseLong(arr[1]));
//        flowBean.setDownFlow(Long.parseLong(arr[2]));
//        flowBean.setTotalFlow();
//
//        text.set(arr[0]);
//        context.write(text,flowBean);
//    }
//}

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WordCountMapper extends Mapper<LongWritable, Text, FlowBean, Text> {
    FlowBean flowBean = new FlowBean();
    Text text = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] arr = value.toString().split(" ");
        flowBean.setUpFlow(Long.parseLong(arr[1]));
        flowBean.setDownFlow(Long.parseLong(arr[2]));
        flowBean.setTotalFlow();

        text.set(arr[0]);
        context.write(flowBean,text);
    }
}