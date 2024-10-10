# CALCULATOR API

Calculator API is a RESTful application built with **Java** and **Spring Boot**
that performs mathematical operations such as square root, addition, multiplication,
and many others. The operations are executed when values are passed as parameters in the URL, and the API returns the result of the desired operation.

## Features

Available operations:
* **SUM** (sum/{n1}/{n2}): Returns the sum of two numbers.
* **SUBTRACTION** (subtract/{n1}/{n2}): Returns the difference between two numbers.
* **MULTIPLICATION** (multiply/{n1}/{n2}): Returns the product of two numbers.
* **DIVISION** (divide/{n1}/{n2}): Returns the quotient of two numbers.
* **SQUARE ROOT** (sqrt/{n1}): Returns the square root of a number.

## Validations

* All parameters are validated to ensure that the values are numeric. Otherwise, a custom exception called `UnsupportedMathOperationException` is thrown with the message, "Please provide a numeric value."

* The API uses the `NumberConverter` method to verify and convert all string parameters to double before processing the operations.

## Exceptions

If an operation receives an invalid parameter (non-numeric), the API will throw an exception of type `UnsupportedMathOperationException`, returning an appropriate error message.

## Examples

### SUM
**Request**
``GET /sum/10/5``

**Response**
``
{ 
    "result"": 15.0
}
``

### Division
**Request**
``GET /div/10/2``

**Response**
``
{
"result"": 5.0
}
``