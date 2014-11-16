package week06

object session1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(78); 
  println("Welcome to the Scala worksheet");$skip(30); 
  val xs = Array(1, 2, 3, 44);System.out.println("""xs  : Array[Int] = """ + $show(xs ));$skip(22); val res$0 = 
  xs map (x => x * 2);System.out.println("""res0: Array[Int] = """ + $show(res$0));$skip(27); 

  val st = "Hello World";System.out.println("""st  : String = """ + $show(st ));$skip(29); val res$1 = 
  st filter (c => c.isUpper);System.out.println("""res1: String = """ + $show(res$1));$skip(29); val res$2 = 
  st exists (c => c.isUpper);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(29); val res$3 = 
  st forall (c => c.isUpper);System.out.println("""res3: Boolean = """ + $show(res$3));$skip(37); 

  val pairs = List(1, 2, 3) zip st;System.out.println("""pairs  : List[(Int, Char)] = """ + $show(pairs ));$skip(14); val res$4 = 
  pairs.unzip;System.out.println("""res4: (List[Int], List[Char]) = """ + $show(res$4));$skip(35); val res$5 = 

  st flatMap (c => List('.', c));System.out.println("""res5: String = """ + $show(res$5));$skip(11); val res$6 = 

  xs.sum;System.out.println("""res6: Int = """ + $show(res$6));$skip(9); val res$7 = 
  xs max;System.out.println("""res7: Int = """ + $show(res$7));$skip(29); 

  val r: Range = 1 until 5;System.out.println("""r  : Range = """ + $show(r ));$skip(24); 
  val s: Range = 1 to 5;System.out.println("""s  : Range = """ + $show(s ));$skip(15); val res$8 = 
  1 to 10 by 3;System.out.println("""res8: scala.collection.immutable.Range = """ + $show(res$8));$skip(15); val res$9 = 
  6 to 1 by -2;System.out.println("""res9: scala.collection.immutable.Range = """ + $show(res$9));$skip(14); 

  val M = 5;System.out.println("""M  : Int = """ + $show(M ));$skip(12); 
  val N = 6;System.out.println("""N  : Int = """ + $show(N ));$skip(51); val res$10 = 
  1 to M flatMap (x => (1 to N) map (y => (x, y)));System.out.println("""res10: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$10));$skip(163); 

  def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double =
  //(xs zip ys) map (xy => xy._1 * xy._2) sum
  (xs zip ys) map {case (x, y) => x * y} sum;System.out.println("""scalarProduct: (xs: Vector[Double], ys: Vector[Double])Double""");$skip(49); val res$11 = 

  scalarProduct(Vector(1, 2), Vector(3, 4, 5));System.out.println("""res11: Double = """ + $show(res$11));$skip(73); 
  
  def isPrime(n: Int): Boolean = (2 until n forall (x => n % x != 0));System.out.println("""isPrime: (n: Int)Boolean""");$skip(90); 
  
  def isPrimeToo(n: Int): Boolean = ((2 until n) filter (x => n % x != 0)).length != 0;System.out.println("""isPrimeToo: (n: Int)Boolean""");$skip(64); val res$12 = 
                                                  
  isPrime(7);System.out.println("""res12: Boolean = """ + $show(res$12));$skip(16); val res$13 = 
  isPrimeToo(7);System.out.println("""res13: Boolean = """ + $show(res$13))}
}
