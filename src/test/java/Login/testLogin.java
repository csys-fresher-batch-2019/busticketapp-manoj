package Login;


import java.util.Scanner;


import CreateAccount.userAccountDetailsDAOImpl;
import ForgetPassword.testForgetPassword;
import logger.Logger;
import SearchBus.testFindBus;
import UpdatePassword.testUpdatePassword;
import bookingDetails.testMyBookings;

public class testLogin {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		userAccountDetailsDAOImpl obj= new userAccountDetailsDAOImpl();
		Logger out=Logger.getInstance();
		Scanner sc=new Scanner(System.in);
	
    out.getInput("Enter User Id:");
		int userid=sc.nextInt();
		  out.getInput("Enter Password:");
		String password=sc.next();
		
		boolean validate=obj.validateLogin(userid);
		if(validate==true)
		{
			
			
			if(obj.validateLogin2(userid,password)) {
				out.info("\nLogin Successfull");
				  out.getInput("Select 1 to search Buses:");
				  out.getInput("Select 2 to update Password:");
				  out.getInput("Select 3 for My Bookings");
				while(true)
				{
				int choice=sc.nextInt();
				if(choice==1) {
				testFindBus.main(null);
				break;
				}
				else if(choice==2)
				{
					testUpdatePassword.main(null);
					break;
				}
				else if(choice==3) {
					testMyBookings.main(null);
					break;
					
				}
				else
				{
					  out.getInput("Please enter 1 or 2 or 3");
				}
				}
			
			}
			else
			{
				out.info("Invalid Username or Password.....\n");
				while(true) {
					  out.getInput("press 1 to try again:");
					  out.getInput("press 2 if you forgot your password:");
				int a=sc.nextInt();
				if(a==1)
				{
					testLogin.main(null);
					break;
				}
				else if(a==2)
			    {
					testForgetPassword.main(null);
					break;
			    }
			    else
			    {
			    	out.info("you are selected incorrect option:");
			    }
			}
			}
		}
		else {
			out.info("Invalid Username or Password\n");
			while(true) {
				  out.getInput("press 1 to try again:");
				  out.getInput("press 2 if you forgot your password:");
			int a=sc.nextInt();
			if(a==1)
		    {
				testLogin.main(null);
				break;
		    }
			else if(a==2)
			{
				testForgetPassword.main(null);
				break;
			}
		    else
		    {
		    	out.info("you are selected incorrect option:");
		    }
			}
		}
		

	}
	
	}

