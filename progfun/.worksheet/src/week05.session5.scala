package week05

object session5 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
  println("Welcome to the Scala worksheet");$skip(127); 
  
  //def sum(xs: List[Int]) = (0 :: xs) reduceLeft ((x, y) => x + y)
  def sum(xs: List[Int]) = (0 :: xs) reduceLeft (_ + _);System.out.println("""sum: (xs: List[Int])Int""");$skip(55); 
  def sumFold(xs: List[Int]) = (xs foldLeft 0) (_ + _);System.out.println("""sumFold: (xs: List[Int])Int""");$skip(132); 
  //def product(xs: List[Int]) = (1 :: xs) reduceLeft ((x, y) => x * y)
  def product(xs: List[Int]) = (1 :: xs) reduceLeft (_ * _);System.out.println("""product: (xs: List[Int])Int""");$skip(58); 
  def productFold(xs: List[Int]) = (xs foldLeft 1)(_ * _);System.out.println("""productFold: (xs: List[Int])Int""");$skip(26); 
	val l1 = List(1,2,3,4,5);System.out.println("""l1  : List[Int] = """ + $show(l1 ));$skip(11); val res$0 = 
	
	sum(l1);System.out.println("""res0: Int = """ + $show(res$0));$skip(13); val res$1 = 
	sumFold(l1);System.out.println("""res1: Int = """ + $show(res$1));$skip(13); val res$2 = 
	product(l1);System.out.println("""res2: Int = """ + $show(res$2));$skip(17); val res$3 = 
	productFold(l1);System.out.println("""res3: Int = """ + $show(res$3));$skip(85); 
	
	def concat[T](xs: List[T], ys: List[T]): List[T] =
    (xs foldRight ys) (_ :: _);System.out.println("""concat: [T](xs: List[T], ys: List[T])List[T]""");$skip(126); val res$4 = 
 
  //def concatLeft[T](xs: List[T], ys: List[T]): List[T] =
  //	(xs foldLeft ys)(_ :: _)
 	
 	concat(l1, List('a','b','c'));System.out.println("""res4: List[AnyVal] = """ + $show(res$4));$skip(93); 
 	
 	def mapFun[T, U](xs: List[T], f: T => U): List[U] =
    (xs foldRight List[U]())( ??? );System.out.println("""mapFun: [T, U](xs: List[T], f: T => U)List[U]""");$skip(68); 

  def lengthFun[T](xs: List[T]): Int =
    (xs foldRight 0)( ??? );System.out.println("""lengthFun: [T](xs: List[T])Int""")}
  
}
