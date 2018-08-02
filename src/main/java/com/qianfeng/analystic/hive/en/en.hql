1、创建事件的基础维度类，不需要使用集合维度对象

2、创建获取维度id的udf函数，并测试

3、创建hive表映射每一天的数据，创建成分区表

4、创建最终结果表
CREATE external TABLE if not exists stats_event (
  `platform_dimension_id` int,
  `date_dimension_id` int,
  `event_dimension_id` int,
  `times` int,
  `created` string,
);


4、写hql
dw_en


s_time
pl,
ca
ac



-d 2018-07-27

select
 de.s_time,   //用内部函数转换成日期
 de.pl,
 de.ca,
 de.ac,
 count(1)
 from logs de
 where pl is not null
 and de.month = 7
 and de.day = 26
 group by de.s_time,de.pl,de.ca,de.ac
 ;


 1532593870123	website	null	null	1
  1532593870456	java_server	null	null	1



   1532593870123	website	null	all	1
   1532593870456	java_server	null	all	1


  1532593870123	all	null	null	1
  1532593870456	all	null	null	1


  1532593870123	all	null	all	1
    1532593870456	all	null	all	1


5、扩展维度,并将结果集导出到最终结果表中。union all

with tmp as(
select
 de.s_time,
 de.pl,
 de.ca,
 de.ac,
 count(1)
 from logs de
 where pl is not null
 and de.month = 7
 and de.day = 26
 group by de.s_time,de.pl,de.ca,de.ac
 )

 from (select all.... from tmp union all
 selelt ......union all
 select .... union all
  selelt ......union all
  select .... union all
   selelt ......)
   insert into stats_event
   select date_ccnvert(dt),platform_convert(pl),
   group by


 ;



6、使用sqoop语句将结果导出到mysql中
sqoop export --connnection jdbc: \
--username  \
;

7、将整个封装成shell脚本
判断时间，当时间没有则默认使用昨天的时间在执行。

hive --database gpdb -e "
with tmp as(
select
 de.s_time,
 de.pl,
 de.ca,
 de.ac,
 count(1)
 from logs de
 where pl is not null
 and de.month = ${}
 and de.day = ${}
 group by de.s_time,de.pl,de.ca,de.ac
 )

 from (select all.... from tmp union all
 selelt ......union all
 select .... union all
  selelt ......union all
  select .... union all
   selelt ......)
   insert into stats_event
   select date_ccnvert(dt),platform_convert(pl),
   group by


 ;
";

