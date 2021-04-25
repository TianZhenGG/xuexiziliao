package com.spark.rdd.map.mappartitions.reducebykey

import org.apache.spark.{SparkConf, SparkContext}

object reducebykey{
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[2]").setAppName("reduce-rdd")
    val sc = new SparkContext(sparkConf)
    val rdd = sc.makeRDD(List(("a",1),("a",2),("b",3)))
    rdd.reduceByKey(_+_).collect().foreach(println)
    sc.stop()
  }
}
//对数据按照相同key对value进行聚合计算