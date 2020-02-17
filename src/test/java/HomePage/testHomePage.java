package HomePage;

import java.util.Scanner;

import CreateAccount.testUserAccount;
import logger.Logger;
import Login.testLogin;

public class testHomePage {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Logger out=Logger.getInstance();
		out.info(" ====Welcome to eBus==== ");
		out.info(" 1.Existing User \n 2.New User");
		out.getInput("Press 1 or 2");
		Scanner sc=new Scanner(System.in);
		while(true) {
		int choice=sc.nextInt();
		if(choice==1) {
			testLogin.main(null);
			
		}
		else if(choice==2) {
			out.info("Create New Account ");
			testUserAccount.main(null);
		
		}
		else {
			out.info("Please Enter 1 or 2");
			
		}
		
	}}
	

}
