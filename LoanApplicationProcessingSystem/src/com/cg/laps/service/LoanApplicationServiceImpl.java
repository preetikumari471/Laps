package com.cg.laps.service;

import com.cg.laps.bean.LoanApplicationBean;
import com.cg.laps.dao.CustomerDaoImpl;
import com.cg.laps.dao.LoanApplicationDaoImpl;

public class LoanApplicationServiceImpl implements ILoanApplicationService{

	static LoanApplicationDaoImpl loanApplicationDao;

	public static int addApplicationDetails(LoanApplicationBean loanApplication) {
		loanApplicationDao=new LoanApplicationDaoImpl();
		return loanApplicationDao.addApplicationDetails(loanApplication);
		
	}

}
