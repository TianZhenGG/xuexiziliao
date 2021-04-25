package com.spark.rdd.map.mappartitions.sortBy

import org.apache.spark.{SparkConf, SparkContext}

object sortBy {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[2]").setAppName("sortby-rdd")
    val sc = new SparkContext(sparkConf)
    val rdd = sc.makeRDD(Seq(1,2,3,4,2),2)
    rdd.sortBy(num => num).saveAsTextFile("datas")
    sc.stop()
  }
}
