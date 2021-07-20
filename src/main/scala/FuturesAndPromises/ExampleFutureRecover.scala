package FuturesAndPromises

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

/**
 * Recovering error message
 * */
object ExampleFutureRecover {
  def main(args: Array[String]): Unit = {
    def checkIsBig(number: Int): Future[Int] =
      if (number > 0) Future.successful(10) else throw new IllegalStateException("number is negative")

    checkIsBig(-1)
      .recover{ case error: IllegalStateException if error.getMessage == "number is negative" => 0 }
      .onComplete {
        case Success(result) =>
          println(s"Result: $result")
        case Failure(e) =>
          println(s"error: ${e}")
      }

    // recoverWith,
    // Call Future.recoverWith to recover from a known exception
    checkIsBig(-1)
      .recoverWith{
        case error: IllegalStateException if error.getMessage == "number is negative" =>
          Future.successful(0)
      }
      .onComplete{
        case Success(result) =>
          println(s"Result: $result")
        case Failure(e) =>
          println(s"error: ${e}")
      }
    Thread.sleep(100)
  }
}
