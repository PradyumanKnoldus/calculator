package com.knoldus
package mathematicalOperators

import scala.util.{Try, Success, Failure}

class PowerOperator extends Operator {

  // Validate if the given operands sequence contains exactly two operands and the second one is non-negative
  override def validate(operands: Seq[Double]): Boolean = operands.length == 2 && operands(1) >= 0

  // Calculate the power of the first operand to the second operand
  override protected def execute(operands: Seq[Double]): Seq[Double] = power(operands)

  // A private helper method that actually calculates the power
  private def power(operands: Seq[Double]): Seq[Double] = {
    Try {
      val base = operands.head
      val exponent = operands(1)
      Seq(math.pow(base, exponent))
    } match {
      case Success(result) => result
      case Failure(exception) => throw CalculatorException(s"Unexpected Exception Occurred : ${exception.getMessage}")
    }
  }
}
