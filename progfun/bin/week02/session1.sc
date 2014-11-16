object session1 {
  def sum(f: Int => Int, a: Int, b: Int): Int = {
    if (a > b) 0
    else f(a) + sum(f, a + 1, b)
  }                                               //> sum: (f: Int => Int, a: Int, b: Int)Int
  
  def sumInts(a: Int, b: Int) = sum(id, a, b)     //> sumInts: (a: Int, b: Int)Int
  def sumCubes(a: Int, b: Int) = sum(cube, a, b)  //> sumCubes: (a: Int, b: Int)Int
  def sumFactorials(a: Int, b: Int) = sum(fact, a, b)
                                                  //> sumFactorials: (a: Int, b: Int)Int
  def id(x: Int): Int = x                         //> id: (x: Int)Int
  def cube(x: Int): Int = x * x * x               //> cube: (x: Int)Int
  def fact(x: Int): Int = if (x == 0) 1 else x * fact(x - 1)
                                                  //> fact: (x: Int)Int
	sumInts(1, 4)                             //> res0: Int = 10
	sumCubes(1, 3)                            //> res1: Int = 36
	sumFactorials(1, 3)                       //> res2: Int = 9
	
	def sumIntsAnon(a: Int, b: Int): Int = sum(x => x, a, b)
                                                  //> sumIntsAnon: (a: Int, b: Int)Int
	def sumCubesAnon(a: Int, b: Int): Int = sum(x => x * x * x, a, b)
                                                  //> sumCubesAnon: (a: Int, b: Int)Int
	
	sumIntsAnon(1, 4)                         //> res3: Int = 10
	sumCubesAnon(1, 3)                        //> res4: Int = 36
	
	def sumTailRec(f: Int => Int, a: Int, b: Int) = {
		
		def loop(a: Int, count: Int): Int = {
			if (a > b) count
			else loop(a + 1, count + f(a))
		}
		
		loop(a, 0)
	}                                         //> sumTailRec: (f: Int => Int, a: Int, b: Int)Int
	
	sumTailRec(x => x, 1, 4)                  //> res5: Int = 10
}