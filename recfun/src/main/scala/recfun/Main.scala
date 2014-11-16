package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || r == 0 || c == r) 1
    else pascal(c, r - 1) + pascal(c - 1, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def op(chars: List[Char], open: Int): Boolean = {
      if (chars.isEmpty || open < 0) open == 0
      else if (chars.head == '(') op(chars.tail, open + 1)
      else if (chars.head == ')') op(chars.tail, open - 1)
      else op(chars.tail, open)
    }

    op(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def loop(money: Int, coins: List[Int], counter: Int): Int = {
      if (!coins.isEmpty) {
        if (money - coins.head > 0) {
          loop(money, coins.tail, loop(money - coins.head, coins, counter))
        }
        else if (money - coins.head == 0) {
          loop(money, coins.tail, counter + 1)
        }
        else {
          loop(money, coins.tail, counter)
        }
      }
      else counter
    }
    
    loop(money, coins, 0)
  }
}
