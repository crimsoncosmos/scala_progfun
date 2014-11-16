package week04

object session6 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
  println("Welcome to the Scala worksheet");$skip(230); 
  
  def show(e: Expr): String = e match {
    case Number(n) => n.toString
    case Var(x) => x
    case Sum(e1, e2) => "(" + show(e1) + " + " + show(e2) + ")"
    case Prod(e1, e2) => "(" + show(e1) + " * " + show(e2) + ")"
  };System.out.println("""show: (e: week04.Expr)String""");$skip(35); val res$0 = 
  
	Sum(Number(1), Number(2)).eval;System.out.println("""res0: Int = """ + $show(res$0));$skip(33); val res$1 = 
	show(Sum(Number(1), Number(2)));System.out.println("""res1: String = """ + $show(res$1));$skip(48); val res$2 = 
	show(Sum(Prod(Number(2), Var("x")), Var("y")));System.out.println("""res2: String = """ + $show(res$2));$skip(49); val res$3 = 
  show(Prod(Sum(Number(2), Var("x")), Var("y")));System.out.println("""res3: String = """ + $show(res$3))}
}
