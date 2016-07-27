package com.fourfinance.loan.service.approval;

import com.fourfinance.loan.service.common.dto.LoanApplicationDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AmountApprovalStep extends ApprovalStep {

  @Value("${approval.amount.max}")
  private Double maxAmountAllowed;

  @Override
  public boolean approve(LoanApplicationDto loanApplicationDto) {
    return loanApplicationDto.getAmount()<=maxAmountAllowed;
  }

  @Override
  protected String getReason() {
    return "Max amount requested rejection";
  }

}
