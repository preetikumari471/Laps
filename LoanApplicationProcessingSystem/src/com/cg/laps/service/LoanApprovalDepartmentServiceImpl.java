package com.cg.laps.service;

import java.util.ArrayList;

import com.cg.laps.bean.LoanApplicationBean;
import com.cg.laps.dao.LoanApprovalDepartmentDaoImpl;
import com.cg.laps.dao.LoanProcessingDaoImpl;

public class LoanApprovalDepartmentServiceImpl implements ILoanApprovalDepartmentService{

	LoanProcessingDaoImpl loanDao=null;
	LoanApprovalDepartmentDaoImpl loanApprovalDao=null;
	@Override
	public String checkLogin(String userId, String password) {
		loanDao = new LoanProcessingDaoImpl();
		return loanDao.checkLogin(userId, password);
	}
	
	@Override
	public ArrayList<LoanApplicationBean> viewSpecificList(String program) {

		loanApprovalDao = new LoanApprovalDepartmentDaoImpl();
		return loanApprovalDao.viewSpecificList(program);
	}
	

}
