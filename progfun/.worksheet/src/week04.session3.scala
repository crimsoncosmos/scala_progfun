package week04

object session3 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
  println("Welcome to the Scala worksheet");$skip(18); val res$0 = 
  
  True < False;System.out.println("""res0: week04.Boolean = """ + $show(res$0));$skip(15); val res$1 = 
  False < True;System.out.println("""res1: week04.Boolean = """ + $show(res$1));$skip(14); val res$2 = 
  True < True;System.out.println("""res2: week04.Boolean = """ + $show(res$2));$skip(16); val res$3 = 
  False < False;System.out.println("""res3: week04.Boolean = """ + $show(res$3));$skip(10); val res$4 = 
  
  Zero;System.out.println("""res4: week04.Zero.type = """ + $show(res$4));$skip(17); val res$5 = 
  Zero.successor;System.out.println("""res5: week04.Nat = """ + $show(res$5));$skip(27); val res$6 = 
  new Succ(new Succ(Zero));System.out.println("""res6: week04.Succ = """ + $show(res$6));$skip(29); val res$7 = 
  new Succ(Zero).predecessor;System.out.println("""res7: week04.Nat = """ + $show(res$7));$skip(27); val res$8 = 
  new Succ(Zero).successor;System.out.println("""res8: week04.Nat = """ + $show(res$8));$skip(34); val res$9 = 
  Zero.successor - new Succ(Zero);System.out.println("""res9: week04.Nat = """ + $show(res$9))}
  
  
}
