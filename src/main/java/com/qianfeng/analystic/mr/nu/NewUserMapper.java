package com.qianfeng.analystic.mr.nu;

import com.qianfeng.analystic.model.dim.StatsUserDimension;
import com.qianfeng.analystic.model.dim.value.map.TimeOutputValue;
import org.apache.hadoop.hbase.mapreduce.TableMapper;

/**
 * @Auther: lyd
 * @Date: 2018/7/27 10:27
 * @Description: 新增的用户和新增的总用户统计的mapper类
 */
public class NewUserMapper extends TableMapper<StatsUserDimension,TimeOutputValue> {

}
