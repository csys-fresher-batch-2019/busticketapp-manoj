package BusDetails;

import java.util.Scanner;

public class testAddBus {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		busDetailsDAOImpl obj=new busDetailsDAOImpl();
		busDetails a=new busDetails();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Bus Details:\n");
		System.out.println("Enter Bus Id:");
		a.setBusId(sc.nextInt());
		System.out.println("Enter Bus Name:");
		a.setBusName(sc.next());
		System.out.println("Enter From Location:");
		a.setFromLocation(sc.next());
		System.out.println("Enter To Location:");
		a.setToLocation(sc.next());
		System.out.println("Enter Journey Date:");
		a.setJourneyDate(sc.next());
		System.out.println("Enter Ticket Price:");
		a.setTicketPrice(sc.nextInt());
		System.out.println("Enter Travelling Time(Starting):");
		String startingTime=sc.next();
		System.out.println("Enter Travelling Time(Ending):");
		String endingTime=sc.next();
		a.setTravellingTime(startingTime+" to "+endingTime);
		System.out.println("Enter Maximum Seats:");
		a.setMaximumSeats(sc.nextInt());
		System.out.println("Enter Available Seats:");
		a.setAvailableSeats(sc.nextInt());
		
		obj.addBus(a);
		
	
	}

}
