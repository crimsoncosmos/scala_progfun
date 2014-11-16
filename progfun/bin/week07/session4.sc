package week07

object session4 {
  def from(n: Int): Stream[Int] = n #:: from(n + 1)
                                                  //> from: (n: Int)Stream[Int]
  val nats = from(0)                              //> nats  : Stream[Int] = Stream(0, ?)
  nats map (_ * 4)                                //> res0: scala.collection.immutable.Stream[Int] = Stream(0, ?)
  def sieve(s: Stream[Int]): Stream[Int] =
    s.head #:: sieve(s.tail filter (_ % s.head != 0))
                                                  //> sieve: (s: Stream[Int])Stream[Int]
  val primes = sieve(from(2))                     //> primes  : Stream[Int] = Stream(2, ?)
  (primes take 10).toList                         //> res1: List[Int] = List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)

  def sqrtStream(x: Double): Stream[Double] = {
    def improve(guess: Double) = (guess + x / guess) / 2
    lazy val guesses: Stream[Double] = 1 #:: (guesses map improve)
    guesses
  }                                               //> sqrtStream: (x: Double)Stream[Double]

  def isGoodEnough(guess: Double, x: Double) =
    math.abs((guess * guess - x) / x) < 0.0001    //> isGoodEnough: (guess: Double, x: Double)Boolean
  sqrtStream(4) filter (isGoodEnough(_, 4))       //> res2: scala.collection.immutable.Stream[Double] = Stream(2.0000000929222947,
                                                  //|  ?)
}