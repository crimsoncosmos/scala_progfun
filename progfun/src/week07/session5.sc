package week07

object session5 {
  val problem = new Pouring(Vector(4,9))          //> problem  : week07.Pouring = week07.Pouring@622b104
  problem.moves                                   //> res0: scala.collection.immutable.IndexedSeq[Product with Serializable with we
                                                  //| ek07.session5.problem.Move] = Vector(Empty(0), Empty(1), Fill(0), Fill(1), Po
                                                  //| ur(0,1), Pour(1,0))
  
  problem.pathSets.take(3).toList                 //> res1: List[Set[week07.session5.problem.Path]] = List(Set(--> Vector(0, 0)), 
                                                  //| Set(Fill(0)--> Vector(4, 0), Fill(1)--> Vector(0, 9)), Set(Fill(0) Fill(1)--
                                                  //| > Vector(4, 9), Fill(0) Pour(0,1)--> Vector(0, 4), Fill(1) Fill(0)--> Vector
                                                  //| (4, 9), Fill(1) Pour(1,0)--> Vector(4, 5)))
	problem.solution(6)                       //> res2: Stream[week07.session5.problem.Path] = Stream(Fill(1) Pour(1,0) Empty(
                                                  //| 0) Pour(1,0) Empty(0) Pour(1,0) Fill(1) Pour(1,0)--> Vector(4, 6), ?)
}