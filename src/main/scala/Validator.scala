package com.knoldus

trait Validator {
  // Validate the operands for the specific operator
  def validate(operands: Seq[Double]): Boolean
}

trait Operator extends Validator {
  // This method will validate the operands and execute it.
  // Throw CalculatorException when validation fails.
  def validateAndExecute(operands: Seq[Double]): Seq[Double] = {
    if (validate(operands)) {
      execute(operands)
    } else {
      throw CalculatorException("Validation Failed !")
    }
  }

  // This method consist of execution logic or process
  protected def execute(operands: Seq[Double]): Seq[Double]
}



