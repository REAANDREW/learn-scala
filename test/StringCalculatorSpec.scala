package test

import org.specs2.mutable._
import katas._

class StringCalculatorSpec extends Specification{
  "This is a specification for the String Calculator Kata".txt

  def calculator: StringCalculator = new StringCalculator()

  "The 'Add(numbers: string)' method can handle" >> {

    "0 numbers" >> {
      calculator Add "" mustEqual(0)
    }
  }
}
