package PassengerInfo;

public class passengerInfo {
	public passengerInfo(int bookingId, int userId, int busId, String passengerName, Long mobileNumber, int noOfTickets,
			int age, String gender) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.busId = busId;
		this.passengerName = passengerName;
		this.mobileNumber = mobileNumber;
		this.noOfTickets = noOfTickets;
		this.age = age;
		this.gender = gender;
	}
	public passengerInfo() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "passengerInfo [bookingId=" + bookingId + ", userId=" + userId + ", busId=" + busId + ", passengerName="
				+ passengerName + ", mobileNumber=" + mobileNumber + ", noOfTickets=" + noOfTickets + ", age=" + age
				+ ", gender=" + gender + "]";
	}
	public int bookingId;
	public int userId;
	public int busId;
	public String passengerName;
	public Long mobileNumber;
	public int noOfTickets;
	public int age;
	public String gender;
	
	

}
