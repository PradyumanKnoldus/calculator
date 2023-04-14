package com.knoldus
package mathematicalOperators

import scala.util.{Try, Success, Failure}

class EvenOperator extends Operator {

  // Validate if the given operands sequence is non-empty and all its elements are greater than 0
  override def validate(operands: Seq[Double]): Boolean = operands.nonEmpty && operands.forall(_ > 0)

  // Execute filtering out the even numbers from the operands and return the result
  override protected def execute(operands: Seq[Double]): Seq[Double] = findEven(operands)

  // A private helper method that actually finds the even numbers from the operands
  private def findEven(operands: Seq[Double]): Seq[Double] = {
    Try {
      operands.filter(_ % 2 == 0)
    } match {
      case Success(result) => result
      case Failure(exception) => throw CalculatorException(s"Unexpected Exception Occurred : ${exception.getMessage}")
    }
  }
}
