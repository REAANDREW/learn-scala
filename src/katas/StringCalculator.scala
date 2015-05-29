package katas

import scala.language.postfixOps
import scala.annotation.tailrec

class NumbersExtractor{
  def extract(numbers:String) = {
      val delimiter = numbers.charAt(2)
      val value = numbers.split("\n")(1)
      value.split(delimiter) 
  }
}

class StringCalculator{

  def extractor : NumbersExtractor = new NumbersExtractor()

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

  def Add(numbers: String) = 
    numbers match{
      case n:String if n nonEmpty => NonEmptyInput(n)
      case _ => 0
    }

  def NonEmptyInput(numbers:String) = 
    numbers match {
      case n:String if n startsWith "//" => DefinedDelimiter(numbers)
      case _ => addMultiple(numbers.split(Array(',','\n')).toList)
    }

  def DefinedDelimiter(numbers:String) = 
    addMultiple(extractor.extract(numbers).toList)
}
