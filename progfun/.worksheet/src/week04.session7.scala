package week04

object session7 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
  println("Welcome to the Scala worksheet");$skip(44); 
  
  val test = scala.List(1,3,5,7,2,6,8,0);System.out.println("""test  : List[Int] = """ + $show(test ));$skip(147); 
  
  def isort(xs: scala.List[Int]): scala.List[Int] = xs match {
  	case scala.List() => scala.List()
  	case y :: ys => insert(y, isort(ys))
  };System.out.println("""isort: (xs: List[Int])List[Int]""");$skip(180); 
  
  def insert(x: Int, xs: scala.List[Int]): scala.List[Int] = xs match {
  	case scala.List() => scala.List(x)
  	case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
  };System.out.println("""insert: (x: Int, xs: List[Int])List[Int]""");$skip(17); val res$0 = 
  
  isort(test);System.out.println("""res0: List[Int] = """ + $show(res$0))}
}
