package test

import org.specs2.mutable._
import katas._

class StringCalculatorSpec extends Specification{
  "This is a specification for the String Calculator Kata".txt

  def calculator: StringCalculator = new StringCalculator()

  "The 'Add(numbers: string)' method can handle" >> {

    "0 numbers" should{
      calculator Add "" mustEqual(0)
    }

    "1 number" should{
      calculator Add "1" mustEqual(1)
    }

    "2 numbers" should{
      calculator Add "1,2" mustEqual(3)
    }

    "3 numbers" should{
      calculator Add "1,2,3" mustEqual(6)
    }

    "10 numbers" should{
      val range = 1 until 10
      val expected = range sum;
      calculator Add (range mkString ",") mustEqual(expected)
    }

    "100 numbers" should{
      val range = 1 until 100
      val expected = range sum;
      calculator Add (range mkString ",") mustEqual(expected)
    }
  }
}
