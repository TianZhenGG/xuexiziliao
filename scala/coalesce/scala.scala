package com.spark.rdd.map.mappartitions.coalesce

import org.apache.spark.{SparkConf, SparkContext}

object coalesce {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[2]").setAppName("coalesce-rdd")
    val sc = new SparkContext(sparkConf)
    val rdd = sc.makeRDD(List(1,2,3,4),4)
    rdd.coalesce(2).saveAsTextFile("output")
    //rdd.repartition(2).saveAsTextFile("output")
    sc.stop()
  }
}
//将数据减少分区，用大数据集过滤，提高小数据集执行效率
