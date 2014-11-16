package week06

class Poly(val terms0: Map[Int, Double]) {
  def this(bindings: (Int, Double)*) = this(bindings.toMap)
  val terms = terms0 withDefaultValue 0.0
//  def +(other: Poly) = new Poly(terms ++ (other.terms map adjust))
//  def adjust(term: (Int, Double)): (Int, Double) = {
//    val (exp, coeff) = term
//    exp -> (coeff + terms(exp))
/*    
 *    can be simplifed because we have a default value in the map
 *    terms get exp match {
      case Some(coeff1) => exp -> (coeff + coeff1)
      case None => exp -> coeff
    }
 */
//  }  
  def addTerm(terms: Map[Int, Double], term: (Int, Double)) = {
    val (exp, coeff) = term
    //terms updated(exp, coeff + terms(exp))
    terms + (exp -> (coeff + terms(exp)))
  }  
  
  def + (other: Poly) = new Poly((other.terms foldLeft terms)(addTerm))
    
  override def toString = (for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^" + exp) mkString " + "
}

object Main {
  def main(args: Array[String]) = {
    val p1 = new Poly(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2))
    val p2 = new Poly(Map(0 -> 3.0, 3 -> 7.0))

    println(p1 + p2)
  }
}