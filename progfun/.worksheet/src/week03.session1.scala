package week03

object session1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
  println("Welcome to the Scala worksheet");$skip(41); 
  val t1 = new NonEmpty(3, Empty, Empty);System.out.println("""t1  : week03.NonEmpty = """ + $show(t1 ));$skip(21); 
  val t2 = t1 incl 4;System.out.println("""t2  : week03.IntSet = """ + $show(t2 ));$skip(54); 
  
  val t3 = t1.union(new NonEmpty(2, Empty, Empty));System.out.println("""t3  : week03.IntSet = """ + $show(t3 ));$skip(51); 
  val t4 = t3.union(new NonEmpty(5, Empty, Empty));System.out.println("""t4  : week03.IntSet = """ + $show(t4 ))}
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
