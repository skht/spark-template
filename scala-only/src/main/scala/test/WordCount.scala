package test

import org.apache.spark.sql.SparkSession

object WordCount extends App {

  val ss = SparkSession.builder().appName("Spark App").master("local").getOrCreate();
  val textFile = "src/main/resources/text.txt"
  val inputRdd = ss.sparkContext.textFile(textFile)
  val counts = inputRdd.flatMap(line => line.split(" "))
    .map(word => (word, 1))
    .reduceByKey(_ + _)
    .foreach(println)

}
