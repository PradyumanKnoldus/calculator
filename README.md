# Calculator

This is a simple calculator program that supports several operators including addition, subtraction, multiplication, division, exponentiation, square root, factorial, finding the sum, greatest common divisor, finding odd and even numbers, and generating the Fibonacci series. It also includes additional methods to check whether a given expression satisfies a certain mathematical property, find numbers whose factorial is greater than a certain number, and find the average after performing a chain of operations on a sequence of numbers.

## Usage

To use the calculator, you can call the calculate method of the Calculator object, passing in the operator as a string and the operands as a sequence of doubles. For example, to calculate the factorial of 10, you would call:

	Calculator.calculate("!", Seq(10))

The calculate method returns a Future[Seq[Double]] object, which you can use to retrieve the result of the calculation once it is complete.

## Operators

The calculator supports the following operators:

    +: Addition of two operands
    -: Subtraction of the second operand from the first operand
    *: Multiplication of two operands
    /: Division of the first operand by the second operand
    ^: Exponentiation where the first operand is raised to the power of the second operand or first operand should be multiplied second operand times.
    sqrt: Square root of the operand
    !: Factorial of the operand
    sum: Sum of all the operands
    gcd: Greatest common divisor of two operands
    odd: All the odd operands
    even: All the even operands
    fibonacci: Fibonacci series till operand. Let’s say if operand is 5 then the result should have first 5 Fibonacci numbers

## Additional Methods

The calculator also includes the following additional methods:

### squareOfExpression

This method checks whether the expression (firstOperand + secondOperand) ^ 2 == (firstOperand ^ 2) + (secondOperand ^ 2) + (2 * firstOperand * secondOperand) is true or false. If the expression is true, the method returns "Equal", otherwise it returns "Not Equal". To use this method, call:


	squareOfExpression(firstOperand: Double, secondOperand: Double)

### find

This method finds the numbers from a given sequence whose factorial is greater than 6 ^ number. To use this method, call:


	find(numbers: Seq[Double])

This method returns a Future[Seq[Double]] object, which you can use to retrieve the result of the calculation once it is complete.

### findAverageAfterChainingOperations

This method first finds the Fibonacci series for each number in a given sequence, then finds the odd numbers from the resulting sequence, and finally returns their sum. After performing this operation on each number in the sequence, it finds the average. To use this method, call:

	findAverageAfterChainingOperations(numbers: Seq[Double])

This method returns a Future[Double] object, which you can use to retrieve the result of the calculation once it is complete.
Error Handling

If the operands provided to an operator are not valid, the calculator will throw a CalculatorException.

## How to Run

To run this code, follow these steps:

    - Make sure you have Scala and sbt (Scala build tool) installed on your computer.
    - Clone or download the repository to your local machine.
    - Open a terminal or command prompt and navigate to the project directory.
    - Run the command "sbt run" to run the project.
    - The program will ask for the operator and operands to be entered through the console.
    - Enter the values as required and hit enter.
    - The result will be displayed on the console.

