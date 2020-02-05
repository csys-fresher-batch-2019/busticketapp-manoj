package SearchBus;

import java.util.ArrayList;
import java.util.Scanner;

import AvailableSeats.testAvailableSeats;

public class testFindBus {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		FindBusDAOImpl obj = new FindBusDAOImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Search bus here:");
		while (true) {
			System.out.println("Enter From Location");
			String fromLocation = sc.next();
			System.out.println("Enter To Location");
			String toLocation = sc.next();
			System.out.println("Enter Journey Date");
			String date = sc.next();
			System.out.println(" ");

			ArrayList<FindBus> buses1 = obj.searchbus(fromLocation, toLocation, date);
			if (buses1.size() > 0) {
				for (FindBus obj1 : buses1) {
					System.out.println(obj1);
				}
				testAvailableSeats.main(null);
				break;

			} else {
				System.out.println("No Buses are found.......\n try another date or another location");
			}

		}
	}

}
