package PassengerInfo;

import java.util.Scanner;


import CreateAccount.userAccountDetailsDAOImpl;
import logger.Logger;
import bookingDetails.testBookingDetails;
import payment.testPayment;

public class testPassengerInfo {


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		passengerInfoDAOImpl obj1=new passengerInfoDAOImpl();
		 userAccountDetailsDAOImpl obj2=new  userAccountDetailsDAOImpl();
			Logger out=Logger.getInstance();
		passengerInfo a=new passengerInfo();
		Scanner sc=new Scanner(System.in);
		out.info("Please fill the following form:");
		out.getInput("Enter User Id:");
		a.setUserId(sc.nextInt());
		if(obj2.validateLogin(a.getUserId())) {
		System.out.println("Enter Bus Id:");
		a.setBusId(sc.nextInt());
		if(obj1.validateBusId(a.getBusId())) {
			out.getInput("Enter Passenger's Name:");
		a.setPassengerName(sc.next());
		out.getInput("Enter Passenger's Age:");
		a.setAge(sc.nextInt());
		out.getInput("Enter Passenger's Gender:");
		a.setGender(sc.next());
		out.getInput("Enter Mobile Number:");
		a.setMobileNumber(sc.nextLong());
		out.getInput("Enter no of Tickets:");
		a.setNoOfTickets(sc.nextInt());
		int bId=obj1.insertPassengerInfo(a);

		
		out.info("Your Booking Id is:"+bId);
		
		while(true) {
			out.getInput("select 1 to view booking details...");
		int choice =sc.nextInt();
		if(choice==1)
		{
			testBookingDetails.main(null);
			break;
		}
		
		
		else
		{
			out.info("please select valid option...");
		}

	}}
		
		
		else
		{
			out.info("invalid user id or bus id....try again");
			 testPassengerInfo.main(null);
		}}
		else
		{
		out.info("invalid user id or bus id....try again");
			 testPassengerInfo.main(null);
			
		}
	}

	

}
