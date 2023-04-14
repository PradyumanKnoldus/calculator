package com.knoldus
package mathematicalOperators

import scala.annotation.tailrec
import scala.util.{Failure, Success, Try}

class SumOperator extends Operator {

  // Validate if the given sequence is non-empty and returns true if it is, otherwise false
  override def validate(operands: Seq[Double]): Boolean = operands.nonEmpty

  // Calculate the sum of the given Sequence of integers and return the result in sequence
  override protected def execute(operands: Seq[Double]): Seq[Double] = Seq(sum(operands))

  // A private helper method that actually sums up all the elements of the input sequence recursively by adding the head of the sequence to the accumulator and calling the method again with the tail of the sequence
  private def sum(operands: Seq[Double]): Double = {
    Try {
      @tailrec
      def sumHelper(operands: Seq[Double], accumulator: Double = 0.0): Double = {
        if (operands.isEmpty) accumulator
        else sumHelper(operands.tail, accumulator + operands.head)
      }

      sumHelper(operands)
    } match {
      case Success(result) => result
      case Failure(exception) => throw CalculatorException(s"Unexpected Exception Occurred : ${exception.getMessage}")
    }
  }
}

