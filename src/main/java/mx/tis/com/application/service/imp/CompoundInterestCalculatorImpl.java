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
import mx.tis.com.application.service.CompoundInterestCalculator;
import mx.tis.com.dto.InitialInvestmentDto;
import mx.tis.com.dto.InvestmentYieldDto;


public class CompoundInterestCalculatorImpl implements CompoundInterestCalculator {

  @Override
  public boolean validateInput(InitialInvestmentDto initialInvestment) {
    
    this.setValuesAsDefault(initialInvestment);
    
boolean isValid = true;

isValid = isValid && (initialInvestment.getInitialInvestment() >= 1000);
isValid = isValid && (initialInvestment.getYearlyInput() >= 0.0);
isValid = isValid && (initialInvestment.getYearlyInputIncrement() >= 0);
isValid = isValid && (initialInvestment.getInvestmentYears() > 0.0);
isValid = isValid && (initialInvestment.getInvestmentYield() > 0.0);

return isValid;

  }

  public void setValuesAsDefault(InitialInvestmentDto initialInvestment) {
    Double yearlyInput = initialInvestment.getYearlyInput();
    yearlyInput = yearlyInput == null ? 0.0 : yearlyInput;
    initialInvestment.setYearlyInput(yearlyInput);

    Integer yearlyInputIncrement = initialInvestment.getYearlyInputIncrement();
    yearlyInputIncrement = yearlyInputIncrement == null ? 0 : yearlyInputIncrement;
    initialInvestment.setYearlyInputIncrement(yearlyInputIncrement);
  }


  public ArrayList<InvestmentYieldDto> createRevenueGrid(
      InitialInvestmentDto initialInvestmentDto) {
    Integer investmentYear = 0;
    Double initialInvestment = 0.00;
    Double yearlyInput = 0.00;
    Double investmentYield = 0.00;
    Double finalBalance = 0.00;

    ArrayList<InvestmentYieldDto> investmentYieldList = new ArrayList<>();


    double savedValue = 0.00;


    for (int index = 0; index < initialInvestmentDto.getInvestmentYears(); index++) {
      investmentYear = index + 1;
      yearlyInput = initialInvestmentDto.getYearlyInput() + savedValue;
      savedValue += yearlyInput * initialInvestmentDto.getYearlyInputIncrement() / 100;
      savedValue = Math.ceil(savedValue);

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
