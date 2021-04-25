package com.spark.rdd.map.mappartitions.filter

import org.apache.spark.{SparkConf, SparkContext}

object filter{
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[2]").setAppName("filter-rdd")
    val sc = new SparkContext(sparkConf)
    val rdd = sc.makeRDD(List(1,2,3,4),2)
    rdd.filter(x => x % 2 !=0).collect().foreach(println)
    sc.stop()
  }
}
//按规则过滤