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
  val sentence = List("yes", "man");System.out.println("""sentence  : List[String] = """ + $show(sentence ));$skip(300); 

  def wordOccurrences(st: Word): Occurrences = {
    val cleanSt = (st map (c => c.toLower) filter (c => c != ' ')).toList
    val mappedSt = cleanSt.groupBy(c => c)
    val listOfChars = (mappedSt map { case (c, cs) => (c, cs.length) }).toList
    listOfChars sortBy { case (c, i) => (i, c) }
  };System.out.println("""wordOccurrences: (st: forcomp.test.Word)forcomp.test.Occurrences""");$skip(432); 

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
  };System.out.println("""sentenceOccurrences: (s: forcomp.test.Sentence)forcomp.test.Occurrences""");$skip(43); val res$0 = 

  sentenceOccurrences(List("abcd", "e"));System.out.println("""res0: forcomp.test.Occurrences = """ + $show(res$0));$skip(79); 

  val dictionaryByOccurrences = dictionary groupBy (s => wordOccurrences(s));System.out.println("""dictionaryByOccurrences  : scala.collection.immutable.Map[forcomp.test.Occurrences,List[String]] = """ + $show(dictionaryByOccurrences ));$skip(181); 

  def wordAnagrams(word: Word): List[Word] = {
    dictionaryByOccurrences get (wordOccurrences(word)) match {
      case None => List()
      case Some(words) => words
    }
  };System.out.println("""wordAnagrams: (word: forcomp.test.Word)List[forcomp.test.Word]""");$skip(1175); 

  def combinations(occ: Occurrences): List[Occurrences] = {
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

    def a(tst: Occurrences): Boolean = {
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
  };System.out.println("""combinations: (occ: forcomp.test.Occurrences)List[forcomp.test.Occurrences]""");$skip(269); 

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
  };System.out.println("""subtract: (x: forcomp.test.Occurrences, y: forcomp.test.Occurrences)forcomp.test.Occurrences""");$skip(248); 

  def getCombinations(occurrences: Occurrences) = for {
    combination <- combinations(occurrences)
    if ((dictionaryByOccurrences get (combination)) match {
      case None => false
      case Some(words) => true
    })
  } yield combination;System.out.println("""getCombinations: (occurrences: forcomp.test.Occurrences)List[forcomp.test.Occurrences]""");$skip(52); 

  val sentenceOcc = sentenceOccurrences(sentence);System.out.println("""sentenceOcc  : forcomp.test.Occurrences = """ + $show(sentenceOcc ));$skip(42); 
  val comb = getCombinations(sentenceOcc);System.out.println("""comb  : List[forcomp.test.Occurrences] = """ + $show(comb ));$skip(90); val res$1 = 

  for {
    cmb <- comb
    remainder <- subtract(sentenceOcc, cmb)
  } yield remainder;System.out.println("""res1: List[(Char, Int)] = """ + $show(res$1));$skip(356); 

  def f(currentSentence: Occurrences, sentences: List[Sentence]): List[Sentence] = {
    val out = for {
    	cmb <- getCombinations(currentSentence)
  	} yield {
    	dictionaryByOccurrences get (cmb) match {
      	case None => sentences
      	case Some(words) => f(subtract(currentSentence, cmb), words :: sentences)
    	}
    }
    out.flatten
  };System.out.println("""f: (currentSentence: forcomp.test.Occurrences, sentences: List[forcomp.test.Sentence])List[forcomp.test.Sentence]""");$skip(24); val res$2 = 
	f(sentenceOcc, List());System.out.println("""res2: List[forcomp.test.Sentence] = """ + $show(res$2))}
}
