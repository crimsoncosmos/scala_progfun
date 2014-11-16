package week04

object session7 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val test = scala.List(1,3,5,7,2,6,8,0)          //> test  : List[Int] = List(1, 3, 5, 7, 2, 6, 8, 0)
  
  def isort(xs: scala.List[Int]): scala.List[Int] = xs match {
  	case scala.List() => scala.List()
  	case y :: ys => insert(y, isort(ys))
  }                                               //> isort: (xs: List[Int])List[Int]
  
  def insert(x: Int, xs: scala.List[Int]): scala.List[Int] = xs match {
  	case scala.List() => scala.List(x)
  	case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
  }                                               //> insert: (x: Int, xs: List[Int])List[Int]
  
  isort(test)                                     //> res0: List[Int] = List(0, 1, 2, 3, 5, 6, 7, 8)
}