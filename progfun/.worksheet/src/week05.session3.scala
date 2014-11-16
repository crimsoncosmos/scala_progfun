package week05

import math.Ordering

object session3 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(100); 
  println("Welcome to the Scala worksheet");$skip(622); 

  //def msort[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
  def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
    val n = xs.length / 2
    if (n == 0) xs
    else {
      def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
        case (xs, Nil) => xs
        case (Nil, ys) => ys
        case (x :: xs1, y :: ys1) =>
          //if (lt(x, y)) x :: merge(xs1, ys)
          if (ord.lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
      val (fst, snd) = xs splitAt n
      //merge(msort(fst)(lt), msort(snd)(lt))
      merge(msort(fst), msort(snd))
    }
  };System.out.println("""msort: [T](xs: List[T])(implicit ord: scala.math.Ordering[T])List[T]""");$skip(128); val res$0 = 

  //msort(List(2, -4, 5, 7, 1))((x, y) => x <= y)
  //msort(List(2, -4, 5, 7, 1))(Ordering.Int)
  msort(List(2, -4, 5, 7, 1));System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(59); 
  val fruit = List("apple", "pear", "orange", "pineapple");System.out.println("""fruit  : List[String] = """ + $show(fruit ));$skip(15); val res$1 = 
  msort(fruit);System.out.println("""res1: List[String] = """ + $show(res$1))}

}
