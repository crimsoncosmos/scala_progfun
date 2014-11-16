package week06

object session4 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
  println("Welcome to the Scala worksheet")
  case class Book(title: String, authors: List[String]);$skip(616); 
  val books: List[Book] = List(
    Book(title = "Structure and Interpretation of Computer Programs",
      authors = List("Abelson, Harald", "Sussman, Gerald J.")),
    Book(title = "Introduction to Functional Programming",
      authors = List("Bird, Richard", "Wadler, Phil")),
    Book(title = "Effective Java",
      authors = List("Bloch, Joshua")),
    Book(title = "Java Puzzlers",
      authors = List("Bloch, Joshua", "Gafter, Neal")),
    Book(title = "Programming in Scala",
      authors = List("Odersky, Martin", "Spoon, Lex", "Venners, Bill")));System.out.println("""books  : List[week06.session4.Book] = """ + $show(books ));$skip(78); val res$0 = 

  for (b <- books; a <- b.authors if a startsWith "Bird,")
    yield b.title;System.out.println("""res0: List[String] = """ + $show(res$0));$skip(213); val res$1 = 
  //for (b <- books if b.title indexOf "Program" >= 0)
  //  yield b.title
  for {
    b1 <- books
    b2 <- books
    if b1.title < b2.title
    a1 <- b1.authors
    a2 <- b2.authors
    if a1 == a2
  } yield a1

  {;System.out.println("""res1: List[String] = """ + $show(res$1));$skip(172); val res$2 = 
    for {
      b1 <- books
      b2 <- books
      if b1.title < b2.title
      a1 <- b1.authors
      a2 <- b2.authors
      if a1 == a2
    } yield a1
  }.distinct;System.out.println("""res2: List[String] = """ + $show(res$2));$skip(29); 

  val bookSet = books.toSet;System.out.println("""bookSet  : scala.collection.immutable.Set[week06.session4.Book] = """ + $show(bookSet ));$skip(131); val res$3 = 
  for {
    b1 <- bookSet
    b2 <- bookSet
    if b1 != b2
    a1 <- b1.authors
    a2 <- b2.authors
    if a1 == a2
  } yield a1;System.out.println("""res3: scala.collection.immutable.Set[String] = """ + $show(res$3))}
}
