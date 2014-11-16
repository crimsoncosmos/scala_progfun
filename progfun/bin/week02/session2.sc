package week02

object session2 {
  def sum(f: Int => Int): (Int, Int) => Int = {
  	def sumF(a: Int, b: Int): Int = {
  		if (a > b) 0
  		else f(a) + sumF(a + 1, b)
  	}
  	sumF
  }                                               //> sum: (f: Int => Int)(Int, Int) => Int
  
  def sumInts = sum(x => x)                       //> sumInts: => (Int, Int) => Int
  def sumCubes = sum(x => x * x * x)              //> sumCubes: => (Int, Int) => Int
  
  sumInts(1, 4)                                   //> res0: Int = 10
  sumCubes(1, 3)                                  //> res1: Int = 36
  
  def cube(x: Int) = x * x * x                    //> cube: (x: Int)Int
  sum(cube)(1, 3)                                 //> res2: Int = 36
  
  def sumCurry(f: Int => Int)(a: Int, b: Int): Int = {
  	if (a > b) 0
  	else f(a) + sumCurry(f)(a + 1, b)
  }                                               //> sumCurry: (f: Int => Int)(a: Int, b: Int)Int
  
  sumCurry(cube)_                                 //> res3: (Int, Int) => Int = <function2>
  
  def product(f: Int => Int)(a: Int, b: Int): Int = {
  	if (a > b) 1
  	else f(a) * product(f)(a + 1, b)
  }                                               //> product: (f: Int => Int)(a: Int, b: Int)Int
  
  product(x => x)(1, 4)                           //> res4: Int = 24
  
  def fact(n: Int) = product(x => x)(1, n)        //> fact: (n: Int)Int
  
  fact(4)                                         //> res5: Int = 24
  
  def math(f: Int => Int, op: (Int, Int) => Int, id: Int)(a: Int, b: Int): Int = {
  	if (a > b) id
  	else op(f(a), math(f, op, id)(a + 1, b))
  }                                               //> math: (f: Int => Int, op: (Int, Int) => Int, id: Int)(a: Int, b: Int)Int
  
  math(x => x, (x, y) => x + y, 0)(1, 4)          //> res6: Int = 10
  math(x => x, (x, y) => x * y, 1)(1, 4)          //> res7: Int = 24
}