## Scala Concurrent Learn
Learn about scala futures and promises, concurrent programming

#### Scala Future Basics

Learn about Futures and how to print its results, Feature is used for read. [example code](src/main/scala/FuturesAndPromises/ScalaFuture.scala)

#### Scala Promise

Promise can be written (normally only once), Promise is used for write.
[example code](src/main/scala/FuturesAndPromises/ScalaPromise.scala)

#### Scala Concurrent example

How to do calculation concurrently with Features. [example code](src/main/scala/FuturesAndPromises/ExampleConcurrent.scala)

#### Scala Synchronous example

How to do calculation synchronously with Features, used Await.result to wait result. [example code](src/main/scala/FuturesAndPromises/ExampleSynchronous.scala)

#### Scala Parallel calculation example

How to do calculation parallel with Features, used Future.sequence.
[example code](src/main/scala/FuturesAndPromises/ExampleParallel.scala)

#### Scala Parallel-2 calculation example

How to do calculation parallel with Features, used Future.traverse, traverse and sequence are similar, difference is that traverse
easily convert all the Option[Int] into just Int type.
[example code](src/main/scala/FuturesAndPromises/ExampleParallel2.scala)

#### Scala Zip two features example

The Future.zip will create a new future, whose return type will be a tuple holding the return types of the two futures.
[example code-1](src/main/scala/FuturesAndPromises/ExampleFutureZip.scala), [example dode-2](src/main/scala/FuturesAndPromises/ExampleReadingFile.scala)

#### Scala FoldLeft example

The foldLeft on your future operations will be run asynchronously from left to right.
[example code](src/main/scala/FuturesAndPromises/ExampleFoldLeft.scala)

#### Scala ReduceLeft example

The reduceLeft is similar with foldLeft, however, reduceLeft() does not allow you to provide a default value.
[example code](src/main/scala/FuturesAndPromises/ExampleReduceLeft.scala)

#### Scala FutureThen example

The andThen is used for passing partialFunction.
[example code](src/main/scala/FuturesAndPromises/ExampleFutureThen.scala)

#### Scala FirstCompletedOf callback function example

The firstCompletedOf return any one of the futures which finish first.
[example code](src/main/scala/FuturesAndPromises/ExampleFirstCompletedOf.scala)

#### Scala ExecutionContext example

In this example, learn how to create single threaded executionContext.
[example code](src/main/scala/FuturesAndPromises/ExampleExecutionContext.scala)

#### Scala Future recover example

The recover function recovers error message.
[example code](src/main/scala/FuturesAndPromises/ExampleFutureRecover.scala)

#### More resources for concurrent and parallel programming in Scala
- [Scala Futures for Beginners](http://allaboutscala.com/tutorials/chapter-9-beginner-tutorial-using-scala-futures/#futures-introduction)
- [Monix](https://monix.io/)
- [Akka Actors](https://doc.akka.io/docs/akka/current/index.html)
