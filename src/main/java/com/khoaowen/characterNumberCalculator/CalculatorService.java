package com.khoaowen.characterNumberCalculator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Set;

public class CalculatorService {

  private static final String DATE_PATTERN = "dd/MM/yyyy";
  private static final Set<Integer> notReduced = Set.of(11, 22, 33);

  int calculateNumberFromBirthday(String date) {
    final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
    try {
      final Date parsedDate = simpleDateFormat.parse(date);
      LocalDate localDate = parsedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
      return reduceNumber(
              reduceNumber(localDate.getDayOfMonth()) +
              reduceNumber(localDate.getMonthValue()) +
              reduceNumber(localDate.getYear()));


    } catch (ParseException e) {
      throw new IllegalArgumentException("Expected date format: " + DATE_PATTERN);
    }
  }

  int reduceNumber(int number) {
    if (notReduced.contains(number)) {
      return number;
    }
    if (String.valueOf(number).length() == 1) {
      return number;
    }
    return reduceNumber(sumDigits(number));
  }

  /* Function to get sum of digits */
  static int sumDigits(int no) {
    return no == 0 ? 0 : no % 10 +
        sumDigits(no / 10);
  }

}
