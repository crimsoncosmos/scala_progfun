package week03

object session1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val t1 = new NonEmpty(3, Empty, Empty)          //> t1  : week03.NonEmpty = {.3.}
  val t2 = t1 incl 4                              //> t2  : week03.IntSet = {.3{.4.}}
  
  val t3 = t1.union(new NonEmpty(2, Empty, Empty))//> t3  : week03.IntSet = {.2{.3.}}
  val t4 = t3.union(new NonEmpty(5, Empty, Empty))//> t4  : week03.IntSet = {{{.2.}3.}5.}
}

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

/*
class Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
  override def toString = "."
}
*/

object Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
  def union(other: IntSet): IntSet = other
  override def toString = "."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean = {
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  }
  def incl(x: Int): IntSet = {
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
  }
  def union(other: IntSet): IntSet = {
  	if (this == Empty) other
  	else {
  		//left.union(right.union(other.incl(elem)))
  		((left union right) union other) incl elem
  	}
  }
  override def toString = "{" + left + elem + right + "}"
}