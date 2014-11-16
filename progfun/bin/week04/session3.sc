package week04

object session3 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  True < False                                    //> res0: week04.Boolean = week04.False$@2cf5e0f0
  False < True                                    //> res1: week04.Boolean = week04.True$@4282c39f
  True < True                                     //> res2: week04.Boolean = week04.False$@2cf5e0f0
  False < False                                   //> res3: week04.Boolean = week04.False$@2cf5e0f0
  
  Zero                                            //> res4: week04.Zero.type = week04.Zero$@16f91dd6
  Zero.successor                                  //> res5: week04.Nat = week04.Succ@3d15d862
  new Succ(new Succ(Zero))                        //> res6: week04.Succ = week04.Succ@65312942
  new Succ(Zero).predecessor                      //> res7: week04.Nat = week04.Zero$@16f91dd6
  new Succ(Zero).successor                        //> res8: week04.Nat = week04.Succ@7e8bdff4
  Zero.successor - new Succ(Zero)                 //> res9: week04.Nat = week04.Zero$@16f91dd6
  
  
}