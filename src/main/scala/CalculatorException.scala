package com.knoldus

//  This message provides additional information about the error that caused the exception to be thrown
case class CalculatorException(message: String) extends Exception(message)