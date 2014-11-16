package forcomp

object test {
  type Word = String
  type Sentence = List[Word]
  type Occurrences = List[(Char, Int)]

  val st = "Hello"                                //> st  : String = Hello
  val lst = List(st, "World", "I", "am", "here")  //> lst  : List[String] = List(Hello, World, I, am, here)
  val occurence = List(('a', 1), ('e', 1), ('t', 1))
                                                  //> occurence  : List[(Char, Int)] = List((a,1), (e,1), (t,1))
  val occ = List(('a', 2), ('b', 2))              //> occ  : List[(Char, Int)] = List((a,2), (b,2))
  val o = ('a', 2)                                //> o  : (Char, Int) = (a,2)
  val p = ('b', 2)                                //> p  : (Char, Int) = (b,2)
  val x: Occurrences = List(('a', 1), ('d', 1), ('l', 1), ('r', 1))
                                                  //> x  : forcomp.test.Occurrences = List((a,1), (d,1), (l,1), (r,1))
  val y: Occurrences = List(('r', 1))             //> y  : forcomp.test.Occurrences = List((r,1))
  val word = "ate"                                //> word  : String = ate
  val dictionary = List("ate", "eat", "tea", "pray", "love", "ah", "en", "as", "my", "sane", "Sean", "men", "man")
                                                  //> dictionary  : List[String] = List(ate, eat, tea, pray, love, ah, en, as, my,
                                                  //|  sane, Sean, men, man)
  val sentence = List("yes", "man")               //> sentence  : List[String] = List(yes, man)

  def wordOccurrences(st: Word): Occurrences = {
    val cleanSt = (st map (c => c.toLower) filter (c => c != ' ')).toList
    val mappedSt = cleanSt.groupBy(c => c)
    val listOfChars = (mappedSt map { case (c, cs) => (c, cs.length) }).toList
    listOfChars sortBy { case (c, i) => (i, c) }
  }                                               //> wordOccurrences: (st: forcomp.test.Word)forcomp.test.Occurrences

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
  }                                               //> sentenceOccurrences: (s: forcomp.test.Sentence)forcomp.test.Occurrences

  sentenceOccurrences(List("abcd", "e"))          //> res0: forcomp.test.Occurrences = List((a,1), (b,1), (c,1), (d,1), (e,1))

  val dictionaryByOccurrences = dictionary groupBy (s => wordOccurrences(s))
                                                  //> dictionaryByOccurrences  : scala.collection.immutable.Map[forcomp.test.Occu
                                                  //| rrences,List[String]] = Map(List((e,1), (l,1), (o,1), (v,1)) -> List(love),
                                                  //|  List((a,1), (s,1)) -> List(as), List((a,1), (p,1), (r,1), (y,1)) -> List(p
                                                  //| ray), List((a,1), (m,1), (n,1)) -> List(man), List((a,1), (e,1), (n,1), (s,
                                                  //| 1)) -> List(sane, Sean), List((a,1), (h,1)) -> List(ah), List((e,1), (m,1),
                                                  //|  (n,1)) -> List(men), List((e,1), (n,1)) -> List(en), List((m,1), (y,1)) ->
                                                  //|  List(my), List((a,1), (e,1), (t,1)) -> List(ate, eat, tea))

  def wordAnagrams(word: Word): List[Word] = {
    dictionaryByOccurrences get (wordOccurrences(word)) match {
      case None => List()
      case Some(words) => words
    }
  }                                               //> wordAnagrams: (word: forcomp.test.Word)List[forcomp.test.Word]

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
  }                                               //> combinations: (occ: forcomp.test.Occurrences)List[forcomp.test.Occurrences]
                                                  //| 

  val indices = for {
    (c, i) <- y
  } yield {
    (c, i)
    val index = x indexWhere { case (ch, in) => ch == c }
    val (ch, in) = x(index)
    if (in == i) (x take (index)) ::: (x takeRight (x.length - index - 1))
    else x updated (index, (ch, in - i))
  }                                               //> indices  : List[List[(Char, Int)]] = List(List((a,1), (d,1), (l,1)))

  def subtract(x: Occurrences, y: Occurrences): Occurrences = y match {
    case List() => x
    case yh :: ys => {
      val (c, i) = yh
      val index = x indexWhere { case (ch, in) => ch == c }
      val (ch, in) = x(index)
      if (in == i) subtract((x take (index)) ::: (x takeRight (x.length - index - 1)), ys)
      else subtract(x updated (index, (ch, in - i)), ys)
    }
  }                                               //> subtract: (x: forcomp.test.Occurrences, y: forcomp.test.Occurrences)forcomp
                                                  //| .test.Occurrences

  def getCombinations(occurrences: Occurrences) = for {
    combination <- combinations(occurrences)
    if ((dictionaryByOccurrences get (combination)) match {
      case None => false
      case Some(words) => true
    })
  } yield combination                             //> getCombinations: (occurrences: forcomp.test.Occurrences)List[forcomp.test.O
                                                  //| ccurrences]

  val sentenceOcc = sentenceOccurrences(sentence) //> sentenceOcc  : forcomp.test.Occurrences = List((a,1), (e,1), (m,1), (n,1), 
                                                  //| (s,1), (y,1))
  val comb = getCombinations(sentenceOcc)         //> comb  : List[forcomp.test.Occurrences] = List(List((a,1), (s,1)), List((e,1
                                                  //| ), (n,1)), List((m,1), (y,1)), List((a,1), (m,1), (n,1)), List((e,1), (m,1)
                                                  //| , (n,1)), List((a,1), (e,1), (n,1), (s,1)))

  for {
    cmb <- comb
    remainder <- subtract(sentenceOcc, cmb)
  } yield remainder                               //> res1: List[(Char, Int)] = List((e,1), (m,1), (n,1), (y,1), (a,1), (m,1), (s
                                                  //| ,1), (y,1), (a,1), (e,1), (n,1), (s,1), (e,1), (s,1), (y,1), (a,1), (s,1), 
                                                  //| (y,1), (m,1), (y,1))

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
  }                                               //> f: (currentSentence: forcomp.test.Occurrences, sentences: List[forcomp.test
                                                  //| .Sentence])List[forcomp.test.Sentence]
	f(sentenceOcc, List())                    //> res2: List[forcomp.test.Sentence] = List()
}