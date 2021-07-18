package FuturesAndPromises

import scala.concurrent.duration._
import scala.concurrent.{Await, ExecutionContext, Future}

/**
 *  Synchronous Futures
 * */
object ExampleSynchronous {
  implicit  val ec = ExecutionContext.global

  def multiple(input: Int): Future[Int] = {
    Future(
      input * input
    )
  }

  def divide(input: Int): Future[Float] = {
    Future(
      input / (input + 1)
    )
  }

  def main(args: Array[String]): Unit = {
    for (i <- 1 to 5) {
      val m = multiple(i)
      val d = divide(i)

      // waiting results
      Await.result(m, 1.seconds)
      Await.result(d, 1.seconds)

      m.map(answer => println(s"multiple for index-${i}: ${answer}"))
      d.map(answer => println(s"divide for index-${i}: ${answer}"))
    }

    // prevent main thread from quitting too early
    Thread.sleep(5000)
  }
}
