package payment;

import java.util.Scanner;


import logger.Logger;

public class testPayment {

	public static void main(String[] args) throws Exception {
		

		Logger out=Logger.getInstance();
		out.info("Payment Page \n");
		out.info(" 1.To pay using credit card ");
		out.getInput("Press 1");
		Scanner sc=new Scanner(System.in);
		while(true) {
		int choice=sc.nextInt();
		if(choice==1) {
			testBank.main(null);
			
		}
		
		else {
			out.info("Please Enter 1 ...");
			
		}
		
	}}
	

}
