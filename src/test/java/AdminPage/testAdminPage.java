package AdminPage;

import java.util.Scanner;

import BusDetails.testAddBus;
import BusDetails.testRemoveBus;
import BusDetails.testUpdateBusTimings;
import logger.Logger;

public class testAdminPage {

	public static void main(String[] args) throws Exception {
		Logger out=Logger.getInstance();
		out.info(" ====Welcome to Admin Page==== ");
		out.info(" 1.Add Bus \n 2.Remove Bus \n 3.Update Bus timings");
		out.getInput("Press 1 or 2 or 3");
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			int choice=sc.nextInt();
			if(choice==1)
			{
				testAddBus.main(null);
			}
			else if(choice==2)
			{
				testRemoveBus.main(null);
			}
			else if(choice==3)
			{
				testUpdateBusTimings.main(null);
			}
			else
			{
				out.info("try again...Please Enter 1 or 2 or 3");
			}
		}

	}

}
