package BusDetails;

import java.util.Scanner;

import logger.Logger;

public class testUpdateBusTimings {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		busDetailsDAOImpl obj=new busDetailsDAOImpl();
		
		busDetails a=new busDetails();
		Logger out=Logger.getInstance();
		Scanner sc=new Scanner(System.in);
		
		out.info("Update Bus Timings:\n");
		out.getInput("Enter bus Id:");
		a.setBusId(sc.nextInt());
		out.getInput("Enter Travelling Time(Starting):");
		String startingTime=sc.next();
		out.getInput("Enter Travelling Time(Ending):");
		String endingTime=sc.next();
		a.setTravellingTime(startingTime+" to "+endingTime);
		
		obj.updateBusTiming(a);

	}

}
