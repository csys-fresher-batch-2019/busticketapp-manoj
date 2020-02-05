package BusDetails;

import java.util.ArrayList;

public interface busDetailsDAO {
	public void addBus(busDetails a) throws Exception;
	public void removeBus(int busId) throws Exception;
	public void updateBusTiming(busDetails a) throws Exception;
    
}
