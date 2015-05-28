package katas

class StringCalculator{

  def addMultiple(numbers: List[String]) : Int = {
    def sumAccumulator(numbers: List[String], accum: Int) : Int = {
      numbers match {
        case Nil => accum
        case x :: tail => sumAccumulator(tail, accum + x.toInt)
      }
    }

    sumAccumulator(numbers, 0)
  }

  def Add(numbers: String) : Int = {
    if(numbers.isEmpty) 0 
    else addMultiple(numbers.split(",").toList)
  }
}
