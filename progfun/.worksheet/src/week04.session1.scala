package week04

object session1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(78); 
  println("Welcome to the Scala worksheet")

  trait Function1[A, B] {
    def apply(x: A): B
  };$skip(77); val res$0 = 

  (x: Int) => x * x;System.out.println("""res0: Int => Int = """ + $show(res$0));$skip(112); val res$1 = 

  {
    class AnonFun extends Function1[Int, Int] {
      def apply(x: Int) = x * x
    }
    new AnonFun
  };System.out.println("""res1: AnonFun = """ + $show(res$1));$skip(84); val res$2 = 
  // is equivalent to
  new Function1[Int, Int] {
    def apply(x: Int) = x * x
  };System.out.println("""res2: week04.session1.Function1[Int,Int] = """ + $show(res$2));$skip(157); 
  // f.apply(a, b)
  // val f = (x: Int) = x * x
  // f(7)
  // the above expand as:

  val f = new Function1[Int, Int] {
    def apply(x: Int) = x * x
  };System.out.println("""f  : week04.session1.Function1[Int,Int] = """ + $show(f ));$skip(7); val res$3 = 
  f(7);System.out.println("""res3: Int = """ + $show(res$3));$skip(253); 

  // def f(x: Int): Boolean = ...
  // is not itself a function value
  // but if used where a function is expected
  // (x: Int) = f(x)
  // expands to

  // new Function1[Int, Boolean] {
  //  def apply(x: Int) = f(x)
  // }
	
	val l1 = List(1, 2);System.out.println("""l1  : week04.List[Int] = """ + $show(l1 ))}

}
