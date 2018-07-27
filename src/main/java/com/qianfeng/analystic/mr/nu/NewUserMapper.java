package com.qianfeng.analystic.mr.nu;

import org.apache.hadoop.hbase.mapreduce.TableMapper;
import org.apache.hadoop.io.Text;

/**
 * @Auther: lyd
 * @Date: 2018/7/27 10:27
 * @Description: 新增的用户和新增的总用户统计的mapper类
 */
public class NewUserMapper extends TableMapper<Text,Text> {

}
