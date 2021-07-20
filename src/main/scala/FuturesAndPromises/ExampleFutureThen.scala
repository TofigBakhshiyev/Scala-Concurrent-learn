package FuturesAndPromises

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
 *  andThen() is used,
 *  whenever you have a need to apply a side-effect function on the result returned by the future
 * */
object ExampleFutureThen {
  def main(args: Array[String]): Unit = {
    def check(item: String): Future[Int] =
      if (item.length > 0) Future.successful(item.length) else Future.successful(0)

    val futureThen = check("key")

    // Call Future.andThen with a PartialFunction
    futureThen.andThen {
      case result =>
        println(s"Result: ${result}")
    }

    Thread.sleep(100)
  }
}
