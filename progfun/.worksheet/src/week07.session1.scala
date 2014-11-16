package week07

object session1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(72); 

  def isPrime(x: Int): Boolean = true;System.out.println("""isPrime: (x: Int)Boolean""");$skip(39); val res$0 = 

  ((1000 to 10000) filter isPrime)(1);System.out.println("""res0: Int = """ + $show(res$0));$skip(63); 

  def secondPrime(from: Int, to: Int) = nthPrime(from, to, 2);System.out.println("""secondPrime: (from: Int, to: Int)Int""");$skip(219); 
  def nthPrime(from: Int, to: Int, n: Int): Int =
    if (from >= to) throw new Error("no prime")
    else if (isPrime(from))
      if (n == 1) from else nthPrime(from + 1, to, n - 1)
    else nthPrime(from + 1, to, n);System.out.println("""nthPrime: (from: Int, to: Int, n: Int)Int""");$skip(57); 

  val xs = Stream.cons(1, Stream.cons(2, Stream.empty));System.out.println("""xs  : Stream.Cons[Int] = """ + $show(xs ));$skip(18); val res$1 = 
  Stream(1, 2, 3);System.out.println("""res1: scala.collection.immutable.Stream[Int] = """ + $show(res$1));$skip(24); val res$2 = 

  (1 to 1000).toStream;System.out.println("""res2: scala.collection.immutable.Stream[Int] = """ + $show(res$2));$skip(133); 

  def streamRange(lo: Int, hi: Int): Stream[Int] =
    if (lo >= hi) Stream.empty
    else Stream.cons(lo, streamRange(lo + 1, hi));System.out.println("""streamRange: (lo: Int, hi: Int)Stream[Int]""");$skip(107); 

  def listRange(lo: Int, hi: Int): List[Int] =
    if (lo >= hi) Nil
    else lo :: listRange(lo + 1, hi);System.out.println("""listRange: (lo: Int, hi: Int)List[Int]""");$skip(28); val res$3 = 
    
   4 #:: Stream(1,2,3);System.out.println("""res3: scala.collection.immutable.Stream[Int] = """ + $show(res$3))}
}
