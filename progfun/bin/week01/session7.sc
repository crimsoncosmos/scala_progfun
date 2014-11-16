package week01

object session7 {

  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)              //> gcd: (a: Int, b: Int)Int

  gcd(32, 28)                                     //> res0: Int = 4

  def factorial(n: Int): Int =
    if (n == 0) 1 else n * factorial(n - 1)       //> factorial: (n: Int)Int

  factorial(5)                                    //> res1: Int = 120

  def tailrecFactorial(n: Int): Int = {

    def op(n: Int, acc: Int): Int = {
      if (n == 0) acc
      else op(n - 1, n * acc)
    }

    op(n, 1)
  }                                               //> tailrecFactorial: (n: Int)Int
  
  tailrecFactorial(5)                             //> res2: Int = 120
}