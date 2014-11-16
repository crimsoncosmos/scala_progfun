package week04

abstract class Nat {
  def isZero: scala.Boolean
  def predecessor: Nat
  def successor: Nat
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}

object Zero extends Nat {
  def isZero: scala.Boolean = true
  def predecessor: Nat = throw new NoSuchElementException("predecessor for zero")
  def successor: Nat = new Succ(this)
  def + (that: Nat): Nat = that
  def - (that: Nat): Nat = if (that.isZero) Zero else throw new NoSuchElementException("minus for zero")
}

class Succ(n: Nat) extends Nat {
  def isZero: scala.Boolean = false
  def predecessor: Nat = n
  def successor: Nat = new Succ(this)
  def + (that: Nat): Nat = new Succ(n + that)
  def - (that: Nat): Nat = if (that.isZero) this else n - that.predecessor
}