package com.fourfinance.loan.model.repository;

import com.fourfinance.loan.model.ModelBaseTest;
import com.fourfinance.loan.model.entity.LoanApplication;
import com.fourfinance.loan.model.entity.Person;
import com.fourfinance.loan.model.util.ModelTestUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.joda.time.LocalDateTime.now;

public class LoanApplicationRepositoryTest extends ModelBaseTest {

  @Resource
  private ModelTestUtil testUtil;

  @Resource
  private LoanApplicationRepository loanApplicationRepository;

  @Test
  public void testFindByIdentificationNumber () {
    String ip = RandomStringUtils.randomNumeric(10);
    Person person = testUtil.createPerson();
    testUtil.createLoanApplication(person, now().plusDays(1), ip);
    LoanApplication createdLoanApplication = testUtil.createLoanApplication(person, now(), ip);
    testUtil.createLoanApplication(person, now().minusDays(1), ip);
    List<LoanApplication> foundLoanApplications = loanApplicationRepository.findByIpAndDatetimeToday(ip, testUtil.setDayStartBoundary(now()), testUtil.setDayEndBoundary(now()));
    assertThat(foundLoanApplications.size(),is(1));
    assertThat(foundLoanApplications.get(0).getId(),is(createdLoanApplication.getId()));
  }

}
