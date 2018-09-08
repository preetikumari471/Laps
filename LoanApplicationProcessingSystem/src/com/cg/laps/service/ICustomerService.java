package com.cg.laps.service;

import com.cg.laps.bean.CustomerBean;
import com.cg.laps.bean.LoanApplicationBean;

public interface ICustomerService {

	String viewApplicationStatus();

	boolean addPersonalDetails(CustomerBean customer);

	int addApplicationDetails(LoanApplicationBean loanApplication);

	String viewApplicationStatus(int appid);

}
