package com.spark.rdd.map.mappartitions.intersection

import org.apache.spark.{SparkConf, SparkContext}

object intersection{
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[2]").setAppName("intersection-rdd")
    val sc = new SparkContext(sparkConf)
    val rdd1 = sc.makeRDD(Seq(1,2,3,4,2),2)
    val rdd = sc.makeRDD(List(2,4,5,6,4),2)
    println(rdd.intersection(rdd1).collect().mkString(","))
    println(rdd.union(rdd1).collect().mkString(","))
    println(rdd.subtract(rdd1).collect().mkString(","))
    println(rdd.zip(rdd1).collect().foreach(println))
    sc.stop()
  }
}
//交集&&并集&&差集&&拉链