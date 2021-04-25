package com.spark.rdd.map.mappartitions.mappartitions

import org.apache.spark.{SparkConf, SparkContext}

object mappartitions {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[2]").setAppName("mappartitions-rdd")
    val sc = new SparkContext(sparkConf)
    val rdd = sc.makeRDD(List(1, 2, 3, 4), 2)
    rdd.mapPartitions(
      iter => {
        List(iter.max).iterator
      }
    ).collect().foreach(println)
  }
}
