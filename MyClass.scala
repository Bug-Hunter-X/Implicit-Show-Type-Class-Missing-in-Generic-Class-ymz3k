```scala
class MyClass[T](val value: T) {
  def printValue(): Unit = {
    println(value)
  }
}

object Main extends App {
  val myInt = new MyClass(10)
  myInt.printValue()

  val myString = new MyClass("Hello")
  myString.printValue()

  val myList = new MyClass(List(1, 2, 3))
  myList.printValue()
}
```