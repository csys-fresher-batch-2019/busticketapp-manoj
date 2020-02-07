package bookingDetails;

import java.util.ArrayList;
import java.util.Scanner;

import CancelBooking.testCancelBooking;
import PassengerInfo.passengerInfo;
import PassengerInfo.passengerInfoDAOImpl;


public class testBookingDetails {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		passengerInfoDAOImpl obj1 = new passengerInfoDAOImpl();

		passengerInfo a = new passengerInfo();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Booking Id:");
		int bookingId = sc.nextInt();
		if (obj1.validateBookingId(bookingId)) {
			ArrayList<passengerInfo> details = obj1.BookingDetails(bookingId);
			for (passengerInfo info : details) {
				System.out.println(info);
			}
			while (true) {
			System.out.println("Select 1 to cancel booking:");
			int choice = sc.nextInt();
		
				if (choice == 1) {
					testCancelBooking.main(null);
					break;
				} else {
					System.out.println("select valid option");
				}
			}
		} else {
			System.out.println("Enter valid booking id...try again");
			testBookingDetails.main(null);

		}
	}
}
