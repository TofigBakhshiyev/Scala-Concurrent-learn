package FuturesAndPromises

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

/**
 * The Future.zip will create a new future,
 * whose return type will be a tuple holding the return types of the two futures
 * */
object ExampleFutureZip {
  def main(args: Array[String]): Unit = {
    def item(): Future[String] = Future.successful("apple")
    def price(): Future[Double] = Future.successful(9.99)

    // zip item with price
    val zippedFuture = item zip price

    zippedFuture onComplete {
      case Success(result) =>
        println(s"Result: ${result}")
      case Failure(e) =>
        println(s"Error: ${e}")
    }

    // zipWith, difference is that,
    // the zipWith() method allows you to pass-through a function which can be applied to the results
    def itemWith(i: String): Future[Option[String]] = {
      Future(
        Some(i)
      )
    }

    val future: (Option[String], Double) => (String, Double) = (some, price) => (some.getOrElse(""), price)
    val futureZipWith = itemWith("apple-1").zipWith(price())(future)

    futureZipWith onComplete {
      case Success(result) =>
        println(s"Result: ${result}")
      case Failure(e) =>
        println(s"Error: ${e}")
    }

    Thread.sleep(100)
  }
}
