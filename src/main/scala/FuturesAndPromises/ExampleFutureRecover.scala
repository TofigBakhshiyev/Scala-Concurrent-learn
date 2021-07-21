package FuturesAndPromises

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

/**
 * Recovering error message
 * */
object ExampleFutureRecover {
  def main(args: Array[String]): Unit = {

    def checkIsBig(number: Int): Future[Int] = Future {
      if(number > 0) number
      else throw new IllegalStateException("number is negative")
    }

    checkIsBig(-1)
      .recover { case e: IllegalStateException if e.getMessage == "number is negative" => 0 }
      .onComplete {
        case Success(donutStock)  => println(s"Results $donutStock")
        case Failure(e)           => println(s"Error processing future operations, error = ${e.getMessage}")
      }

    // recoverWith,
    // Call Future.recoverWith to recover from a known exception
    checkIsBig(-1)
      .recoverWith{
        case error: IllegalStateException if error.getMessage == "number is negative" =>
          Future.successful(1)
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
