package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class SimpleCalculator {
  private ArrayList<Token> operations;

  SimpleCalculator() {
    operations = new ArrayList<Token>();
  }

  public ArrayList<Token> getOperationsList() {
    return operations;
  }

  private Token getLastOperation() {
    return (operations.size() != 0)?
      operations.get(operations.size() -1):
      new Token(TokenType.NULL, null);
  }

  public double getDouble(Scanner scanner) {
    final Token LAST_OPERATION = getLastOperation();
    if (LAST_OPERATION.getType() == TokenType.NUMBER) {
      System.out.print((double) LAST_OPERATION.getObject());
    }
    System.out.print(AnsiColor.CYAN + "> " + AnsiColor.RESET);
    double num;
    if (scanner.hasNextDouble()) {
      num = scanner.nextDouble();
    } else {
      System.out.println("Only numbers are supported");
      scanner.next();
      num = getDouble(scanner);
    }
    operations.add(new Token(TokenType.NUMBER, (Object) num));
    return num;
  }

  public Token getOperation(Scanner scanner) {
    System.out.print(AnsiColor.PURPLE + "> " + AnsiColor.RESET);
    Token operation;
    char ch = scanner.next().charAt(0);
    operation = (ch == '+' || ch == '-' || ch == '*' || ch == '/')? new Token(TokenType.OPERATION, (Object) ch): getOperation(scanner);
    operations.add(operation);
    return operation;
  }

  public double calc(Scanner scanner) {
    double num1 = getDouble(scanner);
    char operation = (char) getOperation(scanner).getObject();
    double num2 = getDouble(scanner);
    double result = 0;
    switch (operation) {
      case '+':
        result = num1 + num2;
        break;
      case '-':
        result = num1 - num2;
        break;
      case '*':
        result = num1 * num2;
        break;
      case '/':
        result = num1 / num2;
        break;
    }
    operations.add(new Token(TokenType.NUMBER, (Object) result));
    return result;
  }

}