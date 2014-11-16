package week06

object session2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
  println("Welcome to the Scala worksheet");$skip(66); 

  def isPrime(n: Int): Boolean = (2 until n forall (n % _ != 0));System.out.println("""isPrime: (n: Int)Boolean""");$skip(13); 

  val n = 7;System.out.println("""n  : Int = """ + $show(n ));$skip(103); val res$0 = 
  (1 until n) flatMap (i => (1 until i) map (j => (i, j))) filter (pair => isPrime(pair._1 + pair._2))

  //(xss foldRight Seq[Int]())(_ ++ _)
  //xs flatMap f = (xs map f).flatten

  case class Person(name: String, age: Int);System.out.println("""res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$0));$skip(316); val res$1 = 

  //for (p <- persons if p.age > 20) yield p.name
  //persons filter (p => p.age > 20) map (p => p.name)s

  for {
    i <- 1 until n
    j <- 1 until i
    if isPrime(i + j)
  } yield (i, j);System.out.println("""res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$1));$skip(127); 
  
  def scalarProduct(xs: List[Double], ys: List[Double]): Double = {
    (for ((i, j) <- (xs zip ys)) yield (i * j)).sum
  };System.out.println("""scalarProduct: (xs: List[Double], ys: List[Double])Double""");$skip(33); val res$2 = 
  
  List(1,2,3) zip List(4,5,6);System.out.println("""res2: List[(Int, Int)] = """ + $show(res$2));$skip(42); val res$3 = 
  scalarProduct(List(1,2,3), List(4,5,6));System.out.println("""res3: Double = """ + $show(res$3))}
}
