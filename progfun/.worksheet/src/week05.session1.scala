package week05

object session1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
  println("Welcome to the Scala worksheet");$skip(174); 
  
  def init[T](xs: List[T]): List[T] = xs match {
    case List() => throw new Error("init of empty list")
    case List(x) => List()
    case y :: ys => y :: init(ys)
  };System.out.println("""init: [T](xs: List[T])List[T]""");$skip(19); val res$0 = 
  
  init(List(1));System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(26); val res$1 = 
  init(List(1,2,3,4,5,6));System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(246); 
  
//  def removeAt[T](n: Int, xs: List[T]): List[T] = xs match {
//  	case List() => xs
//  	case y :: ys =>
//  		if (n == 0) ys
//  		else y :: removeAt(n - 1, ys)
//  }

	def removeAt[T](n: Int, xs: List[T]) = (xs take n) ::: (xs drop n + 1);System.out.println("""removeAt: [T](n: Int, xs: List[T])List[T]""");$skip(32); val res$2 = 
  
  removeAt(0, List(1,2,3,4));System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(29); val res$3 = 
  removeAt(1, List(1,2,3,4));System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(25); val res$4 = 
  removeAt(2, List(1,2));System.out.println("""res4: List[Int] = """ + $show(res$4));$skip(49); 
  
  def flatten(xs: List[Any]): List[Any] = ???;System.out.println("""flatten: (xs: List[Any])List[Any]""")}

// flatten(List(List(1, 1), 2, List(3, List(5, 8)))) res0: List[Any] = List(1, 1, 2, 3, 5, 8)
}
