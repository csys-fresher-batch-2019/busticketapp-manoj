package BusDetails;

import java.util.Scanner;

public class testUpdateBusTimings {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		busDetailsDAOImpl obj=new busDetailsDAOImpl();
		
		busDetails a=new busDetails();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Update Bus Timings:\n");
		System.out.println("Enter bus Id:");
		a.setBusId(sc.nextInt());
		System.out.println("Enter Travelling Time(Starting):");
		String startingTime=sc.next();
		System.out.println("Enter Travelling Time(Ending):");
		String endingTime=sc.next();
		a.setTravellingTime(startingTime+" to "+endingTime);
		
		obj.updateBusTiming(a);

	}

}
