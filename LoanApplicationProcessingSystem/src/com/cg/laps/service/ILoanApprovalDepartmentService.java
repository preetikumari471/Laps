package com.cg.laps.service;

import java.util.ArrayList;

import com.cg.laps.bean.LoanApplicationBean;

public interface ILoanApprovalDepartmentService {

	String checkLogin(String userId, String password);

	ArrayList<LoanApplicationBean> viewSpecificList(String program);

	int changeStatus(int opt, int applicationId);

}