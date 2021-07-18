package FuturesAndPromises

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

/**
 * Parallel calculation with Futures traverse
 * Using the Future.traverse function, we can easily convert all the Option[Int] into just Int type
 * */
object ExampleParallel2 {
  def multiple(input: Int): Future[Option[Int]] = {
    Future(
      if (input > 0)
        Some(input * input)
      else {
        None
      }
    )
  }

  def divide(input: Int): Future[Option[Float]] = {
    Future(
      if (input > 0)
        Some((input + 1) / input)
      else {
        None
      }
    )
  }

  def main(args: Array[String]): Unit = {
    for (i <- -1 to 4) {

      val futures: List[Future[Option[Any]]] = List(multiple(i), divide(i))

      // Call Future.traverse to run the future operations in parallel
      val futureTraverseResult = Future.traverse(futures){ result =>
        result.map( answer =>
          answer.getOrElse(0)
        )
      }

      futureTraverseResult.onComplete {
        case Success(results) =>
          println(s"Results of execution index-${i}: ${results}")
        case Failure(e) =>
          println(s"Error processing future operations, error = ${e.getMessage}")
      }
    }

    Thread.sleep(100)
  }
}
