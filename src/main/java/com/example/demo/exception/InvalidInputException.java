package com.example.demo.exception;

public class InvalidInputException extends RuntimeException {
  private String someField;

  public InvalidInputException(String message) {
    super(message);
  }

  public InvalidInputException(String message, String someField) {
    super(message);
    this.someField = someField;
  }

  public String getSomeField() {
    return someField;
  }
}
