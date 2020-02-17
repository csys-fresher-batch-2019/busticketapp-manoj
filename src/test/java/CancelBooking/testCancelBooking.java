package CancelBooking;

import java.util.Scanner;

import logger.Logger;
import PassengerInfo.passengerInfoDAOImpl;

public class testCancelBooking {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		passengerInfoDAOImpl obj1=new passengerInfoDAOImpl();
		Scanner sc=new Scanner(System.in);
		Logger out=Logger.getInstance();

		out.getInput("Enter Booking Id:");
		int bookingId=sc.nextInt();
		if (obj1.validateBookingId(bookingId)) {
		obj1.cancelBooking(bookingId);
		out.info("your booking is cancelled successfully");}
		else
		{
			out.info("Enter valid booking id...try again");
			testCancelBooking.main(null);
		}
		

	}

}
