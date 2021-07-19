package FuturesAndPromises

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

/**
 * Scala also provides a Future.reduceLeft() function which has a similar behaviour.
 * Unlike foldLeft(), however, reduceLeft() does not allow you to provide a default value
 * */
object ExampleReduceLeft {
  def checkIsBig(input: Int): Future[Option[Int]] = {
    Future(
      if (input > 0) {
        Some(20)
      } else {
        None
      }
    )
  }

  def main(args: Array[String]): Unit = {
    val futures = List(
      checkIsBig(1),
      checkIsBig(-1),
      checkIsBig(8),
      checkIsBig(9),
      checkIsBig(11),
      checkIsBig(7)
    )

    // Call Future.reduceLeft to fold over futures results from left to right
    // we cannot provide a default value and hence the accumulator is of type Option[Int]
    val futureFoldLeft = Future.reduceLeft(futures) {
      case (accumulator, some) =>
        accumulator.map(result => result + some.getOrElse(0))
    }

    futureFoldLeft onComplete {
      case Success(results) =>
        println(s"Aggregate result: $results")
      case Failure(e) =>
        println(s"Error processing future operations, error = ${e.getMessage}")
    }

    Thread.sleep(100)
  }
}
