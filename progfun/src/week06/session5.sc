package week06

object session5 {
  case class Book(title: String, authors: List[String])
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
      authors = List("Odersky, Martin", "Spoon, Lex", "Venners, Bill")))
                                                  //> books  : List[week06.session5.Book] = List(Book(Structure and Interpretation
                                                  //|  of Computer Programs,List(Abelson, Harald, Sussman, Gerald J.)), Book(Intro
                                                  //| duction to Functional Programming,List(Bird, Richard, Wadler, Phil)), Book(E
                                                  //| ffective Java,List(Bloch, Joshua)), Book(Java Puzzlers,List(Bloch, Joshua, G
                                                  //| after, Neal)), Book(Programming in Scala,List(Odersky, Martin, Spoon, Lex, V
                                                  //| enners, Bill)))
  
  def mapFun[T, U](xs: List[T], f: T => U): List[U] =
    for (x <- xs) yield f(x)                      //> mapFun: [T, U](xs: List[T], f: T => U)List[U]
  def flatMap[T, U](xs: List[T], f: T => Iterable[U]): List[U] =
    for (x <- xs; y <- f(x)) yield y              //> flatMap: [T, U](xs: List[T], f: T => Iterable[U])List[U]
  def filter[T](xs: List[T], p: T => Boolean): List[T] =
    for (x <- xs if p(x)) yield x                 //> filter: [T](xs: List[T], p: T => Boolean)List[T]

  // for (x <- e1) yield e2
  // e1 map (x => e2)

  // for (x <- e1 if f; s) yield e2
  // for(x <- e1.withFilter(x => f); s) yield e2

  // for (x <- e1; y <- e2; s) yield e3
  // e1.flatMap(x => for(y <- e2; s) yield e3)
  
    for (b <- books; a <- b.authors if a startsWith "Bird,")
    yield b.title                                 //> res0: List[String] = List(Introduction to Functional Programming)
    
    books.flatMap(b => for (a <- b.authors if a startsWith "Bird,") yield b.title)
                                                  //> res1: List[String] = List(Introduction to Functional Programming)
		books.flatMap(b => for (a <- b.authors.withFilter(a => a startsWith "Bird,")) yield b.title)
                                                  //> res2: List[String] = List(Introduction to Functional Programming)
		
		books.flatMap(b => b.authors.withFilter(a => a startsWith "Bird,") map (a => b.title))
                                                  //> res3: List[String] = List(Introduction to Functional Programming)
}