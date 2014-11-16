package week02

object session2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(183); 
  def sum(f: Int => Int): (Int, Int) => Int = {
  	def sumF(a: Int, b: Int): Int = {
  		if (a > b) 0
  		else f(a) + sumF(a + 1, b)
  	}
  	sumF
  };System.out.println("""sum: (f: Int => Int)(Int, Int) => Int""");$skip(31); 
  
  def sumInts = sum(x => x);System.out.println("""sumInts: => (Int, Int) => Int""");$skip(37); 
  def sumCubes = sum(x => x * x * x);System.out.println("""sumCubes: => (Int, Int) => Int""");$skip(19); val res$0 = 
  
  sumInts(1, 4);System.out.println("""res0: Int = """ + $show(res$0));$skip(17); val res$1 = 
  sumCubes(1, 3);System.out.println("""res1: Int = """ + $show(res$1));$skip(34); 
  
  def cube(x: Int) = x * x * x;System.out.println("""cube: (x: Int)Int""");$skip(18); val res$2 = 
  sum(cube)(1, 3);System.out.println("""res2: Int = """ + $show(res$2));$skip(115); 
  
  def sumCurry(f: Int => Int)(a: Int, b: Int): Int = {
  	if (a > b) 0
  	else f(a) + sumCurry(f)(a + 1, b)
  };System.out.println("""sumCurry: (f: Int => Int)(a: Int, b: Int)Int""");$skip(21); val res$3 = 
  
  sumCurry(cube)_;System.out.println("""res3: (Int, Int) => Int = """ + $show(res$3));$skip(113); 
  
  def product(f: Int => Int)(a: Int, b: Int): Int = {
  	if (a > b) 1
  	else f(a) * product(f)(a + 1, b)
  };System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(27); val res$4 = 
  
  product(x => x)(1, 4);System.out.println("""res4: Int = """ + $show(res$4));$skip(46); 
  
  def fact(n: Int) = product(x => x)(1, n);System.out.println("""fact: (n: Int)Int""");$skip(13); val res$5 = 
  
  fact(4);System.out.println("""res5: Int = """ + $show(res$5));$skip(151); 
  
  def math(f: Int => Int, op: (Int, Int) => Int, id: Int)(a: Int, b: Int): Int = {
  	if (a > b) id
  	else op(f(a), math(f, op, id)(a + 1, b))
  };System.out.println("""math: (f: Int => Int, op: (Int, Int) => Int, id: Int)(a: Int, b: Int)Int""");$skip(44); val res$6 = 
  
  math(x => x, (x, y) => x + y, 0)(1, 4);System.out.println("""res6: Int = """ + $show(res$6));$skip(41); val res$7 = 
  math(x => x, (x, y) => x * y, 1)(1, 4);System.out.println("""res7: Int = """ + $show(res$7))}
}
