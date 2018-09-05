package com.cg.laps.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;









import com.cg.laps.bean.LoanApplicationBean;
import com.cg.laps.bean.LoanProgramsOfferedBean;
import com.cg.laps.bean.UserBean;
import com.cg.laps.bean.CustomerBean;
import com.cg.laps.dao.LoanProcessingDaoImpl;
import com.cg.laps.service.CustomerServiceImpl;
import com.cg.laps.service.ICustomerService;
import com.cg.laps.service.ILoanApprovalDepartmentService;
import com.cg.laps.service.LoanApprovalDepartmentServiceImpl;
import com.cg.laps.service.LoanProcessingServiceImpl;
import com.cg.laps.service.LoanProgramsOfferedServiceImpl;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class ClientUi {
	
	static Scanner scanner=null;
	static CustomerBean customer=null;
	static UserBean user=null;
	static CustomerServiceImpl customerService = null;
	static LoanApprovalDepartmentServiceImpl loanApprovalDepartmentService=null;
	static LoanProgramsOfferedServiceImpl loanProgramsOfferedService=null;
	static ClientUi client = null;
	static LoanProgramsOfferedBean loanProgramsOffered=null;
	static LoanApplicationBean loanApplication=null;
	static LoanProcessingServiceImpl loanProcessingService=null;
	
	
	
	public static void main(String[] args) {
	
	loanApprovalDepartmentService=new LoanApprovalDepartmentServiceImpl();
	loanProcessingService=new LoanProcessingServiceImpl();
	customerService=new CustomerServiceImpl();
	loanProgramsOfferedService=new LoanProgramsOfferedServiceImpl();		
	loanProgramsOffered=new LoanProgramsOfferedBean();		
	loanApplication= new LoanApplicationBean();
	customer=new CustomerBean();
	user=new UserBean();
		
	scanner=new Scanner(System.in);
	boolean status=false;
	String role=null;
	String userId,password;
	int appid=0;
	String appstatus=null;
	
	
	do{
		
		System.out.println("-------------LOAN APPLICATION PROCESSING SYSTEM-----------");
		System.out.println("__________________________________________________________");
		System.out.println("Select your choice to proceed:");
		System.out.println("1. Login as Admin/Member of LAD");
		System.out.println("2. Enter as Customer");
		System.out.println(" Press any other key to exit ");
		
		
		
		int option=scanner.nextInt();
		String a=scanner.nextLine();
		
		switch(option)
		{
			case 1:
					System.out.println("Enter Username: ");
					userId=scanner.nextLine();
					System.out.println("Enter Password:");
					password=scanner.nextLine();
					
					loanProcessingService= new LoanProcessingServiceImpl();
					role=loanProcessingService.checkLogin(userId,password);
					if(role!=null)
						status=true;
					else
						status=false;
					break;
					

			case 2:
				
				do
				{
					System.out.println();
					System.out.println("--------------- Welcome ---------------");
					System.out.println("Select your choice :");
					System.out.println("1. View loan programs");
					System.out.println("2. View application status");
					System.out.println(" Press any other key to exit ");
					int choice = scanner.nextInt();
					
					switch(choice)
					{
					case 1:
						int applicationId=0;
						System.out.println("-------AVAILABLE LOAN PROGRAMS------");
						client=new ClientUi();
						client.displayLoanPrograms();
						System.out.println("_______________________________________");
						System.out.println("Apply for loan?(Y/N)");
						String input=scanner.next();
						while(input.equalsIgnoreCase("Y")){
							if(loanProcessingService.display()!=null)
							{
			
								loanApplication=populateLoanApplicationBean();
								applicationId=customerService.addApplicationDetails(loanApplication);
								System.out.println();
								System.out.println("Succesfully applied for loan!!!");
								System.out.println("Your application ID is:"+applicationId);
					
					
								customer=populateCustomerBean();
								boolean add=customerService.addPersonalDetails(customer);
								if(add==true){
									System.out.println("Details added successfully!!!");	
								}
								else{
									System.out.println("Error encountered. Please Try again later!");
									}
							}
				
						}break;//add option for continue
				
				 
					case 2:
					 		System.out.println("Enter Application ID: ");
					 		appid=scanner.nextInt();
						
					 		customerService= new CustomerServiceImpl();
					 		appstatus=customerService.viewApplicationStatus(appid);
					 		if(appstatus!=null)
							System.out.println("Your current status is: "+appstatus);
					 		else
							System.out.println("No loan application found!!");
					 		break;
						
					default:
							System.out.println("You have successfully exited!!");
							System.exit(0);
					}

					 
				}while(true);
				
				
				
			default:
				System.out.println("You have successfully exited!!");
				System.exit(0);
		
	}
		if(status==false)
		{
			System.err.println("Invalid username or password!!!");
		}
		else
		{
			System.out.println("Welcome!!");
			break;
		}
	
	}while(true);
	
	if(status==true)
	{
		if(role.equalsIgnoreCase("admin"))
		{
			do
			{
				System.out.println();
				System.out.println("--------------- Welcome Admin ---------------");
				System.out.println("Select your choice :");
				System.out.println("1. View loan programs");
				System.out.println("2. Update loan programs");
				System.out.println("3) Generate Reports");
				System.out.println(" Press any other key to exit ");
				int choice = scanner.nextInt();
				
				switch(choice)
				{
				case 1:
					client=new ClientUi();
					client.displayLoanPrograms();
					break;
					
				case 2:
					System.out.println();
					System.out.println("--------------- Update loan programs ---------------");
					System.out.println("Select your choice :");
					System.out.println("1) Add Loan Programs");
					System.out.println("2) Delete Loan Programs");
					System.out.println(" Press any other key to exit ");
					
					int adchoice = scanner.nextInt();
					int operation=0;
					String dltprogram=null;
					switch(adchoice)
					{
					
					case 1:
						
							loanProgramsOffered=populateLoanProgramsOfferedBean();
						
						operation=loanProgramsOfferedService.addLoanProgramsOffered(loanProgramsOffered);
						if(operation==1){
							System.out.println("Data added successfully!!!");	
						}
						else{
							System.out.println("Error encountered. Please Try again later!");
						}
						break;
					case 2:
						
						System.out.println("Enter the name of loan program: ");
						dltprogram=scanner.next();
						operation=loanProgramsOfferedService.deleteLoanProgramsOffered(dltprogram);
						if(operation==1){
							System.out.println("Data deleted successfully!!!");	
						}
						else{
							System.out.println("Error encountered. Please Try again later!");
						}
						break;
						
						
					default:
						System.out.println("You have successfully exited!!");
						System.exit(0);
					}
					break;
					
				case 3:
					System.out.println();
					System.out.println("--------------- Generate Reports ---------------");
					System.out.println("Choose Your Option :");
					System.out.println("1. List of applications");
					System.out.println("2. View status of applications");
					System.out.println(" Press any other key to exit ");
					break;
					
				default:
					System.out.println("You have successfully exited!!");
					System.exit(0);
				}
			}while(true);
		}
			
			else{
				do
				{
					System.out.println();
					System.out.println("--------------- Welcome Member of Loan Approval Department ---------------");
					System.out.println("Select your choice :");
					System.out.println("1. View loan programs");
					System.out.println("2. View applications for specific loan program");
					System.out.println(" Press any other key to exit ");
					int choice = scanner.nextInt();
					String program=null;
					
					switch(choice)
					{
					case 1:
						client=new ClientUi();
						client.displayLoanPrograms();
						break;
						
					case 2:
						
						LoanApprovalDepartmentServiceImpl loanApprovalDepartmentService=new LoanApprovalDepartmentServiceImpl();
						ArrayList<LoanApplicationBean> loanApplicationList=new ArrayList<LoanApplicationBean>();
						loanApplicationList=loanApprovalDepartmentService.viewSpecificList(program);
						System.out.println("Enter the name of loan program: ");
						program=scanner.next();
						loanApplicationList=loanApprovalDepartmentService.viewSpecificList(program);
						
						if(loanApplicationList !=null){
							Iterator<LoanApplicationBean> i=loanApplicationList.iterator();
							while(i.hasNext()){
								loanApplication=i.next();
								System.out.println("Application ID : "+loanApplication.getApplicationId());
								System.out.println("Application Date : "+loanApplication.getApplicationDate());
								System.out.println("Loan Program : "+loanApplication.getLoanProgram());
								System.out.println("Loan Amount : "+loanApplication.getLoanAmount());
								System.out.println("Address of Property : "+loanApplication.getPropertyAddress());
								System.out.println("Annual Family Income : "+loanApplication.getAnnualFamilyIncome());
								System.out.println("Document proof : "+loanApplication.getDocsProof());
								System.out.println("Guarantee Cover : "+loanApplication.getGuaranteeCoverString());
								System.out.println("Market value of guarantee cover : "+loanApplication.getMarktValOfCover());
								System.out.println("Application status : "+loanApplication.getStatus());
								System.out.println("Interview Date : "+loanApplication.getInterviewDate());
								System.out.println("----------------------------------------------------------");
								
							}
							
						} else {
							System.out.println("End of list!!");
						}
						
						
						break;
						
					default:
						System.out.println("You have successfully exited!!");
						System.exit(0);
					}
				
				}while(true);
			
			
			}
		
	}

}

	private static LoanProgramsOfferedBean populateLoanProgramsOfferedBean() {
		loanProgramsOffered=new LoanProgramsOfferedBean();
		System.out.println("_________________________________________");
		System.out.println();
		System.out.println("-------NEW LOAN PROGRAM---------");
		System.out.println();
		System.out.println("Enter Loan Program name:");
		loanProgramsOffered.setLoanProgramName(scanner.next());
		System.out.println("Enter Loan Description:");
		scanner.nextLine();
		loanProgramsOffered.setDescription(scanner.nextLine());
		System.out.println("Enter loan type:");
		loanProgramsOffered.setLoanType(scanner.next());
		System.out.println("Enter duration in years:");
		loanProgramsOffered.setDurationInYears(scanner.nextInt());
		System.out.println("Enter minimum loan amount:");
		loanProgramsOffered.setMinLoanAmnt(scanner.nextDouble());
		System.out.println("Enter maximum loan amount:");
		loanProgramsOffered.setMaxLoanAmnt(scanner.nextDouble());
		System.out.println("Enter rate of interest:");
		loanProgramsOffered.setRateOfIntrest(scanner.nextDouble());
		System.out.println("Enter proofs required:");
		loanProgramsOffered.setProofReq(scanner.next());
		return loanProgramsOffered;
	}




	private static CustomerBean populateCustomerBean() {
		
		System.out.println();
		System.out.println("Enter your personal details!!");
		System.out.println();
		System.out.println("Enter application ID: ");
		customer.setApplicationId(scanner.nextInt());
		System.out.println("Enter name: ");
		customer.setApplicantName(scanner.next());
		System.out.println("Enter Date of Birth (DD-MM-YYYY) : ");
		customer.setDateOfBirth(scanner.next());
		System.out.println("Enter marital status (Married/Unmarried) : ");
		customer.setMaritalStatus(scanner.next());
		System.out.println("Enter Phone Number:");
		customer.setPhoneNumber(scanner.nextLong());
		System.out.println("Enter mobile number:");
		customer.setMobileNumber(scanner.nextLong());
		System.out.println("Enter number of dependents:");
		customer.setDependentsCount(scanner.nextInt());
		System.out.println("Enter Email ID:");
		customer.setEmailId(scanner.next());
		return customer;
	}

	private static LoanApplicationBean populateLoanApplicationBean() {
		
		loanApplication=new LoanApplicationBean();
		System.out.println("_________________________________________");
		System.out.println();
		System.out.println("-------APPLICATION FORM--------");
		System.out.println();
		System.out.println("Enter the Loan Program name:");
		loanApplication.setLoanProgram(scanner.next());
		System.out.println("Enter the loan amount:");
		loanApplication.setLoanAmount(scanner.nextDouble());
		System.out.println("Enter address of property:");
		loanApplication.setPropertyAddress(scanner.next());
		System.out.println("Enter Annual family income:");
		loanApplication.setAnnualFamilyIncome(scanner.nextDouble());
		System.out.println("Enter the document proofs:");
		loanApplication.setDocsProof(scanner.next());
		System.out.println("Gaurantee cover details:");
		loanApplication.setGuaranteeCoverString(scanner.next());
		System.out.println("Market value of gaurantee cover:");
		loanApplication.setMarktValOfCover(scanner.nextDouble());
			
		return loanApplication;
	}

	
	private void displayLoanPrograms() {
		LoanProcessingServiceImpl loanProcessingService=new LoanProcessingServiceImpl();
		ArrayList<LoanProgramsOfferedBean> loanProgramsOfferedList=new ArrayList<LoanProgramsOfferedBean>();
		loanProgramsOfferedList=loanProcessingService.display();
		if(loanProgramsOfferedList !=null){
			Iterator<LoanProgramsOfferedBean> i=loanProgramsOfferedList.iterator();
			while(i.hasNext()){
				loanProgramsOffered=i.next();
				System.out.println("Loan program name : "+loanProgramsOffered.getLoanProgramName());
				System.out.println("Description : "+loanProgramsOffered.getDescription());
				System.out.println("Loan Type : "+loanProgramsOffered.getLoanType());
				System.out.println("Duration (years) : "+loanProgramsOffered.getDurationInYears());
				System.out.println("Minimum loan amount : "+loanProgramsOffered.getMinLoanAmnt());
				System.out.println("Maximum loan amount : "+loanProgramsOffered.getRateOfIntrest());
				System.out.println("Proofs required : "+loanProgramsOffered.getProofReq());
				System.out.println("----------------------------------------------------------");
				
			}
			
		} else {
			System.out.println("End of list!!");
		}
		
		
	}




	

	
	

}

