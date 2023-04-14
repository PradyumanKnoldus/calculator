package com.knoldus

import additionalOperations.MathematicalOperations

import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object CalculatorDriver extends App {

  // Addition Operator
  Calculator.calculate("+", Seq(2, 3)) onComplete {
    case Success(result) => println(s"Addition : ${result.head}")
    case Failure(exception) => println(s"Addition : ${exception.getMessage}")
  }

  // Subtraction Operator
  Calculator.calculate("-", Seq(6, 3)) onComplete {
    case Success(result) => println(s"Subtraction : ${result.head}")
    case Failure(exception) => println(s"Subtraction : ${exception.getMessage}")
  }

  // Multiplication Operator
  Calculator.calculate("*", Seq(4, 9)) onComplete {
    case Success(result) => println(s"Multiplication : ${result.head}")
    case Failure(exception) => println(s"Multiplication : ${exception.getMessage}")
  }

  // Division Operator
  Calculator.calculate("/", Seq(6, 2)) onComplete {
    case Success(result) => println(s"Division : ${result.head}")
    case Failure(exception) => println(s"Division : ${exception.getMessage}")
  }

  // Power Operator
  Calculator.calculate("^", Seq(2, 3)) onComplete {
    case Success(result) => println(s"Power : ${result.head}")
    case Failure(exception) => println(s"Power : ${exception.getMessage}")
  }

  // SquareRoot Operator
  Calculator.calculate("sqrt", Seq(25)) onComplete {
    case Success(result) => println(s"Square Root : ${result.head}")
    case Failure(exception) => println(s"Square Root : ${exception.getMessage}")
  }

  // Factorial Operator
  Calculator.calculate("!", Seq(7)) onComplete {
    case Success(result) => println(s"Factorial : ${result.head}")
    case Failure(exception) => println(s"Factorial : ${exception.getMessage}")
  }

  // Sum Operator
  Calculator.calculate("sum", Seq(2, 3, 4, 9)) onComplete {
    case Success(result) => println(s"Sum : ${result.head}")
    case Failure(exception) => println(s"Sum : ${exception.getMessage}")
  }

  // GCD Operator
  Calculator.calculate("gcd", Seq(2, 6, 4, 8)) onComplete {
    case Success(result) => println(s"Greatest Common Divisor: ${result.head}")
    case Failure(exception) => println(s"Greatest Common Divisor : ${exception.getMessage}")
  }

  // Odd Operator
  Calculator.calculate("odd", Seq(1, 2, 4, 5, 6, 8, 11, 12, 13)) onComplete {
    case Success(result) => println(s"Odd Values : $result")
    case Failure(exception) => println(s"Odd Values : ${exception.getMessage}")
  }

  // Even Operator
  Calculator.calculate("even", Seq(1, 2, 4, 5, 6, 8, 11, 12, 13)) onComplete {
    case Success(result) => println(s"Even Values : $result")
    case Failure(exception) => println(s"Even Values : ${exception.getMessage}")
  }

  // Fibonacci Operator
  Calculator.calculate("fibonacci", Seq(8)) onComplete {
    case Success(result) => println(s"Fibonacci Series : $result")
    case Failure(exception) => println(s"Fibonacci : ${exception.getMessage}")
  }

  // Additional Operations

  private val mathematicalOperations = new MathematicalOperations

  // Square Of Expression Method
  private val squareOfExpressions = mathematicalOperations.squareOfExpression(2, 4)

  println(s"Square Of Expressions : $squareOfExpressions")

  // Find Method - To find the numbers whose factorial is greater than 6 ^ number
  private val find = mathematicalOperations.find(Seq(3, 4, 5, 6, 7))

  find onComplete {
    case Success(result) => println(s"The numbers whose factorial is greater than 6 ^ number : $result")
    case Failure(exception) => println(exception.getMessage)
  }

  // FindAverageAfterChainingOperations Method
  private val averageAfterChainingOperations = mathematicalOperations.findAverageAfterChainingOperations(Seq(3, 4, 5, 6, 7))

  averageAfterChainingOperations onComplete {
    case Success(result) => println(s"AverageAfterChainingOperations : $result")
    case Failure(exception) => println(s"AverageAfterChainingOperations : ${exception.getMessage}")
  }

}
