package AvailableSeats;


import java.util.Scanner;


import PassengerInfo.testPassengerInfo;

public class testAvailableSeats {

	public static void main(String[] args) throws Exception {
		availableSeatsDAOImpl obj = new availableSeatsDAOImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println(" ");
		System.out.println("Please Enter your choice of bus id to know available seats:");
		int busId = sc.nextInt();
		int num = obj.seatavail(busId);
		if (num == 0) {
			System.out.println("invalid Bus Id");

			while (true) {
				System.out.println("Select 1 to retry.....\");");
				int press = sc.nextInt();
				if (press == 1) {
					testAvailableSeats.main(null);
					break;
				} else {
					System.out.println("invalid option");
				}
			}
		} else {
			System.out.println(" Available Seats are " + num);
		}
		while (true) {
			System.out.println("Please Enter 1 to search available seats of other Buses or Enter 2 to book the bus:");
			int choice = sc.nextInt();
			if (choice == 1) {
				testAvailableSeats.main(null);
				break;
			} else if (choice == 2) {
				testPassengerInfo.main(null);
				break;

			} else {
				System.out.println("invalid option");
			}
		}
	}

}
