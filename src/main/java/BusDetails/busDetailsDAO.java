package BusDetails;


import java.util.List;

public interface busDetailsDAO {
	public void addBus(busDetails a);
	public void removeBus(int busId) ;
	public void updateBusTiming(busDetails a) ;
	public  List<String> getFromLocation() ;
	public  List<String> getToLocation() ;
	
    
}
