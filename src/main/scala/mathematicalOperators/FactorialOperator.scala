package com.knoldus
package mathematicalOperators

import scala.annotation.tailrec
import scala.util.{Try, Success, Failure}

class FactorialOperator extends Operator {

  // Validate if the given operands sequence contains exactly one non-negative integer
  override def validate(operands: Seq[Double]): Boolean = operands.length == 1 && operands.head >= 0 && operands.head % 1 == 0

  // Calculate the factorial of the given integer and return the result in a sequence
  override protected def execute(operands: Seq[Double]): Seq[Double] = Seq(factorialOfNumber(operands.head.toInt))

  // A private helper method that actually calculates the factorial of the given integer
  private def factorialOfNumber(number: Int): Double = {
    Try {
      @tailrec
      def factorialHelper(number: Int, accumulator: Double = 1): Double = {
        if (number == 0) accumulator
        else factorialHelper(number - 1, number * accumulator)
      }

      factorialHelper(number)
    } match {
      case Success(result) => result
      case Failure(exception) => throw CalculatorException(s"Unexpected Exception Occurred : ${exception.getMessage}")
    }
  }
}
