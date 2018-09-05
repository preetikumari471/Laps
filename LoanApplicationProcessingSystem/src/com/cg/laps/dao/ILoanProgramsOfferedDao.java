package com.cg.laps.dao;

import com.cg.laps.bean.LoanProgramsOfferedBean;

public interface ILoanProgramsOfferedDao {

	int addLoanPrograms(LoanProgramsOfferedBean loanProgramsOffered);

	int deleteLoanPrograms(String dltprogram);

}
