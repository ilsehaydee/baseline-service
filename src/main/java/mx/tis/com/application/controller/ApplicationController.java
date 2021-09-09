/*
 * This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, version 3.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * Nombre de archivo: ApplicationController.java Autor: ilsegonzalez Fecha de creación: Sep 8, 2021
 */
package mx.tis.com.application.controller;

import java.util.List;
import mx.tis.com.application.service.CompoundInterestCalculator;
import mx.tis.com.application.service.imp.CompoundInterestCalculatorImpl;
import mx.tis.com.dto.InitialInvestmentDto;
import mx.tis.com.dto.InvestmentYieldDto;

/**
 * The Class ApplicationController.
 */
public class ApplicationController {


  /** The calculator. */
  private static CompoundInterestCalculator calculator; // = new CompoundInterestCalculatorImpl();

  // public static void main(String[] args) {
  // InitialInvestmentDto initialInvestmentDto =
  // new InitialInvestmentDto(5000.00, 3000.00, 1, (float) 0.21, 5);
  //
  // System.out.println(calculator.createRevenueGrid(initialInvestmentDto));
  // }



  /**
   * Instantiates a new application controller.
   *
   * @param calculator the calculator
   */
  public ApplicationController(CompoundInterestCalculator calculator) {
    this.calculator = calculator;
  }

  /**
   * Creates the table yield.
   *
   * @param initialInvestment the initial investment
   * @return the list
   */
  public List<InvestmentYieldDto> createTableYield(InitialInvestmentDto initialInvestment) {

    if (calculator.validateInput(initialInvestment)) {
      return calculator.createRevenueGrid(initialInvestment);
    }

    throw new CalculatorInputException("El cálculo no puede ser ejecutado");
  }

}
