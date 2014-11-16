package week06

object session6 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(78); 
  println("Welcome to the Scala worksheet");$skip(107); 
  //val p1 = new Poly(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2))
  val p1 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2);System.out.println("""p1  : week06.Poly = """ + $show(p1 ));$skip(87); 
  //val p2 = new Poly(Map(0 -> 3.0, 3 -> 7.0))
  val p2 = new Poly(0 -> 3.0, 3 -> 7.0);System.out.println("""p2  : week06.Poly = """ + $show(p2 ));$skip(21); 

  println(p1 + p2);$skip(16); val res$0 = 

  p1.terms(7);System.out.println("""res0: Double = """ + $show(res$0))}
}
