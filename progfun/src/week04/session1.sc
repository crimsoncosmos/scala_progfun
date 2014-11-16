package week04

object session1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  trait Function1[A, B] {
    def apply(x: A): B
  }

  (x: Int) => x * x                               //> res0: Int => Int = <function1>

  {
    class AnonFun extends Function1[Int, Int] {
      def apply(x: Int) = x * x
    }
    new AnonFun
  }                                               //> res1: AnonFun = week04.session1$$anonfun$main$1$AnonFun$1@5763d118
  // is equivalent to
  new Function1[Int, Int] {
    def apply(x: Int) = x * x
  }                                               //> res2: week04.session1.Function1[Int,Int] = week04.session1$$anonfun$main$1$$
                                                  //| anon$1@37e604da
  // f.apply(a, b)
  // val f = (x: Int) = x * x
  // f(7)
  // the above expand as:

  val f = new Function1[Int, Int] {
    def apply(x: Int) = x * x
  }                                               //> f  : week04.session1.Function1[Int,Int] = week04.session1$$anonfun$main$1$$a
                                                  //| non$2@723a4422
  f(7)                                            //> res3: Int = 49

  // def f(x: Int): Boolean = ...
  // is not itself a function value
  // but if used where a function is expected
  // (x: Int) = f(x)
  // expands to

  // new Function1[Int, Boolean] {
  //  def apply(x: Int) = f(x)
  // }
	
	val l1 = List(1, 2)                       //> l1  : week04.List[Int] = week04.Cons@7a93069b

}