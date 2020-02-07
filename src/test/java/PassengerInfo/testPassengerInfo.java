package PassengerInfo;

import java.util.Scanner;

import CancelBooking.testCancelBooking;
import CreateAccount.userAccountDetailsDAOImpl;
import bookingDetails.testBookingDetails;

public class testPassengerInfo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		passengerInfoDAOImpl obj1=new passengerInfoDAOImpl();
		 userAccountDetailsDAOImpl obj2=new  userAccountDetailsDAOImpl();
	
		passengerInfo a=new passengerInfo();
		Scanner sc=new Scanner(System.in);
		System.out.println("Please fill the following form:");
		System.out.println("Enter User Id:");
		a.setUserId(sc.nextInt());
		if(obj2.validateLogin(a.getUserId())) {
		System.out.println("Enter Bus Id:");
		a.setBusId(sc.nextInt());
		if(obj1.validateBusId(a.getBusId())) {
		System.out.println("Enter Passenger's Name:");
		a.setPassengerName(sc.next());
		System.out.println("Enter Passenger's Age:");
		a.setAge(sc.nextInt());
		System.out.println("Enter Passenger's Gender:");
		a.setGender(sc.next());
		System.out.println("Enter Mobile Number:");
		a.setMobileNumber(sc.nextLong());
		System.out.println("Enter no of Tickets:");
		a.setNoOfTickets(sc.nextInt());
		int bId=obj1.insertPassengerInfo(a);
		System.out.println("Your Booking Id is:"+bId);
		while(true) {
		System.out.println("select 1 to view booking details or select 2 to cancel the booking");
		int choice =sc.nextInt();
		
		if(choice==1)
		{
			testBookingDetails.main(null);
			break;
		}
		else if(choice==2)
		{
			testCancelBooking.main(null);
			break;
		}
		else
		{
			System.out.println("please select valid option...");
		}

	}}
		
		
		else
		{
			System.out.println("invalid user id or bus id....try again");
			 testPassengerInfo.main(null);
		}}
		else
		{
			System.out.println("invalid user id or bus id....try again");
			 testPassengerInfo.main(null);
			
		}
	}

}
