package com.knoldus
package mathematicalOperators

import scala.util.{Try, Success, Failure}

class AdditionOperator extends Operator {

  // Validate if the given operands sequence has exactly two elements
  override def validate(operands: Seq[Double]): Boolean = operands.length == 2

  // Execute the addition operation on the operands and return the result
  override protected def execute(operands: Seq[Double]): Seq[Double] = addition(operands)

  // A private helper method that actually performs the addition operation
  private def addition(operands: Seq[Double]): Seq[Double] = {
    Try {
      Seq(operands.head + operands(1))
    } match {
      case Success(result) => result
      case Failure(exception) => throw CalculatorException(s"Unexpected Error Occurred : ${exception.getMessage}")
    }
  }
}
