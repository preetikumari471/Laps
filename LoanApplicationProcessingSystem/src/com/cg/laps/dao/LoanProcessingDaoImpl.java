package com.cg.laps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.laps.bean.LoanApplicationBean;
import com.cg.laps.bean.LoanProgramsOfferedBean;
import com.cg.laps.bean.UserBean;
import com.cg.laps.util.DBUtil;
import com.cg.laps.util.IQueryMapper;
import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;

public class LoanProcessingDaoImpl implements ILoanProcessingDao {
	String role=null;
	static Connection conn;
	static PreparedStatement preparedstatement=null;
	static ResultSet rs=null;


	@Override
	public String checkLogin(String userId, String password) {
		
		
		try {
			conn = DBUtil.establishConnection();
			preparedstatement = conn.prepareStatement(IQueryMapper.VALID_LOGIN);
			preparedstatement.setString(1, userId);
			preparedstatement.setString(2, password);
			ResultSet rs=preparedstatement.executeQuery();
			while(rs.next())
			{	
				role=rs.getString(1);
				
				/*String userid=rs.getString(1);
				String pwd=rs.getString(2);
				if(userid.equals(userId)&& pwd.equals(password))
				{ 
					role=user.getRole();
					System.out.println(role);
					break;
				}*/
			}

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return role;
	}

	@Override
	public ArrayList<LoanProgramsOfferedBean> display() {
		int loanProgramsCount=0;
		conn=DBUtil.establishConnection();
		try {
		ArrayList<LoanProgramsOfferedBean> loanProgramsOfferedList = new ArrayList<LoanProgramsOfferedBean>();
		preparedstatement=conn.prepareStatement(IQueryMapper.RETRIEVE_LOAN_PROGRAMS_OFFERED_LIST);
		rs=preparedstatement.executeQuery();
		while(rs.next())
		{
			LoanProgramsOfferedBean loanProgramsOffered=new LoanProgramsOfferedBean();
			loanProgramsOffered.setLoanProgramName(rs.getString(1));
			loanProgramsOffered.setDescription(rs.getString(2));
			loanProgramsOffered.setLoanType(rs.getString(3));
			loanProgramsOffered.setDurationInYears(rs.getInt(4));
			loanProgramsOffered.setMinLoanAmnt(rs.getDouble(5));
			loanProgramsOffered.setMaxLoanAmnt(rs.getDouble(6));
			loanProgramsOffered.setRateOfIntrest(rs.getDouble(7));
			loanProgramsOffered.setProofReq(rs.getString(8));
			loanProgramsOfferedList.add(loanProgramsOffered);
			
			loanProgramsCount++;
		}
		if(loanProgramsCount==0)
			return null;
		else
			return loanProgramsOfferedList;			
		}catch(Exception e){
		e.printStackTrace();
		}
		return null;
	
	}

	
}
