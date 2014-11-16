package week02

object session5 {
  val x = new Rational(1, 3)                      //> x  : week02.Rational = 1/3
  x.numer                                         //> res0: Int = 1
  x.denom                                         //> res1: Int = 3
  
  val y = new Rational(5, 7)                      //> y  : week02.Rational = 5/7
  
  x.add(y)                                        //> res2: week02.Rational = 22/21
  x.neg                                           //> res3: week02.Rational = 1/-3
  y.neg                                           //> res4: week02.Rational = 5/-7
  y.sub(x)                                        //> res5: week02.Rational = 8/21
  
  val z = new Rational(3, 2)                      //> z  : week02.Rational = 3/2
  x.sub(y).sub(z)                                 //> res6: week02.Rational = -79/42
  y.add(y)                                        //> res7: week02.Rational = 10/7
  x.less(y)                                       //> res8: Boolean = true
  x.max(y)                                        //> res9: week02.Rational = 5/7
  
  val t = new Rational(3)                         //> t  : week02.Rational = 3/1
}

class Rational(x: Int, y: Int) {
	require(y != 0, "denominator must be nonzero")

	def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)
  //def numer = x / g
  //def denom = y / g
  def numer = x
  def denom = y
  
  def less(that: Rational) = numer * that.denom < that.numer * denom
  
  def max(that: Rational) = if (less(that)) that else this
  
  def add(that: Rational) =
  	new Rational(numer * that.denom + that.numer * denom, denom * that.denom)
  
  def neg = {
  	new Rational(-numer, denom)
	}
  
  def sub(that: Rational) = add(that.neg)
  
  override def toString = {
  	//val g = gcd(numer, denom)
  	numer / g + "/" + denom / g
	}
}