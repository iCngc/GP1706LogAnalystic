package com.qianfeng.etl.mr.tohbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.util.Tool;
import org.apache.log4j.Logger;

/**
 * @Auther: lyd
 * @Date: 2018/7/26 11:49
 * @Description:驱动类
 */
public class LogToHbaseRunner implements Tool{
    private static final Logger logger = Logger.getLogger(LogToHbaseRunner.class);
    Configuration conf = null;

    @Override
    public void setConf(Configuration conf) {
        this.conf = HBaseConfiguration.create();
    }

    @Override
    public Configuration getConf() {
        return this.conf;
    }

    /**
     * yarn jar /home/gp1706.jar com.qianfeng.etl.mr.tohbase.ToLogRunner -d 2018-07-26
     * @param args
     * @return
     * @throws Exception
     */
    @Override
    public int run(String[] args) throws Exception {
        Configuration conf = this.getConf();
        //设置处理的参数
        this.setArgs(args,conf);
        //判断hbase的表是否存在
        this.HbaseTableExists(conf);
        //获取job
        Job job = Job.getInstance(conf,"to hbase etl");
        job.setJarByClass(LogToHbaseRunner.class);

        //设置map端的属性
        job.setMapperClass(LogToHbaseMapper.class);
        job.setMapOutputKeyClass(NullWritable.class);
        job.setMapOutputValueClass(Put.class);

        return 0;
    }

    /**
     * 判断hbase表是否存在，不存在则创建，存在则过
     * @param conf
     */
    private void HbaseTableExists(Configuration conf) {
    }

    /**
     * 参数处理
     * @param args
     * @param conf
     */
    private void setArgs(String[] args, Configuration conf) {
    }


}
