package com.spark.rdd.map.mappartitions.flatmap

import org.apache.spark.{SparkConf, SparkContext}

object flatmap{
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[2]").setAppName("flatmap-rdd")
    val sc = new SparkContext(sparkConf)
    val value = sc.textFile("datas")
    value.flatMap(_.split(" ")).map(x => (x,1)).reduceByKey(_+_).collect().foreach(println)
    sc.stop()
  }
}
