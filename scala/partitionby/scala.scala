package com.spark.rdd.map.mappartitions.partitionby

import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}

object partitionby {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[2]").setAppName("partition-rdd")
    val sc = new SparkContext(sparkConf)
    val rdd = sc.makeRDD(
      Seq(1,2,3,4,2),2
    )
    rdd.map((_,1)).partitionBy(new HashPartitioner(2)).saveAsTextFile("output")
    sc.stop()
  }
}
//重新分区