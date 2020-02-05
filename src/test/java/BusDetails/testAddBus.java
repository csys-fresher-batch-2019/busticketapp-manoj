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
		a.busId=sc.nextInt();
		System.out.println("Enter Bus Name:");
		a.busName=sc.next();
		System.out.println("Enter From Location:");
		a.fromLocation=sc.next();
		System.out.println("Enter To Location:");
		a.toLocation=sc.next();
		System.out.println("Enter Journey Date:");
		a.journeyDate=sc.next();
		System.out.println("Enter Ticket Price:");
		a.ticketPrice=sc.nextInt();
		System.out.println("Enter Travelling Time(Starting):");
		String startingTime=sc.next();
		System.out.println("Enter Travelling Time(Ending):");
		String endingTime=sc.next();
		a.travellingTime=startingTime+" to "+endingTime;
		System.out.println("Enter Maximum Seats:");
		a.maximumSeats=sc.nextInt();
		System.out.println("Enter Available Seats:");
		a.availableSeats=sc.nextInt();
		
		obj.addBus(a);
		
	
	}

}
