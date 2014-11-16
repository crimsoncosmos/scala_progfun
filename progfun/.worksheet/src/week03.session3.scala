package week03
import week03._

object session3 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(109); 
  def singleton[T](elem: T) = new Cons[T](elem, new Nil[T]);System.out.println("""singleton: [T](elem: T)week03.Cons[T]""");$skip(18); val res$0 = 
  
  singleton(1);System.out.println("""res0: week03.Cons[Int] = """ + $show(res$0));$skip(27); val res$1 = 
  singleton[Boolean](true);System.out.println("""res1: week03.Cons[Boolean] = """ + $show(res$1));$skip(280); 
  
  def nth[T](index: Int, list: List[T]): T = {
  	//if (index < 0) throw new IndexOutOfBoundsException("index < 0")
  	/*else*/ if (list.isEmpty) throw new IndexOutOfBoundsException("index out of bounds")
  	else if (index == 0) list.head
  	else nth(index - 1, list.tail)
  };System.out.println("""nth: [T](index: Int, list: week03.List[T])T""");$skip(64); 
  
  def list1 = new Cons(1, new Cons(2, new Cons(3, new Nil)));System.out.println("""list1: => week03.Cons[Int]""");$skip(16); val res$2 = 
  nth(0, list1);System.out.println("""res2: Int = """ + $show(res$2));$skip(16); val res$3 = 
  nth(1, list1);System.out.println("""res3: Int = """ + $show(res$3));$skip(17); val res$4 = 
  nth(-3, list1);System.out.println("""res4: Int = """ + $show(res$4))}
}
