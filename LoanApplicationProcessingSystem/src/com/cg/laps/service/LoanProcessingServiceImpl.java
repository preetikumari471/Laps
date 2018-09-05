package com.cg.laps.service;

import java.util.ArrayList;

import com.cg.laps.bean.LoanProgramsOfferedBean;
import com.cg.laps.dao.LoanProcessingDaoImpl;

public class LoanProcessingServiceImpl implements ILoanProcessingService{
	
	 static LoanProcessingDaoImpl loanProcessingDao=null;
	 
	 @Override
	 public String checkLogin(String userId, String password) {
				loanProcessingDao = new LoanProcessingDaoImpl();
				return loanProcessingDao.checkLogin(userId, password);
		}
	 

	 @Override
	 public  ArrayList<LoanProgramsOfferedBean> display() {
		 		loanProcessingDao = new LoanProcessingDaoImpl();
		 		return loanProcessingDao.display();
				
		
	}

	
		
		


}
