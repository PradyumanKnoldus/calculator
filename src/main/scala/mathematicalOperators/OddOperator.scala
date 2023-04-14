package com.knoldus
package mathematicalOperators

import scala.util.{Try, Success, Failure}

class OddOperator extends Operator {

  // Validate if the given operands sequence contains exactly one number
  override def validate(operands: Seq[Double]): Boolean = operands.nonEmpty && operands.forall(_ > 0)

  // Find the odd number in the given sequence and return it in a sequence
  override protected def execute(operands: Seq[Double]): Seq[Double] = findOdd(operands)

  // A private helper method that finds the odd number in a sequence of numbers
  private def findOdd(operands: Seq[Double]): Seq[Double] = {
    Try {
      operands.filter(_ % 2 != 0)
    } match {
      case Success(filtered) => filtered
      case Failure(exception) => throw CalculatorException(s"Unexpected Error Occurred : ${exception.getMessage}")
    }
  }
}
