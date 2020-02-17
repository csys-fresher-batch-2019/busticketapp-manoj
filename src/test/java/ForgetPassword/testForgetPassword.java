package ForgetPassword;

import java.util.Scanner;

import CreateAccount.userAccountDetails;
import CreateAccount.userAccountDetailsDAOImpl;
import logger.Logger;

public class testForgetPassword {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		userAccountDetailsDAOImpl obj = new userAccountDetailsDAOImpl();
		userAccountDetails a = new userAccountDetails();
		Logger out=Logger.getInstance();

		Scanner sc = new Scanner(System.in);
		int userId=0;
		boolean test = true, test1 = true;
		while (test) {
			out.getInput("Enter your userId:");
			userId = sc.nextInt();
			out.getInput("Enter your emailId:");
			String emailId = sc.next();
			if (obj.validateLogin(userId) && obj.checkEmailId2(emailId,userId)) {
				test = false;
				while (test1) {
					out.getInput("Type New password ");
					String a1 = sc.next();
					out.getInput("Confirm password");
					String a2 = sc.next();
					if (a1.equals(a2)) {
						test1 = false;
						if(obj.forgetPassword(userId,a1)) {
							out.info("Password updated");
						}
					} else {
					out.info("Password Mismatch");
					}
				}
			} else {
				out.info("Invalid userid or mailid !!");
			}
		}
	}

}
