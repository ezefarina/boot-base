package com.fourfinance.loan.service.approval;

import com.fourfinance.loan.service.common.dto.LoanApplicationDto;
import com.fourfinance.loan.service.exception.LoanRejected;

public abstract class ApprovalStep {

  public abstract boolean approve (LoanApplicationDto loanApplicationDto) throws LoanRejected;
  protected abstract String getReason();

}
