package week04

import java.util.NoSuchElementException

//trait List[T] {
trait List[+T] {
	def isEmpty: scala.Boolean
	def head: T
	def tail: List[T]
	def prepend[U >: T](elem: U): List[U] = new Cons(elem, this)
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
  // def head = head
  // def tail = tail
}

object Nil extends List[Nothing] {
//class Nil[T] extends List[T] {
  def isEmpty = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

object List {
  // List(1, 2) = List.apply(1, 2)
  def apply[T](x: T, y: T): List[T] = new Cons(x, new Cons(y, Nil))
  def apply[T](x: T): List[T] = new Cons(x, Nil)
  def apply = Nil
}

object test {
  val x: List[String] = Nil
}