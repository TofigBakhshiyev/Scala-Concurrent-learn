package FuturesAndPromises

import java.util.concurrent.Executors
import scala.concurrent.Future
import scala.util.{Failure, Success}

/**
 * Example for creating single thread
 * */
object ExampleExecutionContext {
  def main(args: Array[String]): Unit = {
    // defining single thread
    val executor = Executors.newSingleThreadExecutor()

    implicit val ec = scala.concurrent.ExecutionContext.fromExecutorService(executor)

    def simpleFuture(): Future[Int] =
      Future.successful(10)

    simpleFuture onComplete {
      case Success(result) =>
        println(s"Result: ${result}")
      case Failure(e) =>
        println(s"error: ${e}")
    }

    Thread.sleep(100)
  }
}
