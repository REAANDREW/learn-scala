package katas

import scala.language.postfixOps
import scala.annotation.tailrec
import java.lang.RuntimeException

class StringCalculatorException(msg:String) extends RuntimeException(msg){ }

class StringCalculator{

  def valueGuard(number:Int) : Int = 
    number match{
      case x if x < 0 => throw new StringCalculatorException("negatives not allowed")
      case x if x >= 1000 => 0
      case _ => number
    }

  def addMultiple(numbers: List[String]) : Int = {
    @tailrec
    def sumAccumulator(numbers: List[String], accum: Int) : Int = {
      numbers match {
        case Nil => accum
        case x :: tail => sumAccumulator(tail, accum + valueGuard(x.toInt))
      }
    }

    sumAccumulator(numbers, 0)
  }

  def add(numbers: String) = 
    numbers match{
      case n:String if n nonEmpty => nonEmptyInput(n)
      case _ => 0
    }

  private def nonEmptyInput(numbers:String) = 
    numbers match {
      case n:String if n startsWith "//" => definedDelimiter(numbers)(addMultiple)
      case _ => addMultiple(numbers.split(delimiterSet(",")).toList)
    }

  private def definedDelimiter(numbers:String) = {
    var delimiter = numbers.substring(2,numbers.indexOf("\n"))
    val value = numbers.substring(numbers.indexOf("\n")+1)
    val values = value.split(delimiterSet(delimiter.toString))
    (handler:(List[String]=>Int)) => handler(values.toList)
  }

  private def delimiterSet(delimiter:String) : String = s"[$delimiter]+|\n"
    
}
