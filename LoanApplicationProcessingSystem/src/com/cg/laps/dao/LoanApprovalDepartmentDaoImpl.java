package com.cg.laps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.laps.bean.LoanApplicationBean;
import com.cg.laps.bean.UserBean;
import com.cg.laps.service.ILoanApprovalDepartmentService;
import com.cg.laps.util.DBUtil;
import com.cg.laps.util.IQueryMapper;

public class LoanApprovalDepartmentDaoImpl implements
		ILoanApprovalDepartmentDao {

	String role = null;
	static Connection conn;
	static PreparedStatement preparedstatement = null;
	static ResultSet rs = null;
	static UserBean user = null;

	@Override
	public ArrayList<LoanApplicationBean> viewSpecificList(String program) {

		ArrayList<LoanApplicationBean> loanApplicationList = new ArrayList<LoanApplicationBean>();

		int applicationDetailsCount = 0;
		conn = DBUtil.establishConnection();
		try {
			preparedstatement = conn
					.prepareStatement(IQueryMapper.RETRIEVE_LOAN_SPECIFIC_APPLICATIONS);
			preparedstatement.setString(1, program);
			rs = preparedstatement.executeQuery();
			while (rs.next()) {
				LoanApplicationBean loanApplication = new LoanApplicationBean();
				loanApplication.setApplicationId(rs.getInt(1));
				loanApplication.setApplicationDate(rs.getString(2));
				loanApplication.setLoanProgram(rs.getString(3));
				loanApplication.setLoanAmount(rs.getDouble(4));
				loanApplication.setPropertyAddress(rs.getString(5));
				loanApplication.setAnnualFamilyIncome(rs.getDouble(6));
				loanApplication.setDocsProof(rs.getString(7));
				loanApplication.setGuaranteeCoverString(rs.getString(8));
				loanApplication.setMarktValOfCover(rs.getDouble(9));
				loanApplication.setStatus(rs.getString(10));
				loanApplication.setInterviewDate(rs.getString(11));
				loanApplicationList.add(loanApplication);
				applicationDetailsCount++;
			}
			if (applicationDetailsCount == 0)
				return null;
			else
				return loanApplicationList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public int changeStatus(int opt, int applicationId) {
		int update = 0;

		conn = DBUtil.establishConnection();
		try {
			switch (opt) {
			case 1:
				preparedstatement = conn
						.prepareStatement(IQueryMapper.UPDATE_QUERY_APPLICATION_STATUS_ACCEPT);
				break;

			case 2:
				preparedstatement = conn
						.prepareStatement(IQueryMapper.UPDATE_QUERY_APPLICATION_STATUS_APPROVE);
				break;

			case 3:
				preparedstatement = conn
						.prepareStatement(IQueryMapper.UPDATE_QUERY_APPLICATION_STATUS_REJECT);
				break;
			}
			preparedstatement.setInt(1, applicationId);
			update = preparedstatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return update;
	}

}
