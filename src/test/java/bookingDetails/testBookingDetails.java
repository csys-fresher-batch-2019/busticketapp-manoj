package bookingDetails;

import java.util.ArrayList;
import java.util.Scanner;


import logger.Logger;
import PassengerInfo.passengerInfo;
import PassengerInfo.passengerInfoDAOImpl;
import payment.testPayment;


public class testBookingDetails {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		passengerInfoDAOImpl obj1 = new passengerInfoDAOImpl();
		Logger out=Logger.getInstance();

		
		Scanner sc = new Scanner(System.in);
		out.getInput("Enter Booking Id:");
		int bookingId = sc.nextInt();
		if (obj1.validateBookingId(bookingId)) {
			ArrayList<passengerInfo> details = obj1.BookingDetails(bookingId);
			for (passengerInfo info : details) {
				out.info(info);
			}
			int totalPrice=obj1.totalPrice(bookingId);
			out.info(" ");
			out.info("Amount to be paid is Rs."+totalPrice);
			while (true) {
				out.getInput("Select 1 make payment....");
				int choice = sc.nextInt();
				if(choice==1)
				{
					testPayment.main(null);
					break;
				}
				else {
					out.info("select valid option");
				}
			}
		} else {
			out.info("Enter valid booking id...try again");
			testBookingDetails.main(null);

		}
	}
}
