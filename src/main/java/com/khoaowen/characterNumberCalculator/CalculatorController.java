package com.khoaowen.characterNumberCalculator;

import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

  private final CalculatorService service = new CalculatorService();

  @PostMapping
  public int calculateCharacterNumber(@RequestBody String date) {
    return service.calculateNumberFromBirthday(date);

  }

}
