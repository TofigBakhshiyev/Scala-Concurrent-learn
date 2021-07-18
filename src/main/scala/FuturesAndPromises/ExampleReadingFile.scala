package FuturesAndPromises

import scala.concurrent.ExecutionContext.Implicits.global
import java.io.FileNotFoundException
import scala.concurrent.duration.{DurationInt}
import scala.concurrent.{Await, Future}
import scala.io.Source.fromFile

/**
 * Reading files parallel
 * */
object ExampleReadingFile {

  def readFile(fileName: String): List[String] = {
    fromFile(fileName).getLines.toList
  }

  def main(args: Array[String]): Unit =  {
    val data = for {
      keys <- Future { readFile("TestData/keys.txt") }
      values <- Future { readFile("TestData/values.txt") }
    } yield keys.zip(values).toMap

    data.recover {
      case e: FileNotFoundException => {
        Map[String, String]()
      }
    }.onComplete {
      case map => {
        println(map)
      }
    }

    Await.result(data, 1.seconds)
    Thread.sleep(500)
  }
}
