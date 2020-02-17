package SearchBus;

import java.util.ArrayList;
import java.util.Scanner;

import AvailableSeats.testAvailableSeats;
import logger.Logger;

public class testFindBus {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		FindBusDAOImpl obj = new FindBusDAOImpl();
		Scanner sc = new Scanner(System.in);
		Logger out=Logger.getInstance();
		out.info("Search bus here:");
		while (true) {
			out.getInput("Enter From Location");
			String fromLocation = sc.next();
			out.getInput("Enter To Location");
			String toLocation = sc.next();
			out.getInput("Enter Journey Date");
			String date = sc.next();
			out.info(" ");

			ArrayList<FindBus> buses1 = obj.searchbus(fromLocation, toLocation, date);
			if (buses1.size() > 0) {
				for (FindBus obj1 : buses1) {
					out.info(obj1);
				}
				testAvailableSeats.main(null);
				break;

			} else {
				out.info("No Buses are found.......\n try another date or another location");
			}

		}
	}

}
