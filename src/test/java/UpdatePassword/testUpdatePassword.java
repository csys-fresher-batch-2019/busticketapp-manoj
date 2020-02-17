package UpdatePassword;

import java.util.Scanner;

import CreateAccount.userAccountDetails;
import CreateAccount.userAccountDetailsDAOImpl;
import logger.Logger;

public class testUpdatePassword {

	public static void main(String[] args) throws Exception {
		
	
		
		userAccountDetailsDAOImpl obj = new userAccountDetailsDAOImpl();
		userAccountDetails a = new userAccountDetails();
		Scanner sc = new Scanner(System.in);
		Logger out=Logger.getInstance();
		int userId=0;
		boolean test = true, test1 = true;
		while (test) {
			out.getInput("Enter your userId:");
			userId = sc.nextInt();
			out.getInput("Enter your current password:");
			String password = sc.next();
			if (obj.validateLogin(userId) && obj.validateLogin2(userId,password)) {
				test = false;
				while (test1) {
					out.getInput("Type New password ");
					String a1 = sc.next();
					out.getInput("Confirm password");
					String a2 = sc.next();
					if (a1.equals(a2)) {
						test1 = false;
						if(obj.forgetPassword(userId,a1)) {
							out.getInput("Password updated");
						}
					} else {
						out.getInput("Password Mismatch");
					}
				}
			} else {
				out.getInput("Invalid userid or Password !!");
			}
		}
	}

}


	


	
