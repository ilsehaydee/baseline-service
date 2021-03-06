package mx.tis.com.application.service.imp;

import org.springframework.stereotype.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import mx.tis.com.application.service.CompoundInterestCalculator;
import mx.tis.com.dto.InitialInvestmentDto;
import mx.tis.com.dto.InvestmentYieldDto;
import java.util.ArrayList;
@Service
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


  @HystrixCommand(commandKey = "createRevenueGrid", fallbackMethod = "fallbackRevenueGrid")
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

  public ArrayList<InvestmentYieldDto> fallbackRevenueGrid(InitialInvestmentDto initialInvestmentDto) {
    return null;
  }
}
