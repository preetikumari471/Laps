package com.cg.laps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.laps.bean.CustomerBean;
import com.cg.laps.bean.LoanApplicationBean;
import com.cg.laps.util.DBUtil;
import com.cg.laps.util.IQueryMapper;


public class CustomerDaoImpl implements ICustomerDao {
	static Connection conn;
	static PreparedStatement preparedstatement=null;
	static ResultSet rs=null;
	boolean result=false;

	@Override
	public boolean addPersonalDetails(CustomerBean customer) {
		
		int queryResult=0;
		
		conn = DBUtil.establishConnection();
		try {
			preparedstatement = conn.prepareStatement(IQueryMapper.INSERT_QUERY_CUSTOMER_DETAILS);
		
		preparedstatement.setInt(1,customer.getApplicationId());
		preparedstatement.setString(2,customer.getApplicantName());
		preparedstatement.setString(3,customer.getDateOfBirth());
		preparedstatement.setString(4,customer.getMaritalStatus());
		preparedstatement.setLong(5,customer.getPhoneNumber());
		preparedstatement.setLong(6,customer.getMobileNumber());
		preparedstatement.setDouble(7,customer.getDependentsCount());
		preparedstatement.setString(8,customer.getEmailId());
		
		//ResultSet rs=preparedstatement.executeUpdate();
		
		queryResult=preparedstatement.executeUpdate();
	
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
	
		
		
		return true;
	}
	

	
}
