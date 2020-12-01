package com.example;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    SimpleCalculator simpleCalculator = new SimpleCalculator();
    Scanner scanner = new Scanner(System.in);
    int version;
    System.out.println(
      "1. Simple Calculator\n" + "2. Rounded Calculator");
    while (true) {
      switch (scanner.nextInt()) {
        case 1:
          System.out.println("SimpleCalculator");
          System.out.println("= " + simpleCalculator.calc(scanner));
          break;
        case 2:
          System.out.println("RoundedCalculator");
          break;
        default:
        System.out.println("Default");
          break;
        }
    }

  }
}
