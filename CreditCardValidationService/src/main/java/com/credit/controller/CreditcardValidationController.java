package com.credit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CreditcardValidationController {

  @GetMapping("/validate")
  public Boolean validateCreditCard(
      @RequestParam("creditCardNumber") Long creditCardNumber) {
    if (creditCardNumber % 2 == 0) {
      return Boolean.TRUE;
    } else {
      return Boolean.FALSE;
    }

  }
}
