package katas

import scala.language.postfixOps
import scala.annotation.tailrec

class StringCalculator{

  def addMultiple(numbers: List[String]) : Int = {
    @tailrec
    def sumAccumulator(numbers: List[String], accum: Int) : Int = {
      numbers match {
        case Nil => accum
        case x :: tail => sumAccumulator(tail, accum + x.toInt)
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
      case _ => addMultiple(numbers.split(delimiterSet(',')).toList)
    }

  private def definedDelimiter(numbers:String) = {
    var delimiter = numbers(2)
    val value = numbers.substring(numbers.indexOf("\n")+1)
    val values = value.split(delimiterSet(delimiter))
    (handler:(List[String]=>Int)) => handler(values.toList)
  }

  private def delimiterSet(delimiter:Char) : Array[Char] = Array(delimiter,'\n')
    
}
