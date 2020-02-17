package bookingDetails;

import java.util.ArrayList;
import java.util.Scanner;

import CreateAccount.userAccountDetails;
import CreateAccount.userAccountDetailsDAOImpl;
import PassengerInfo.passengerInfo;
import PassengerInfo.passengerInfoDAOImpl;
import logger.Logger;

public class testMyBookings {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		userAccountDetailsDAOImpl obj1 = new userAccountDetailsDAOImpl();
		passengerInfoDAOImpl obj2 = new passengerInfoDAOImpl();
		Logger out=Logger.getInstance();

		
		Scanner sc = new Scanner(System.in);
		out.getInput("Enter User Id:");
		int userId = sc.nextInt();
		if (obj1.validateLogin(userId)) {
			ArrayList<passengerInfo> details = obj2.MyBookings(userId);
			for (passengerInfo info : details) {
				out.info(info);
			}}
			 else {
					out.info("Enter valid booking id...try again");
					testBookingDetails.main(null);

				}
			}

	}


