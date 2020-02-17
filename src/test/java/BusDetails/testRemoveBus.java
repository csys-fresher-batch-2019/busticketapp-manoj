package BusDetails;

import java.util.Scanner;

import logger.Logger;

public class testRemoveBus {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		busDetailsDAOImpl obj1=new busDetailsDAOImpl();
		Logger out=Logger.getInstance();
		Scanner sc=new Scanner(System.in);
		out.info("Deleting Bus Details");
		out.getInput("Enter bus id:");
		int busId=sc.nextInt();
		
		obj1.removeBus(busId);

	}

}
