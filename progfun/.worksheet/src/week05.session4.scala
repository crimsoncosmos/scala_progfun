package week05

object session4 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(78); 
  println("Welcome to the Scala worksheet");$skip(158); 

  def scaleList(xs: List[Double], factor: Double): List[Double] = xs match {
    case Nil => xs
    case y :: ys => y * factor :: scaleList(ys, factor)
  };System.out.println("""scaleList: (xs: List[Double], factor: Double)List[Double]""");$skip(86); 

  def scaleListMap(xs: List[Double], factor: Double) =
    xs map (x => x * factor);System.out.println("""scaleListMap: (xs: List[Double], factor: Double)List[Double]""");$skip(131); 

  def squareList(xs: List[Int]): List[Int] = xs match {
    case Nil => List()
    case y :: ys => (y * y) :: squareList(ys)
  };System.out.println("""squareList: (xs: List[Int])List[Int]""");$skip(72); 
  def squareListMap(xs: List[Int]): List[Int] =
    xs map (x => x * x);System.out.println("""squareListMap: (xs: List[Int])List[Int]""");$skip(33); 

  val l1 = List(1, 2, 3, 4, 5);System.out.println("""l1  : List[Int] = """ + $show(l1 ));$skip(17); val res$0 = 
  squareList(l1);System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(20); val res$1 = 
  squareListMap(l1);System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(146); 

  def posElems(xs: List[Int]): List[Int] = xs match {
    case Nil => xs
    case y :: ys => if (y > 0) y :: posElems(ys) else posElems(ys)
  };System.out.println("""posElems: (xs: List[Int])List[Int]""");$skip(75); 

  def posElemsMap(xs: List[Int]): List[Int] =
    xs filter (x => x > 0);System.out.println("""posElemsMap: (xs: List[Int])List[Int]""");$skip(36); 

  val nums = List(2, -4, 5, 7, 1);System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(27); val res$2 = 
  nums filter (x => x > 0);System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(30); val res$3 = 
  nums filterNot (x => x > 0);System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(30); val res$4 = 
  nums partition (x => x > 0);System.out.println("""res4: (List[Int], List[Int]) = """ + $show(res$4));$skip(32); val res$5 = 

  nums takeWhile (x => x > 0);System.out.println("""res5: List[Int] = """ + $show(res$5));$skip(30); val res$6 = 
  nums dropWhile (x => x > 0);System.out.println("""res6: List[Int] = """ + $show(res$6));$skip(25); val res$7 = 
  nums span (x => x > 0);System.out.println("""res7: (List[Int], List[Int]) = """ + $show(res$7));$skip(56); 

  val data = List("a", "a", "a", "b", "c", "c", "a");System.out.println("""data  : List[String] = """ + $show(data ));$skip(176); ;

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 =>
      val (first, rest) = xs span (y => y == x)
      first :: pack(rest)
  };System.out.println("""pack: [T](xs: List[T])List[List[T]]""");$skip(112); 

  def encode[T](xs: List[T]): List[(T, Int)] = {
    pack(xs) map ((ys: List[T]) => (ys.head, ys.length))
  };System.out.println("""encode: [T](xs: List[T])List[(T, Int)]""");$skip(18); val res$8 = 
  
  encode(data);System.out.println("""res8: List[(String, Int)] = """ + $show(res$8))}
}
