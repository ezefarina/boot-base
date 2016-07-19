package com.fourfinance.loan.service;

import com.fourfinance.loan.service.common.dto.LoanApplicationDto;

import java.util.List;

public interface LoanApplicationService {

  List<LoanApplicationDto> getTodaysIpApplications(String ip);
  List<LoanApplicationDto> getAll();
  LoanApplicationDto save (LoanApplicationDto loanApplicationDto);

}
