package com.nirvana.travel.bigdata.mr.wc;

import java.io.IOException;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * @author arainliu
 * @date 2020/10/27
 */
public class MyJob {

  public static void main(String[] args)
    throws IOException, ClassNotFoundException, InterruptedException {



    // Create a new Job
    Job job = Job.getInstance();
    job.setJarByClass(MyJob.class);
    job.setJobName("myjob");

    FileInputFormat.addInputPath(job, new Path("/data/wc/input"));
    FileOutputFormat.setOutputPath(job, new Path("data/wc/output"));

    job.setMapperClass(MyMapper.class);
    //定义输出到reduce中的<K,V>类型
    job.setMapOutputKeyClass(Text.class);
    job.setMapOutputValueClass(IntWritable.class);

    //reduce处理类
    job.setReducerClass(MyReducer.class);
    job.setNumReduceTasks(10);

    // Submit the job, then poll for progress until the job is complete
    job.waitForCompletion(true);
  }
}
