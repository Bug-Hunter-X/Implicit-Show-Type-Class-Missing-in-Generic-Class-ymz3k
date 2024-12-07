```scala
trait Show[T] {
  def show(t: T): String
}

object ShowInstances {
  implicit val intShow: Show[Int] = new Show[Int] {
    override def show(t: Int): String = t.toString
  }

  implicit val stringShow: Show[String] = new Show[String] {
    override def show(t: String): String = t
  }

  implicit val listIntShow: Show[List[Int]] = new Show[List[Int]] {
    override def show(t: List[Int]): String = t.mkString(", ")
  }
}

class MyClass[T](val value: T)(implicit val show: Show[T]) {
  def printValue(): Unit = {
    println(show.show(value))
  }
}

object Main extends App {
  import ShowInstances._
  val myInt = new MyClass(10)
  myInt.printValue()

  val myString = new MyClass("Hello")
  myString.printValue()

  val myList = new MyClass(List(1, 2, 3))
  myList.printValue()
}
```