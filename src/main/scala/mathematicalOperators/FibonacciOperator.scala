package com.knoldus
package mathematicalOperators

import scala.annotation.tailrec
import scala.util.{Try, Success, Failure}

class FibonacciOperator extends Operator {

  // Validate if the given operands sequence contains exactly one non-negative integer
  override def validate(operands: Seq[Double]): Boolean = operands.length == 1 && operands.head >= 0 && operands.head % 1 == 0

  // Calculate the Fibonacci series up to the given number and return the result in a sequence
  override protected def execute(operands: Seq[Double]): Seq[Double] = fibonacciSeries(operands.head)

  // A private helper method that actually calculates the Fibonacci series
  private def fibonacciSeries(number: Double): Seq[Double] = {
    Try {
      @tailrec
      def fibonacciSeriesHelper(currentIndex: Double, nextToLast: Double = 0.0, last: Double = 1.0, fibonacciSequence: Seq[Double] = Seq(0.0)): Seq[Double] = {
        if (currentIndex <= 0) {
          fibonacciSequence
        } else if (currentIndex == 1) {
          fibonacciSequence :+ last
        } else {
          val currentNumber = nextToLast + last
          fibonacciSeriesHelper(currentIndex - 1, last, currentNumber, fibonacciSequence :+ last)
        }
      }

      fibonacciSeriesHelper(number)
    } match {
      case Success(result) => result
      case Failure(exception) => throw CalculatorException(s"Unexpected Exception Occurred : ${exception.getMessage}")
    }
  }
}
