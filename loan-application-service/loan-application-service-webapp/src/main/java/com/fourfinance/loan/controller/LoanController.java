package com.fourfinance.loan.controller;

import com.fourfinance.loan.service.LoanApplicationService;
import com.fourfinance.loan.service.PersonService;
import com.fourfinance.loan.service.common.dto.LoanApplicationDto;
import com.fourfinance.loan.service.common.dto.NewLoanApplicationDto;
import com.fourfinance.loan.service.common.dto.PersonDto;
import com.fourfinance.loan.service.exception.LoanRejected;
import com.google.common.collect.Sets;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Set;
import java.util.stream.Collectors;

import static org.joda.time.LocalDateTime.*;

@Controller
public class LoanController implements BaseController {

  @Resource
  private LoanApplicationService loanApplicationService;

  @Resource
  private PersonService personService;

  private static final Integer NEW_LOAN_STEP = 0;
  private static final Integer NEW_LOAN_EXTENDED_STEP = 1;

  @RequestMapping(value = "/")
  public String list(Model model) {
    model.addAttribute("applications",loanApplicationService.getAll());
    model.addAttribute("module", "list");
    model.addAttribute("fragment", "list");
    return "main";
  }

  @RequestMapping(value = "/new", method = RequestMethod.GET)
  public String newApplicationGet(Model model) {
    model.addAttribute("newLoanApplicationDto", new NewLoanApplicationDto().setStep(NEW_LOAN_STEP));
    model.addAttribute("module", "newApplication");
    model.addAttribute("fragment", "newApplicationPhase1");
    return "main";
  }

  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public String newApplicationPost(@Valid @ModelAttribute NewLoanApplicationDto newLoanApplicationDto,
      BindingResult result, Model model, HttpServletRequest request) {
    boolean validationPassed = validationFlowHandler(model, result, newLoanApplicationDto);
    if (!validationPassed) {
      PersonDto person;
      if (NEW_LOAN_EXTENDED_STEP.equals(newLoanApplicationDto.getStep())) {
        person = new PersonDto()
            .setIdentificationNumber(newLoanApplicationDto.getIdentificationNumber())
            .setFirstName(newLoanApplicationDto.getFirstName())
            .setLastName(newLoanApplicationDto.getLastName());
        person = personService.save(person);
      } else {
        person = personService.getByIdentificationNumber(newLoanApplicationDto.getIdentificationNumber());
      }

      if (person == null) {
        model.addAttribute("module", "newApplication");
        model.addAttribute("fragment", "newApplicationPhase2");
        model.addAttribute("newLoanApplicationDto", newLoanApplicationDto.setStep(NEW_LOAN_EXTENDED_STEP));
      } else {
        LoanApplicationDto loanApplicationDto = new LoanApplicationDto()
            .setPerson(person)
            .setAmount(newLoanApplicationDto.getAmount())
            .setDatetime(now())
            .setIp(request.getRemoteAddr());
        loanApplicationService.save(loanApplicationDto);
        return "redirect:/";
      }
    }
    return "main";
  }

  @ExceptionHandler(LoanRejected.class)
  public String handleLoanRejection(LoanRejected lr, Model model) {
    model.addAttribute("loanRejected", true);
    return "redirect:/";
  }

  private boolean validationFlowHandler (Model model, BindingResult result, NewLoanApplicationDto newLoanApplicationDto) {
    boolean output = false;
    Set<String> errorFields=Sets.newHashSet();
    if (result.hasErrors()) {
      errorFields = Sets.newHashSet();
      errorFields.addAll(result.getFieldErrors()
          .stream()
          .map(FieldError::getField)
          .collect(Collectors.toList()));
    }
    crappyValidator(errorFields, newLoanApplicationDto);

    if (!CollectionUtils.isEmpty(errorFields)) {
      output = true;
      model.addAttribute("errorFields", errorFields);
      if (NEW_LOAN_STEP.equals(newLoanApplicationDto.getStep())) {
        model.addAttribute("module", "newApplication");
        model.addAttribute("fragment", "newApplicationPhase1");
      } else {
        model.addAttribute("module", "newApplication");
        model.addAttribute("fragment", "newApplicationPhase2");
      }
    }
    return output;
  }

  private void crappyValidator (Set<String> errorFields, NewLoanApplicationDto newLoanApplicationDto) {
    if (NEW_LOAN_EXTENDED_STEP.equals(newLoanApplicationDto.getStep())) {
      if (StringUtils.trimToNull(newLoanApplicationDto.getFirstName()) == null) {
        errorFields.add("firstName");
      }
      if (StringUtils.trimToNull(newLoanApplicationDto.getLastName()) == null) {
        errorFields.add("lastName");
      }
    }
    if (StringUtils.trimToNull(newLoanApplicationDto.getIdentificationNumber())==null) {
      errorFields.add("identificationNumber");
    }
  }

}
