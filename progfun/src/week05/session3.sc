package week05

import math.Ordering

object session3 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

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
  }                                               //> msort: [T](xs: List[T])(implicit ord: scala.math.Ordering[T])List[T]

  //msort(List(2, -4, 5, 7, 1))((x, y) => x <= y)
  //msort(List(2, -4, 5, 7, 1))(Ordering.Int)
  msort(List(2, -4, 5, 7, 1))                     //> res0: List[Int] = List(-4, 1, 2, 5, 7)
  val fruit = List("apple", "pear", "orange", "pineapple")
                                                  //> fruit  : List[String] = List(apple, pear, orange, pineapple)
  msort(fruit)                                    //> res1: List[String] = List(apple, orange, pear, pineapple)

}