/*
 * This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, version 3.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * Nombre de archivo: CompoundInterestCalculatorImpl.java Autor: ilsegonzalez Fecha de creación: Sep 8,
 * 2021
 */

package mx.tis.com.application.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.math.*;
import mx.tis.com.application.service.CompoundInterestCalculator;
import mx.tis.com.dto.InitialInvestmentDto;
import mx.tis.com.dto.InvestmentYieldDto;


public class CompoundInterestCalculatorImpl implements CompoundInterestCalculator {

  @Override
  public boolean validateInput(InitialInvestmentDto input) {
    return (input.getInitialInvestment() > 1000.00);
  }



  public ArrayList<InvestmentYieldDto> createRevenueGrid(
      InitialInvestmentDto initialInvestmentDto) {
    Integer investmentYear = 0;
    Double initialInvestment = 0.00;
    Double yearlyInput = 0.00;
    Double investmentYield = 0.00;
    Double finalBalance = 0.00;

    ArrayList<InvestmentYieldDto> investmentYieldList = new ArrayList<>();


    double aux = 0.00;


    for (int index = 0; index < initialInvestmentDto.getInvestmentYears(); index++) {
      investmentYear = index + 1;
      yearlyInput = initialInvestmentDto.getYearlyInput() + aux;
      aux += yearlyInput * initialInvestmentDto.getYearlyInputIncrement() / 100;
      aux = Math.ceil(aux);
      System.out.println(aux);

      if (index == 0) {

        initialInvestment = initialInvestmentDto.getInitialInvestment();

      } else if (index > 0) {
        initialInvestment = finalBalance;
      }

      investmentYield =
          (initialInvestment + yearlyInput) * initialInvestmentDto.getInvestmentYield();

      finalBalance = initialInvestment + yearlyInput + investmentYield;

      investmentYieldList.add(new InvestmentYieldDto(investmentYear, initialInvestment, yearlyInput,
          investmentYield, finalBalance));
    }

    return investmentYieldList;
  }

}
