package com.fourfinance.loan.service.impl;

import com.fourfinance.loan.model.entity.LoanApplication;
import com.fourfinance.loan.model.repository.LoanApplicationRepository;
import com.fourfinance.loan.service.BaseService;
import com.fourfinance.loan.service.LoanApplicationService;
import com.fourfinance.loan.service.approval.ApprovalStep;
import com.fourfinance.loan.service.common.dto.LoanApplicationDto;
import com.fourfinance.loan.service.exception.LoanRejected;
import com.google.common.base.Preconditions;
import org.dozer.DozerBeanMapper;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoanApplicationServiceImpl extends BaseService<LoanApplicationDto,LoanApplication> implements LoanApplicationService {

  @Resource
  private List<ApprovalStep> approvalSteps;

  @Resource
  private LoanApplicationRepository loanApplicationRepository;

  @Autowired
  public LoanApplicationServiceImpl(final DozerBeanMapper mapper) {
    super(mapper);
  }

  @Override
  public List<LoanApplicationDto> getTodaysIpApplications(String ip) {
    LocalDateTime start = setDayStartBoundary(LocalDateTime.now());
    LocalDateTime end = setDayEndBoundary(LocalDateTime.now());
    return translate(loanApplicationRepository.findByIpAndDatetimeToday(ip, start, end));
  }

  private LocalDateTime setDayStartBoundary(LocalDateTime dateTime) {
    return dateTime.withHourOfDay(0)
        .withMinuteOfHour(0)
        .withSecondOfMinute(0)
        .withMillisOfSecond(0);
  }

  private LocalDateTime setDayEndBoundary(LocalDateTime dateTime) {
    return dateTime.withHourOfDay(23)
        .withMinuteOfHour(59)
        .withSecondOfMinute(59)
        .withMillisOfSecond(999);
  }

  @Override
  // This is just for testing or demo. Not to be used on prod env
  public List<LoanApplicationDto> getAll() {
    return translate(loanApplicationRepository.findAll());
  }

  @Override
  public LoanApplicationDto save(LoanApplicationDto loanApplicationDto) {
    Preconditions.checkNotNull(loanApplicationDto);
    LoanApplication loanApplication;
    if (loanApplicationDto.getId()==null) {
      loanApplication = new LoanApplication();
    } else {
      loanApplication = loanApplicationRepository.findOne(loanApplicationDto.getId());
    }
    copyProperties(loanApplicationDto, loanApplication);
    boolean approval = runApprovalProcedure(loanApplicationDto);
    loanApplication.setApproved(approval);
    loanApplication = loanApplicationRepository.save(loanApplication);
    if (!approval) {
      throw new LoanRejected();
    } else {
      return translate(loanApplication);
    }
  }

  private boolean runApprovalProcedure (LoanApplicationDto loanApplicationDto) {
    for (ApprovalStep approvalStep : approvalSteps) {
      if (!approvalStep.approve(loanApplicationDto))
        return false;
    }
    return true;
  }

}
