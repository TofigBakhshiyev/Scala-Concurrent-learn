package FuturesAndPromises

import scala.concurrent.{Promise}
import scala.util.{Success, Try}
import scala.concurrent.ExecutionContext

/**
 * Simple Examples of Promise
 * Promise can be written (normally only once)
 * */
object ScalaPromise {
  implicit  val ec = ExecutionContext.global

  def main(args: Array[String]): Unit = {
    val promise = Promise[Int]()
    val future = promise.future

    // write a value to promise
    promise.complete(Success(1))
    // read the value
    println(future.map(answer => println(s"Answer: ${answer}")))

    // this will give an error because promise has already fulfilled
    promise.complete(Try(throw new Exception("e")))
  }
}
