package week06

object session5 {
  case class Book(title: String, authors: List[String]);import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(650); 
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
      authors = List("Odersky, Martin", "Spoon, Lex", "Venners, Bill")));System.out.println("""books  : List[week06.session5.Book] = """ + $show(books ));$skip(86); 
  
  def mapFun[T, U](xs: List[T], f: T => U): List[U] =
    for (x <- xs) yield f(x);System.out.println("""mapFun: [T, U](xs: List[T], f: T => U)List[U]""");$skip(102); 
  def flatMap[T, U](xs: List[T], f: T => Iterable[U]): List[U] =
    for (x <- xs; y <- f(x)) yield y;System.out.println("""flatMap: [T, U](xs: List[T], f: T => Iterable[U])List[U]""");$skip(91); 
  def filter[T](xs: List[T], p: T => Boolean): List[T] =
    for (x <- xs if p(x)) yield x;System.out.println("""filter: [T](xs: List[T], p: T => Boolean)List[T]""");$skip(310); val res$0 = 

  // for (x <- e1) yield e2
  // e1 map (x => e2)

  // for (x <- e1 if f; s) yield e2
  // for(x <- e1.withFilter(x => f); s) yield e2

  // for (x <- e1; y <- e2; s) yield e3
  // e1.flatMap(x => for(y <- e2; s) yield e3)
  
    for (b <- books; a <- b.authors if a startsWith "Bird,")
    yield b.title;System.out.println("""res0: List[String] = """ + $show(res$0));$skip(88); val res$1 = 
    
    books.flatMap(b => for (a <- b.authors if a startsWith "Bird,") yield b.title);System.out.println("""res1: List[String] = """ + $show(res$1));$skip(95); val res$2 = 
		books.flatMap(b => for (a <- b.authors.withFilter(a => a startsWith "Bird,")) yield b.title);System.out.println("""res2: List[String] = """ + $show(res$2));$skip(92); val res$3 = 
		
		books.flatMap(b => b.authors.withFilter(a => a startsWith "Bird,") map (a => b.title));System.out.println("""res3: List[String] = """ + $show(res$3))}
}
