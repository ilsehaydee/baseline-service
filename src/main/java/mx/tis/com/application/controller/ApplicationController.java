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

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import mx.tis.com.application.service.CompoundInterestCalculator;
import mx.tis.com.dto.InitialInvestmentDto;
import mx.tis.com.dto.InvestmentYieldDto;
import java.util.List;


@RestController
public class ApplicationController {


  private static CompoundInterestCalculator calculator; // = new CompoundInterestCalculatorImpl();

  // public static void main(String[] args) {
  // InitialInvestmentDto initialInvestmentDto =
  // new InitialInvestmentDto(5000.00, 3000.00, 1, (float) 0.21, 5);
  //
  // System.out.println(calculator.createRevenueGrid(initialInvestmentDto));
  // }



  public ApplicationController(CompoundInterestCalculator calculator) {
    this.calculator = calculator;
  }

  @PostMapping(value = "/api/v1/investors/calculators/ci")
  public List<InvestmentYieldDto> createTableYield(
      @RequestHeader(value = "Content-Type", required = false) String contentType,
      @RequestBody InitialInvestmentDto initialInvestment) {

    if (calculator.validateInput(initialInvestment)) {
      return calculator.createRevenueGrid(initialInvestment);
    }

    throw new CalculatorInputException("El cálculo no puede ser ejecutado");
  }

}
