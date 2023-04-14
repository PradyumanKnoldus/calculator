package com.knoldus
package mathematicalOperators

import scala.util.{Failure, Success, Try}

class SubtractionOperator extends Operator {
  // Validate if the given operands sequence has exactly two elements
  override def validate(operands: Seq[Double]): Boolean = operands.length == 2

  // Execute the subtraction operation on the operands and return the result
  override protected def execute(operands: Seq[Double]): Seq[Double] = subtraction(operands)

  // A private helper method that actually performs the subtraction operation
  private def subtraction(operands: Seq[Double]): Seq[Double] = {
    Try {
      Seq(operands.head - operands(1))
    } match {
      case Success(result) => result
      case Failure(exception) => throw CalculatorException(s"Unexpected Exception Occurred : ${exception.getMessage}")
    }
  }
}
