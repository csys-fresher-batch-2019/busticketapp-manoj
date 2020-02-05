package CreateAccount;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import AdminRole.TestConnection;
import Login.testLogin;

public class testUserAccount {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		userAccountDetailsDAOImpl obj = new userAccountDetailsDAOImpl();
		userAccountDetails a = new userAccountDetails();

		Scanner sc = new Scanner(System.in);
		boolean test = true;
		System.out.println("Enter user name:");
		a.userName = sc.next();
		System.out.println("Enter password:");
		a.password = sc.next();
		System.out.println("Enter gender(M/F/others):");
		a.gender = sc.next();
		System.out.println("Enter DOB:");
		a.dob = sc.next();
		System.out.println("Enter contact number:");
		a.contactNumber = sc.nextLong();

		int userid = 0;
		while (test) {
			System.out.println("Enter EmailId:");
		String mailId= sc.next();
		boolean mail=obj.checkEmailId(mailId);
		if (mail==true) {
			test = false;
			a.emailId=mailId;
			userid = obj.addUser(a);

		} else {
			System.out.println("Email Id already exists...try another email Id!!! \n");
		}}
		System.out.println("Thank you for creating account.....");
		System.out.println("Your User Id:");
		System.out.println(userid);
		System.out.println("\n");
		
		while(true)
		{
		System.out.println("press 1 to login:");
		int choice = sc.nextInt();
		if (choice == 1) {
			testLogin.main(null);
			break;
		} else {
			System.out.println("You are selected incorrect option...");
		}
		}
	}

}
