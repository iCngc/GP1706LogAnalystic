package com.qianfeng.analystic.model.dim.base;

import com.qianfeng.common.DateEnum;
import com.qianfeng.util.TimeUtil;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * @Auther: lyd
 * @Date: 2018/7/27 11:22
 * @Description:时间维度
 */
public class DateDimension extends BaseDimension{
    private int id;
    private int year;
    private int season; //季度
    private int month;
    private int week;
    private int day;
    private Date calendar = new Date();
    private String type;  //什么类型的指标 ，如天指标，月直指标

    public DateDimension(){

    }

    public DateDimension(int year, int season, int month, int week, int day) {
        this.year = year;
        this.season = season;
        this.month = month;
        this.week = week;
        this.day = day;
    }

    public DateDimension(int year, int season, int month, int week, int day,Date calendar) {
       this(year, season, month, week, day);
       this.calendar = calendar;
    }

    public DateDimension(int year, int season, int month, int week, int day,Date calendar,String type) {
        this(year, season, month, week, day,calendar);
        this.type = type;
    }

    /**
     * 根据时间戳和type获取时间的维度
     * @param time
     * @param type
     * @return
     */
    public static DateDimension buildDate(long time,DateEnum type){
        int year = TimeUtil.getDateInfo(time,type);
        Calendar calendar = Calendar.getInstance();
        calendar.clear();  //先先清除日历对象
        //判断type的类型
        if(DateEnum.YEAR.equals(type)){  //当年的1月1号这一天
            calendar.set(year,0,1);
            return new DateDimension(year,1,0,0,1,calendar.getTime(),type.type);
        }
        int season = TimeUtil.getDateInfo(time,DateEnum.SEASON);
        if(DateEnum.SEASON.equals(type)){  //当季度的第一个月的1号这一天
            int month = season*3 -2 ;
            calendar.set(year,month-1,1);
            return new DateDimension(year,season,month,0,1,calendar.getTime(),type.type);
        }

        int month = TimeUtil.getDateInfo(time,DateEnum.MONTH);
        if(DateEnum.MONTH.equals(type)){  //当月1号这一天
            calendar.set(year,month-1,1);
            return new DateDimension(year,season,month,0,1,calendar.getTime(),type.type);
        }

        int week = TimeUtil.getDateInfo(time,DateEnum.WEEK);
        if(DateEnum.WEEK.equals(type)){  //当周的第一天的0时0分0秒
            long firstDayOfWeek = TimeUtil.getFirstDayOfWeek(time);
            year = TimeUtil.getDateInfo(firstDayOfWeek,DateEnum.YEAR);
            season = TimeUtil.getDateInfo(firstDayOfWeek,DateEnum.SEASON);
            month = TimeUtil.getDateInfo(firstDayOfWeek,DateEnum.MONTH);
            week = TimeUtil.getDateInfo(firstDayOfWeek,DateEnum.WEEK);
            int day = TimeUtil.getDateInfo(firstDayOfWeek,DateEnum.DAY);
            calendar.set(year,month-1,1);
            return new DateDimension(year,season,month,week,day,calendar.getTime(),type.type);
        }

        int day = TimeUtil.getDateInfo(time,DateEnum.DAY);
        if(DateEnum.DAY.equals(type)){  //当月1号这一天
            calendar.set(year,month-1,day);
            return new DateDimension(year,season,month,week,day,calendar.getTime(),type.type);
        }
        throw new RuntimeException("该type暂时不支持获取时间维度."+type.type);
    }


    @Override
    public void write(DataOutput out) throws IOException {

    }

    @Override
    public void readFields(DataInput in) throws IOException {

    }

    @Override
    public int compareTo(BaseDimension o) {
        return 0;
    }


}
