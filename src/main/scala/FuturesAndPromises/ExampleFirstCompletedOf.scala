package FuturesAndPromises

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

/**
 * A reminder that firstCompletedOf() is non-deterministic and,
 * it will return any one of the futures which finish first
 * */
object ExampleFirstCompletedOf {
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

    // Call Future.firstCompletedOf to get the results of the first future that completes
    val futureFirstCompletedResult = Future.firstCompletedOf(futures)
    futureFirstCompletedResult.onComplete {
      case Success(results) => println(s"Results $results")
      case Failure(e)       => println(s"Error processing future operations, error = ${e.getMessage}")
    }

    Thread.sleep(100)
  }
}
