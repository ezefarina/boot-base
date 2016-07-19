package com.fourfinance.loan.service.approval;

import com.fourfinance.loan.service.common.dto.LoanApplicationDto;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TimeApprovalStep extends ApprovalStep {

  @Value("${approval.time.hourBoundary}")
  private int allowedHourBoundary;

  @Value("${approval.amount.max}")
  private Double maxAmountAllowed;

  @Override
  public boolean approve(LoanApplicationDto loanApplicationDto) {
    LocalDateTime current = LocalDateTime.now();
    boolean isValidTime = current.isBefore(current.withHourOfDay(allowedHourBoundary)
        .withMinuteOfHour(0)
        .withSecondOfMinute(0)
        .withMillisOfSecond(0));
    boolean isMaxAmount = loanApplicationDto.getAmount().equals(maxAmountAllowed);
    return !(!isValidTime && isMaxAmount);
  }

  @Override
  protected String getReason() {
    return "Max amount requested in the incorrect time frame";
  }

}
