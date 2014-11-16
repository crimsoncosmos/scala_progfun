package week01

object session4 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def and(x: Boolean, y: => Boolean): Boolean = if (x) y else false
                                                  //> and: (x: Boolean, y: => Boolean)Boolean

  and(true, false)                                //> res0: Boolean = false
  and(false, true)                                //> res1: Boolean = false
  and(true, true)                                 //> res2: Boolean = true
  and(false, false)                               //> res3: Boolean = false

  def or(x: Boolean, y: => Boolean) = if (x) true else y
                                                  //> or: (x: Boolean, y: => Boolean)Boolean

  or(true, false)                                 //> res4: Boolean = true
  or(false, true)                                 //> res5: Boolean = true
  or(true, true)                                  //> res6: Boolean = true
  or(false, false)                                //> res7: Boolean = false
}