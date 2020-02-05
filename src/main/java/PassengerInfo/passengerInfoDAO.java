package PassengerInfo;

import java.util.ArrayList;

import SearchBus.FindBus;

public interface passengerInfoDAO {
	public int insertPassengerInfo(passengerInfo a) throws Exception;
	public ArrayList<passengerInfo> BookingDetails(int bookingId) throws Exception;
	public void cancelBooking(int bookingId) throws Exception;
	 public boolean validateBookingId(int bookingId) throws Exception;
	 public boolean validateBusId(int busId) throws Exception;
	 
}
