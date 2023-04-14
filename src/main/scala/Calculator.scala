package com.knoldus

import mathematicalOperators._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Calculator {
  // Maps the input operator string to an instance of the corresponding Operator class
  def calculate(operator: String, operands: Seq[Double]): Future[Seq[Double]] = {
    val inputOperator = operator match {
      case "+" => new AdditionOperator
      case "-" => new SubtractionOperator
      case "*" => new MultiplicationOperator
      case "/" => new DivisionOperator
      case "^" => new PowerOperator
      case "sqrt" => new SquareRootOperator
      case "!" => new FactorialOperator
      case "sum" => new SumOperator
      case "gcd" => new GcdOperator
      case "odd" => new OddOperator
      case "even" => new EvenOperator
      case "fibonacci" => new FibonacciOperator
      case _ => throw CalculatorException("Invalid Operator")
    }
    // Executes the input operator on the given operands and returns a Future of the result
    execute(inputOperator, operands)
  }

  // Executes the given operator on the given operands and returns a Future of the result
  private def execute(operator: Operator, operands: Seq[Double]): Future[Seq[Double]] = {
    if (!operator.validate(operands)) {
      Future.failed(CalculatorException("Validation Failed !"))
    } else {
      Future {
        operator.validateAndExecute(operands)
      }
    }
  }
}
