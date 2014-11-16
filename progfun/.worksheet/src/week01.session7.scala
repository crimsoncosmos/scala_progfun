package week01

object session7 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(106); 

  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b);System.out.println("""gcd: (a: Int, b: Int)Int""");$skip(16); val res$0 = 

  gcd(32, 28);System.out.println("""res0: Int = """ + $show(res$0));$skip(77); 

  def factorial(n: Int): Int =
    if (n == 0) 1 else n * factorial(n - 1);System.out.println("""factorial: (n: Int)Int""");$skip(17); val res$1 = 

  factorial(5);System.out.println("""res1: Int = """ + $show(res$1));$skip(159); 

  def tailrecFactorial(n: Int): Int = {

    def op(n: Int, acc: Int): Int = {
      if (n == 0) acc
      else op(n - 1, n * acc)
    }

    op(n, 1)
  };System.out.println("""tailrecFactorial: (n: Int)Int""");$skip(25); val res$2 = 
  
  tailrecFactorial(5);System.out.println("""res2: Int = """ + $show(res$2))}
}
