package com.khoaowen.characterNumberCalculator;

import static com.khoaowen.characterNumberCalculator.CalculatorService.sumDigits;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.text.DateFormat;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorServiceTest {

  private final CalculatorService calculatorService = new CalculatorService();

  @ParameterizedTest
  @CsvSource({"03/12/2020,1",
      "04/11/2021 ,2",
      "07/02/1988 ,8",
      "22/12/2018 ,9",
      "29/12/2019 ,8"})
  void testCalculateNumber(String input, int expected) {
    assertThat(calculatorService.calculateNumberFromBirthday(input)).isEqualTo(expected);

  }

  @ParameterizedTest
  @CsvSource({"11,11",
      "22 ,22",
      "33 ,33",
      "1, 1",
      "10 ,1",
      "12 ,3",
      "19 ,1",
      "1988 ,8",
      "2018 ,11",
  })
  void testReduceNumber(int input, int expected) {
    assertThat(calculatorService.reduceNumber(input)).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource({"11,2",
      "22 ,4",
      "33 ,6",
      "1, 1",
      "10 ,1",
      "12 ,3",
      "19 ,10",
      "1988 ,26",
      "2018 ,11",
  })
  void testSumDigits(int input, int expected) {
    assertThat(sumDigits(input)).isEqualTo(expected);
  }

}