package com.knoldus
package mathematicalOperators

import scala.util.{Try, Success, Failure}

class GcdOperator extends Operator {

  // Validate if the given operands sequence contains at least two valid integers
  override def validate(operands: Seq[Double]): Boolean = operands.nonEmpty && operands.forall(_.isValidInt)

  // Calculate the greatest common divisor (GCD) of two integers and return the result in a sequence
  override protected def execute(operands: Seq[Double]): Seq[Double] = Seq(gcd(operands.head, operands.last))

  // A private helper method that actually calculates the GCD
  private def gcd(firstElement: Double, secondElement: Double): Double = {
    Try {
      if (secondElement == 0) firstElement
      else gcd(secondElement, firstElement % secondElement)
    } match {
      case Success(result) => result
      case Failure(exception) => throw CalculatorException(s"Unexpected Exception Occurred : ${exception.getMessage}")
    }
  }
}
