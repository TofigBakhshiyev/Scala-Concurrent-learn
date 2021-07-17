package FuturesAndPromises

import java.util.concurrent.{ExecutorService, Executors}

import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.{Failure, Success}
import scala.concurrent.duration._

/**
 * Simple Examples of Futures,
 * Future is a read-only container for a result that does not yet exist
 * */
object ScalaFuture {
  // Creates a thread pool with a single thread.
  val singleThreadedPool: ExecutorService = Executors.newSingleThreadExecutor()
  implicit val ec = ExecutionContext.fromExecutorService(singleThreadedPool)

  def add(a: Int, b: Int): Future[Int] = {
    Future.successful(a + b)
  }

  def main(args: Array[String]): Unit = {
    val answer = add(8, 9)
    // waiting result with Await
    Await.result(answer, 10.seconds)
    println(s"Sum: ${answer}")

    answer onComplete {
      case Success(value) =>
        println("Handling Future with onComplete")
        println(s"Sum: ${value}")
      case Failure(exception) =>
        println(s"An error has occurred: ${exception}")
    }

    add(7, 10).map { answer =>
      println("Handling Future with map")
      println(s"Sum: ${answer}")
    }
  }
}
