package AvailableSeats;


import java.util.Scanner;

import logger.Logger;
import PassengerInfo.testPassengerInfo;

public class testAvailableSeats {

	public static void main(String[] args) throws Exception {
		availableSeatsDAOImpl obj = new availableSeatsDAOImpl();
		Logger out=Logger.getInstance();
		Scanner sc = new Scanner(System.in);
		out.info(" ");
		out.getInput("Please Enter your choice of bus id to know available seats:");
		int busId = sc.nextInt();
		int num = obj.seatavail(busId);
		if (num == 0) {
			out.info("invalid Bus Id");

			while (true) {
				out.getInput("Select 1 to retry.....\");");
				int press = sc.nextInt();
				if (press == 1) {
					testAvailableSeats.main(null);
					break;
				} else {
					out.info("invalid option");
				}
			}
		} else {
			out.info(" Available Seats are " + num);
		}
		while (true) {
			out.getInput("Please Enter 1 to search available seats of other Buses or Enter 2 to book the bus:");
			int choice = sc.nextInt();
			if (choice == 1) {
				testAvailableSeats.main(null);
				break;
			} else if (choice == 2) {
				testPassengerInfo.main(null);
				break;

			} else {
				out.info("invalid option");
			}
		}
	}

}
