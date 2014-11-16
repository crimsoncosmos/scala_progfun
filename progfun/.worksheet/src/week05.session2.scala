package week05

object session2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(78); 
  println("Welcome to the Scala worksheet");$skip(165); 

	def msort(xs: List[Int]): List[Int] = {
		val n = xs.length / 2
		if (n == 0) xs
		else {
			val (fst, snd) = xs splitAt n
			merge(msort(fst), msort(snd))
		}
	};System.out.println("""msort: (xs: List[Int])List[Int]""");$skip(230); 

  def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
    case (xs, Nil) => xs
    case (Nil, ys) => ys
    case (x :: xs1, y :: ys1) =>
      if (x <= y) x :: merge(xs1, ys)
      else y :: merge(xs, ys1)
  };System.out.println("""merge: (xs: List[Int], ys: List[Int])List[Int]""");$skip(38); val res$0 = 
  
  merge(List(1,3,5), List(2,4,6));System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(30); val res$1 = 
  msort(List(2, -4, 5, 7, 1));System.out.println("""res1: List[Int] = """ + $show(res$1))}
}
