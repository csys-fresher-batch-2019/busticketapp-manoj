package Login;


import java.util.Scanner;


import CreateAccount.userAccountDetailsDAOImpl;
import ForgetPassword.testForgetPassword;
import SearchBus.testFindBus;
import UpdatePassword.testUpdatePassword;

public class testLogin {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		userAccountDetailsDAOImpl obj= new userAccountDetailsDAOImpl();
		
		Scanner sc=new Scanner(System.in);
	
		System.out.println("Enter User Id:");
		int userid=sc.nextInt();
		System.out.println("Enter Password:");
		String password=sc.next();
		
		boolean validate=obj.validateLogin(userid);
		if(validate==true)
		{
			
			
			if(obj.validateLogin2(userid,password)) {
				System.out.println("\nLogin Successfull");
				System.out.println("Select 1 to search Buses:");
				System.out.println("Select 2 to update Password:");
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
				else
				{
					System.out.println("Please enter 1 or 2");
				}
				}
			
			}
			else
			{
				System.out.println("Invalid Username or Password.....\n");
				while(true) {
				System.out.println("press 1 to try again:");
				System.out.println("press 2 if you forgot your password:");
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
			    	System.out.println("you are selected incorrect option:");
			    }
			}
			}
		}
		else {
			System.out.println("Invalid Username or Password\n");
			while(true) {
			System.out.println("press 1 to try again:");
			System.out.println("press 2 if you forgot your password:");
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
		    	System.out.println("you are selected incorrect option:");
		    }
			}
		}
		

	}
	
	}

