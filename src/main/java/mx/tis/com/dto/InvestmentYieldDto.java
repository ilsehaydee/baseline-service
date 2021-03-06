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

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * The Class InvestmentYieldDto.
 */

/**
 * Instantiates a new investment yield dto.
 *
 * @param investmentYear the investment year
 * @param initialInvestment the initial investment
 * @param yearlyInput the yearly input
 * @param investmentYield the investment yield
 * @param finalBalance the final balance
 */
@AllArgsConstructor

/**
 * To string.
 *
 * @return the java.lang. string
 */

/**
 * To string.
 *
 * @return the java.lang. string
 */
@ToString
public class InvestmentYieldDto {
  
  /** The investment year. */
  private Integer investmentYear;
  
  /** The initial investment. */
  private Double initialInvestment;
  
  /** The yearly input. */
  private Double yearlyInput;
  
  /** The investment yield. */
  private Double investmentYield;
  
  /** The final balance. */
  private Double finalBalance;

  /**
   * Gets the investment year.
   *
   * @return the investment year
   */
  public Integer getInvestmentYear() {
    return investmentYear;
  }

  /**
   * Sets the investment year.
   *
   * @param investmentYear the new investment year
   */
  public void setInvestmentYear(Integer investmentYear) {
    this.investmentYear = investmentYear;
  }

  /**
   * Gets the initial investment.
   *
   * @return the initial investment
   */
  public Double getInitialInvestment() {
    return initialInvestment;
  }

  /**
   * Sets the initial investment.
   *
   * @param initialInvestment the new initial investment
   */
  public void setInitialInvestment(Double initialInvestment) {
    this.initialInvestment = initialInvestment;
  }

  /**
   * Gets the yearly input.
   *
   * @return the yearly input
   */
  public Double getYearlyInput() {
    return yearlyInput;
  }

  /**
   * Sets the yearly input.
   *
   * @param yearlyInput the new yearly input
   */
  public void setYearlyInput(Double yearlyInput) {
    this.yearlyInput = yearlyInput;
  }

  /**
   * Gets the investment yield.
   *
   * @return the investment yield
   */
  public Double getInvestmentYield() {
    return investmentYield;
  }

  /**
   * Sets the investment yield.
   *
   * @param investmentYield the new investment yield
   */
  public void setInvestmentYield(Double investmentYield) {
    this.investmentYield = investmentYield;
  }

  /**
   * Gets the final balance.
   *
   * @return the final balance
   */
  public Double getFinalBalance() {
    return finalBalance;
  }

  /**
   * Sets the final balance.
   *
   * @param finalBalance the new final balance
   */
  public void setFinalBalance(Double finalBalance) {
    this.finalBalance = finalBalance;
  }
}
