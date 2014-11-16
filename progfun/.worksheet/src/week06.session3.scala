package week06

object session3 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
  println("Welcome to the Scala worksheet");$skip(45); 
  val fruit = Set("apple", "banana", "pear");System.out.println("""fruit  : scala.collection.immutable.Set[String] = """ + $show(fruit ));$skip(25); 
  val s = (1 to 6).toSet;System.out.println("""s  : scala.collection.immutable.Set[Int] = """ + $show(s ));$skip(17); val res$0 = 

  s map (_ + 2);System.out.println("""res0: scala.collection.immutable.Set[Int] = """ + $show(res$0));$skip(54); val res$1 = 
  //fruit filter (_.startsWith == "app")
  s.nonEmpty;System.out.println("""res1: Boolean = """ + $show(res$1));$skip(931); 

  def queens(n: Int): Set[List[Int]] = {
    def placeQueens(k: Int): Set[List[Int]] = {
      if (k == 0) Set(List())
      else
        for {
          queens <- placeQueens(k - 1)
          col <- 0 until n
          if isSafe(col, queens)
        } yield col :: queens
    }

    def isSafe(col: Int, queens: List[Int]): Boolean = {
      val row = queens.length
      val queensWithRow = (row - 1 to 0 by -1) zip queens
      queensWithRow forall {
        case (r, c) => col != c && math.abs(col - c) != row - r
      }
    }

    def isSafe1(col: Int, queens: List[Int]): Boolean = queens match {
      case List() => true
      case y :: ys =>
        if (col == y) { /*println(col + "=y" + queens); */ false }
        else if (col == y - 1) { /*println(col + "=y-1" + queens);*/ false }
        //else if (col == y + 1) { println(col + "=y+1" + queens); false }
        else isSafe(col, ys)
    }

    placeQueens(n)
  };System.out.println("""queens: (n: Int)Set[List[Int]]""");$skip(197); 

  def show(queens: List[Int]) = {
    val lines =
      for (col <- queens.reverse)
        yield Vector.fill(queens.length)("* ").updated(col, "X ").mkString
    "\n" + (lines mkString "\n")
  };System.out.println("""show: (queens: List[Int])String""");$skip(47); val res$2 = 
  
  (queens(8) take 3 map show) mkString "\n";System.out.println("""res2: String = """ + $show(res$2));$skip(32); val res$3 = 
  Vector(1,3,4,5) mkString "\n";System.out.println("""res3: String = """ + $show(res$3))}
}
