package forcomp

object test {
  type Word = String
  type Sentence = List[Word]
  type Occurrences = List[(Char, Int)];import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(141); 

	
  val st = "Hello";System.out.println("""st  : String = """ + $show(st ));$skip(49); 
  val lst = List(st, "World", "I", "am", "here");System.out.println("""lst  : List[String] = """ + $show(lst ));$skip(53); 
  val occurence = List(('a', 1), ('e', 1), ('t', 1));System.out.println("""occurence  : List[(Char, Int)] = """ + $show(occurence ));$skip(37); 
  val occ = List(('a', 2), ('b', 2));System.out.println("""occ  : List[(Char, Int)] = """ + $show(occ ));$skip(19); 
  val o = ('a', 2);System.out.println("""o  : (Char, Int) = """ + $show(o ));$skip(19); 
  val p = ('b', 2);System.out.println("""p  : (Char, Int) = """ + $show(p ));$skip(68); 
  val x: Occurrences = List(('a', 1), ('d', 1), ('l', 1), ('r', 1));System.out.println("""x  : forcomp.test.Occurrences = """ + $show(x ));$skip(38); 
  val y: Occurrences = List(('r', 1));System.out.println("""y  : forcomp.test.Occurrences = """ + $show(y ));$skip(19); 
  val word = "ate";System.out.println("""word  : String = """ + $show(word ));$skip(115); 
  val dictionary = List("ate", "eat", "tea", "pray", "love", "ah", "en", "as", "my", "sane", "Sean", "men", "man");System.out.println("""dictionary  : List[String] = """ + $show(dictionary ));$skip(36); 
  val sentence = List("yes", "man");System.out.println("""sentence  : List[String] = """ + $show(sentence ));$skip(313); 

  

  def wordOccurrences(st: String): List[(Char, Int)] = {
    val cleanSt = (st map (c => c.toLower) filter (c => c != ' ')).toList
    val mappedSt = cleanSt.groupBy(c => c)
    val listOfChars = (mappedSt map { case (c, cs) => (c, cs.length) }).toList
    listOfChars sortBy { case (c, i) => (i, c) }
  };System.out.println("""wordOccurrences: (st: String)List[(Char, Int)]""");$skip(427); 

 def sentenceOccurrences(s: Sentence): Occurrences = {
    val letters = (for {
      w <- s
    } yield wordOccurrences(w)) flatten

    val groupedLetters = letters.groupBy { case (c, i) => c }

    def flat(term: (Char, List[(Char, Int)])) = {
      val (char, list) = term
      (char, (list unzip)._2.sum)
    }

    val pairs = for {
      (c, cs) <- groupedLetters
    } yield flat(c, cs)

    pairs.toList.sorted
  };System.out.println("""sentenceOccurrences: (s: forcomp.test.Sentence)forcomp.test.Occurrences""");$skip(44); val res$0 = 
  
  sentenceOccurrences(List("abcd", "e"));System.out.println("""res0: forcomp.test.Occurrences = """ + $show(res$0));$skip(79); 

  val dictionaryByOccurrences = dictionary groupBy (s => wordOccurrences(s));System.out.println("""dictionaryByOccurrences  : scala.collection.immutable.Map[List[(Char, Int)],List[String]] = """ + $show(dictionaryByOccurrences ));$skip(185); 

  def wordAnagrams(word: String): List[String] = {
    dictionaryByOccurrences get (wordOccurrences(word)) match {
      case None => List()
      case Some(words) => words
    }
  };System.out.println("""wordAnagrams: (word: String)List[String]""");$skip(1193); 

