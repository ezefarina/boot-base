package com.fourfinance;

import com.fourfinance.loan.configuration.LoanApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LoanApplication.class)
@WebAppConfiguration
public class HomeworkApplicationTests {

	@Test
	public void contextLoads() {
	}

}
