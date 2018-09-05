package com.cg.laps.dao;

import java.util.ArrayList;

import com.cg.laps.bean.LoanApplicationBean;

public interface ILoanApprovalDepartmentDao {

	ArrayList<LoanApplicationBean> viewSpecificList(String program);

}
