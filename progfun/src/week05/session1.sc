package week05

object session1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def init[T](xs: List[T]): List[T] = xs match {
    case List() => throw new Error("init of empty list")
    case List(x) => List()
    case y :: ys => y :: init(ys)
  }                                               //> init: [T](xs: List[T])List[T]
  
  init(List(1))                                   //> res0: List[Int] = List()
  init(List(1,2,3,4,5,6))                         //> res1: List[Int] = List(1, 2, 3, 4, 5)
  
//  def removeAt[T](n: Int, xs: List[T]): List[T] = xs match {
//  	case List() => xs
//  	case y :: ys =>
//  		if (n == 0) ys
//  		else y :: removeAt(n - 1, ys)
//  }

	def removeAt[T](n: Int, xs: List[T]) = (xs take n) ::: (xs drop n + 1)
                                                  //> removeAt: [T](n: Int, xs: List[T])List[T]
  
  removeAt(0, List(1,2,3,4))                      //> res2: List[Int] = List(2, 3, 4)
  removeAt(1, List(1,2,3,4))                      //> res3: List[Int] = List(1, 3, 4)
  removeAt(2, List(1,2))                          //> res4: List[Int] = List(1, 2)
  
  def flatten(xs: List[Any]): List[Any] = ???     //> flatten: (xs: List[Any])List[Any]

// flatten(List(List(1, 1), 2, List(3, List(5, 8)))) res0: List[Any] = List(1, 1, 2, 3, 5, 8)
}