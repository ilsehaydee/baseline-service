package mx.tis.com.application.controller;

import mx.tis.com.application.service.CompoundInterestCalculator;
import mx.tis.com.application.service.imp.CompoundInterestCalculatorImpl;
import mx.tis.com.dto.InitialInvestmentDto;

public class ApplicationController {

  private static CompoundInterestCalculator calculator = new CompoundInterestCalculatorImpl();

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    InitialInvestmentDto initialInvestmentDto =
        new InitialInvestmentDto(5000.00, 3000.00, 1, (float) 0.21, 5);
    calculator.createRevenueGrid(initialInvestmentDto);
  }

}