  def combinations(occ: List[(Char, Int)]): List[List[(Char, Int)]] = {
    def f(term: (Char, Int)): List[(Char, Int)] = {
      val (c, i) = term
      val out = List()
      (for {
        r <- 1 to i
      } yield (c, r)).toList
    }

    val in = {
      for {
        i <- occ
      } yield f(i)
    }.flatten

    val int = for {
      i <- 0 to in.length
      combinations <- in combinations i
    } yield combinations

    def a(tst: List[(Char, Int)]): Boolean = {
      val mtst = tst groupBy { case (c, i) => c }
      val res = {
        for {
          (i, list) <- mtst
          if (list.length <= 1)
        } yield i
      }.toList

      res.length == tst.length
    }

    (int filter (a)).toList

    /*def g(t1: (Char, Int), t2: (Char, Int)) = {
      val lt1 = f(t1)
      val lt2 = f(t2)
      List() ::
        (for {
          i <- lt1
        } yield List(i)) :::
        (for {
          j <- lt2
        } yield List(j)) :::
        (for {
          i <- lt1
          j <- lt2
        } yield List((i, j)))
    }

    val res = for {
      i <- 0 to occ.length - 2
      j <- 1 to occ.length - 1
    } yield g(occ(i), occ(j))

    res(0).toList*/
  };System.out.println("""combinations: (occ: List[(Char, Int)])List[List[(Char, Int)]]""");$skip(269); 

  val indices = for {
    (c, i) <- y
  } yield {
    (c, i)
    val index = x indexWhere { case (ch, in) => ch == c }
    val (ch, in) = x(index)
    if (in == i) (x take (index)) ::: (x takeRight (x.length - index - 1))
    else x updated (index, (ch, in - i))
  };System.out.println("""indices  : List[List[(Char, Int)]] = """ + $show(indices ));$skip(388); 

  def subtract(x: Occurrences, y: Occurrences): Occurrences = y match {
    case List() => x
    case yh :: ys => {
      val (c, i) = yh
      val index = x indexWhere { case (ch, in) => ch == c }
      val (ch, in) = x(index)
      if (in == i) subtract((x take (index)) ::: (x takeRight (x.length - index - 1)), ys)
      else subtract(x updated (index, (ch, in - i)), ys)
    }
  };System.out.println("""subtract: (x: forcomp.test.Occurrences, y: forcomp.test.Occurrences)forcomp.test.Occurrences""");$skip(17); val res$1 = 
  subtract(x, y);System.out.println("""res1: forcomp.test.Occurrences = """ + $show(res$1));$skip(128); val res$2 = 
  
  
  
  dictionaryByOccurrences get List(('a', 1), ('h', 1)) match {
  		case None => false
  		case Some(words) => words
	};System.out.println("""res2: Any = """ + $show(res$2));$skip(14); val res$3 = 
  
  sentence;System.out.println("""res3: List[String] = """ + $show(res$3));$skip(32); val res$4 = 
  sentenceOccurrences(sentence);System.out.println("""res4: forcomp.test.Occurrences = """ + $show(res$4));$skip(242); 
  
  def getCombinations(occurrences: Occurrences) = for {
  	combination <- combinations(occurrences)
  	if ((dictionaryByOccurrences get (combination)) match {
  		case None => false
  		case Some(words) => true
  	})
  } yield combination;System.out.println("""getCombinations: (occurrences: forcomp.test.Occurrences)List[List[(Char, Int)]]""");$skip(49); 
	val sentenceOcc = sentenceOccurrences(sentence);System.out.println("""sentenceOcc  : forcomp.test.Occurrences = """ + $show(sentenceOcc ));$skip(42); 
  val comb = getCombinations(sentenceOcc);System.out.println("""comb  : List[List[(Char, Int)]] = """ + $show(comb ));$skip(99); val res$5 = 
	for {
		cmb <- comb
		remainder <- getCombinations(subtract(sentenceOcc, cmb))
	} yield remainder;System.out.println("""res5: List[List[(Char, Int)]] = """ + $show(res$5));$skip(273); 
  	
  def f(sentence: Sentence): List[Sentence] = sentence match {
  	case List() => List()
  	case x :: xs => {
  		//dictionaryByOccurrences get (wordOccurrences(word)) match {
      //case None => List()
      //case Some(words) => words
      List(sentence)
    }
  };System.out.println("""f: (sentence: forcomp.test.Sentence)List[forcomp.test.Sentence]""")}
}
