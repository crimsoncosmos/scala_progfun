package week05

object session2 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

	def msort(xs: List[Int]): List[Int] = {
		val n = xs.length / 2
		if (n == 0) xs
		else {
			val (fst, snd) = xs splitAt n
			merge(msort(fst), msort(snd))
		}
	}                                         //> msort: (xs: List[Int])List[Int]

  def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
    case (xs, Nil) => xs
    case (Nil, ys) => ys
    case (x :: xs1, y :: ys1) =>
      if (x <= y) x :: merge(xs1, ys)
      else y :: merge(xs, ys1)
  }                                               //> merge: (xs: List[Int], ys: List[Int])List[Int]
  
  merge(List(1,3,5), List(2,4,6))                 //> res0: List[Int] = List(1, 2, 3, 4, 5, 6)
  msort(List(2, -4, 5, 7, 1))                     //> res1: List[Int] = List(-4, 1, 2, 5, 7)
}