package com.khoaowen.characterNumberCalculator;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import java.util.Map;

public class AwsLambdaHandler  implements RequestHandler<Map<String,String>, Integer> {
  private final CalculatorService service = new CalculatorService();
  @Override
  public Integer handleRequest(Map<String, String> input, Context context) {
    return service.calculateNumberFromBirthday(input.get("date"));
  }
}
