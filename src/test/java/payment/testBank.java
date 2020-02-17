package payment;

import java.time.LocalDate;
import java.util.Scanner;

import creditcard.Card;
import creditcard.PaymentResponse;
import logger.Logger;

public class testBank {

	public static void main(String[] args) throws Exception {
		Scanner scan=new Scanner(System.in);
		Logger out=Logger.getInstance();
		out.getInput("Enter card No:");
		long cardNo=scan.nextLong();
		out.getInput("Enter Expity Date:");
		String date=scan.next();
		LocalDate exp=LocalDate.parse(date);
		System.out.println("Enter CVV:");
		int cvv=scan.nextInt();
		
		out.getInput("Enter comments:");
	     String comment=scan.next();
	     out.getInput ("Enter total amount");
	     float amount=scan.nextFloat();
	     Card pay = new Card();
	     PaymentResponse payment = pay.cardpayment(cardNo, exp, cvv, amount, comment);
	     int transId = payment.getTransactionId();
	     out.info(payment.isStatus());
	     if (payment.isStatus()) {
	    	 paymentDAOImpl obj=new paymentDAOImpl();
	    	 out.info("Enter BookingId:");
			int bookingId=scan.nextInt();
			obj.paymentSuccess(bookingId);
			out.getInput(transId);
	     
			out.info(" !!! Successfully Booked !!! ");
			while(true)
			{
			System.out.println("Enter 1 to cancel booking");
			int choice=scan.nextInt();
			if(choice==1)
			{
				break;
			}
			else
			{
				System.out.println("Invalid choice");
			}
			}
	     } else {
	    	 
	    	 paymentDAOImpl obj=new paymentDAOImpl();
			out.info("Enter BookingId:");
			int bookingId=scan.nextInt();
			obj.paymentFailure(bookingId);
			out.info("Transaction failed!!!");
	     }

		
		
		
		
		
	}

}
