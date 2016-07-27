package com.fourfinance.loan.service.approval;

import com.fourfinance.loan.service.LoanApplicationService;
import com.fourfinance.loan.service.common.dto.LoanApplicationDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ApplicationsLimitApprovalStep extends ApprovalStep {

  @Value("${approval.ip.max}")
  private int maxPerIpAllowed;

  @Resource
  private LoanApplicationService loanApplicationService;

  @Override
  public boolean approve(LoanApplicationDto loanApplicationDto) {
    List<LoanApplicationDto> ipLoanApplications = loanApplicationService.getTodaysIpApplications(loanApplicationDto.getIp());
    return ipLoanApplications.size()<maxPerIpAllowed;
  }

  @Override
  protected String getReason() {
    return "IP max amount of applications rejection";
  }

}
