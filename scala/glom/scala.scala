package com.spark.rdd.map.mappartitions.glom

import org.apache.spark.{SparkConf, SparkContext}

object glom {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[2]").setAppName("glom-rdd")
    val sc = new SparkContext(sparkConf)
    val rdd = sc.makeRDD(List(1,2,3,4),2)
    rdd.glom().collect().foreach(
      data => println(data.mkString(","))
    )
    sc.stop()
  }
}
//直接转换相同类型的内存数组处理，分区不变