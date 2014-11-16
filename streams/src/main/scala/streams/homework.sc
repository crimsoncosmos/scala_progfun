package week07

object homework {

  val v1: Vector[Vector[Char]] = Vector(Vector('o', 'o', 'o'), Vector('S', 'o', '-'), Vector('T', 'o', 'o'))
                                                  //> v1  : Vector[Vector[Char]] = Vector(Vector(o, o, o), Vector(S, o, -), Vector
                                                  //| (T, o, o))

  /*def findChar(c: Char, levelVector: Vector[Vector[Char]]): Vector[Pos] = {
    val p = for {
      row <- levelVector
      col <- row
      if (col == c)
    } yield new Pos(levelVector indexOf row, row indexOf col)
    p(0)
	}
  findChar('-', v1)*/

	(for {
      row <- v1
      col <- row
      if (col == '-')
    } yield new Pos(v1 indexOf row, row indexOf col)).head
                                                  //> res0: week07.Pos = Pos(1,2)
    
}
case class Pos(x: Int, y: Int) {
  /** The position obtained by changing the `x` coordinate by `d` */
  def dx(d: Int) = copy(x = x + d)

  /** The position obtained by changing the `y` coordinate by `d` */
  def dy(d: Int) = copy(y = y + d)
}