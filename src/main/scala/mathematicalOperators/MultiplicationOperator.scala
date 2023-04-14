package com.knoldus
package mathematicalOperators

import scala.util.{Try, Success, Failure}

class MultiplicationOperator extends Operator {

  // Validate if the given operands sequence contains exactly two elements
  override def validate(operands: Seq[Double]): Boolean = operands.length == 2

  // Execute the multiplication operation on the given operands and return the result in a sequence
  override protected def execute(operands: Seq[Double]): Seq[Double] = multiplication(operands)

  // A private helper method that actually performs the multiplication operation
  private def multiplication(operands: Seq[Double]): Seq[Double] = {
    Try {
      Seq(operands.head * operands(1))
    } match {
      case Success(result) => result
      case Failure(exception) => throw CalculatorException(s"Unexpected Error Occurred : ${exception.getMessage}")
    }
  }
}
