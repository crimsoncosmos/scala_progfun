package week02

object session6 {
  val x = new Rational(1, 3)                      //> x  : week02.Rational = 1/3
  x.numer                                         //> res0: Int = 1
  x.denom                                         //> res1: Int = 3

  val y = new Rational(5, 7)                      //> y  : week02.Rational = 5/7

  x + y                                           //> res2: week02.Rational = 22/21
  -x                                              //> res3: week02.Rational = 1/-3
  -y                                              //> res4: week02.Rational = 5/-7
  y - x                                           //> res5: week02.Rational = 8/21

  val z = new Rational(3, 2)                      //> z  : week02.Rational = 3/2
  x - y - z                                       //> res6: week02.Rational = -79/42
  y + y                                           //> res7: week02.Rational = 10/7
  x < y                                           //> res8: Boolean = true
  x max y                                         //> res9: week02.Rational = 5/7

  val t = new Rational(3)                         //> t  : week02.Rational = 3/1
}

class Rational(x: Int, y: Int) {
  require(y != 0, "denominator must be nonzero")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)
  def numer = x
  def denom = y

  def < (that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (this < that) that else this

  def +(that: Rational) =
    new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

  def unary_- = new Rational(-numer, denom)

  def -(that: Rational) = this + -that

  override def toString = {
    numer / g + "/" + denom / g
  }
  
  def a = 1
  def b = 2
  def c = 3
  def d = 4
  def ^?(x: Int, y: Int) = x + y
}