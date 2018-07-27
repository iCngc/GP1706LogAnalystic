package com.qianfeng.analystic.mr.nu;

import com.qianfeng.analystic.model.dim.StatsUserDimension;
import com.qianfeng.analystic.model.dim.base.PlatformDimension;
import com.qianfeng.analystic.model.dim.value.map.TimeOutputValue;
import com.qianfeng.analystic.model.dim.value.reduce.MapWritableValue;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * @Auther: lyd
 * @Date: 2018/7/27 15:13
 * @Description:
 */
public class NewUserReudcer extends Reducer<StatsUserDimension,TimeOutputValue,
        StatsUserDimension,MapWritableValue>{
    PlatformDimension platformDimension = new PlatformDimension("website");
}
