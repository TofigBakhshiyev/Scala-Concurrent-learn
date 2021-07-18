package FuturesAndPromises

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

/**
 * Parallel calculation with Futures sequence
 * */
object ExampleParallel {
  def multiple(input: Int): Future[Int] = {
    Future(
      input * input
    )
  }

  def divide(input: Int): Future[Float] = {
    Future(
      (input + 1) / input
    )
  }

  def main(args: Array[String]): Unit = {
    for (i <- 1 to 5) {

      val futures: List[Future[Any]] = List(multiple(i), divide(i))
      
      // Call Future.sequence to run the future operations in parallel
      val futureSequenceResults = Future.sequence(futures)

      futureSequenceResults.onComplete {
        case Success(results) =>
          println(s"Results of execution index-${i}: ${results}")
        case Failure(e) =>
          println(s"Error processing future operations, error = ${e.getMessage}")
      }
    }

    Thread.sleep(100)
  }
}
