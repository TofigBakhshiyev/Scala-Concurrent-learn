package FuturesAndPromises

import scala.concurrent.{Promise}
import scala.util.{Success, Try}
import scala.concurrent.ExecutionContext

/**
 * Simple Examples of Promise
 * Promise can be written (normally only once)
 * https://www.youtube.com/watch?v=Wq9YbTeOkjA&t=33s
 * */
object ScalaPromise {
  implicit  val ec = ExecutionContext.global

  def main(args: Array[String]): Unit = {
    val promise = Promise[Int]()
    val future = promise.future

    promise.complete(Success(1))
    println(future.map(answer => println(s"Answer: ${answer}")))

    // this will give an error because promise has already fulfilled
    promise.complete(Try(throw new Exception("e")))
  }
}
