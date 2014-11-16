package week06

object session2 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def isPrime(n: Int): Boolean = (2 until n forall (n % _ != 0))
                                                  //> isPrime: (n: Int)Boolean

  val n = 7                                       //> n  : Int = 7
  (1 until n) flatMap (i => (1 until i) map (j => (i, j))) filter (pair => isPrime(pair._1 + pair._2))
                                                  //> res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))

  //(xss foldRight Seq[Int]())(_ ++ _)
  //xs flatMap f = (xs map f).flatten

  case class Person(name: String, age: Int)

  //for (p <- persons if p.age > 20) yield p.name
  //persons filter (p => p.age > 20) map (p => p.name)s

  for {
    i <- 1 until n
    j <- 1 until i
    if isPrime(i + j)
  } yield (i, j)                                  //> res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))
  
  def scalarProduct(xs: List[Double], ys: List[Double]): Double = {
    (for ((i, j) <- (xs zip ys)) yield (i * j)).sum
  }                                               //> scalarProduct: (xs: List[Double], ys: List[Double])Double
  
  List(1,2,3) zip List(4,5,6)                     //> res2: List[(Int, Int)] = List((1,4), (2,5), (3,6))
  scalarProduct(List(1,2,3), List(4,5,6))         //> res3: Double = 32.0
}