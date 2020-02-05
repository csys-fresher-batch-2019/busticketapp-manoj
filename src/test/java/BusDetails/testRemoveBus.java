package BusDetails;

import java.util.Scanner;

public class testRemoveBus {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		busDetailsDAOImpl obj1=new busDetailsDAOImpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("Deleting Bus Details");
		System.out.println("Enter bus id:");
		int busId=sc.nextInt();
		
		obj1.removeBus(busId);

	}

}
