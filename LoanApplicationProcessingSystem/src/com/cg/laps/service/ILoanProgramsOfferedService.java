package com.cg.laps.service;

import com.cg.laps.bean.LoanProgramsOfferedBean;

public interface ILoanProgramsOfferedService {

	int addLoanProgramsOffered(LoanProgramsOfferedBean loanProgramsOffered);

	int deleteLoanProgramsOffered(String dltprogram);

}
