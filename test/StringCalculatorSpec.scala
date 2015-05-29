package test

import org.specs2.mutable._
import katas._

class DelimiterExtractorSpec extends Specification{
  "This is a specification for the DelimiterExtractor".txt

  def extractor: NumbersExtractor = new NumbersExtractor()

  "The 'Extract(numbers: String)' method can handle" >> {
    "Defined delimiter" should{
      extractor extract "//;\n1;2" mustEqual(Array("1","2"))
    }
  }
}

class StringCalculatorSpec extends Specification{
  "This is a specification for the String Calculator Kata".txt

  def calculator: StringCalculator = new StringCalculator()

  "The 'Add(numbers: String)' method can handle" >> {

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
      calculator Add ("1,2,3,4,5,6,7,8,9") mustEqual(45)
    }

    //
    //Just adding this test case to explore some scala
    //syntax of the range and also the out of the box
    //functions attached to Iterables! :-)
    //
    "1,..,100" should{
      "return 4950" in {
        val range = 1 until 100
        val expected = range sum;
        val input = range mkString ","
        calculator Add (input) mustEqual(expected)
      }
    }

    "A set of numbers with a new line delimiter present" should{
      calculator Add "1\n2,3" mustEqual 6
    }

    "Allow for a defined delimiter" should{ 
      calculator Add "//;\n1;2" mustEqual 3
    }
  }
}
