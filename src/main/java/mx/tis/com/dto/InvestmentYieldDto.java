/* 
* This program is free software: you can redistribute it and/or modify  
* it under the terms of the GNU General Public License as published by  
* the Free Software Foundation, version 3.
*
* This program is distributed in the hope that it will be useful, but 
* WITHOUT ANY WARRANTY; without even the implied warranty of 
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
* General Public License for more details.
*
* Nombre de archivo: InvestmentYieldDto.java
* Autor: ilgonzal
* Fecha de creación: 7 sep. 2021
*/
package mx.tis.com.dto;

import lombok.NoArgsConstructor;

/**
 * Instantiates a new investment yield dto.
 */
@NoArgsConstructor
public class InvestmentYieldDto {
  public Integer investmentYear;
  public Double initialInvestment;
  public Double yearlyInput;
  public Double investmentYield;
  public Double finalBalance;

  public Integer getInvestmentYear() {
    return investmentYear;
  }

  public void setInvestmentYear(Integer investmentYear) {
    this.investmentYear = investmentYear;
  }

  public Double getInitialInvestment() {
    return initialInvestment;
  }

  public void setInitialInvestment(Double initialInvestment) {
    this.initialInvestment = initialInvestment;
  }

  public Double getYearlyInput() {
    return yearlyInput;
  }

  public void setYearlyInput(Double yearlyInput) {
    this.yearlyInput = yearlyInput;
  }

  public Double getInvestmentYield() {
    return investmentYield;
  }

  public void setInvestmentYield(Double investmentYield) {
    this.investmentYield = investmentYield;
  }

  public Double getFinalBalance() {
    return finalBalance;
  }

  public void setFinalBalance(Double finalBalance) {
    this.finalBalance = finalBalance;
  }
}
