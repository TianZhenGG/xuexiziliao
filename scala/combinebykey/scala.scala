package com.spark.rdd.map.mappartitions.combinebykey

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object combine {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[2]").setAppName("combine-rdd")
    val sc = new SparkContext(sparkConf)
    val rdd = sc.makeRDD(
      List(
        ("a",1),("a",2),("b",3),2
      )
    )
    val newRDD: RDD[(String,(Int,Int))] = rdd.combineByKey(
      v => (v,1),
      (t: (Int,Int),v) => {
        (t._1 + v,t._2 + t2._2)
      },
      (t1:(Int,Int),t2:(Int,Int)) => {
        (t1._1 + t2._1, t1._2 + t2._2)
      }
    )
    newRDD.collect().foreach(println)
    sc.stop()
  }
}
