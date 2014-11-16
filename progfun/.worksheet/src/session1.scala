object session1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(121); 
  def sum(f: Int => Int, a: Int, b: Int): Int = {
    if (a > b) 0
    else f(a) + sum(f, a + 1, b)
  };System.out.println("""sum: (f: Int => Int, a: Int, b: Int)Int""");$skip(50); 
  
  def sumInts(a: Int, b: Int) = sum(id, a, b);System.out.println("""sumInts: (a: Int, b: Int)Int""");$skip(49); 
  def sumCubes(a: Int, b: Int) = sum(cube, a, b);System.out.println("""sumCubes: (a: Int, b: Int)Int""");$skip(54); 
  def sumFactorials(a: Int, b: Int) = sum(fact, a, b);System.out.println("""sumFactorials: (a: Int, b: Int)Int""");$skip(26); 
  def id(x: Int): Int = x;System.out.println("""id: (x: Int)Int""");$skip(36); 
  def cube(x: Int): Int = x * x * x;System.out.println("""cube: (x: Int)Int""");$skip(61); 
  def fact(x: Int): Int = if (x == 0) 1 else x * fact(x - 1);System.out.println("""fact: (x: Int)Int""");$skip(15); val res$0 = 
	sumInts(1, 4);System.out.println("""res0: Int = """ + $show(res$0));$skip(16); val res$1 = 
	sumCubes(1, 3);System.out.println("""res1: Int = """ + $show(res$1));$skip(21); val res$2 = 
	sumFactorials(1, 3);System.out.println("""res2: Int = """ + $show(res$2));$skip(60); 
	
	def sumIntsAnon(a: Int, b: Int): Int = sum(x => x, a, b);System.out.println("""sumIntsAnon: (a: Int, b: Int)Int""");$skip(67); 
	def sumCubesAnon(a: Int, b: Int): Int = sum(x => x * x * x, a, b);System.out.println("""sumCubesAnon: (a: Int, b: Int)Int""");$skip(21); val res$3 = 
	
	sumIntsAnon(1, 4);System.out.println("""res3: Int = """ + $show(res$3));$skip(20); val res$4 = 
	sumCubesAnon(1, 3);System.out.println("""res4: Int = """ + $show(res$4));$skip(173); 
	
	def sumTailRec(f: Int => Int, a: Int, b: Int) = {
		
		def loop(a: Int, count: Int): Int = {
			if (a > b) count
			else loop(a + 1, count + f(a))
		}
		
		loop(a, 0)
	};System.out.println("""sumTailRec: (f: Int => Int, a: Int, b: Int)Int""");$skip(28); val res$5 = 
	
	sumTailRec(x => x, 1, 4);System.out.println("""res5: Int = """ + $show(res$5))}
}
