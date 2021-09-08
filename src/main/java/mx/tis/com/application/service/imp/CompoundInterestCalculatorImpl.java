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
    // TODO Auto-generated method stub
    return false;
  }


  @Override
  public ArrayList<InvestmentYieldDto> createRevenueGrid(InitialInvestmentDto initialInvestmentDto) {
    ArrayList<InvestmentYieldDto> investmentYieldList= new ArrayList<>();
    InvestmentYieldDto investmentYieldDto = new InvestmentYieldDto();
    double aux = 0.00;

    for (int i = 0; i < initialInvestmentDto.getInvestmentYears(); i++) {
      investmentYieldDto.setInvestmentYear(i + 1);
      investmentYieldDto.setYearlyInput(initialInvestmentDto.getYearlyInput() + aux);
      aux += investmentYieldDto.getYearlyInput()
          * (initialInvestmentDto.getYearlyInputIncrement() / 100);
      aux = Math.ceil(aux);
        if (i == 0) {
  
          investmentYieldDto.setInitialInvestment(initialInvestmentDto.getInitialInvestment());
  
  
        } else if (i > 0) {
          investmentYieldDto.setInitialInvestment(investmentYieldDto.getFinalBalance());
        }
      investmentYieldDto.setInvestmentYield(
          (initialInvestmentDto.getInitialInvestment() + initialInvestmentDto.getYearlyInput())
              * initialInvestmentDto.getInvestmentYield());

      investmentYieldDto.setFinalBalance(investmentYieldDto.getInitialInvestment()
          + investmentYieldDto.getYearlyInput() + investmentYieldDto.getInvestmentYield());


      investmentYieldList.add(investmentYieldDto);
    }
   
    return investmentYieldList;
  }

}
