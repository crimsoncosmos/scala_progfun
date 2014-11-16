package week03
import week03._

object session3 {
  def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])
                                                  //> singleton: [T](elem: T)week03.Cons[T]
  
  singleton(1)                                    //> res0: week03.Cons[Int] = week03.Cons@1b3bae89
  singleton[Boolean](true)                        //> res1: week03.Cons[Boolean] = week03.Cons@6b3fb256
  
  def nth[T](index: Int, list: List[T]): T = {
  	//if (index < 0) throw new IndexOutOfBoundsException("index < 0")
  	/*else*/ if (list.isEmpty) throw new IndexOutOfBoundsException("index out of bounds")
  	else if (index == 0) list.head
  	else nth(index - 1, list.tail)
  }                                               //> nth: [T](index: Int, list: week03.List[T])T
  
  def list1 = new Cons(1, new Cons(2, new Cons(3, new Nil)))
                                                  //> list1: => week03.Cons[Int]
  nth(0, list1)                                   //> res2: Int = 1
  nth(1, list1)                                   //> res3: Int = 2
  nth(-3, list1)                                  //> java.lang.IndexOutOfBoundsException: index out of bounds
                                                  //| 	at week03.session3$$anonfun$main$1.nth$1(week03.session3.scala:12)
                                                  //| 	at week03.session3$$anonfun$main$1.apply$mcV$sp(week03.session3.scala:20
                                                  //| )
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at week03.session3$.main(week03.session3.scala:4)
                                                  //| 	at week03.session3.main(week03.session3.scala)
}