/*
 * This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, version 3.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * Nombre de archivo: InitialInvestmentDto.java Autor: ilgonzal Fecha de creación: 7 sep. 2021
 */
package mx.tis.com.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;


@AllArgsConstructor


@ToString
public class InitialInvestmentDto {


  public Double initialInvestment;


  public Double yearlyInput;


  public Integer yearlyInputIncrement;


  public Float investmentYield;


  public Integer investmentYears;


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

  public Integer getYearlyInputIncrement() {
    return yearlyInputIncrement;
  }

  public void setYearlyInputIncrement(Integer yearlyInputIncrement) {
    this.yearlyInputIncrement = yearlyInputIncrement;
  }

  public Float getInvestmentYield() {
    return investmentYield;
  }


  public void setInvestmentYield(Float investmentYield) {
    this.investmentYield = investmentYield;
  }


  public Integer getInvestmentYears() {
    return investmentYears;
  }


  public void setInvestmentYears(Integer investmentYears) {
    this.investmentYears = investmentYears;
  }
}
