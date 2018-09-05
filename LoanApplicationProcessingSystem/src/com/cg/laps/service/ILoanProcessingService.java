package com.cg.laps.service;

import java.util.ArrayList;

import com.cg.laps.bean.LoanProgramsOfferedBean;

public interface ILoanProcessingService {

	

	String checkLogin(String userId, String password);

	 ArrayList<LoanProgramsOfferedBean> display();

	

	


}
