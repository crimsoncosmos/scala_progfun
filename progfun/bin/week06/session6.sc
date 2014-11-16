package week06

object session6 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  //val p1 = new Poly(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2))
  val p1 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2) //> p1  : week06.Poly = 6.2x^5 + 4.0x^3 + 2.0x^1
  //val p2 = new Poly(Map(0 -> 3.0, 3 -> 7.0))
  val p2 = new Poly(0 -> 3.0, 3 -> 7.0)           //> p2  : week06.Poly = 7.0x^3 + 3.0x^0

  println(p1 + p2)                                //> 6.2x^5 + 11.0x^3 + 2.0x^1 + 3.0x^0

  p1.terms(7)                                     //> res0: Double = 0.0
}