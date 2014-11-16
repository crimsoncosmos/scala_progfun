object w2session1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(113); 
  def sum(f: Int => Int, a: Int, b: Int): Int =
  if (a > b) 0
  else f(a) + sum(f, a + 1, b);System.out.println("""sum: (f: Int => Int, a: Int, b: Int)Int""");$skip(49); 
  
  def sumInts(a: Int, b: Int) = sum(id, a, b);System.out.println("""sumInts: (a: Int, b: Int)Int""");$skip(49); 
  def sumCubes(a: Int, b: Int) = sum(cube, a, b);System.out.println("""sumCubes: (a: Int, b: Int)Int""");$skip(54); 
  def sumFactorials(a: Int, b: Int) = sum(fact, a, b);System.out.println("""sumFactorials: (a: Int, b: Int)Int""");$skip(24); 
  
  def id(x: Int) = x;System.out.println("""id: (x: Int)Int""");$skip(31); 
  def cube(x: Int) = x * x * x;System.out.println("""cube: (x: Int)Int""");$skip(61); 
  def fact(x: Int): Int = if (x == 0) 1 else x * fact(x - 1);System.out.println("""fact: (x: Int)Int""")}
}
