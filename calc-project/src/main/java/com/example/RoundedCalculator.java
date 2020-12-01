package com.example;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class RoundedCalculator extends SimpleCalculator {
  DecimalFormat df;
  RoundedCalculator(int roundLen) {
    super();
    df = new DecimalFormat("#.####");
    df.setRoundingMode(RoundingMode.CEILING);
  }
}
