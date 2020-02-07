package PassengerInfo;

import java.util.ArrayList;

import SearchBus.FindBus;

public interface passengerInfoDAO {
	public int insertPassengerInfo(passengerInfo a) ;
	public ArrayList<passengerInfo> BookingDetails(int bookingId) ;
	public void cancelBooking(int bookingId);
	 public boolean validateBookingId(int bookingId);
	 public boolean validateBusId(int busId) ;
	 
}
