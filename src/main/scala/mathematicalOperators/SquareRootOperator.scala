package com.knoldus
package mathematicalOperators

import scala.util.{Try, Success, Failure}

class SquareRootOperator extends Operator {

  // Validate if the operands sequence contains exactly 1 non-negative number
  override def validate(operands: Seq[Double]): Boolean = operands.length == 1 && operands.head >= 0

  // The execute method calculates the square root of the operand and returns it as a sequence of one number
  override protected def execute(operands: Seq[Double]): Seq[Double] = findSquareRoot(operands)

  // The findSquareRoot method calculates the square root of the operand using the math.pow function
  private def findSquareRoot(operands: Seq[Double]): Seq[Double] = {
    Try {
      Seq(math.sqrt(operands.head))
    }match {
      case Success(result) => result
      case Failure(exception) => throw CalculatorException(s"Unexpected Exception Occurred : ${exception.getMessage}")
    }
  }
}
