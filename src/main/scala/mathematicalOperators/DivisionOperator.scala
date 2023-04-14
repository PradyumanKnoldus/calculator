package com.knoldus
package mathematicalOperators

import scala.util.{Try, Success, Failure}

class DivisionOperator extends Operator {

  // Validate if the given operands sequence has exactly two elements and the second operand is not 0
  override def validate(operands: Seq[Double]): Boolean = operands.length == 2 && operands(1) != 0

  // Execute the division operation on the operands and return the result
  override protected def execute(operands: Seq[Double]): Seq[Double] = division(operands)

  // A private helper method that actually performs the division operation
  private def division(operands: Seq[Double]): Seq[Double] = {
    Try {
      Seq(operands.head / operands(1))
    } match {
      case Success(result) => result
      case Failure(exception) => throw CalculatorException(s"Unexpected Error Occurred : ${exception.getMessage}")
    }
  }
}
