package SearchBus;

public class FindBus {
	public int busId;
	public String busName;
	public int ticketPrice;
	public String travellingTime;
	
	@Override
	public String toString() {
		return "FindBus [busId=" + busId + ", busName=" + busName + ", ticketPrice=" + ticketPrice + ", travellingTime="
				+ travellingTime + "]";
	}
	public FindBus(int busId, String busName, int ticketPrice, String travellingTime) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.ticketPrice = ticketPrice;
		this.travellingTime = travellingTime;
	}
	public FindBus() {
		// TODO Auto-generated constructor stub
	}
	
	
	

}
