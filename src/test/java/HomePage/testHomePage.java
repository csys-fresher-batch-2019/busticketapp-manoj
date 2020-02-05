package HomePage;

import java.util.Scanner;

import CreateAccount.testUserAccount;
import Login.testLogin;

public class testHomePage {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(" ====Welcome to eBus==== ");
		System.out.println(" 1.Existing User \n 2.New User");
		System.out.println("Press 1 or 2");
		Scanner sc=new Scanner(System.in);
		while(true) {
		int choice=sc.nextInt();
		if(choice==1) {
			testLogin.main(null);
			
		}
		else if(choice==2) {
			System.out.println("Create New Account ");
			testUserAccount.main(null);
		
		}
		else {
			System.out.println("Please Enter 1 or 2");
			
		}
		
	}}
	

}
