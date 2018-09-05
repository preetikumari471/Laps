package com.cg.laps.service;
import com.cg.laps.bean.LoanProgramsOfferedBean;
import com.cg.laps.dao.LoanProgramsOfferedDaoImpl;


public class LoanProgramsOfferedServiceImpl implements ILoanProgramsOfferedService{
		static LoanProgramsOfferedDaoImpl loanProgramsOfferedDao=null;


		@Override
		public int addLoanProgramsOffered(
				LoanProgramsOfferedBean loanProgramsOffered) {
			
			loanProgramsOfferedDao = new LoanProgramsOfferedDaoImpl();
			return loanProgramsOfferedDao.addLoanPrograms(loanProgramsOffered);	
			
		}

		@Override
		public int deleteLoanProgramsOffered(String dltprogram) {
			
			loanProgramsOfferedDao = new LoanProgramsOfferedDaoImpl();
			return loanProgramsOfferedDao.deleteLoanPrograms(dltprogram);
		
		}

		
}
