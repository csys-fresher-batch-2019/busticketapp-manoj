package UpdatePassword;

import java.util.Scanner;

import CreateAccount.userAccountDetails;
import CreateAccount.userAccountDetailsDAOImpl;

public class testUpdatePassword {

	public static void main(String[] args) throws Exception {
		
	
		
		userAccountDetailsDAOImpl obj = new userAccountDetailsDAOImpl();
		userAccountDetails a = new userAccountDetails();
		Scanner sc = new Scanner(System.in);
		int userId=0;
		boolean test = true, test1 = true;
		while (test) {
			System.out.println("Enter your userId:");
			userId = sc.nextInt();
			System.out.println("Enter your current password:");
			String password = sc.next();
			if (obj.validateLogin(userId) && obj.validateLogin2(userId,password)) {
				test = false;
				while (test1) {
					System.out.println("Type New password ");
					String a1 = sc.next();
					System.out.println("Confirm password");
					String a2 = sc.next();
					if (a1.equals(a2)) {
						test1 = false;
						if(obj.forgetPassword(userId,a1)) {
							System.out.println("Password updated");
						}
					} else {
						System.out.println("Password Mismatch");
					}
				}
			} else {
				System.out.println("Invalid userid or Password !!");
			}
		}
	}

}


	


	
