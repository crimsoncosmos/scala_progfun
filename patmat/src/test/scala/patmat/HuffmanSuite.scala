package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
    val t3 = Leaf('d', 3)
    val t4 = Fork(Leaf('a', 8), Fork(Fork(Leaf('b', 3), Fork(Leaf('c', 1), Leaf('d', 1), List('c', 'd'), 2), List('b', 'c', 'd'), 5), Leaf('e', 1), List('b', 'c', 'd', 'e'), 6), List('a', 'b', 'c', 'd', 'e'), 14);
    val l1 = List('a', 'b', 'c', 'a', 'c', 'a')
    val l2 = List(t1)
    val l3 = List(t2, Leaf('a', 2))
    val l4 = List(Leaf('a', 3))
    val ct1 = List(('a', List(0,1)), ('b', List(1)), ('c', List(0, 0)))
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }
  
  test("times") {
    new TestTrees {
      assert(times(l1).head === ('a', 3))
    }
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }
  
  test("singleton") {
    new TestTrees {
      assert(singleton(l2) === true)
      assert(singleton(l3) === false)
      assert(singleton(l4) === true)
    }
  }

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }
  
  test("combine of some small leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 3), Leaf('z', 3))
    assert(combine(leaflist) === List(Leaf('z', 3), Fork(Leaf('e',1), Leaf('t',3), List('e', 't'),4)))
  }
  
  test("combine of some tree list") {
    new TestTrees {
      val leaflist = List(t1, Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
	  assert(combine(leaflist) === 
	    List(Leaf('t',2), Leaf('x',4), Fork(Fork(Leaf('a',2), Leaf('b',3), List('a', 'b'),5), Leaf('e',1), List('a', 'b', 'e'),6)))
    }
  }
  
  test("until of empty list") {
    new TestTrees {
      assert(until(singleton, combine)(List()) === List())
    }
  }
  
  test("until of some tree list") {
    new TestTrees {
      assert(until(singleton, combine)(List(t1, t2, t3)) === 
        List(Fork(Leaf('d',3),Fork(Fork(Leaf('a',2),Leaf('b',3),List('a','b'),5),Fork(Fork(Leaf('a',2),Leaf('b',3),List('a','b'),5),Leaf('d',4),List('a','b','d'),9),List('a','b','a','b','d'),14),List('d','a','b','a','b','d'),17)))
    }
  }
  
  test("create code tree") {
    new TestTrees {
    	assert(createCodeTree(l1) === Fork(Leaf('b', 1), Fork(Leaf('a', 3), Leaf('c', 2), List('a', 'c'), 5), List('b', 'a', 'c'), 6))      
    }
  }
  
  test("decode simple") {
    new TestTrees {
      assert(decode(t4, List(1, 0, 1, 1, 0)) === List('d', 'a'))
    }
  }
  
  test("decode") {
    assert(decode(frenchCode, secret) === List('h', 'u', 'f', 'f', 'm', 'a', 'n', 'e', 's', 't', 'c', 'o', 'o', 'l'))
  }
  
  test("encode") {
    new TestTrees {
      assert(encode(t2)("abd".toList) === List(0, 0, 0, 1, 1))
    }
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }
  
  test("code bits not found") {
    new TestTrees {
    	assert(codeBits(ct1)('d') === List())
    }
  }
  
  test("code bits") {
    new TestTrees {
    	assert(codeBits(ct1)('c') === List(0, 0))
    }
  }
  
  test("convert") {
    new TestTrees {
      assert(convert(t1) === List(('a', List(0)), ('b', List(1))))
      assert(convert(t2) === List(('a', List(0,0)), ('b', List(0,1)), ('d', List(1))))
    }
  }
  
  test("quick encode") {
    new TestTrees {
      assert(quickEncode(t1)("ab".toList) === List(0, 1))
      assert(quickEncode(t2)("abd".toList) === List(0, 0, 0, 1, 1))
    }
  }
  
  test("decode and quick encode a short text should be identity") {
    new TestTrees {
      assert(decode(t4, quickEncode(t4)("ab".toList)) === "ab".toList)
    }
  }
}
