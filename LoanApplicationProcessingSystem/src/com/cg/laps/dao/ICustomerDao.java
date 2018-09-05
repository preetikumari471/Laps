package com.cg.laps.dao;

import com.cg.laps.bean.CustomerBean;
import com.cg.laps.bean.LoanApplicationBean;

public interface ICustomerDao {

	boolean addPersonalDetails(CustomerBean customer);

	int addApplicationDetails(LoanApplicationBean loanApplication);

	String viewApplicationStatus(int appid);

}
