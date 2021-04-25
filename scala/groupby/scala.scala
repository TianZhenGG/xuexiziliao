package com.spark.rdd.map.mappartitions.groupby

import org.apache.spark.{SparkConf, SparkContext}

object groupby {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[2]").setAppName("groupby-rdd")
    val sc = new SparkContext(sparkConf)
    val rdd = sc.makeRDD(List(1,2,3,4),2)
    rdd.groupBy(x => x % 2).collect().foreach(println)
    sc.stop()
  }
}
//指定规则分组
