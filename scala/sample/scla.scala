package com.spark.rdd.map.mappartitions.sample

import org.apache.spark.{SparkConf, SparkContext}

object sample{
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[2]").setAppName("sample-rdd")
    val sc = new SparkContext(sparkConf)
    val rdd = sc.makeRDD(List(1,2,3,4,5,6,7,8,9,10),2)
    rdd.sample(
      true,
      0.4,2).collect().foreach(println)
    sc.stop()}}
//数据抽取
