package com.cg.laps.dao;

import java.util.ArrayList;

import com.cg.laps.bean.LoanApplicationBean;
import com.cg.laps.bean.LoanProgramsOfferedBean;

public interface ILoanProcessingDao {

	public String checkLogin(String userId, String password);

	ArrayList<LoanProgramsOfferedBean> display();

	ArrayList<LoanApplicationBean> viewApplicationList();
}
