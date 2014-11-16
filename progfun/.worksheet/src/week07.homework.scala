package week07

object homework {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(119); 
  
  val v1 = Vector(Vector('o','o','o'), Vector('S','o','-'), Vector('T', 'o', 'o'));System.out.println("""v1  : scala.collection.immutable.Vector[scala.collection.immutable.Vector[Char]] = """ + $show(v1 ));$skip(108); val res$0 = 
  
  for {
  	row <- v1
  	col <- row
  	if ('-' == col)
  } yield new Pos(v1 indexOf row, row indexOf col);System.out.println("""res0: scala.collection.immutable.Vector[Nothing] = """ + $show(res$0))}
}
