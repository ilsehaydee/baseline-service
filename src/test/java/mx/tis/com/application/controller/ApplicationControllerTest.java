package mx.tis.com.application.controller;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import mx.tis.com.application.service.CompoundInterestCalculator;
import mx.tis.com.application.service.imp.CompoundInterestCalculatorImpl;
import mx.tis.com.dto.InitialInvestmentDto;
import mx.tis.com.dto.InvestmentYieldDto;

public class ApplicationControllerTest {
private ApplicationController controller;
  
  /** The initial investment. */
  private InitialInvestmentDto initialInvestment;
  
  /** The calculator. */
  private CompoundInterestCalculator calculator;

  /**
   * Creates the values before to test.
   */
  @Before
  public void createValuesBeforeToTest() {
    // Crear una calculadora
    this.calculator = new CompoundInterestCalculatorImpl();
    this.controller = new ApplicationController(this.calculator);

    // Crear los valores iniciales de la inversion
    this.initialInvestment = new InitialInvestmentDto();

    this.initialInvestment.setInitialInvestment(5000.00);
    this.initialInvestment.setYearlyInput(3000.00);
    this.initialInvestment.setYearlyInputIncrement(1);
    this.initialInvestment.setInvestmentYears(5);
    this.initialInvestment.setInvestmentYield(21f);
  }

  /**
   * Should generate table yield.
   */
  @Test
  public void shouldGenerateTableYield() {

    List<InvestmentYieldDto> tableYield = controller.createTableYield("application/json", initialInvestment);

    assertEquals(5, tableYield.size());
    
    InvestmentYieldDto firstYear =  tableYield.get(0);
    assertEquals(Double.valueOf(5000.00), firstYear.getInitialInvestment());
    assertEquals(Double.valueOf(3000.00), firstYear.getYearlyInput());
    assertEquals(Double.valueOf(1680.00), firstYear.getInvestmentYield());
    assertEquals(Double.valueOf(9680.00), firstYear.getFinalBalance());
  }

}

