package week05

object session4 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def scaleList(xs: List[Double], factor: Double): List[Double] = xs match {
    case Nil => xs
    case y :: ys => y * factor :: scaleList(ys, factor)
  }                                               //> scaleList: (xs: List[Double], factor: Double)List[Double]

  def scaleListMap(xs: List[Double], factor: Double) =
    xs map (x => x * factor)                      //> scaleListMap: (xs: List[Double], factor: Double)List[Double]

  def squareList(xs: List[Int]): List[Int] = xs match {
    case Nil => List()
    case y :: ys => (y * y) :: squareList(ys)
  }                                               //> squareList: (xs: List[Int])List[Int]
  def squareListMap(xs: List[Int]): List[Int] =
    xs map (x => x * x)                           //> squareListMap: (xs: List[Int])List[Int]

  val l1 = List(1, 2, 3, 4, 5)                    //> l1  : List[Int] = List(1, 2, 3, 4, 5)
  squareList(l1)                                  //> res0: List[Int] = List(1, 4, 9, 16, 25)
  squareListMap(l1)                               //> res1: List[Int] = List(1, 4, 9, 16, 25)

  def posElems(xs: List[Int]): List[Int] = xs match {
    case Nil => xs
    case y :: ys => if (y > 0) y :: posElems(ys) else posElems(ys)
  }                                               //> posElems: (xs: List[Int])List[Int]

  def posElemsMap(xs: List[Int]): List[Int] =
    xs filter (x => x > 0)                        //> posElemsMap: (xs: List[Int])List[Int]

  val nums = List(2, -4, 5, 7, 1)                 //> nums  : List[Int] = List(2, -4, 5, 7, 1)
  nums filter (x => x > 0)                        //> res2: List[Int] = List(2, 5, 7, 1)
  nums filterNot (x => x > 0)                     //> res3: List[Int] = List(-4)
  nums partition (x => x > 0)                     //> res4: (List[Int], List[Int]) = (List(2, 5, 7, 1),List(-4))

  nums takeWhile (x => x > 0)                     //> res5: List[Int] = List(2)
  nums dropWhile (x => x > 0)                     //> res6: List[Int] = List(-4, 5, 7, 1)
  nums span (x => x > 0)                          //> res7: (List[Int], List[Int]) = (List(2),List(-4, 5, 7, 1))

  val data = List("a", "a", "a", "b", "c", "c", "a");
                                                  //> data  : List[String] = List(a, a, a, b, c, c, a)

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 =>
      val (first, rest) = xs span (y => y == x)
      first :: pack(rest)
  }                                               //> pack: [T](xs: List[T])List[List[T]]

  def encode[T](xs: List[T]): List[(T, Int)] = {
    pack(xs) map ((ys: List[T]) => (ys.head, ys.length))
  }                                               //> encode: [T](xs: List[T])List[(T, Int)]
  
  encode(data)                                    //> res8: List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1))
}