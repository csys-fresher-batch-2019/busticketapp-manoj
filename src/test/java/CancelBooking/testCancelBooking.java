package CancelBooking;

import java.util.Scanner;

import PassengerInfo.passengerInfoDAOImpl;

public class testCancelBooking {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		passengerInfoDAOImpl obj1=new passengerInfoDAOImpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Booking Id:");
		int bookingId=sc.nextInt();
		if (obj1.validateBookingId(bookingId)) {
		obj1.cancelBooking(bookingId);
		System.out.println("your booking is cancelled successfully");}
		else
		{
			System.out.println("Enter valid booking id...try again");
			testCancelBooking.main(null);
		}
		

	}

}
