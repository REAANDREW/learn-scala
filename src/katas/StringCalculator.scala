package katas

class StringCalculator{
  def Add(numbers: String) : Int = {
    numbers match{
      case "" => 0
      case _ => 1
    }
  }
}
