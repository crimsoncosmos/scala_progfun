package week05

object session5 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  //def sum(xs: List[Int]) = (0 :: xs) reduceLeft ((x, y) => x + y)
  def sum(xs: List[Int]) = (0 :: xs) reduceLeft (_ + _)
                                                  //> sum: (xs: List[Int])Int
  def sumFold(xs: List[Int]) = (xs foldLeft 0) (_ + _)
                                                  //> sumFold: (xs: List[Int])Int
  //def product(xs: List[Int]) = (1 :: xs) reduceLeft ((x, y) => x * y)
  def product(xs: List[Int]) = (1 :: xs) reduceLeft (_ * _)
                                                  //> product: (xs: List[Int])Int
  def productFold(xs: List[Int]) = (xs foldLeft 1)(_ * _)
                                                  //> productFold: (xs: List[Int])Int
	val l1 = List(1,2,3,4,5)                  //> l1  : List[Int] = List(1, 2, 3, 4, 5)
	
	sum(l1)                                   //> res0: Int = 15
	sumFold(l1)                               //> res1: Int = 15
	product(l1)                               //> res2: Int = 120
	productFold(l1)                           //> res3: Int = 120
	
	def concat[T](xs: List[T], ys: List[T]): List[T] =
    (xs foldRight ys) (_ :: _)                    //> concat: [T](xs: List[T], ys: List[T])List[T]
 
  //def concatLeft[T](xs: List[T], ys: List[T]): List[T] =
  //	(xs foldLeft ys)(_ :: _)
 	
 	concat(l1, List('a','b','c'))             //> res4: List[AnyVal] = List(1, 2, 3, 4, 5, a, b, c)
 	
 	def mapFun[T, U](xs: List[T], f: T => U): List[U] =
    (xs foldRight List[U]())( ??? )               //> mapFun: [T, U](xs: List[T], f: T => U)List[U]

  def lengthFun[T](xs: List[T]): Int =
    (xs foldRight 0)( ??? )                       //> lengthFun: [T](xs: List[T])Int
  
}