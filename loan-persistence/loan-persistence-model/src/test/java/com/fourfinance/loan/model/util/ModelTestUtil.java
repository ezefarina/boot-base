package com.fourfinance.loan.model.util;

import com.fourfinance.loan.model.entity.LoanApplication;
import com.fourfinance.loan.model.repository.LoanApplicationRepository;
import com.fourfinance.loan.model.entity.Person;
import com.fourfinance.loan.model.repository.PersonRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Random;

@Component
public class ModelTestUtil {

  @Resource
  private PersonRepository personRepository;
  @Resource
  private LoanApplicationRepository loanApplicationRepository;

  private Random random = new Random();

  public Person createPerson () {
    Person person = new Person()
        .setFirstName(RandomStringUtils.randomAlphabetic(10))
        .setLastName(RandomStringUtils.randomAlphabetic(10))
        .setIdentificationNumber(RandomStringUtils.randomNumeric(10));
    return personRepository.save(person);
  }

  public LoanApplication createLoanApplication (Person person, LocalDateTime dateTime, String ip) {
    LoanApplication loanApplication = new LoanApplication()
        .setApproved(true)
        .setPerson(person)
        .setDatetime(dateTime)
        .setIp(ip)
        .setAmount(random.nextDouble());
    return loanApplicationRepository.save(loanApplication);
  }

  public LoanApplication createLoanApplication () {
    return createLoanApplication(createPerson(), LocalDateTime.now(), RandomStringUtils.randomNumeric(10));
  }

  public LocalDateTime setDayStartBoundary(LocalDateTime dateTime) {
    return dateTime.withHourOfDay(0)
        .withMinuteOfHour(0)
        .withSecondOfMinute(0)
        .withMillisOfSecond(0);
  }

  public LocalDateTime setDayEndBoundary(LocalDateTime dateTime) {
    return dateTime.withHourOfDay(23)
        .withMinuteOfHour(59)
        .withSecondOfMinute(59)
        .withMillisOfSecond(999);
  }

}
