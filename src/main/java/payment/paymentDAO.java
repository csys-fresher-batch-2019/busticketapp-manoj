package payment;

public interface paymentDAO {
	public void paymentSuccess(int bookingId);
	public void paymentFailure(int bookingId);
}
