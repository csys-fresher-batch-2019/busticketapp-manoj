package BusDetails;

import java.util.Scanner;

import logger.Logger;

public class testAddBus {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		busDetailsDAOImpl obj=new busDetailsDAOImpl();
		busDetails a=new busDetails();
		Logger out=Logger.getInstance();
		Scanner sc=new Scanner(System.in);
        out.info("Enter Bus Details:\n");
		out.getInput("Enter Bus Id:");
		a.setBusId(sc.nextInt());
		out.getInput("Enter Bus Name:");
		a.setBusName(sc.next());
		out.getInput("Enter From Location:");
		a.setFromLocation(sc.next());
		out.getInput("Enter To Location:");
		a.setToLocation(sc.next());
		out.getInput("Enter Journey Date:");
		a.setJourneyDate(sc.next());
		out.getInput("Enter Ticket Price:");
		a.setTicketPrice(sc.nextInt());
		out.getInput("Enter Travelling Time(Starting):");
		String startingTime=sc.next();
		out.getInput("Enter Travelling Time(Ending):");
		String endingTime=sc.next();
		a.setTravellingTime(startingTime+" to "+endingTime);
		out.getInput("Enter Maximum Seats:");
		a.setMaximumSeats(sc.nextInt());
		out.getInput("Enter Available Seats:");
		a.setAvailableSeats(sc.nextInt());
		
		obj.addBus(a);
		
	
	}

}
