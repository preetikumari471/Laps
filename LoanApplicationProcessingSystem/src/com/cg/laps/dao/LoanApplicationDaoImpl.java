package com.cg.laps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.laps.bean.LoanApplicationBean;
import com.cg.laps.util.DBUtil;
import com.cg.laps.util.IQueryMapper;

public class LoanApplicationDaoImpl implements ILoanApplicationDao {

	static Connection conn;
	static PreparedStatement preparedstatement=null;
	static ResultSet rs=null;
	int applicationId=0;
	
	@Override	
	public int addApplicationDetails(LoanApplicationBean loanApplication) {
		
		int queryResult=0;
		
		conn = DBUtil.establishConnection();
		try {
			preparedstatement = conn.prepareStatement(IQueryMapper.INSERT_QUERY_APPLICATION_DETAILS);
		
		preparedstatement.setString(1,loanApplication.getLoanProgram());
		preparedstatement.setDouble(2,loanApplication.getLoanAmount());
		preparedstatement.setString(3,loanApplication.getPropertyAddress());
		preparedstatement.setDouble(4,loanApplication.getAnnualFamilyIncome());
		preparedstatement.setString(5,loanApplication.getDocsProof());
		preparedstatement.setString(6,loanApplication.getGuaranteeCoverString());
		preparedstatement.setDouble(7,loanApplication.getMarktValOfCover());
		//ResultSet rs=preparedstatement.executeQuery();
		
			
		queryResult=preparedstatement.executeUpdate();
		
		preparedstatement = conn.prepareStatement(IQueryMapper.APPLICATIONID_QUERY_SEQUENCE);
			rs=preparedstatement.executeQuery();

			if(rs.next())
			{
				applicationId=rs.getInt(1);
						
			}
	
		/*	
			if(queryResult==0)
			{
				logger.error("Insertion failed ");
				throw new DonorException("Inserting donor details failed ");

			}
			else
			{
				logger.info("Donor details added successfully:");
				return donorId;
			}

		}
		catch(SQLException sqlException)
		{
			logger.error(sqlException.getMessage());
			throw new DonorException("Tehnical problem occured refer log");
		}*/

		//finally
		//{
			//try 
			//{
				//resultSet.close();
				preparedstatement.close();
				conn.close();
			//}
			/*catch (SQLException sqlException) 
			{
				logger.error(sqlException.getMessage());
				throw new DonorException("Error in closing db connection");

			}*/

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			// TODO Auto-generated method stub
	
		return applicationId;
	}


}
