package FuturesAndPromises

import scala.concurrent.{ExecutionContext, Future}

/**
 *  Concurrent calculation with Futures (Asynchronous)
 * */
object ExampleConcurrent {
  implicit  val ec = ExecutionContext.global

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
        val m = multiple(i)
        val d = divide(i)

        m.map(answer => println(s"multiple for index-${i}: ${answer}"))
        d.map(answer => println(s"divide for index-${i}: ${answer}"))
      }

    // prevent main thread from quitting too early
    Thread.sleep(500)
  }
}
