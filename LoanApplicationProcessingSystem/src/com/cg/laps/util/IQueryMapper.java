package com.cg.laps.util;

public class IQueryMapper {

	public static final String VALID_LOGIN="SELECT role FROM Users WHERE login_id=? and password=?";
		public static final String RETRIEVE_LOAN_PROGRAMS_OFFERED_LIST = "SELECT * FROM loanProgramsOffered";
		public static final String RETRIEVE_LOAN_APPLICATION_STATUS = "SELECT status FROM loanApplication WHERE application_id = 1001";
		public static final String INSERT_QUERY_CUSTOMER_DETAILS = "INSERT INTO CustomerDetails VALUES (?,?,?,?,?,?,?)";
		//public static final String APPLICATIONID_QUERY_SEQUENCE = "SELECT Application_ID_sequence.CURRVAL FROM DUAL";
		//public static final String INSERT_QUERY_APPLICATION_DETAILS = "INSERT INTO LoanApplication VALUES (Application_Id_sequence.NEXTVAL,SYSDATE,?,?,?,?,?,?,?,SYSDATE+7)";
		public static final String INSERT_QUERY_APPLICATION_DETAILS = "INSERT INTO LoanApplication VALUES (?,?,?,?,?,?,?)";
		public static final String APPLICATIONID_QUERY_SEQUENCE = "SELECT Last_INSERT_ID";
		public static final String INSERT_QUERY_LOAN_PROGRAMS_OFFERED = "INSERT INTO LoanProgramsOffered VALUES (?,?,?,?,?,?,?,?)";
}


