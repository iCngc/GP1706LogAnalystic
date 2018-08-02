package com.qianfeng.analystic.hive;

import com.qianfeng.analystic.model.dim.base.DateDimension;
import com.qianfeng.analystic.mr.service.IDimensionConvert;
import com.qianfeng.analystic.mr.service.impl.IDimensionConvertImpl;
import com.qianfeng.common.DateEnum;
import com.qianfeng.util.TimeUtil;
import org.apache.hadoop.hive.ql.exec.UDF;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

/**
 * @Auther: lyd
 * @Date: 2018/8/2 15:27
 * @Description:
 */
public class DateDimensionUdf extends UDF {

    private IDimensionConvert convert = new IDimensionConvertImpl();


    public int evaluate(String dt){
        DateDimension dd = DateDimension.buildDate(TimeUtil.parserString2Long(dt), DateEnum.DAY);
        int id = 0;
        try {
            id = convert.getDimensionIdByDimension(dd);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

}
