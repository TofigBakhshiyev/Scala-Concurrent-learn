package FuturesAndPromises

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

/**
 * The foldLeft on your future operations will be run asynchronously from left to right.
 * */
object ExampleFoldLeft {
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

    // Future.foldLeft to fold over futures results from left to right
    // pass a valid quantity or a default value of zero to the accumulator
    val futureFoldLeft = Future.foldLeft(futures)(0) {
      case (accumulator, some) =>
        accumulator + some.getOrElse(0)
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
