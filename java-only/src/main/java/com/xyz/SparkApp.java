package com.xyz;


import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.JavaPairRDD;
import java.util.Arrays;
import scala.Tuple2;


public class SparkApp {

  public static void main(String[] args) {

    String fileName = "src/main/resources/lorem.txt";
    System.out.println("Simple Spark App");

    SparkConf sparkConf = new SparkConf()
            .setMaster("local")
            .setAppName("Word count app");

    JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);

    JavaPairRDD<String, String> result = sparkContext
            .textFile(fileName)
            .flatMap(s -> Arrays.asList(s.split(" ")).iterator())
            .mapToPair(t -> new Tuple2(t, 1))
            .reduceByKey((x, y) -> (int) x + (int) y);
    result.foreach(row -> System.out.println(row));
  }

}
