package com.spark.rdd.map.mappartitions.distinct

import org.apache.spark.{SparkConf, SparkContext}

object distinct {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[2]").setAppName("distinct-rdd")
    val sc = new SparkContext(sparkConf)
    val rdd = sc.makeRDD(List(1,2,3,4,1,2,3,4),2)
    rdd.distinct().collect().foreach(println)
    sc.stop()
  }
}
//数据去重