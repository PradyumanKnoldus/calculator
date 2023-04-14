package com.knoldus
package additionalOperations

import mathematicalOperators._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success, Try}

class MathematicalOperations {

  // Method to calculate the square of the sum of two numbers and the sum of their squares,
  // and compare the two values to return "Equal" or "Not Equal" as a string.
  def squareOfExpression(firstOperand: Double, secondOperand: Double): String = {
    Try {
      val sum = firstOperand + secondOperand
      val square = new PowerOperator().validateAndExecute(Seq(sum, 2)).head
      val sumOfSquares = new PowerOperator().validateAndExecute(Seq(firstOperand, 2)).head + new PowerOperator().validateAndExecute(Seq(secondOperand, 2)).head + 2 * firstOperand * secondOperand

      square == sumOfSquares
    } match {
      case Success(true) => "Equal"
      case Success(false) => "Not Equal"
      case Failure(exception) => s"Failed to Calculate : ${exception.getMessage}"
    }
  }

  // Method to find all numbers in a sequence that have a factorial greater than 6 raised to the power of that number.
  def find(numbers: Seq[Double]): Future[Seq[Double]] = {
    Future {
      numbers.filter { number =>
        Try(new FactorialOperator().validateAndExecute(Seq(number)).head) match {
          case Success(factorial) => factorial > math.pow(6, number)
          case Failure(_) => false
        }
      }
    }.recoverWith {
      case _ => Future.successful(Seq.empty)
    }
  }

  // Method to find the average of the sums of odd numbers in the Fibonacci series
  def findAverageAfterChainingOperations(numbers: Seq[Double]): Future[Double] = {
    val fibonacciOperator = new FibonacciOperator()
    val oddOperator = new OddOperator()
    val sumOperator = new SumOperator()

    val resultFuture: Future[Seq[Double]] = Future {
      numbers.flatMap { number =>
        val fibonacciSeries = fibonacciOperator.validateAndExecute(Seq(number)).filterNot(_ == 0)

        val oddValues = oddOperator.validateAndExecute(fibonacciSeries)

        sumOperator.validateAndExecute(oddValues)
      }
    }

    resultFuture.flatMap { oddSums =>
      Try {
        oddSums.sum / oddSums.length
      } match {
        case Success(result) => Future.successful(result)
        case Failure(ex) => Future.failed(CalculatorException(s"Unexpected Exception : ${ex.getMessage}"))
      }
    }
  }

}
