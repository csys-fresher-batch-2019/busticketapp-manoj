package CreateAccount;



import java.util.Scanner;

import logger.Logger;
import Login.testLogin;

public class testUserAccount {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		userAccountDetailsDAOImpl obj = new userAccountDetailsDAOImpl();
		userAccountDetails a = new userAccountDetails();
		Logger out=Logger.getInstance();

		
		

		Scanner sc = new Scanner(System.in);
		boolean test = true;
	out.getInput("Enter user name:");
		a.setUserName(sc.next());
		out.getInput("Enter password:");
		a.setPassword(sc.next());
		out.getInput("Enter gender(M/F/others):");
		a.setGender(sc.next());
		out.getInput("Enter DOB:");
		a.setDob(sc.next());
		out.getInput("Enter contact number:");
		a.setContactNumber(sc.nextLong());

		int userid = 0;
		while (test) {
			out.getInput("Enter EmailId:");
		String mailId= sc.next();
		boolean mail=obj.checkEmailId(mailId);
		if (mail==true) {
			test = false;
			a.setEmailId(mailId);
			userid = obj.addUser(a);

		} else {
			out.info("Email Id already exists...try another email Id!!! \n");
		}}
		out.info("Thank you for creating account.....");
		out.info("Your User Id:");
		out.info(userid);
		out.info("\n");
		
		while(true)
		{
		System.out.println("press 1 to login:");
		int choice = sc.nextInt();
		if (choice == 1) {
			testLogin.main(null);
			break;
		} else {
			out.info("You are selected incorrect option...");
		}
		}
	}

}
