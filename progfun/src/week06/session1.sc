package week06

object session1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val xs = Array(1, 2, 3, 44)                     //> xs  : Array[Int] = Array(1, 2, 3, 44)
  xs map (x => x * 2)                             //> res0: Array[Int] = Array(2, 4, 6, 88)

  val st = "Hello World"                          //> st  : String = Hello World
  st filter (c => c.isUpper)                      //> res1: String = HW
  st exists (c => c.isUpper)                      //> res2: Boolean = true
  st forall (c => c.isUpper)                      //> res3: Boolean = false

  val pairs = List(1, 2, 3) zip st                //> pairs  : List[(Int, Char)] = List((1,H), (2,e), (3,l))
  pairs.unzip                                     //> res4: (List[Int], List[Char]) = (List(1, 2, 3),List(H, e, l))

  st flatMap (c => List('.', c))                  //> res5: String = .H.e.l.l.o. .W.o.r.l.d

  xs.sum                                          //> res6: Int = 50
  xs max                                          //> res7: Int = 44

  val r: Range = 1 until 5                        //> r  : Range = Range(1, 2, 3, 4)
  val s: Range = 1 to 5                           //> s  : Range = Range(1, 2, 3, 4, 5)
  1 to 10 by 3                                    //> res8: scala.collection.immutable.Range = Range(1, 4, 7, 10)
  6 to 1 by -2                                    //> res9: scala.collection.immutable.Range = Range(6, 4, 2)

  val M = 5                                       //> M  : Int = 5
  val N = 6                                       //> N  : Int = 6
  1 to M flatMap (x => (1 to N) map (y => (x, y)))//> res10: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,1), (1,
                                                  //| 2), (1,3), (1,4), (1,5), (1,6), (2,1), (2,2), (2,3), (2,4), (2,5), (2,6), (3
                                                  //| ,1), (3,2), (3,3), (3,4), (3,5), (3,6), (4,1), (4,2), (4,3), (4,4), (4,5), (
                                                  //| 4,6), (5,1), (5,2), (5,3), (5,4), (5,5), (5,6))

  def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
  //(xs zip ys) map (xy => xy._1 * xy._2) sum
  (xs zip ys) map {case (x, y) => x * y} sum      //> scalarProduct: (xs: Vector[Double], ys: Vector[Double])Double

  scalarProduct(Vector(1, 2), Vector(3, 4, 5))    //> res11: Double = 11.0
  
  def isPrime(n: Int): Boolean = (2 until n forall (x => n % x != 0))
                                                  //> isPrime: (n: Int)Boolean
  
  def isPrimeToo(n: Int): Boolean = ((2 until n) filter (x => n % x != 0)).length != 0
                                                  //> isPrimeToo: (n: Int)Boolean
                                                  
  isPrime(7)                                      //> res12: Boolean = true
  isPrimeToo(7)                                   //> res13: Boolean = true
}